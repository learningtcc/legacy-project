package org.jbpm.job.executor;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.StaleStateException;
import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;
import org.jbpm.db.JobSession;
import org.jbpm.job.Job;

public class JobExecutorThread extends Thread {

  public JobExecutorThread( String name,
                            JobExecutor jobExecutorThreadGroup,
                            JbpmConfiguration jbpmConfiguration,
                            int idleInterval,
                            int maxIdleInterval,
                            long maxLockTime,
                            int maxHistory
                          ) {
    super(name);
    this.jobExecutor = jobExecutorThreadGroup;
    this.jbpmConfiguration = jbpmConfiguration;
    this.idleInterval = idleInterval;
    this.maxIdleInterval = maxIdleInterval;
    this.maxLockTime = maxLockTime;
    this.maxHistory = maxHistory;
  }

  JobExecutor jobExecutor; 
  JbpmConfiguration jbpmConfiguration;
  int idleInterval;
  int maxIdleInterval;
  long maxLockTime;
  int maxHistory;

  Collection history = new ArrayList();
  int currentIdleInterval;
  boolean isActive = true;

  public void run() {
    try {
      currentIdleInterval = idleInterval;
      while (isActive) {
        try {
          Collection acquiredJobs = acquireJobs();

          if (! acquiredJobs.isEmpty()) {
            Iterator iter = acquiredJobs.iterator();
            while (iter.hasNext() && isActive) {
              Job job = (Job) iter.next();
              executeJob(job);
            }

          } else { // no jobs acquired
            if (isActive) {
              long sleepPeriod = getSleepPeriod();
              if (sleepPeriod>0) {
                sleep(sleepPeriod);
              }
            }
          }
          
          // no exception so resetting the currentIdleInterval
          currentIdleInterval = idleInterval;

        } catch (InterruptedException e) {
          log.info("job executor thread '"+getName()+"' got interrupted");
        } catch (Exception e) {
          log.error("exception in job executor thread. waiting "+currentIdleInterval+" milliseconds", e);
          try {
            sleep(currentIdleInterval);
          } catch (InterruptedException e2) {
            log.debug("delay after exception got interrupted", e2);
          }
          // after an exception, the current idle interval is doubled to prevent 
          // continuous exception generation when e.g. the db is unreachable
          currentIdleInterval = currentIdleInterval*2;
        }
      }
    } catch (Throwable t) {
      t.printStackTrace();
    } finally {
      log.info(getName()+" leaves cyberspace");
    }
  }

  protected Collection acquireJobs() {
    Collection acquiredJobs = null;
    Collection jobsToLock = new ArrayList();
    JbpmContext jbpmContext = jbpmConfiguration.createJbpmContext();
    try {
      try {
        JobSession jobSession = jbpmContext.getJobSession();
        log.debug("querying for acquirable job...");
        Job job = jobSession.getFirstAcquirableJob(getName());
        if (job!=null) {
          if (job.isExclusive()) {
            log.debug("exclusive acquirable job found ("+job+"). querying for other exclusive jobs to lock them all in one tx...");
            List otherExclusiveJobs = jobSession.findExclusiveJobs(getName(), job.getProcessInstance());
            jobsToLock.addAll(otherExclusiveJobs);
            log.debug("trying to obtain a process-instance exclusive locks for '"+otherExclusiveJobs+"'");
          } else {
            log.debug("trying to obtain a lock for '"+job+"'");
            jobsToLock.add(job);
          }
          
          Iterator iter = jobsToLock.iterator();
          while (iter.hasNext()) {
            job = (Job) iter.next();
            job.setLockOwner(getName());
            job.setLockTime(new Date());
            jbpmContext.getSession().saveOrUpdate(job);
          }
          
          try {
            jbpmContext.getSession().flush();
            log.info("FLUSH SUCCESS !!!");
          } catch (Exception e) {
            log.error("FLUSH FAILURE", e);
          }

        } else {
          log.debug("no acquirable jobs in job table");
        }
        
      } finally {
        jbpmContext.close();
      }
      acquiredJobs = jobsToLock;
      log.debug("obtained locks on following jobs: "+acquiredJobs);

    } catch (StaleStateException e) {
      log.debug("couldn't acquire lock on job(s): "+jobsToLock);
    }
    return acquiredJobs;
  }


  protected void executeJob(Job job) {
    JbpmContext jbpmContext = jbpmConfiguration.createJbpmContext();
    try {
      JobSession jobSession = jbpmContext.getJobSession();
      jobSession.reattachUnmodifiedJob(job);

      try {
        if (job.execute(jbpmContext)) {
          jobSession.deleteJob(job);
        }

      } catch (Exception e) {
        log.debug("exception while executing '"+job+"'", e);
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        job.setException(sw.toString());
        job.setRetries(job.getRetries()-1);
      }
      
      // if this job is locked too long
      long totalLockTimeInMillis = System.currentTimeMillis() - job.getLockTime().getTime(); 
      if (totalLockTimeInMillis>maxLockTime) {
        jbpmContext.setRollbackOnly();
      }

    } finally {
      try {
        jbpmContext.close();
      } catch (RuntimeException e) {
        log.error("problem committing job execution transaction", e);
        throw e;
      }
    }
  }
  protected Date getNextDueDate() {
    Date nextDueDate = null;
    JbpmContext jbpmContext = jbpmConfiguration.createJbpmContext();
    try {
      JobSession jobSession = jbpmContext.getJobSession();
      Collection jobIdsToIgnore = jobExecutor.getMonitoredJobIds();
      Job job = jobSession.getFirstDueJob(getName(), jobIdsToIgnore);
      if (job!=null) {
        nextDueDate = job.getDueDate();
        jobExecutor.addMonitoredJobId(getName(), job.getId());
      }
    } finally {
      jbpmContext.close();
    }
    return nextDueDate;
  }

  protected long getSleepPeriod() {
    long interval = currentIdleInterval;
    Date nextDueDate = getNextDueDate();
    if (nextDueDate!=null) {
      long currentTimeMillis = System.currentTimeMillis();
      long nextDueDateTime = nextDueDate.getTime();
      if (nextDueDateTime < currentTimeMillis+currentIdleInterval) {
        interval = nextDueDateTime-currentTimeMillis;
      }
    }
    if (interval<0) {
      interval = 0;
    }
    return interval;
  }

  public void setActive(boolean isActive) {
    this.isActive = isActive;
  }

  private static Log log = LogFactory.getLog(JobExecutorThread.class);
}

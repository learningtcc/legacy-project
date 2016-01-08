package et.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * OperEvent generated by MyEclipse Persistence Tools
 */

public class OperEvent implements java.io.Serializable {

	// Fields

	private String id;

	private String topic;

	private String contents;

	private Date eventdate;

	private String principal;

	private String actor;

	private Date addtime;

	private String adduser;

	private Set operEventResults = new HashSet(0);

	// Constructors

	/** default constructor */
	public OperEvent() {
	}

	/** minimal constructor */
	public OperEvent(String id) {
		this.id = id;
	}

	/** full constructor */
	public OperEvent(String id, String topic, String contents, Date eventdate, String principal, String actor, Date addtime, String adduser, Set operEventResults) {
		this.id = id;
		this.topic = topic;
		this.contents = contents;
		this.eventdate = eventdate;
		this.principal = principal;
		this.actor = actor;
		this.addtime = addtime;
		this.adduser = adduser;
		this.operEventResults = operEventResults;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTopic() {
		return this.topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getEventdate() {
		return this.eventdate;
	}

	public void setEventdate(Date eventdate) {
		this.eventdate = eventdate;
	}

	public String getPrincipal() {
		return this.principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getActor() {
		return this.actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public Date getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getAdduser() {
		return this.adduser;
	}

	public void setAdduser(String adduser) {
		this.adduser = adduser;
	}

	public Set getOperEventResults() {
		return this.operEventResults;
	}

	public void setOperEventResults(Set operEventResults) {
		this.operEventResults = operEventResults;
	}

}
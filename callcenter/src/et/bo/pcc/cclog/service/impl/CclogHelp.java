package et.bo.pcc.cclog.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import et.po.CcLog;
import et.po.PoliceCallin;
import excellence.common.page.PageInfo;
import excellence.common.util.time.TimeUtil;
import excellence.framework.base.dto.IBaseDTO;
import excellence.framework.base.query.MyQuery;
import excellence.framework.base.query.impl.MyQueryImpl;

public class CclogHelp extends MyQueryImpl {

	private String addoneDate(String endTime) {
		Date date = new Date();
		Calendar ca = Calendar.getInstance();
		ca.setTime(TimeUtil.getTimeByStr(endTime, "yyyy-MM-dd"));
		ca.add(ca.DATE, 1);
		date = ca.getTime();
		endTime = TimeUtil.getTheTimeStr(date, "yyyy-MM-dd");
		return endTime;
	}

	public MyQuery cclogQuery(IBaseDTO dto, PageInfo pi) {
		MyQuery mq = new MyQueryImpl();
		// 时间处理
		// String beginTime = (String)dto.get("beginTime");
		// Date startTime = TimeUtil.getTimeByStr(beginTime,"yyyy-MM-dd");
		// java.text.SimpleDateFormat sdf = new
		// java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// beginTime = sdf.format(startTime);
		// startTime = TimeUtil.getTimeByStr(sdf.format(startTime));
		// startTime = TimeUtil.getTimeByStr(beginTime, "yyyy-MM-dd HH:mm:ss");
		// String endTime = (String)dto.get("endTime");
		// Date endTimeAdd = TimeUtil.getTimeByStr(endTime,"yyyy-MM-dd");
		try {
			// Calendar ca = Calendar.getInstance();
			// ca.setTime(endTimeAdd);
			// ca.add(ca.DATE, 1);
			// endTimeAdd = ca.getTime();
			// System.out.println(beginTime);
			// System.out.println(TimeUtil.getTimeByStr(startTime.toLocaleString(),
			// "yyyy-MM-dd HH:mm:ss"));
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// end
		StringBuilder hql = new StringBuilder();
		String taginfo = (String) dto.get("taginfo");
		if(taginfo != null && !taginfo.trim().equals(""))
		hql.append("select c from CcLog c,PoliceCallin p,PoliceCallinInfo pcii where c.id=p.id");
		else
			hql.append("select c from CcLog c,PoliceCallin p where c.id=p.id");
		if (!dto.get("phoneNum").toString().equals("")) {
			hql.append(" and c.phoneNum like '" + "%"
					+ dto.get("phoneNum").toString() + "%" + "'");
		}
		if (!dto.get("fuzzNo").toString().equals("")) {
			hql.append(" and p.fuzzNo='" + dto.get("fuzzNo").toString() + "'");
		}
		// if(!dto.get("beginTime").toString().equals("")){
		// hql.append(" and
		// c.beginTime>=to_date('"+dto.get("beginTime").toString()+"','yyyy-MM-dd')
		// and
		// c.beginTime<=to_date('"+dto.get("endTime").toString()+"','yyyy-MM-dd')");
		// }
		// if(!dto.get("unit").toString().equals("")){
		// hql.append("and p.fuzzNo='"+"000000"+"'");
		// }
		// hql.append(" and c.beginTime<:st");
		// hql.append(" and p.operator=? ");
		//System.out.println("dto.begintime"+dto.get("beginTime").toString());
		if (!dto.get("beginTime").toString().equals("")) {
			hql.append(" and c.beginTime>=to_date('"
					+ dto.get("beginTime").toString() + "','yyyy-MM-dd') ");
		}
		if (!dto.get("endTime").toString().equals("")) {
			hql.append(" and c.beginTime<=to_date('"
					+ addoneDate(dto.get("endTime").toString())
					+ "','yyyy-MM-dd') ");
		}
		if (!dto.get("department").toString().equals("")) {
			hql.append(" and p.department='" + dto.get("department").toString()
					+ "'");
		}
		String isvalidin = (String) dto.get("isvalidin");
		if (isvalidin != null && !isvalidin.trim().equals("")) {
			if (isvalidin.equals("SYS_TREE_0000000182")) {
				hql.append(" and p.isValidIn = '0'");
			} else if (isvalidin.equals("SYS_TREE_0000000183")) {
				hql.append(" and p.isValidIn = '1'");
			} else if (isvalidin.equals("SYS_TREE_0000000184")) {
				hql.append(" and p.isValidIn = '2'");
			}
		}
		
		if (taginfo != null && !taginfo.trim().equals("")) {
			hql.append(" and pcii.policeCallin=p.id and pcii.tagInfo = '" + taginfo + "'");
		}
		if (pi.getFieldAsc()==null&&pi.getFieldDesc()==null) {
			hql.append(" order by c.beginTime desc");
		}
		if (pi.getFieldAsc()!=null) {
			hql.append(" order by " + pi.getFieldAsc() + " asc");
		}
		if (pi.getFieldDesc()!=null) {
			hql.append(" order by " + pi.getFieldDesc() + " desc");
		}

		// mq.setParameter("st",
		// TimeUtil.getTimeByStr(startTime.toLocaleString(), "yyyy-MM-dd
		// HH:mm:ss"));
		// System.out.println(hql.toString());
		mq.setHql(hql.toString());
		mq.setFirst(pi.getBegin());
		mq.setFetch(pi.getPageSize());
		return mq;
	}

	public MyQuery cclogQuerySize(IBaseDTO dto, PageInfo pi, String orderValue,
			String ad) {
		MyQuery mq = new MyQueryImpl();
		// 时间处理
		// String beginTime = (String)dto.get("beginTime");
		// Date startTime = TimeUtil.getTimeByStr(beginTime,"yyyy-MM-dd");
		// java.text.SimpleDateFormat sdf = new
		// java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// beginTime = sdf.format(startTime);
		// startTime = TimeUtil.getTimeByStr(sdf.format(startTime));
		// startTime = TimeUtil.getTimeByStr(beginTime, "yyyy-MM-dd HH:mm:ss");
		// String endTime = (String)dto.get("endTime");
		// Date endTimeAdd = TimeUtil.getTimeByStr(endTime,"yyyy-MM-dd");
		try {
			// Calendar ca = Calendar.getInstance();
			// ca.setTime(endTimeAdd);
			// ca.add(ca.DATE, 1);
			// endTimeAdd = ca.getTime();
			// System.out.println(beginTime);
			// System.out.println(TimeUtil.getTimeByStr(startTime.toLocaleString(),
			// "yyyy-MM-dd HH:mm:ss"));
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// end
		StringBuilder hql = new StringBuilder();
		hql
				.append("select count(c.id) from CcLog c,PoliceCallin p where c.id=p.id");
		if (!dto.get("phoneNum").toString().equals("")) {
			hql.append(" and c.phoneNum like '" + "%"
					+ dto.get("phoneNum").toString() + "%" + "'");
		}
		if (!dto.get("fuzzNo").toString().equals("")) {
			hql.append(" and p.fuzzNo='" + dto.get("fuzzNo").toString() + "'");
		}
		if (!dto.get("beginTime").toString().equals("")) {
			hql.append(" and c.beginTime<=to_date('"
					+ addoneDate(dto.get("endTime").toString())
					+ "','yyyy-MM-dd') ");
		}
		if (!dto.get("department").toString().equals("")) {
			hql.append(" and p.department='" + dto.get("department").toString()
					+ "'");
		}
		String isvalidin = (String) dto.get("isvalidin");
		if (isvalidin != null && !isvalidin.trim().equals("")) {
			if (isvalidin.equals("SYS_TREE_0000000182")) {
				hql.append(" and p.isValidIn = '0'");
			} else if (isvalidin.equals("SYS_TREE_0000000183")) {
				hql.append(" and p.isValidIn = '1'");
			} else if (isvalidin.equals("SYS_TREE_0000000184")) {
				hql.append(" and p.isValidIn = '2'");
			}
		}
		if (orderValue.equals("")) {
			hql.append(" order by c.beginTime desc");
		}
		if (orderValue.equals("up")) {
			hql.append(" order by p." + ad + " asc");
		}
		if (orderValue.equals("down")) {
			hql.append(" order by p." + ad + " desc");
		}

		// if(!dto.get("unit").toString().equals("")){
		// hql.append("and p.fuzzNo='"+"000000"+"'");
		// }
		// hql.append(" and c.beginTime<:st");
		// hql.append(" and p.operator=? ");
		// if ((!beginTime.equals(""))){
		// hql.append(" and c.beginTime>=? ");
		// }
		// mq.setParameter("st",
		// TimeUtil.getTimeByStr(startTime.toLocaleString(), "yyyy-MM-dd
		// HH:mm:ss"));
		// System.out.println(hql.toString());
		mq.setHql(hql.toString());

		// mq.setParameter(0, startTime);
		mq.setFirst(pi.getBegin());
		mq.setFetch(pi.getPageSize());
		return mq;
	}

	/**
	 * 得到今天数据信息
	 * 
	 * @param
	 * @version Oct 30, 2006
	 * @return
	 */
	public MyQuery queryToday(IBaseDTO dto, PageInfo pi, String begintime,
			String opernum) {
		MyQuery mq = new MyQueryImpl();
		StringBuilder hql = new StringBuilder();
		System.out.println("begintime"+begintime);
		hql.append("select c from CcLog c,PoliceCallin p where c.id=p.id and ");
		hql.append("c.beginTime>=to_date('"
					+ begintime
					+ "','yyyy-MM-dd hh24:mi:ss') and ");
		hql.append("p.operator='"+opernum+"' ");
		hql.append("order by c.beginTime desc");
		mq.setHql(hql.toString());
		mq.setFirst(pi.getBegin());
		mq.setFetch(pi.getPageSize());
		return mq;
	}

	/**
	 * 得到今天数据信息
	 * 
	 * @param
	 * @version Oct 30, 2006
	 * @return
	 */
	public MyQuery queryTodaySize(IBaseDTO dto, PageInfo pi, String begintime,
			String opernum) {
		MyQuery mq = new MyQueryImpl();
		DetachedCriteria dc = DetachedCriteria.forClass(CcLog.class);
		// Calendar c = Calendar.getInstance();
		// c.setTime(new Date());
		// c.set(Calendar.HOUR, 0);
		// c.set(Calendar.MINUTE, 0);
		// c.set(Calendar.SECOND, 0);
		// Date beginTime = c.getTime();
		// c.add(Calendar.DATE, 1);
		// Date endTime=c.getTime();
		/*
		 * dc.add(Expression.between("beginTime", beginTime, endTime));
		 * dc.addOrder(Order.desc("beginTime")); mq.setDetachedCriteria(dc);
		 */
		// Date d = new Date();
		// java.text.SimpleDateFormat sdf = new
		// java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// String endtime = sdf.format(d);
		StringBuilder hql = new StringBuilder();
		System.out.println("begintime"+begintime);
		hql.append("select Count(c.id) from CcLog c,PoliceCallin p where c.id=p.id and ");
		hql.append("c.beginTime>=to_date('"
					+ begintime
					+ "','yyyy-MM-dd HH:mm:ss') and ");
		// hql.append("c.beginTime<=? and ");
		hql.append("p.operator='"+opernum+"' ");
		hql.append("order by c.beginTime desc");
		mq.setHql(hql.toString());
		//mq.setParameter(0, TimeUtil.getTimeByStr(begintime));
		// mq.setParameter(1,endtime);
//		mq.setParameter(1, opernum);
		// mq.setHql(hql);
		mq.setFirst(pi.getBegin());
		mq.setFetch(pi.getPageSize());
		return mq;
	}

	/**
	 * 得到部门信息
	 * 
	 * @param
	 * @version Oct 30, 2006
	 * @return
	 */
	public MyQuery queryDep(IBaseDTO dto, String id) {
		MyQuery mq = new MyQueryImpl();
		// DetachedCriteria dc = DetachedCriteria.forClass(PoliceCallin.class);
		// dc.add(Restrictions.eq("department",id));
		// mq.setDetachedCriteria(dc);
		StringBuilder hql = new StringBuilder();
		hql.append("select p from CcLog c,PoliceCallin p where c.id=p.id");
		hql.append(" and p.department = '" + id + "'");
		if (!dto.get("beginTime").toString().equals("")) {
			hql.append(" and c.beginTime>=to_date('"
					+ dto.get("beginTime").toString() + "','yyyy-MM-dd') ");
		}
		if (!dto.get("endTime").toString().equals("")) {
			hql.append(" and c.beginTime<=to_date('"
					+ dto.get("endTime").toString() + "','yyyy-MM-dd') ");
		}
		mq.setHql(hql.toString());
		return mq;
	}
}

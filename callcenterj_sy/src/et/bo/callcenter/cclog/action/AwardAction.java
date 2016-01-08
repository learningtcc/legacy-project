/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package et.bo.callcenter.cclog.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import et.bo.callcenter.cclog.service.impl.AwardHelp;
import excellence.framework.base.action.BaseAction;
import excellence.framework.base.dto.impl.DynaActionFormDTO;
import excellence.framework.base.dto.impl.DynaBeanDTO;

/** 
 * wanglichun
 * Creation date: 07-28-2008
 * 
 * XDoclet definition:
 * @struts.action path="/callcenter/award" name="AwardForm" parameter="method" scope="request" validate="true"
 */
public class AwardAction extends BaseAction {
	/*
	 * Generated Methods
	 */
	


	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward toAwardMain(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		DynaActionFormDTO AwardForm = (DynaActionFormDTO) form;
		return mapping.findForward("main");
	}
	
	
	public ActionForward toAwardList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		DynaActionFormDTO AwardForm = (DynaActionFormDTO) form;
		String beginNum1=AwardForm.get("beginNum").toString();
		String endNum1=AwardForm.get("endNum").toString();
		String spaceNum1=AwardForm.get("spaceNum").toString();
		if(beginNum1.equals("")){
			beginNum1="0";
		}
		if(endNum1.equals("")){
			endNum1="0";
		}
		if(spaceNum1.equals("")){
			spaceNum1="0";
		}
		int beginNum=Integer.parseInt(beginNum1);
		int endNum=Integer.parseInt(endNum1);
		int spaceNum=Integer.parseInt(spaceNum1);
		beginNum=beginNum+spaceNum;
		List list=new ArrayList();
		AwardHelp ah=new AwardHelp();
		String sql="SELECT  TOP (100) PERCENT   dbo.cc_main.ring_begintime , dbo.oper_custinfo.cust_id , dbo.oper_custinfo.dict_cust_type , dbo.cc_main.tel_num "+
		" FROM dbo.cc_main LEFT OUTER JOIN "+
		" dbo.oper_custinfo ON dbo.cc_main.tel_num = dbo.oper_custinfo.cust_tel_home AND dbo.cc_main.tel_num = dbo.oper_custinfo.cust_tel_work AND "+
		" dbo.cc_main.tel_num = dbo.oper_custinfo.cust_tel_mob "+
			" ORDER BY dbo.cc_main.ring_begintime asc";
		ResultSet rs=ah.getScrollRs(sql);
		int rsCount=0;
		try {
			rs.last();
			rsCount=rs.getRow();	
			if(endNum>rsCount){
				endNum=rsCount;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		while(beginNum<endNum){			
			try {							
				rs.absolute(beginNum);
				int orderNum=130000+beginNum;
				beginNum=beginNum+spaceNum;				
				String ring_begintime=rs.getString(1);
				String cust_id=rs.getString(2);
				String dict_cust_type=rs.getString(3);
				String tel_num=rs.getString(4);
				if(ring_begintime!=null&&ring_begintime.length()>19){
					ring_begintime=ring_begintime.substring(0,19);
				}
				DynaBeanDTO dto=new DynaBeanDTO();
				dto.set("phoneNum", tel_num);
				dto.set("orderNum", orderNum);
				dto.set("ringBegintime", ring_begintime);
				dto.set("id", cust_id);
				dto.set("dict_cust_type", dict_cust_type);
				list.add(dto);
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("list",list);
		return mapping.findForward("list");
	}
	
	public ActionForward toAwardQuery(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		DynaActionFormDTO AwardForm = (DynaActionFormDTO) form;
		return mapping.findForward("query");
	}
}
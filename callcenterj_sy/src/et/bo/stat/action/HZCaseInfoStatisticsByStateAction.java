/**
 * 	@(#) FocusCaseInfoStatAction.java 2008-4-11 下午01:09:12
 *	版权所有 沈阳市卓越科技有限公司。 
 *	卓越科技 保留一切权利
 */
package et.bo.stat.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.jfree.chart.JFreeChart;

import et.bo.stat.service.HZCaseInfoStatisticsByStateService;
import excellence.framework.base.action.BaseAction;
import excellence.framework.base.dto.impl.DynaActionFormDTO;
import excellence.framework.base.dto.impl.DynaBeanDTO;

/**
 * <p>会诊案例库下全部座席员和每一座席员受理的各审核状态下的案例数量action</p>
 * 
 * @version 2008-03-29
 * @author wangwenquan
 */
public class HZCaseInfoStatisticsByStateAction extends BaseAction {
	private HZCaseInfoStatisticsByStateService service;

	public HZCaseInfoStatisticsByStateService getService() {
		return service;
	}

	public void setService(HZCaseInfoStatisticsByStateService service) {
		this.service = service;
	}
	/**
	 * 程序main页
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward toMain(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward("main");
	}

	/**
	 * 执行该方法，显示座席电话量统计的条件输入界面
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward toQuery(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		List user=service.userQuery("select user_id from sys_user where group_id = 'SYS_GROUP_0000000001'");
		request.setAttribute("user", user);
		return mapping.findForward("query");
	}

	/**
	 * 接受统计条件，执行相应的的统计方法，将统计结果回显到display页面
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward toDisplay(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		DynaActionFormDTO dto = (DynaActionFormDTO) form;
		String chartType = (String) dto.get("chartType");
		if (chartType.equals("")) {
			List<DynaBeanDTO> list=service.query(dto);
			request.setAttribute("caseRid", dto.get("agentNum"));
			if(dto.get("agentNum")!=null&&!"".equals(dto.get("agentNum")))
			{
				request.setAttribute("cTitle", "受理工号");
			}
			else
			{
				request.setAttribute("cTitle", "审核时间");
			}
			request.setAttribute("list", list);
//			request.setAttribute("condition", dto.get("condition"));
			return mapping.findForward("report");
		} else {
			JFreeChart chart = service.statistic(dto);
			request.setAttribute("chart", chart);
			return mapping.findForward("chartDisplay");
		}
	}
}

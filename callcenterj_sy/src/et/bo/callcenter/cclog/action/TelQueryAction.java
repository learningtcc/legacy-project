/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package et.bo.callcenter.cclog.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import et.bo.callcenter.cclog.service.TelQueryService;
import excellence.common.page.PageInfo;
import excellence.common.page.PageTurning;
import excellence.framework.base.action.BaseAction;
import excellence.framework.base.dto.impl.DynaActionFormDTO;

/**
 * MyEclipse Struts Creation date: 06-24-2008
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/callcenter/cclog/telQuery" name="TelForm"
 *                scope="request" validate="true"
 */
public class TelQueryAction extends BaseAction {
	/*
	 * Generated Methods
	 */
	private TelQueryService telQueryService = null;

	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward toTelQuery(ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		DynaActionFormDTO formdto = (DynaActionFormDTO) form;

		String pageState = null;
		PageInfo pageInfo = null;
		pageState = (String) request.getParameter("pagestate");
		if (pageState == null) {
			pageInfo = new PageInfo();
		} else {
			PageTurning pageTurning = (PageTurning) request.getSession()
					.getAttribute("telQueryPageTurning");
			pageInfo = pageTurning.getPage();
			pageInfo.setState(pageState);
			formdto = (DynaActionFormDTO) pageInfo.getQl();
		}
		pageInfo.setPageSize(14);
		List list = new ArrayList();
		try {
			list = telQueryService.telQuery(formdto, pageInfo);
			// list = telQueryService.getTel(formdto, pageInfo,pageState);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		int size = telQueryService.getSize();
		// System.out.println(size);
		pageInfo.setRowCount(size);
		pageInfo.setQl(formdto);
		request.setAttribute("list", list);
		PageTurning pt = new PageTurning(pageInfo, "/cc_police_heb/", map,
				request);
		request.getSession().setAttribute("telQueryPageTurning", pt);
		return map.findForward("list");
	}

	public ActionForward toTelMain(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		DynaActionFormDTO TelForm = (DynaActionFormDTO) form;
		List user = telQueryService
				.userQuery("select user_id from sys_user where group_id = 'SYS_GROUP_0000000001' or group_id = 'SYS_GROUP_0000000141'");
		request.setAttribute("user", user);
		return mapping.findForward("query");
	}

	public ActionForward toMain(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		DynaActionFormDTO TelForm = (DynaActionFormDTO) form;

		return mapping.findForward("main");
	}

	public ActionForward toTelList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		DynaActionFormDTO TelForm = (DynaActionFormDTO) form;

		return mapping.findForward("list");
	}

	/**
	 * @return telQueryService
	 */
	public TelQueryService getTelQueryService() {
		return telQueryService;
	}

	/**
	 * @param telQueryService
	 *            Ҫ���õ� telQueryService
	 */
	public void setTelQueryService(TelQueryService telQueryService) {
		this.telQueryService = telQueryService;
	}
}
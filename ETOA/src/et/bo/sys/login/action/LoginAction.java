package et.bo.sys.login.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import et.bo.oa.auditingClass.auditingclass;
import et.bo.sys.common.SysStaticParameter;
import et.bo.sys.login.UserInfo;
import et.bo.sys.login.service.LoginService;
import et.bo.sys.user.action.Password_encrypt;
import excellence.common.tree.TreeControlI;
import excellence.common.util.Constants;
import excellence.framework.base.action.BaseAction;
import excellence.framework.base.container.SpringRunningContainer;
import excellence.framework.base.dto.IBaseDTO;



public class LoginAction extends BaseAction implements ApplicationContextAware {

	private String path="images";
	
	private LoginService ls=null;
	private ApplicationContext context=null;
	public LoginService getLs() {
		return ls;
	}
	public void setLs(LoginService ls) {
		this.ls = ls;
	}
	public ActionForward login(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception 
    {
		
		auditingclass ac = new auditingclass();
		
		String css=Constants.getProperty("web_html_css");
		path=Constants.getProperty("web_images_link_path");
	 	IBaseDTO myForm = (IBaseDTO) form;
	 	String rand=(String)request.getSession().getAttribute("rand");
	 	if(myForm.get("val")==null||!((String)myForm.get("val")).trim().equals(rand))
	 	{
	 		request.setAttribute("error","sys.login.error.val");
	 		request.removeAttribute(mapping.getName());
	 		return mapping.findForward("error");
	 	}
	 	String user=(String)myForm.get("username");
	 	
	 	ac.setUserName(user);
	 	
	 	String pw=(String)myForm.get("pw");
	 	if(user==null||user.trim().equals(""))
	 	{
	 		request.setAttribute("error","sys.login.error.user");
	 		request.removeAttribute(mapping.getName());
	 		return mapping.findForward("error");
	 	}
	 	if(pw==null||pw.trim().equals(""))
	 	{
	 		request.setAttribute("error","sys.login.error.password");
	 		request.removeAttribute(mapping.getName());
	 		return mapping.findForward("error");
	 	}
	 	    Password_encrypt pe = new Password_encrypt();
		    pw=pe.pw_encrypt(pw);
	 		boolean pass=ls.login(user,pw);
	 		if(!pass)
	 		{
	 			request.setAttribute("error","sys.login.error.login");
	 			request.removeAttribute(mapping.getName());
	 			return mapping.findForward("error");
	 		}
	 		try
	 		{
	 		TreeControlI tci=ls.loadTree(user);
	 		request.getSession().setAttribute(SysStaticParameter.MOD_TREE_IN_SESSION,tci.getTreeControl());
	 		
	 		UserInfo ui=ls.loadUser(user);
	 		request.getSession().setAttribute(SysStaticParameter.USER_IN_SESSION,ui);
	 		
	 		String cssinsession="/"+Constants.getProperty("project_name")
	 							+"/"+path
	 							+"/"+"css"+"/"+css;
	 		String imagesinsession="/"+Constants.getProperty("project_name")
				+"/"+path+"/";
	 		request.getSession().setAttribute(SysStaticParameter.IMAGES_IN_SESSION, imagesinsession);
	 		request.getSession().setAttribute(SysStaticParameter.CSS_IN_SESSION,cssinsession);
	 		
	 		return mapping.findForward("success");
	 		}catch(Exception e)
	 		{
	 			e.printStackTrace();
	 			request.setAttribute("error","sys.login.error.other");
	 			return mapping.findForward("error");
	 		}
	 	
	 
    }
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		// TODO Auto-generated method stub
		this.context=context;
	}
}

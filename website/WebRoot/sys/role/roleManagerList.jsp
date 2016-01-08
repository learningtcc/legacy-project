<%@ page language="java" import="java.util.*" contentType="text/html; charset=GBK" pageEncoding="GBK"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html locale="true">
  <head>
    <html:base />
    
    <title></title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    
   <link href="<bean:write name='cssinsession'/>" rel="stylesheet" type="text/css" />
    <script language="javascript" src="../../js/tools.js"></script>
    <script language="javascript" src="../../js/common.js"></script>
  </head>
  
  <body>
    <html:form action="/sys/role/Role" method="post">
		<table width="80%" border="0" align="center" cellpadding="1" cellspacing="1" class="tablebgcolor">
		  <tr class="tdbgpiclist">
		    <td><bean:message bundle="sys" key="sys.role.roleManagerList.roleName"/></td>
		    <td><bean:message bundle="sys" key="sys.role.roleManagerList.delSign"/></td>
		    <td><bean:message bundle="sys" key="sys.role.roleManagerList.remark"/></td>
		    <td><bean:message bundle="sys" key="sys.role.roleManagerList.operation"/></td>
		  </tr>
		  
		  <logic:iterate id="c" name="list" indexId="i">
		  <%
  			String style=i.intValue()%2==0?"tdbgcolorlist1":"tdbgcolorlist2";
  		  %>
		  <tr>
		    <td class="<%=style%>"><bean:write name="c" property="name" filter="true"/></td>
		    <td class="<%=style%>"><logic:equal name="c" property="delMark" value="0"><bean:message bundle="sys" key="sys.role.roleManagerList.yes"/></logic:equal><logic:notEqual name="c" property="delMark" value="0"><bean:message bundle="sys" key="sys.role.roleManagerList.no"/></logic:notEqual></td>
		    <td class="<%=style%>"><bean:write name="c" property="remark" filter="true"/></td>
		    <td class="<%=style%>">
		    <img alt="<bean:message bundle='sys' key='sys.role.roleManagerList.update'/>" src="<bean:write name='imagesinsession'/>sysoper/update.gif" onclick="popUp('windows','Role.do?method=toRoleLoad&type=update&id=<bean:write name='c' property='id'/>',480,300)" width="16" height="16" target="windows" border="0"/>
		    <img alt="<bean:message bundle='sys' key='sys.role.roleManagerList.delete'/>" src="<bean:write name='imagesinsession'/>sysoper/del.gif" onclick="popUp('windows','Role.do?method=toRoleLoad&type=delete&id=<bean:write name='c' property='id'/>',480,300)" width="16" height="16" target="windows" border="0"/>	    
		    </td>
		  </tr>
		  </logic:iterate>
		  <tr>
		    <td colspan="4" >
			<page:page name="roleTurning" style="first"/>
		    </td>
		  </tr>
		</table>
    </html:form>
  </body>
</html:html>

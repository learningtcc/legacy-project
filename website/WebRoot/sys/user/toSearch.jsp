
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
    
    <title>toSearch.jsp</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<link href="<bean:write name='cssinsession'/>" rel="stylesheet" type="text/css" />
<script language="javascript" src="../../js/tools.js"></script>
<script>
	
	function a()
		{
			popUp('windows',"UserOper.do?method=toAdd&type=i",800,800);
		}
</script>
  </head>
  
  <body>
  <br>
  <html:form action="/sys/user/UserOper?method=search" target="mainFrame">
     <table width="50%" border="0" align="center" cellpadding="1" cellspacing="1" class="tablebgcolor">
  <tr>
    <td colspan="4"  class="tdbgcolorquerytitle"><bean:message bundle="sys" key="sys.current.page"/><bean:message bundle='sys' key='sys.user'/></td>
  </tr>
 	<tr>
    <td  class="tdbgcolorqueryright"><bean:message bundle='sys' key='sys.user.info.userName'/></td>
    <td class="tdbgcolorqueryleft"><html:text property="userName"></html:text></td>
    <td  class="tdbgcolorqueryright"><bean:message bundle='sys' key='sys.user.info.sysGroup'/></td>
    <td class="tdbgcolorqueryleft">
    <html:select property="sysGroup">
    		<html:option value=""><bean:message bundle='sys' key='sys.pselect'/></html:option>
    		<html:options collection="gl"
  							property="value"
  							labelProperty="label"/>
    	</html:select>
    </td>
  </tr>
  <tr>
    <td  class="tdbgcolorqueryright"><bean:message bundle='sys' key='sys.user.info.sysRole'/></td>
    <td class="tdbgcolorqueryleft">
    <html:select property="sysRole">
    		<html:option value=""><bean:message bundle='sys' key='sys.pselect'/></html:option>
    		<html:options collection="rl"
  							property="value"
  							labelProperty="label"/>
    	</html:select>
    </td>
    <td  class="tdbgcolorqueryright"><bean:message bundle='sys' key='sys.user.info.departmentId'/></td>
    <td class="tdbgcolorqueryleft">
    	<html:select property="departmentId">
    		<html:option value=""><bean:message bundle='sys' key='sys.pselect'/></html:option>
    		<html:options collection="dl"
  							property="value"
  							labelProperty="label"/>
    	</html:select>
    </td>
  </tr>
  <tr>
    <td colspan="4"  class="tdbgcolorquerybuttom"><html:submit><bean:message bundle='sys' key='sys.select'/></html:submit>
	<html:button property="ins" onclick="a()"><bean:message bundle='sys' key='sys.insert'/></html:button>
	
	</td>
    
  </tr>
</table>
</html:form>
  </body>
</html:html>

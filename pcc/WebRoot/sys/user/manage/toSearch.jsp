
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
<script>
	function s()
	{
		document.forms[0].action="/callcenter/sys/user/UserOper.do?method=search";
    	document.forms[0].submit();
	}
	function a()
		{
			window.open("/callcenter/sys/user/UserOper.do?method=toAdd&type=i","a");
		}
</script>
  </head>
  
  <body>
  <br>
  <html:form action="/sys/user/UserOper" target="mainFrame">
     <table width="50%" border="0" align="center" cellpadding="1" cellspacing="1" class="tablebgcolor">
  <tr>
    <td colspan="4"  class="tdbgcolorquerytitle"><bean:message key="sys.current.page"/><bean:message key='hl.bo.sys.user'/></td>
  </tr>
 	<tr>
    <td  class="tdbgcolorqueryright"><bean:message key='hl.bo.sys.user.info.userName'/></td>
    <td class="tdbgcolorqueryleft"><html:text property="userName"></html:text></td>
    <td  class="tdbgcolorqueryright"><bean:message key='hl.bo.sys.user.info.sysGroup'/></td>
    <td class="tdbgcolorqueryleft">
    <html:select property="sysGroup">
    		<html:option value=""><bean:message key='hl.bo.oa.asset.pleaseSelect'/></html:option>
    		<html:options collection="gl"
  							property="value"
  							labelProperty="label"/>
    	</html:select>
    </td>
  </tr>
  <tr>
    <td  class="tdbgcolorqueryright"><bean:message key='hl.bo.sys.user.info.sysRole'/></td>
    <td class="tdbgcolorqueryleft">
    <html:select property="sysRole">
    		<html:option value=""><bean:message key='hl.bo.oa.asset.pleaseSelect'/></html:option>
    		<html:options collection="rl"
  							property="value"
  							labelProperty="label"/>
    	</html:select>
    </td>
    <td  class="tdbgcolorqueryright"><bean:message key='hl.bo.sys.user.info.departmentId'/></td>
    <td class="tdbgcolorqueryleft">
    	<html:select property="departmentId">
    		<html:option value=""><bean:message key='hl.bo.oa.asset.pleaseSelect'/></html:option>
    		<html:options collection="dl"
  							property="value"
  							labelProperty="label"/>
    	</html:select>
    </td>
  </tr>
  <tr>
    <td colspan="4"  class="tdbgcolorquerybuttom"><input name="Submit" type="button" class="bottom" value="<bean:message key='agrofront.common.search'/>" onclick="s()"/>
	<input name="addgov" type="button" class="buttom" value="<bean:message key='agrofront.common.insert'/>" onClick="a()"/>
	
	</td>
    
  </tr>
</table>
</html:form>
  </body>
</html:html>


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
    
    <title>searchResult.jsp</title>
    
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
  </head>
  
  <body bgcolor="#eeeeee">
  
  <table width="80%" border="0" align="center" cellpadding="1" cellspacing="1" class="tablebgcolor">
  <tr class="tdbgpiclist">
    <td><bean:message key='hl.bo.sys.group.info.groupname'/></td>
    <td><bean:message key='hl.bo.sys.group.searchResult.isdongjie'/></td>
    <td><bean:message key='hl.bo.oa.asset.info_remark'/></td>
    <td><bean:message key='hl.bo.oa.asset.oper'/></td>
  </tr>
 
  <logic:iterate name="list" id="l" indexId="i">
  <%
  String style=i.intValue()%2==0?"tdbgcolorlist1":"tdbgcolorlist2";
  %>
  <tr>
    <td class=<%=style%>><bean:write name="l" property="name"/></td>
    <td class=<%=style%>>
    <logic:equal name="l" property="delMark" value="0">
    <bean:message key='hl.bo.sys.group.searchResult.yes'/></logic:equal><logic:notEqual name="l" property="delMark" value="0"><bean:message key='hl.bo.sys.group.searchResult.not'/>
    </logic:notEqual>
    </td>
    <td class=<%=style%>><bean:write name="l" property="remark"/></td>
    <td class=<%=style%>>
    <img alt="<bean:message key='agrofront.common.update'/>" src="<bean:write name='imagesinsession'/>sysoper/update.gif" onclick="window.open('GroupOper.do?method=toLoad&type=u&did=<bean:write name='l' property='id'/>','windows','350.650,scrollbars=yes')" width="16" height="16" target="_blank" border="0"/>
    <img alt="<bean:message key='hl.bo.sys.group.searchResult.impower'/>" src="<bean:write name='imagesinsession'/>sysoper/accredit.gif" onclick="window.open('../right.do?method=loadGroup&group=<bean:write name='l' property='id'/>','windows','350.650,scrollbars=yes')" width="16" height="16" target="_blank" border="0"/>
    <img alt="<bean:message key='agrofront.common.delete'/>" src="<bean:write name='imagesinsession'/>sysoper/del.gif" onclick="window.open('GroupOper.do?method=toLoad&type=d&did=<bean:write name='l' property='id'/>','windows','350.650,scrollbars=yes')" width="16" height="16" target="_blank" border="0"/>
    </td>
  </tr>
  </logic:iterate>
  <tr>
    <td colspan="4" ><page:page name="groupTurning" style="first"/></td>
    </tr>
</table>
  
  </body>
</html:html>

<%@ page language="java" contentType="text/html;charset=GB2312" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/newtreeview.tld" prefix="newtree" %>
<%@ include file="../../style.jsp"%>
<%
response.setHeader("Expires","0");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragrma","no-cache");
response.setDateHeader("Expires",0);
%>
<html:html locale="true">

<link href="../../style/<%=styleLocation%>/style.css" rel="stylesheet"
	type="text/css" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #f5f5f5;
}
.text-selected{
	background: #ccffff;
}

-->
</style>
<script language="javascript">
	function nockClick(id)
	{
		//alert('��ǰ�ڵ�id'+id);
	}
</script>
<body >
  <table class="td" width="80%" height="100%" border="0" cellspacing="0" bgcolor="#E5F3F6" cellpadding="0" background="../images/shu.gif">
<%--<tr>--%>
<%--	<td>--%>
<%--	</td>--%>
<%--</tr>--%>
<tr class="text" bgcolor="#E5F3F6" valign="top">



<!-- Tree Component parameterTreeSession-->
	<td align="center" >
  <newtree:tree tree="parameterSubTreeInsession" 
  			action="./../parameter/paramTree.do?method=loadSubParamTree&tree=$-{name}"
  			style="text" styleSelected="text-selected"
  			styleUnselected="text-unselected"
  			images="style/xia/images/tree"
  />
  </td>
 </tr>
  </table>
</body>

<!-- Standard Footer -->

</html:html>
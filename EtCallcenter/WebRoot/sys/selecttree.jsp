<%@ page language="java" contentType="text/html;charset=GB2312" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/newtree.tld" prefix="newtree" %>


<html:html locale="true">

<link href="<bean:write name='cssinsession'/>" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #f5f5f5;
}
-->
</style>
<head>
<script language="JavaScript" type="text/JavaScript">

function subaa(aa)
{
	alert(aa);
	var value= window.parent.document.frames[1].window.document.forms[0].ll.value;
	alert(value);
	window.parent.document.frames[1].window.document.forms[0].action="dep.do?method=select&id="+aa+"&value="+value;
	window.parent.document.frames[1].window.document.forms[0].submit();
}
</script>
</head>
<body class = "body_left">

<table class="td" border="0" cellspacing="0" cellpadding="0">
<tr class="text">
</tr>
<!-- Tree Component -->

  <newtree:tree tree="depSelectSession" 
  			action="dep.do?method=depTree&name=depSelectSession&tree=$-{name}"
  			style="text" styleSelected="text-selected"
  			styleUnselected="text-unselected"
  			images="images"/>

  </table>
</body>


<!-- Standard Footer -->

</html:html>
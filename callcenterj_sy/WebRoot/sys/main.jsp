
<%@ page language="java" contentType="text/html;charset=GB2312" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>金农咨询服务中心工作平台</title>
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

<frameset id="mainIndexFrame" rows="100,*,25" frameborder="no" border="0" framespacing="0">
  <html:frame frameName="topFrame" page="/sys/top.jsp"  scrolling="No" noresize="true"  title="topFrame" />
  <frameset name="exce" cols="200,*" frameborder="no" border="0" framespacing="0" margwidth="0">
<%--		<html:frame frameName="tree" page="/sys/tree.jsp"  scrolling="auto" noresize="true"  title="tree" />--%>
		<html:frame frameName="tree" page="/sys/moduleNav.jsp"  scrolling="auto" noresize="true"  title="tree" />
		<frameset cols="14,*" frameborder="no" border="0" framespacing="0" margwidth="0">
		  	<html:frame frameName="mid" page="/sys/mid.jsp" scrolling="no"  noresize="true" title="mid"/>
			<html:frame  frameName="contents" page="/caseinfo/generalCaseinfo.do?method=toGeneralCaseinfoMain" />
		</frameset>
  </frameset>
  <html:frame frameName="bottomFrame" page="/sys/buttom.jsp"  scrolling="No" noresize="true"  title="bottomFrame" />
</frameset>

<noframes><body>
</body>
</noframes></html>


<%@ page language="java" pageEncoding="GBK"%>

 <%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html locale="true">
  <head>
    <html:base />
    
    <title>main.jsp</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
  </head>
  <frameset rows="35%,*" frameborder="0" border="0" framespacing="0" noresize>
  <html:frame  page="/sys/log/LogOper.do?method=toSearch" frameName="topFrame" scrolling="No"  noresize="true"/>
  <html:frame page="/sys/content.jsp" frameName="mainFrame" scrolling="No"  noresize="true"/>
</frameset>
  <body>
    This a struts page. <br>
  </body>
</html:html>

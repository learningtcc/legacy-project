<%@ page language="java" import="java.util.*" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<html>
<html:html locale="true">
<head>
<meta HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=gb2312">
<meta name="GENERATOR" content="Microsoft FrontPage 4.0">
<meta name="ProgId" content="FrontPage.Editor.Document">
<title></title>
</head>
<% String atype = request.getParameter("atype");
	if(atype==null)
	{
		atype="other";
	}
 %>
<frameset name="dict" rows="14%,*" border="0" frameborder="0"  framespacing="0">
  <frame name="topp" src="operpriceinfo.do?method=toOperPriceinfoQuery&atype=<%=atype %>&state=<%=request.getParameter("state")%>" noresize scrolling="no">
  <frame name="bottomm" src="html/content.jsp" noresize scrolling="no">
  <noframes>
  <body>
   
  <p>此网页使用了框架，但您的浏览器不支持框架。</p>

  </body>
  </noframes>
</frameset>

</html>

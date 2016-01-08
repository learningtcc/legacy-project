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
    
    <title>popselect.jsp</title>
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

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="../../images/css/styleA.css" rel="stylesheet" type="text/css" />
<link href="../../images/css/jingcss.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="../js/common.js"></script>

<script type="text/javascript">

	function popUp( win_name,loc, w, h, menubar,center ) {
		var NS = (document.layers) ? 1 : 0;
		var editorWin;
		if( w == null ) { w = 500; }
		if( h == null ) { h = 350; }
		if( menubar == null || menubar == false ) {
			menubar = "";
		} else {
			menubar = "menubar,";
		}
		if( center == 0 || center == false ) {
			center = "";
		} else {
			center = true;
		}
		if( NS ) { w += 50; }
		if(center==true){
			var sw=screen.width;
			var sh=screen.height;
			if (w>sw){w=sw;}
			if(h>sh){h=sh;}
			var curleft=(sw -w)/2;
			var curtop=(sh-h-100)/2;
			if (curtop<0)
			{ 
			curtop=(sh-h)/2;
			}
	
			editorWin = window.open(loc,win_name, 'resizable=no,scrollbars,width=' + w + ',height=' + h+',left=' +curleft+',top=' +curtop );
		}
		else{
			editorWin = window.open(loc,win_name, menubar + 'resizable=no,scrollbars,width=' + w + ',height=' + h );
		}
	
		editorWin.focus(); //causing intermittent errors
	}
 	function query(){
			document.forms[0].action = "station.do?method=toStationList";
    		document.forms[0].target = "bottomm";
    		document.forms[0].submit();
    	}


</script>

  </head>
  
  <body>
    <html:form action="/sys/station/station.do" method="post">
    
    	<table width="100%" border="0" align="center" cellpadding="1" cellspacing="1" class="tablebgcolor">
<%--    	<html:hidden property="type"/>--%>
    		<tr>
    			<td  align="right" bgcolor="D3E8FD">
    				<input type="button" name="select" value="查询" class="button" onclick="popUp('windowsStation','station.do?method=toStationQuery',880,300)">&nbsp;
    				<input type="button" name="btnSearch" value="刷新" class="button" onclick="query()">&nbsp;
    				<input name="btnAdd" type="button" class="button" value="增加" onclick="popUp('windows','station.do?method=toStationLoad&type=insert',650,250)"/>
<%--    				<html:link action="/workplan.do?method=add" onclick="popUp('newplan','',880,600)" target="newplan"></html:link>--%>
<%--    				<input type="button"  value="制定阶段计划" class="button" onclick="popUp('windowsWorkPlan','workplan.do?method=add',880,300)">&nbsp;--%>
    				
    			</td>
    		</tr>
    	
    	</table>
    
    </html:form>
  </body>
</html:html>
 
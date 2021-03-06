<%@ page language="java" import="java.util.*" pageEncoding="GBK" contentType="text/html; charset=gbk"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page"%>


<html:html lang="true">
  <head>
    <html:base />
    
    <title></title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link href="../images/css/styleA.css" rel="stylesheet" type="text/css" />
	
	<script language="javascript">
    	
    	function popUp( win_name,loc, w, h, menubar,center ) {
    	
    	//2008-03-20 增加 loc 减少更改
    	loc = "callback.do?method=toCallbackLoad&type=" + loc;
    	
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


   	</script>
	
  </head>
  
  <body bgcolor="#eeeeee">
    <html:form action="custinfo/custinfo.do"  method="post">
		<table width="90%" border="0" align="center" cellpadding="1" cellspacing="1" class="tablebgcolor" color="#eeeee9">
		  <tr>
		    <td class="tdbgpiclist" width="30%" align="center">回访内容</td>
		    <td class="tdbgpiclist" width="40%" align="center">回访备注</td>
		    <td class="tdbgpiclist" width="10%" align="center">回访时间</td>
		    <td class="tdbgpiclist" width="15%" align="center">操作</td>
		  </tr>
		  <logic:iterate id="pagelist" name="list" indexId="i">
		  <%
			String style =i.intValue()%2==0?"tdbgcolorlist1":"tdbgcolorlist2";
		  %>
		  <tr>
		  	<td ><bean:write name="pagelist" property="callback_content" filter="true"/></td>
		    <td ><bean:write name="pagelist" property="remark" filter="true"/></td>
		    <td ><bean:write name="pagelist" property="callback_time" filter="true"/></td>
            <td >

		     <img alt="详细" src="../images/sysoper/particular.gif" onclick="popUp('windows','detail&id=<bean:write name='pagelist' property='id'/>',680,301)"/>
             <img alt="修改" src="../images/sysoper/update.gif"     onclick="popUp('windows','update&id=<bean:write name='pagelist' property='id'/>',680,301)"/>
             <img alt="删除" src="../images/sysoper/del.gif"        onclick="popUp('windows','delete&id=<bean:write name='pagelist' property='id'/>',680,301)"/>
            </td>
		  </tr>
		  </logic:iterate>
		  <tr>
		    <td colspan="7"><page:page name="userpageTurning" style="second"/></td>
		  </tr>
		</table>
    </html:form>
  </body>
</html:html>
 
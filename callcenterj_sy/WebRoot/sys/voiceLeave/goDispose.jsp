<%@ page language="java" import="java.util.*" pageEncoding="GBK" contentType="text/html; charset=gb2312"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ include file="../../style.jsp"%>

<html:html lang="true">
  <head>
    <html:base />
    
    <title>语音留言管理</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link href="../../style/<%=styleLocation%>/style.css" rel="stylesheet" type="text/css" />
	<script language="javascript">
    	//查询
    	function query(){
    		document.forms[0].action = "../voiceLeave.do?method=toVoiceLeaveList";
    		document.forms[0].target = "bottomm";
    		document.forms[0].submit();
    	}
    	function makeSure(){
    		document.forms[0].action = "../voiceLeave.do?method=execDoWith";
    		document.forms[0].target = "bottomm";
    		document.forms[0].submit();
    		window.close();
    	}
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

	function openwin(param)
		{
		   var aResult = showCalDialog(param);
		   if (aResult != null)
		   {
		     param.value  = aResult;
		   }
		}
		
		function showCalDialog(param)
		{
		   var url="<%=request.getContextPath()%>/html/calendar.html";
		   var aRetVal = showModalDialog(url,"status=no","dialogWidth:225px;dialogHeight:225px;status:no;");
		   if (aRetVal != null)
		   {
		      return aRetVal;
		   }
		   return null;
		}
		<%
			String disposeSuccess = (String)request.getAttribute("disposeSuccess");
			if("true".equals(disposeSuccess))
			{
				//out.print("alert(opener.document);");
			}
		%>
   	</script>
 <SCRIPT language=javascript src="../../js/form.js" type=text/javascript></SCRIPT>
 <SCRIPT language=javascript src="../../js/calendar3.js" type=text/javascript></SCRIPT>
<style type="text/css">
<!--
body,td,th {
	font-size: 13px;
}
-->
</style>
  </head>
  
  <body class="conditionBody">
    <html:form action="sys/voiceLeave.do" method="post">
      	<table width="100%" border="0" align="center" cellpadding="0"
				cellspacing="1" class="tablebgcolor">
				<tr>
					<td class="navigateStyle">
						当前位置&ndash;&gt;处理语音留言
					</td>
				</tr>
		</table>
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="tablebgcolor">
		  <tr>
		    <td class="labelStyle">处理意见</td>
		   	<td class="valueStyle">
		   		<html:hidden property="id"></html:hidden>
		   		<html:textarea rows="10" cols="50" property="disposeSuggest"></html:textarea>
		   	</td>
		  </tr>
		  <tr class="buttonAreaStyle">
		    <td colspan="6">
		    <input name="btnSearch" type="button"   value="处理" onclick="makeSure()"/>
		    <html:reset value="刷新" styleClass="buttonStyle"/>
		    </td>
		  </tr>
		</table>
    </html:form>
  </body>
</html:html>
 
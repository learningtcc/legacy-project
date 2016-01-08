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
    
    <title></title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    
    <link href="<bean:write name='cssinsession'/>" rel="stylesheet" type="text/css" />
    <script language="javascript">
    	//��ѯ
    	function query(){
    		document.forms[0].action = "../callinFirewall.do?method=toCallinFireWallList";
    		document.forms[0].target = "bottomm";
    		document.forms[0].submit();
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
	
			editorWin = window.open(loc,win_name, 'resizable,scrollbars,width=' + w + ',height=' + h+',left=' +curleft+',top=' +curtop );
		}
		else{
			editorWin = window.open(loc,win_name, menubar + 'resizable,scrollbars,width=' + w + ',height=' + h );
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
    </script>
    
    
  </head>
  
  <body bgcolor="#eeeeee">
	
    <html:form action="/pcc/callinFirewall" method="post" onsubmit="query()">
      	<table width="70%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
		    <td class="tdbgcolorquerytitle">
		    <bean:message key="sys.current.page"/>
		    <bean:message bundle="pccye" key="et.pcc.callinFirewall"/>
		    </td>
		  </tr>
		</table>
		<table width="70%" border="0" align="center" cellpadding="1" cellspacing="1" class="tablebgcolor">
		  <tr>
		    <td class="tdbgcolorqueryright"><bean:message bundle="pccye" key="et.pcc.callinFirewall.phoneNum"/></td>
		    <td class="tdbgcolorqueryleft" colspan="3"><html:text property="callinNumBegin" styleClass="input"/></td>
<%--		    <td class="tdbgcolorqueryright"><bean:message bundle="pccye" key="et.pcc.callinFirewall.callinNumEnd"/></td>--%>
<%--		    <td class="tdbgcolorqueryleft"><html:text property="callinNumEnd" styleClass="input"/></td>--%>
		  </tr>
<%--		  <tr>--%>
<%--		    <td class="tdbgcolorqueryright"><bean:message bundle="pccye" key="sys.common.beginTime"/></td>--%>
<%--		    <td class="tdbgcolorqueryleft"><html:text property="beginTime" styleClass="input"/></td>--%>
<%--		    <td class="tdbgcolorqueryright"><bean:message bundle="pcc" key="sys.common.endTime"/></td>--%>
<%--		    <td class="tdbgcolorqueryleft"><html:text property="endTime" styleClass="input"/></td>--%>
<%--		  </tr>--%>
		  <tr>
		    <td class="tdbgcolorqueryright"><bean:message bundle="pccye" key="et.pcc.callinFirewall.isPass"/></td>
		    <td class="tdbgcolorqueryleft">	    	
		    	<html:select property="isPass">		
	        		<html:option value="" ></html:option>
	        		<html:option value="Y" ><bean:message bundle="pccye" key="et.pcc.callinFirewall.pass"/></html:option>
	        		<html:option value="N" ><bean:message bundle="pccye" key="et.pcc.callinFirewall.unpass"/></html:option>
	        	</html:select>
		    </td>
		    <td class="tdbgcolorqueryright"><bean:message bundle="pccye" key="et.pcc.callinFirewall.isAvailable"/></td>
		    <td class="tdbgcolorqueryleft">
		        <html:select property="isAvailable">		
	        		<html:option value="" ></html:option>
	        		<html:option value="Y" ><bean:message bundle="pccye" key="et.pcc.callinFirewall.able"/></html:option>
	        		<html:option value="N" ><bean:message bundle="pccye" key="et.pcc.callinFirewall.disable"/></html:option>
	        	</html:select></td>
		  </tr>
		  <tr>
		    <td colspan="4" class="tdbgcolorquerybuttom">
		    <input name="btnSearch" type="submit" class="bottom" value="<bean:message bundle="pccye" key='sys.search'/>"/>
		    <input name="btnAdd" type="button" class="bottom" value="<bean:message bundle='pccye' key='sys.add'/>" onclick="popUp('windows','../pcc/callinFirewall.do?method=toCallinFireWallLoad&type=insert',680,400)"/>
		    </td>
		  </tr>
		</table>
    </html:form>
  </body>
</html:html>

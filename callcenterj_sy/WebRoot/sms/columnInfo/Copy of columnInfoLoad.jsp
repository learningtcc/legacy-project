<%@ page language="java" import="java.util.*" contentType="text/html; charset=GBK" pageEncoding="GBK"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page"%>
<%@ page import="java.util.Calendar,java.text.SimpleDateFormat"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<link href="../../images/css/styleA.css" rel="stylesheet" type="text/css" />

<html:html locale="true">
  <head>
    <html:base />
    
    <title>短信业务</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="../../images/css/styleA.css" rel="stylesheet" type="text/css" />
   <script language="javascript" src="../../js/form.js"></script>
   <script language="javascript" src="../../js/clockCN.js"></script>
<script language="javascript" src="../../js/clock.js"></script>
 
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
	
	
    	function addTel()
        {
    	popUp('selTelwindows','../../sms/smssend.do?method=toaddTel',500,200);
        }
        
        
            function comptime(beginTime,endTime)
       {
<%--             alert(beginTime);--%>
            var bt=beginTime.substring(0,10)+"-"+beginTime.substring(11,13)+"-"+beginTime.substring(14,16);
            var et=endTime.substring(0,10)+"-"+endTime.substring(11,13)+"-"+endTime.substring(14,16);
<%--            alert(et);--%>
			var beginTimes=bt.substring(0,10).split('-');
			var endTimes=et.substring(0,10).split('-');
			
			beginTime=beginTimes[1]+'-'+beginTimes[2]+'-'+beginTimes[0]+' '+beginTime.substring(10,19);
			endTime=endTimes[1]+'-'+endTimes[2]+'-'+endTimes[0]+' '+endTime.substring(10,19);
			
			// alert(beginTime+endTime+beginTime);
			// alert(Date.parse(endTime));alert(Date.parse(beginTime));
			 
			var a =(Date.parse(endTime)-Date.parse(beginTime))/3600/1000;
			
			if(a<0)
			{
				return -1;
			}
			else if (a>0)
				{
				return 1;
				}
			else if (a==0)
			{
				return 0;
			}
			else
			{
				return 'exception'
			}
	}

    	function dep()
		{
		
			select(document.forms[0].receiveManId);
		}
		function select(obj)
   	 {
		
		var page = "../../sys/dep.do?method=select&value="+obj.value
		var winFeatures = "dialogWidth:600px; dialogHeight:600px;center:1; status:0";

		window.showModalDialog(page,obj,winFeatures);
	}
	

  
   function checkForm(addstaffer)
    {    
        if (!checkNotNull(addstaffer.groupName,"群组名称"))return false;
<%--    	if (!checkNotNull(addstaffer.receiveNum,"接收号码"))return false;--%>
<%--        if (!checkNotNull(addstaffer.content,"发送内容"))return false;--%>
       
    	return true;		
    }
<%--    function isInt(num)--%>
<%--  {--%>
<%--	var isint=true;--%>
<%--	for( i=0;i<num.value.length;i++)--%>
<%--	{--%>
<%--		if((num.value.charAt(i)>="0"&&num.value.charAt(i)<="9"))--%>
<%--		{--%>
<%--		}--%>
<%--		else--%>
<%--		{--%>
<%--			return false;--%>
<%--		}--%>
<%--	}--%>
<%--	return isint;--%>
<%--   }--%>
function checknumber(String) 
		{ 
			var Letters = "1234567890"; 
			var i; 
			var c; 
			for( i = 0; i < String.length; i ++ ) 
			{ 
				c = String.charAt( i ); 
				if (Letters.indexOf( c ) ==-1) 
				{ 
					return true; 
				} 
			} 
				return false; 
		} 
   function isTel(num)
  {
	var test=num;
	var part=test.split(",");
	for( i=0;i<num.value.length;i++)
	{
		if((num.value.charAt(i)>="0"&&num.value.charAt(i)<="9"))
		{
		}
		else
		{
			return false;
		}
	}
	return isint;
   }

   	function update()
   	{
		var f = document.forms[0];   
		
		if(checkForm(f)){ 
    		document.forms[0].action = "../../sms/linkGroup.do?method=UpdateLinkGroup";
    		document.forms[0].submit();
    	}
 	}
 	
 	function del()
 	{
 		document.forms[0].action = "../../sms/linkGroup.do?method=delLinkGroup";
 		document.forms[0].submit();
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
		   var aRetVal = showModalDialog(url,"status=no","dialogWidth:215px;dialogHeight:215px;status:no;");
		   if (aRetVal != null)
		   {
		      return aRetVal;
		   }
		   return null;
		}
		//返回页面
     function toback(){
			opener.parent.topp.document.all.btnSearch.click();
		}
   </script>
  </head>
  
  <body bgcolor="#eeeeee" onunload="toback()">
<logic:notEmpty name="operSign">
<script>
alert("操作成功");
toback();
window.close();
</script>
</logic:notEmpty>



  <%
   
  String str=request.getParameter("id");
  int i=0;
  %>
  <%
        Calendar cal=Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String systime = sdf.format(cal.getTime());	
 %> 
   <html:form action="/sms/linkGroup.do">

		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="tablebgcolor">
			<tr>
				<td class="tdbgpicload">群组信息</td>
			</tr>
		</table>

		<table width="100%" border="0" align="center" cellpadding="1"
			cellspacing="1" class="tablebgcolor">	
		  <tr>  
		    <td class="tdbgcolorqueryright">群组名称</td>
		    <td class="tdbgcolorqueryleft">
		     <html:text property="groupName" styleClass="input" ></html:text>
		     </td>
		  </tr>	
	     <tr>
		    <td class="tdbgcolorqueryright">备注</td>
		    <td class="tdbgcolorqueryleft"><html:textarea property="remarks" cols="50"></html:textarea></td>
		 </tr>
		</table>
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="tablebgcolor">
			<tr>
				<td colspan="4" align="center" width="100%"
					class="tdbgcolorloadbuttom">
					<input name="addgov" type="button" class="buttom" value="关闭"
						onClick="javascript: window.close();" />
					<logic:equal name="opertype" value="update">
			          <input name="btnUpd" type="button" class="bottom" value="修改" onclick="update()"/>&nbsp;&nbsp;
			        </logic:equal>
			
				    <logic:equal name="opertype" value="delete">
				     <input name="btnAdd" type="button" class="bottom" value="删除" onclick="del()"/>&nbsp;&nbsp;
				    </logic:equal>
				</td>
			</tr>
			<html:hidden property="id" value="<%=str%>" />
		</table>
	</html:form>
   
<SCRIPT language="javascript" src="<%=request.getContextPath()%>/js/calendar.js" type="text/javascript">
	</SCRIPT>
  </body>
</html:html>
 
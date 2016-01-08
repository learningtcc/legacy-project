<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无标题文档</title>

<!-- 引入jquery -->
<script type="text/javascript" src="../../../js/jquery/jquery-1.3.1.min.js"></script>
<script type="text/javascript" src="../../../js/jquery/plug/jquery[1].json-1.3.min.js"></script>
<script type="text/javascript" src="../../../js/jquery/plug/jquery.blockUI.js"></script>
<!-- 滚动页面 -->
<script language="javascript" src="../../../js/MSClass.js" ></script>

<script type="text/javascript">

	$(document).ready(function(){
		
		//$.blockUI({message:'waiting......'});
		//setTimeout($.unblockUI, 2000);
		
		loadData();
		$("tr.templeteRow").hide();//确保隐藏
		
	}
	);

	function loadData(){
		$.post(
			"../../../incomming/incommingInfo.do?method=telCondition",
			function(data){
				
				var result = $.evalJSON(data);
				
				//解析数组
				for(var key in result){
						var obj = result[key];

						//根据解析得到问题的内容的值obj.casereply是得到问题答案的值
						var str = '';
            			str +='<tr >';
         str +='<td class="Odd" width="135">'+obj.ringBegintime+'&nbsp;</td>';
         str +='<td class="Odd" width="73">'+obj.cust_name+'&nbsp;</td>';
         str +='<td class="Odd" width="276">'+obj.cust_addr+'&nbsp;</td>';
         str +='<td class="Odd" width="71">'+obj.dictQuestionType1+'&nbsp;</td>';
         str +='<td class="Odd" >'+obj.questionContent+'&nbsp;</td>';
         str +='<td class="Odd" width="83">'+obj.answerMan+'&nbsp;</td>';
       str +='</tr>';
<%--            			var str = '<tr>';--%>
<%--            			str = str + '<td class="Odd">';--%>
<%--            			//str = str + obj.ringBegintime;--%>
<%--            			str = str + '.';--%>
<%--            			str = str + '</td>';--%>
<%--            			--%>
<%--            			str = str + '<td class="Odd">';--%>
<%--            			str = str + getDoWithData(obj.cust_name);--%>
<%--            			str = str + '</td>';--%>
<%--            			str = str + '<td class="Odd">';--%>
<%--            			str = str + getDoWithData(obj.cust_addr);--%>
<%--            			str = str + '</td>';--%>
<%--            			--%>
<%--            			--%>
<%--            			str = str + '<td class="Odd">';--%>
<%--            			str = str + obj.dictQuestionType1;--%>
<%--            			str = str + '</td>';--%>
<%--            			str = str + '<td class="Odd">';--%>
<%--            			str = str + getDoWithData(obj.questionContent);--%>
<%--            			str = str + '</td>';--%>
<%--            			str = str + '<td class="Odd">';--%>
<%--            			str = str + getDoWithData(obj.answerMan);--%>
<%--            			str = str + '</td>';--%>
<%--            			str = str + '</tr>';--%>
            			
            			$("#marqueeTableId").append(str);
            			//$("#marqueeTableId").append(str);
				}
				go();
			}
		);
	}
	function getDoWithData(data)
	{
			var name = '&nbsp;';
        	if(typeof(data)!='undefined')
        	return data
        	else if(data)
        	{
        		if(''==trim(data))
        		return '&nbsp;';
        		else
        		{
        			return data;
        		}
       		}
        	else
        	return '&nbsp;';
	}
	function ltrim(s){ 
    return s.replace( /^\s*/,""); 
} 
//去右空格; 
function rtrim(s){ 
    return s.replace( /\s*$/,""); 
} 
//去左右空格; 
function trim(s){ 
    return ltrim(rtrim(s)); 
}
	
</script>

<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
/*整个页面div的宽为100%*/
#width{
	width: 100%;
}
/*************************页面眉头************************/
/*日期时间的文字样式*/
.time{
	font-family: "宋体";
	font-size: 12px;
	font-weight: normal;
	color: #000000;
	text-align: center;
	padding-top: 6px;
}
/*金农分析栏目，白色文字*/
.time2{
	font-family: "宋体";
	font-size: 14px;
	font-weight: bolder;
	color: #000000;
	text-align: left;
	padding: 2px;
}
/*数据标题文字，黑色12号字体*/
.wenzi1{
	font-family: "宋体";
	font-size: 12px;
	font-weight: normal;
	color: #000000;
}
/*话务数据，白色显示数据的地方*/
.shuju{
	background-color: #FFFFFF;
	border: 1px solid #99BBE8;
	font-family: "宋体";
	color: #000000;
	width: 35px;
}
/*在新专家，白色显示数据的地方*/
.shuju2{
	background-color: #FFFFFF;
	border: 1px solid #99BBE8;
	font-family: "宋体";
	color: #000000;
	width: 257px;
}
/*在新专家，白色显示数据的地方*/
.shuju3{
	background-color: #FFFFFF;
	border: 1px solid #99BBE8;
	font-family: "宋体";
	color: #000000;
	width: 370px;
}
/*数据图示说明，红色字体*/
.Icon Description{
	font-family: "宋体";
	font-size: 14px;
	color: #D74305;
	font-weight: bold;
}
.Even {	font-family: "宋体";
	font-size: 12px;
	color: #000000;
	background-color: #F5F9FA;
	border-right-style: solid;
	border-bottom-style: solid;
	border-left-style: solid;
	border-right-color: #CEDDF0;
	border-bottom-color: #CEDDF0;
	border-left-color: #CEDDF0;
	border-right-width: 1px;
	border-bottom-width: 1px;
	border-left-width: 1px;
	text-align: center;
	line-height: 24px;
}
.Odd {	font-family: "宋体";
	font-size: 12px;
	color: #000000;
	background-color: #FFFFFF;
	border-right-style: solid;
	border-bottom-style: solid;
	border-left-style: solid;
	border-right-color: #CEDDF0;
	border-bottom-color: #CEDDF0;
	border-left-color: #CEDDF0;
	border-right-width: 1px;
	border-bottom-width: 1px;
	border-left-width: 1px;
	text-align: center;
	line-height: 24px;
}
/*数据标题*/
.Title {
	font-family: "宋体";
	font-size: 14px;
	color: #000000;
	background-color: #CEDDF0;
	text-align: center;
	border: 1px solid #CEDDF0;
	font-weight: bolder;
}
.Title4 {	font-family: "宋体";
	font-size: 12px;
	color: #C00000;
	text-align: left;
	font-weight: bold;
}
.Title5 {	font-family: "宋体";
	font-size: 12px;
	color: #2270A9;
	text-align: left;
	font-weight: bold;
}
.wenzi2 {	font-family: "宋体";
	font-size: 12px;
	font-weight: normal;
	color: #000000;
	line-height: 22px;
}
-->
</style>
</head>
<body>
	<!--begin-->
  	  <table width="975" border="0" cellpadding="0" cellspacing="0">
       <tr>
         <td width="135" height="24" class="Title">受理时间</td>
         <td width="73" class="Title">用户姓名</td>
         <td width="276" class="Title">用户地址</td>
         <td width="71" class="Title">咨询栏目</td>
         <td  class="Title">咨询问题</td>
         <td width="83" class="Title">解决方式</td>
       </tr>
      </table>
      <div id="marquees">
     <table  id="marqueeTableId" width="975" border="0" cellpadding="0" cellspacing="0">
       <tr class="templeteRow">
         <td class="Odd">2009年3月1日 13：39</td>
         <td class="Odd">张红</td>
         <td class="Odd">沈阳市皇姑区泰山路沈阳软件出口基地B座3号楼</td>
         <td class="Odd">农业产品</td>
         <td class="Odd">今年产品蔬菜多钱一斤？</td>
         <td class="Odd">人工方式</td>
       </tr>
         
     </table>
     </div>
     
     </div>
     <!--end-->
</body>
</html>
<!-- 以下是javascript代码 -->
<script type="text/javascript">
		function go()
		{
			new Marquee("marquees","top",1,975,600,30,1000);
		}
</script>


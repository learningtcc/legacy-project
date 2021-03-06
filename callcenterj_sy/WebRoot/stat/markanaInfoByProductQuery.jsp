<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ include file="../style.jsp"%>
<html>
	<head>
		<html:base />
		<title></title>
		<link href="../style/<%=styleLocation%>/style.css" rel="stylesheet" type="text/css" />
		<script language=javascript src="../js/calendar3.js"></script>
		<script>
		function dodisplay(){
		setSameDateTime(document.forms[0].beginTime,document.forms[0].endTime);
			document.forms[0].action="../stat/markanaInfoByProduct.do?method=toDisplay"
			document.forms[0].submit();
		}
		function dodisplay3d(){
			if(document.forms[0].chartType!=""){
			setSameDateTime(document.forms[0].beginTime,document.forms[0].endTime);
				document.forms[0].action="../stat/markanaInfoByProduct.do?method=toDisplay";
				document.forms[0].submit();
			}
		}
		
		function select1(obj){
		var sid = obj.name;
		var svalue = obj.options[obj.selectedIndex].text;
		if(svalue == "")
			return;
		if(sid == "dictProductType1"){
			sendRequest("select_product.jsp", "svalue="+svalue+"&sid="+sid, processResponse1);
			this.producttd = "dict_product_type2_span";
		}else if(sid == "dictProductType2"){
			sendRequest("select_product.jsp", "svalue="+svalue+"&sid="+sid, processResponse2);
			this.producttd = "product_name_span";
		}
	}

	var XMLHttpReq = false;
 	//创建XMLHttpRequest对象       
    function createXMLHttpRequest() {
		if(window.XMLHttpRequest) { //Mozilla 浏览器
			XMLHttpReq = new XMLHttpRequest();
		}
		else if (window.ActiveXObject) { // IE浏览器
			try {
				XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {}
			}
		}
	}
	//发送请求函数
	function sendRequest(url,value,process) {
		createXMLHttpRequest();
		XMLHttpReq.open("post", url, true);
		XMLHttpReq.onreadystatechange = process;//指定响应函数
		XMLHttpReq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");  
		XMLHttpReq.send(value);  // 发送请求
	}
	
	function processResponse1() {
    	if (XMLHttpReq.readyState == 4) { // 判断对象状态
        	if (XMLHttpReq.status == 200) { // 信息已经成功返回，开始处理信息
            	var res=XMLHttpReq.responseText;
				//window.alert(res); 
				document.getElementById("dict_product_type2_span").innerHTML = "<select name='dictProductType2' class='selectStyle'  onChange='select1(this)'><OPTION value=''>请选择小类</OPTION>"+res+"</select>";
                
            } else { //页面不正常
                window.alert("您所请求的页面有异常。");
            }
        }
	}
	function processResponse2() {
    	if (XMLHttpReq.readyState == 4) { // 判断对象状态
        	if (XMLHttpReq.status == 200) { // 信息已经成功返回，开始处理信息
            	var res=XMLHttpReq.responseText;
				//window.alert(res); 
				document.getElementById("product_name_span").innerHTML = "<select name='name' class='selectStyle'><OPTION  value=''>请选择名称</OPTION>"+res+"</select>";
                
            } else { //页面不正常
                window.alert("您所请求的页面有异常。");
            }
        }
	}
	
	function setTime(){
			var time = new Date();
			document.forms[0].endTime.value = time.format('yyyy-MM-dd');//time.getYear()+"-"+(time.getMonth()+1)+"-"+time.getDate();
			time.setYear(time.getYear()-1);
			document.forms[0].beginTime.value = time.format('yyyy-MM-dd');//time.getYear()+"-"+(time.getMonth()+1)+"-"+time.getDate();			
		}
		
		</script>
	</head>
	<body class="conditionBody" onload="setTime()">
		<html:form action="/stat/markanaInfoByProduct.do?method=toDisplay" method="post" target="bottomm">

			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="nivagateTable">
				<tr>
					<td class="navigateStyle">
						当前位置&ndash;&gt;产品品种量统计
					</td>
				</tr>
			</table>

			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="conditionTable">

				<tr class="conditionoddstyle">

					<td class="LabelStyle">
						开始时间
					</td>
					<td class="valueStyle">
						<html:text property="beginTime" styleClass="writeTextStyle" onclick="openCal('commonForm','beginTime',false);" size="12" />
						<img alt="选择时间" src="../html/img/cal.gif" onclick="openCal('commonForm','beginTime',false);">
					</td>
					<td class="LabelStyle">
						截止时间
					</td>
					<td class="valueStyle">
						<html:text property="endTime" styleClass="writeTextStyle" onclick="openCal('commonForm','endTime',false);" size="12" />
						<img alt="选择时间" src="../html/img/cal.gif" onclick="openCal('commonForm','endTime',false);">
					</td>
					<%--					<td class="LabelStyle">--%>
					<%--						品种--%>
					<%--					</td>--%>
					<%--					<td class="valueStyle">--%>
					<%--						<html:select property="name" styleClass="selectStyle">--%>
					<%--							<html:option value="">--%>
					<%--		    						请选择	    					--%>
					<%--		    					</html:option>--%>
					<%--							<html:options collection="evaluatingList" property="value"--%>
					<%--								labelProperty="label" />--%>
					<%--						</html:select>--%>
					<%--					</td>--%>
					
					<td class="LabelStyle" align="center">
						<input type="button" name="btnSearch" class="buttonStyle" value="统计" onclick="dodisplay()" />
					</td>
				</tr>

				<tr>
					<td class="LabelStyle">
						品种
					</td>
					<td class="valueStyle" >
<%--						<select name="dictProductType1" class="selectStyle" onChange="select1(this)">--%>
<%--							<OPTION value="">--%>
<%--								请选择大类--%>
<%--							</OPTION>--%>
<%--							<jsp:include flush="true" page="select_product.jsp" />--%>
<%--						</select>--%>
<%--						<span id="dict_product_type2_span"> <select name="dictProductType2" class="selectStyle" onChange="select1(this)">--%>
<%--								<OPTION value="">--%>
<%--									请选择小类--%>
<%--								</OPTION>--%>
<%--							</select> </span>--%>
<%--						<span id="product_name_span"> <select name="name" class="selectStyle">--%>
<%--								<OPTION value="">--%>
<%--									请选择名称--%>
<%--								</OPTION>--%>
<%--							</select> </span>--%>
						<html:select property="name" styleClass="selectStyle">
							<option value="">请选择</option>
							<html:options collection="list" property="value" labelProperty="label"/>
						</html:select>
					</td>
					<td class="LabelStyle">
						生成
					</td>
					<td class="valueStyle">
						<html:select property="chartType" styleClass="selectStyle">
							<html:option value="">表格</html:option>
							<html:option value="bar">柱图</html:option>
							<html:option value="pie">饼图</html:option>
							<html:option value="line">曲线图</html:option>
						</html:select>
						<html:checkbox property="is3d" onclick="dodisplay3d()" styleClass="checkBoxStyle">3D图像</html:checkbox>
					</td>
					<td class="LabelStyle" align="center">
						<input type="reset" class="buttonStyle" value="刷新">
					</td>
				</tr>

				<tr height="1px">
					<td colspan="9" class="buttonAreaStyle">
					</td>
				</tr>
			</table>
		</html:form>
	</body>
</html>

<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ include file="../style.jsp" %>
<html>
	<head>
	<html:base />
		<title></title>
		<link href="../style/<%=styleLocation %>/style.css" rel="stylesheet" type="text/css" />
		<script language=javascript src="../js/calendar3.js"></script>
		<script>
		function dodisplay(){
		setSameDateTime(document.forms[0].beginTime,document.forms[0].endTime);
			document.forms[0].action="../stat/focusCaseInfo.do?method=toDisplay"
			document.forms[0].submit();
		}
		function dodisplay3d(){
			if(document.forms[0].chartType!=""){
			setSameDateTime(document.forms[0].beginTime,document.forms[0].endTime);
				document.forms[0].action="../stat/focusCaseInfo.do?method=toDisplay";
				document.forms[0].submit();
			}
		}
		function time(){
				var time=new Date();
				document.forms[0].endTime.value=time.format('yyyy-MM-dd');//time.getYear()+"-"+(time.getMonth()+1)+"-"+time.getDate()
				time.setYear(time.getYear()-1)
				document.forms[0].beginTime.value=time.format('yyyy-MM-dd');//time.getYear()+"-"+(time.getMonth()+1)+"-"+time.getDate()
				
			}
		</script>
	</head>
	<body class="conditionBody" onload="time()">
		<html:form action="/stat/focusCaseInfo" method="post" target="bottomm">

			<table width="100%" border="0" align="center" cellpadding="0"
				cellspacing="0" class="nivagateTable">
				<tr>
					<td class="navigateStyle">
						当前位置&ndash;&gt;案例属性量统计
					</td>
				</tr>
			</table>

			<table width="100%" border="0" align="center" cellpadding="0"
				cellspacing="1" class="conditionTable">

				<tr class="conditionoddstyle">
					<td class="LabelStyle">
						开始时间
					</td>
					<td class="valueStyle">
						<html:text property="beginTime" styleClass="writeTextStyle2"
							onclick="openCal('focusCaseInfoForm','beginTime',false);" />
						<img alt="选择时间" src="../html/img/cal.gif"
					onclick="openCal('focusCaseInfoForm','beginTime',false);">
					</td>
					
<%--					<td class="LabelStyle">--%>
<%--						统计条件--%>
<%--					</td>--%>
<%--					<td class="valueStyle">--%>
<%--						<html:select property="condition" styleClass="selectStyle">--%>
<%--							<html:option value="count">电话数量</html:option>--%>
<%--							<html:option value="periodtime">时长</html:option>--%>
<%--						</html:select>--%>
<%--					</td>--%>
					<td class="LabelStyle">
<%--						座席工号--%>
						受理工号
					</td>
					<td class="valueStyle">
						<html:select property="agentNum" styleClass="selectStyle">
							<option value="">请选择</option>
							<logic:iterate id="u" name="user">
								<html:option value="${u.userId}">${u.userId}</html:option>						
							</logic:iterate>
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
					
				</tr>
				<tr>
					<td class="LabelStyle">
						截止时间
					</td>
					<td class="valueStyle">
						<html:text property="endTime" styleClass="writeTextStyle2"
							onclick="openCal('focusCaseInfoForm','endTime',false);"/>
						<img alt="选择时间" src="../html/img/cal.gif"
					onclick="openCal('focusCaseInfoForm','endTime',false);">
					</td>
					<td class="LabelStyle">
						案例属性
					</td>
					<td class="valueStyle">
						<html:select property="caseAttr4" styleClass="selectStyle">
							<html:option value="">请选择</html:option>
							<html:option value="疫情灾害">疫情灾害</html:option>
							<html:option value="政策纠风">政策纠风</html:option>
							<html:option value="市场经济">市场经济</html:option>
							<html:option value="生产管理">生产管理</html:option>
							<html:option value="医疗卫生">医疗卫生</html:option>
							<html:option value="食品安全">食品安全</html:option>
							<html:option value="文娱教育">文娱教育</html:option>
						</html:select>
					</td>
					<td class="LabelStyle" align="center" colspan="2">
						<input type="button" name="btnSearch" value="统计"  
							onclick="dodisplay()" class="buttonStyle"/>
							<input type="reset" value="刷新"  class="buttonStyle"/>
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

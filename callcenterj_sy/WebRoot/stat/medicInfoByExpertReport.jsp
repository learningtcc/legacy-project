<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page"%>
<%@ include file="../style.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
<head>
	<html:base />

	<title></title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
	%>
	<script language="javascript">
		var basePath='<%=basePath%>';
	</script>
	<script language="javascript" src="../js/Table.js"></script>
	<link href="../style/<%=styleLocation%>/style.css" rel="stylesheet"
		type="text/css" />
	<script language="javascript" src="../../js/common.js"></script>
</head>

<body class="listBody">
	<table id="tbl1" width="100%" border="0" align="center" cellpadding="1"
		cellspacing="1" class="listTable">
		<tr>
			<logic:equal value="notnull" name="name">
				<td class="listTitleStyle">
					时间
				</td>
			</logic:equal>
			<logic:equal value="null" name="name">
				<td class="listTitleStyle">
					受理工号
				</td>
			</logic:equal>
			<td class="listTitleStyle">
				原始(条)
			</td>
			<td class="listTitleStyle">
				待审(条)
			</td>
			<td class="listTitleStyle">
				驳回(条)
			</td>
			<td class="listTitleStyle">
				已审(条)
			</td>
			<td class="listTitleStyle">
				发布(条)
			</td>
			<td class="listTitleStyle">
				合计(条)
			</td>
		</tr>
		</tr>
		<logic:iterate id="c" name="list" indexId="i">
			<%
			String style = i.intValue() % 2 == 0 ? "oddStyle" : "evenStyle";
			%>
			<tr>
				<td >
						<bean:write name="c" property="name" filter="false" />
					</td>
					<td >
						<bean:write name="c" property="count" filter="false" />
					</td>
					<td >
						<bean:write name="c" property="count1" filter="false" />
					</td>
					<td >
						<bean:write name="c" property="count3" filter="false" />
					</td>
					<td >
						<bean:write name="c" property="count2" filter="false" />
					</td>
					<td >
						<bean:write name="c" property="count4" filter="false" />
					</td>
					<td >
						<bean:write name="c" property="rowCount" filter="false" />
					</td>
			</tr>
		</logic:iterate>
		<tr>
			<td colspan="7" class="listTitleStyle" align="right"
				style="margin:0px;padding-right:0px;">
				<div style="text-align:right;">
					<input type="button" class="buttonStyle" value="导出Excel"
						onclick="parseTbl('tbl1','全部专家和每一专家受理医疗服务次数','<%=basePath%>')" />
				</div>
			</td>
		</tr>
	</table>
</body>
</html:html>

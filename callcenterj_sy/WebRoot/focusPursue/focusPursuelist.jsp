<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page"%>
<%@ include file="../style.jsp"%>

<%@ page import="et.bo.sys.login.bean.UserBean"%>
<%@ page import="et.bo.sys.common.SysStaticParameter"%>

<html:html locale="true">
<head>
	<html:base />

	<title>焦点追踪列表</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link href="../style/<%=styleLocation%>/style.css" rel="stylesheet"
		type="text/css" />
	<script language="javascript" src="../js/common.js"></script>

</head>

<body class="listBody">

		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="1" class="listTable">
			<tr>
				<td class="listTitleStyle" width="50">
					选择
				</td>
				<td class="listTitleStyle" width="50">
					期数
				</td>
				<td class="listTitleStyle" width="60">
					出刊时间
				</td>
				<td class="listTitleStyle" width="60">
					责任编辑
				</td>
				<td class="listTitleStyle" width="50">
					版别
				</td>
				<td class="listTitleStyle"  width="150">
					主标题
				</td>
				<td class="listTitleStyle" width="150">
					摘要
				</td>
				<td class="listTitleStyle" width="80">
					审核状态
				</td>
				<td class="listTitleStyle" width="80">
					操作
				</td>
			</tr>
			<logic:iterate id="c" name="list" indexId="i">
				<%
String style = i.intValue() % 2 == 0 ? "oddStyle" : "evenStyle";
				%>

				<tr style="line-height: 21px;">
					<td width="50">
					<input name="educe" type="checkbox" id="educe"
						onclick="setCheckbox(this)"
						value="<bean:write name='c' property='focusId'/>">
					</td>
					<td width="50">
						<bean:write name="c" property="period" filter="true" />
					</td>
					<td>
						<bean:write name="c" property="createTime" filter="true" />
					</td>
					<td>
						<bean:write name="c" property="chargeEditor" filter="true" />
					</td>
					<td>
						<bean:write name="c" property="dictFocusType" filter="true" />
					</td>
					<td>
						<bean:write name="c" property="chiefTitle" filter="true" />
					</td>
					<td>
						<bean:write name="c" property="summary" filter="true" />
					</td>
					<td>
						<bean:write name="c" property="state" filter="true" />
					</td>

					<td>
						<img alt="详细" src="../style/<%=styleLocation%>/images/detail.gif"
							onclick="popUp('1<bean:write name='c' property='focusId'/>','focusPursue.do?method=toFocusPursueLoad&type=detail&id=<bean:write name='c' property='focusId'/>',1010,585)"
							width="16" height="16" border="0" />
						<leafRight:bodyImg alt="修改" nickName="focuspursue_update"  src="../style/${styleLocation}/images/update.gif"  border="0"  styleId="addBtn" name="addBtn" width="16px;" style="height:16px;" scopeName="userRoleLeafRightInsession">
						onclick="popUp('2<bean:write name='c' property='focusId'/>','focusPursue.do?method=toFocusPursueLoad&type=update&id=<bean:write name='c' property='focusId'/>',1010,700)"
						</leafRight:bodyImg>
						<leafRight:bodyImg alt="删除" nickName="focuspursue_delete"  src="../style/${styleLocation}/images/del.gif"  border="0"  styleId="addBtn" name="addBtn" width="16px;" style="height:16px;" scopeName="userRoleLeafRightInsession">
						onclick="popUp('3<bean:write name='c' property='focusId'/>','focusPursue.do?method=toFocusPursueLoad&type=delete&id=<bean:write name='c' property='focusId'/>',1010,585)"
						</leafRight:bodyImg>
						<%--<img alt="修改" src="../style/<%=styleLocation%>/images/update.gif"--%>
	<%--						onclick="popUp('2<bean:write name='c' property='focusId'/>','focusPursue.do?method=toFocusPursueLoad&type=update&id=<bean:write name='c' property='focusId'/>',1010,700)"--%>
	<%--						width="16" height="16" border="0" />--%>
	<%--					<img alt="删除" src="../style/<%=styleLocation%>/images/del.gif"--%>
	<%--						onclick="popUp('3<bean:write name='c' property='focusId'/>','focusPursue.do?method=toFocusPursueLoad&type=delete&id=<bean:write name='c' property='focusId'/>',1010,585)"--%>
		<%--					width="16" height="16" border="0" />--%>
					</td>
				</tr>
			</logic:iterate>
			<tr>
				<td colspan="4" class="pageTable">
					<!-- 参数标识是焦点追踪 -->
					<jsp:include flush="true" page="../output/inc.jsp?dbType=trace" />
				</td>
				<td colspan="4" class="pageTable">
					<page:page name="focusPursuepageTurning" style="second" />
				</td>
				<td style="text-align:right" class="pageTable" width="80">
				<%
							UserBean ub = (UserBean)request.getSession().getAttribute(SysStaticParameter.USERBEAN_IN_SESSION);
							String userGroup = ub.getUserGroup();
							if (!userGroup.equals("operator")) {
			%>	
					<input type="button" name="btnstatistic" value="统计" class="buttonStyle"
						onclick="popUp('statisticWindows','focusPursue.do?method=toPopStatistic',500,40)" />
						<%
							}
			%>	
					<input type="button" name="btnadd" value="添加" class="buttonStyle"
						onclick="popUp('focusPursueWindows','focusPursue.do?method=toFocusPursueLoad&type=insert',1010,700)" />
				</td>
			</tr>
			<tr>
				<td colspan="8">
					<input type="button" name="btnadd1" value="全部责任编辑和每一责任编辑的产品数量统计" class="buttonStyle"
					onclick="parent.document.location.href='./stat/focusInfoByEditor.do?method=toMain'" style="display='none'"/>
					<input type="button" name="btnadd2" value="全部版别和各版别的产品数量" class="buttonStyle"
					onclick="parent.document.location.href='./stat/focusInfoByType.do?method=toMain'" style="display='none'"/>
					<input type="button" name="btnadd3" value="每一责任编辑各版别的产品数量" class="buttonStyle"
					onclick="parent.document.location.href='./stat/focusInfoOneEditor.do?method=toMain'" style="display='none'"/>
					<input type="button" name="btnadd4" value="全部责任编辑和各编辑被领导批示过的产品数量" class="buttonStyle"
					onclick="parent.document.location.href='./stat/focusInfoAllEditor.do?method=toMain'" style="display='none'"/>
				</td>
			</tr>
		</table>

</body>
</html:html>
	
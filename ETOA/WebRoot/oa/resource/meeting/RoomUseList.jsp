<%@ page language="java" pageEncoding="gb2312" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    <title>
      <bean:message key="hl.bo.oa.resource.meeting.title"/>
    </title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="<bean:write name='cssinsession'/>" rel="stylesheet" type="text/css" />
  </head>
  <body>
    <table width="80%" border="0" align="center" cellpadding="1" cellspacing="1" class="tablebgcolor">
      
      <tr class="tdbgpiclist">
        <td>
            <bean:message key="hl.bo.oa.resource.meeting.roomuserlist.name"/>
        </td>
        <td>
            <bean:message key="hl.bo.oa.resource.meeting.roomuserlist.useDate"/>
        </td>
        <td>
            <bean:message key="hl.bo.oa.resource.meeting.roomuserlist.timeArea"/>
        </td>
        <td>
            <bean:message key="hl.bo.oa.resource.meeting.roomuserlist.applyUser"/>
        </td>
        <td>
            <bean:message key="hl.bo.oa.resource.meeting.roomuserlist.state"/>
        </td>
        <td>
            <bean:message key="hl.bo.oa.resource.meeting.roomuserlist.principalName"/>
        </td>
      </tr>
      <logic:iterate id="meetingUse" name="meetingUses" indexId="i">
			<%
				String style =i.intValue()%2==0?"tdbgcolorlist1":"tdbgcolorlist2";
			%>
        <tr>
          <td class="<%=style%>">
              <bean:write name="meetingUse" property="name" filter="true" />
          </td>
          <td class="<%=style%>">
              <bean:write name="meetingUse" property="useDate" filter="true" />
          </td>
          <td class="<%=style%>">
              <bean:write name="meetingUse" property="timeArea" filter="true" />
          </td>
          <td class="<%=style%>">
              <bean:write name="meetingUse" property="applyUser" filter="true" />
          </td>
          <td class="<%=style%>">
              <bean:write name="meetingUse" property="state" filter="true" />
          </td>
          <td class="<%=style%>">
              <bean:write name="meetingUse" property="principalName" filter="true" />
          </td>
        </tr>
      </logic:iterate>
      <tr>
        <td colspan="6">
            <page:page name="meetingTurning" style="first"/>
        </td>
      </tr>
    </table>
  </body>
</html:html>

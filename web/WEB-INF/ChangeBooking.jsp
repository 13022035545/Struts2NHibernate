<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Cammer
  Date: 2018/5/12
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改订票信息</title>
</head>
<body>
<jsp:include page="Guide.jsp"/>
<s:fielderror>
    <s:param>bookingError</s:param>
</s:fielderror>
<s:form action="changeBooking" method="POST">
    <s:textfield name="name" label="真实姓名" value="%{#session.changeBooking.name}"/>
    <s:textfield name="from" label="始发城市" value="%{#session.changeBooking.from}"/>
    <s:textfield name="to" label="目的城市" value="%{#session.changeBooking.to}"/>
    <s:textfield name="date" label="出发日期" value="%{#session.changeBooking.date}"/>
    <s:submit value="修改"/>
</s:form>
</body>
</html>

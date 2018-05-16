<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Cammer
  Date: 2018/4/14
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>机票预订</title>
</head>
<body>
    <jsp:include page="Guide.jsp"/>
    <s:fielderror>
        <s:param>bookingError</s:param>
    </s:fielderror>
    <s:form action="booking" method="POST">
        <s:textfield name="name" label="真实姓名"/>
        <s:textfield name="from" label="始发城市"/>
        <s:textfield name="to" label="目的城市"/>
        <s:textfield name="date" label="出发日期"/>
        <s:submit value="预订"/>
    </s:form>

</body>
</html>

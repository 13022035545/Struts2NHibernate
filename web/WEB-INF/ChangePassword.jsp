<%@ page import="com.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: Cammer
  Date: 2018/5/8
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>修改密码</title>
    <meta charset="UTF-8"/>
</head>
<body>
    <% User user = (User) session.getAttribute("user"); %>
    <jsp:include page="Guide.jsp"/>
    <h5 style="color: blueviolet">${cPassSuccess}</h5>
    <h3>修改密码</h3>
    用户名：<%=user.getUsername() %><br>
    <s:form action="change_pass" method="POST">
        <s:password name="f_password" label="旧密码"/><s:fielderror><s:param>f_passwordError</s:param></s:fielderror>
        <s:password name="n_password" label="新密码"/><s:fielderror><s:param>n_passwordError</s:param></s:fielderror>
        <s:password name="s_password" label="确认密码"/><s:fielderror><s:param>s_passwordError</s:param></s:fielderror>
        <s:fielderror><s:param>notSuitError</s:param></s:fielderror>
        <s:submit value="确认"/>
    </s:form>

</body>
</html>

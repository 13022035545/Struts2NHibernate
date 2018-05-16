<%--
  Created by IntelliJ IDEA.
  User: Cammer
  Date: 2018/4/14
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>登录和注册</title>
    <meta charset="UTF-8"/>
</head>
<body>
    <h3>用户登录</h3>
    <hr style="color: red">
    ${message}
    <s:fielderror>
        <s:param>loginError</s:param>
    </s:fielderror>
    <s:form action="login" method="POST">
        <s:textfield name="username" label="账户"/>
        <s:textfield name="password" label="密码"/>
        <s:submit value="提交"/>
    </s:form>
    <hr style="color: red">
    <s:fielderror>
        <s:param>signError</s:param>
    </s:fielderror>
    <s:form action="sign" method="POST">
        <s:textfield name="username" label="用户账户"/>
        <s:textfield name="password" label="密码"/>
        <s:textfield name="s_password" label="确认密码"/>
        <s:submit value="注册"/>
    </s:form>
</body>
</html>

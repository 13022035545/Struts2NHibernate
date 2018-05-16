<%@ page import="com.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: Cammer
  Date: 2018/4/14
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>主页</title>
    <meta charset="UTF-8"/>
  </head>
  <body>
  <jsp:include page="Guide.jsp"/>
  <% User user = (User) session.getAttribute("user"); %>
  <p>
    你好，<%= user.getUsername()%>，登陆成功!
  </p>
  </body>
</html>

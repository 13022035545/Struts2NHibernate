<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Cammer
  Date: 2018/4/15
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@ page import="com.domain.Booking" %>
<html>
<head>
    <title>预订信息</title>
</head>
<body>
    <jsp:include page="Guide.jsp"/>
    <h3>您的机票预订信息</h3>
    <s:fielderror>
        <s:param>deleteError</s:param>
    </s:fielderror>
    <table border="1">
        <tr style="background-color: darkgray">
            <td>真实姓名</td>
            <td>始发城市</td>
            <td>目的城市</td>
            <td>出发日期</td>
            <td style="border-right: 0px">操</td>
            <td style="border-left: 0px">作</td>
        </tr>
        <% int i = 0; %>
        <s:iterator value="#session.bookings" status="st" var="booking">
            <tr>
                <td><s:property value="#booking.name"/></td>
                <td><s:property value="#booking.from"/></td>
                <td><s:property value="#booking.to"/></td>
                <td><s:date name="#booking.date" format="yyyy/MM/dd"/></td>
                <td><a href = "readyToChange?which = <%= i%>">修改</a></td>
                <td><a href = "deleteBooking?which = <%= i%>">删除</a></td>
                <% i++; %>
            </tr>
        </s:iterator>
    </table>
    <table>
        <tr>
            <td><% if ((boolean)session.getAttribute("firstPage")){ %>
                <span>&nbsp</span>
                <% }else{ %>
                <a href="firstPage.action">首页</a>
                <% } %>
            </td>
            <td>
                <% if ((boolean)session.getAttribute("lastPage")){ %>
                <span>&nbsp</span>
                <% }else{ %>
                <a href="nextPage.action">下一页</a>
                <% } %>
            </td>
            <td>
                第<%= (int)session.getAttribute("page") + 1%>页
            </td>
            <td>
                <% if ((boolean)session.getAttribute("firstPage")){ %>
                <span>&nbsp</span>
                <% }else {%>
                <a href="formPage.action">上一页</a>
                <% } %>
            </td>
        </tr>
    </table>
    <s:form action="queryBooking" method="POST">
        <s:textfield name="name" label="姓名"/>
        <s:textfield name="from" label="始发城市"/>
        <s:textfield name="to" label="目的城市"/>
        <s:textfield name="date" label="出发日期"/>
        <s:submit value="查询"/>
    </s:form>
</body>
</html>

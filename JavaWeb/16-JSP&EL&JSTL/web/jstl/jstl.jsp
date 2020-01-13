<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Leo
  Date: 2020/1/13
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--1. 引入标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL</title>
</head>
<body>

    <%--
        2.1. jstl常用标签  if
        test：必须属性 接受boolean表达式
              如果表达式为true，则显示if标签体内容，如果为false，则不显示标签体内容
              一般情况下，test属性值会结合el表达式一起使用
     --%>
    <c:if test="${5 > 4}">
        <h1>Hello JSTL</h1>
    </c:if>

    <%
        List list = new ArrayList<>();
        list.add("张三");
        request.setAttribute("list", list);
    %>

    <c:if test="${not empty list}">
        遍历集合。。。

    </c:if>

</body>
</html>

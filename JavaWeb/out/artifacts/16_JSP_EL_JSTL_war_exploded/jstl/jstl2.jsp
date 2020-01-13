<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Leo
  Date: 2020/1/13
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL forEach</title>
</head>
<body>

    <%--
        begin:开始值
        end：结束值
        var：变量
        step：步长
        varStatus：循环状态对象
        items：容器对象
    --%>

    <%
        List list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        request.setAttribute("list", list);
    %>

    <c:forEach begin="1" end="10" var="i" step="1" varStatus="s">
        ${i} - ${s.index} - ${s.count}<br>
    </c:forEach>

    <c:forEach var="name" items="${list}" varStatus="s">
        ${name}-${s.index}-${s.count}<br>
    </c:forEach>


</body>
</html>

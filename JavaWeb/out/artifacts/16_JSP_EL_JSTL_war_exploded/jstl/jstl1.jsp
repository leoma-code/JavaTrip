<%--
  Created by IntelliJ IDEA.
  User: Leo
  Date: 2020/1/13
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL choose</title>
</head>
<body>

    <%
        request.setAttribute("number", 71);
    %>

    <c:choose>
        <c:when test="${number == 1}">
            星期一
        </c:when>
        <c:when test="${number == 2}">
            星期二
        </c:when>
        <c:when test="${number == 3}">
            星期三
        </c:when>
        <c:when test="${number == 4}">
            星期四
        </c:when>
        <c:when test="${number == 5}">
            星期五
        </c:when>
        <c:when test="${number == 6}">
            星期六
        </c:when>
        <c:when test="${number == 7}">
            星期天
        </c:when>
        <c:otherwise>
            数字不正确
        </c:otherwise>

    </c:choose>

</body>
</html>

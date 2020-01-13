<%--
  Created by IntelliJ IDEA.
  User: Leo
  Date: 2020/1/13
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

${ 3 > 4}

${empty requestScope.name}

<%
    request.setAttribute("name", "张三");
%>

<div> name : ${requestScope.name}</div>

${empty requestScope.name}




</body>
</html>

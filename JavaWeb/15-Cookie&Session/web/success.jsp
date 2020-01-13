<%--
  Created by IntelliJ IDEA.
  User: Leo
  Date: 2020/1/13
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆成功</title>
</head>
<body>

<h1><%=request.getSession().getAttribute("user")%>,欢迎您</h1>
</body>
</html>

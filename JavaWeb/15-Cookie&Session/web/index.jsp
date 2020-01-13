<%--
  Created by IntelliJ IDEA.
  User: Leo
  Date: 2020/1/10
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <%
    System.out.println("Hello JSP");

    String contextPath = request.getContextPath();
    System.out.println(contextPath);


    out.print(contextPath);

    response.getWriter().write("Hello Response");
  %>


  </body>
</html>

<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: Leo
  Date: 2020/1/13
  Time: 11:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上次访问时间</title>
</head>
<body>

    <%
        Cookie[] cookies = request.getCookies();

        // 获取此处访问时间
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String dateStr = format.format(date);
        // URL编码解决Cookie存储空格的问题
        dateStr = URLEncoder.encode(dateStr, "utf-8");

        // 是否访问过标识
        boolean flag = false;

        if (cookies != null && cookies.length > 0) {
            for (Cookie c: cookies) {
                if ("lastTime".equals(c.getName())) {
                    // URL解码
                    String lastDateStr = URLDecoder.decode(c.getValue(), "utf-8");\
                    // 更新Cookie
                    c.setMaxAge(30);
                    c.setValue(dateStr);
                    response.addCookie(c);
                    response.getWriter().write("欢迎回来，您上次访问时间为:" + lastDateStr);
                    flag = true;
                    break;
                }
            }
        }

        if (cookies == null || cookies.length == 0 || flag == false) {
            response.getWriter().write("您好，欢迎您首次访问。");

            Cookie cookie = new Cookie("lastTime", dateStr);
            cookie.setMaxAge(30);
            response.addCookie(cookie);
        }

    %>

</body>
</html>

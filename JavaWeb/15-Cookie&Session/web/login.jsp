<%--
  Created by IntelliJ IDEA.
  User: Leo
  Date: 2020/1/13
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>验证码登陆</title>

    <style>

        div {
            color: #f00;
        }
    </style>

</head>
<body>

<form action="/cookie/login" method="post">

    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" placeholder="请输入用户名" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" placeholder="请输入密码" name="password"></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="text" placeholder="请输入验证码" name="checkCode"></td>
        </tr>
        <tr>
            <td colspan="2"><img id="img" src="/cookie/checkCode" alt=""></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
        </tr>

    </table>
</form>

<div><%=request.getAttribute("cc_error") == null ? "" : request.getAttribute("cc_error")%></div>
<div><%=request.getAttribute("user_error") == null ? "" : request.getAttribute("user_error") %></div>


</body>

<script>
    window.onload = function () {
        var img = document.getElementById("img");

        img.onclick = function () {
            var time = new Date().getTime();
            this.src = "/cookie/checkCode?t=" + time;
        }
    }


</script>


</html>

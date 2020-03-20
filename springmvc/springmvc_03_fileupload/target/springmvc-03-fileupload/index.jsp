<%--
  Created by IntelliJ IDEA.
  User: Leo
  Date: 2020/3/20
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>传统文件上传</h3>
<form action="/user/fileupload" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload" /> <br>
    <input type="submit" value="上传文件" />
</form>

<h3>SpringMVC文件上传</h3>
<form action="/user/fileupload1" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload" /> <br>
    <input type="submit" value="上传文件" />
</form>

<h3>跨服务器文件文件上传</h3>
<form action="/user/fileupload2" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload" /> <br>
    <input type="submit" value="上传文件" />
</form>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Leo
  Date: 2020/3/20
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="js/jquery.min.js"></script>

    <script>

        $(function () {
            $("#btn").click(function () {

                $.ajax({
                    url: "user/testAjax",
                    contentType: "application/json;charset=utf-8",
                    data: '{"username":"张三","age":"18"}',
                    dataType: "json",
                    type: "post",
                    success: function (data) {

                        alert(data);
                        alert(data.username);
                        alert(data.age);
                    }
                });


            });
        });

    </script>

</head>
<body>


    <a href="user/testString">testString</a>

    <br>

    <button id="btn">发起异步请求</button>
</body>
</html>

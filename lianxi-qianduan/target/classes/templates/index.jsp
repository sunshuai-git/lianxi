
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script src="static/js/JQuery.mini.js"></script>

</head>
<body>

<form action="${pageContext.request.contextPath}/success" method="post">
    账&nbsp;&nbsp;号：<input type="text" id="username" name="username" placeholder="请输入用户名">
    <span id="s_username"></span>
    <br>
    密&nbsp;&nbsp;码：<input type="password" name="password" placeholder="请输入密码"><br>
    邮&nbsp;&nbsp;箱：<input type="text" name="email" placeholder="请输入邮箱"><br>
    手机号：<input type="text" name="phone" placeholder="请输入手机号"><br>
    <input type="submit" value="注册">
</form>


</body>
</html>

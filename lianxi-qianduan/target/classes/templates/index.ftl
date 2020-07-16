<!DOCTYPE html>
<html>
<head>
    <title>登录</title>

</head>
<body>
<center>
    <form action="/login" method="post">
        账&nbsp;&nbsp;号：<input type="text" id="username" name="username" placeholder="请输入用户名">
        <span id="s_username"></span>
        <br>
        密&nbsp;&nbsp;码：<input type="password" name="password" placeholder="请输入密码">
        ${msg}
        <br>
        <input type="submit" value="登录"><input type="button" value="注册" id="btn" onclick="zhuce()">
    </form>

</center>
</body>
<script src="js/JQuery.mini.js"></script>
<script>
    function zhuce() {
        window.location = "http://localhost:8083/register"
    }
</script>
</html>

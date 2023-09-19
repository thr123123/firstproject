<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录页</title>
    <link rel="stylesheet" href="./css/common.css">
    <link rel="stylesheet" href="./css/blog-login.css">
    <script src="./js/jquery-3.6.3.js"></script>
</head>
<body>
<!-- 导航栏 -->
<div class="nav">
    <img src="image/head.jpg" alt="">
    <span class="title">邮件管理系统</span>
    <!-- 使用 span 把左右两侧的元素给撑开 -->
    <span class="spacer"></span>
</div>
<!-- 登录页面的版心 -->
<div class="login-container">
    <div class="login-dialog">
        <h3>登录</h3>
        <form action="Login" method="post" name="loginForm">
            <div class="row1">
                <span>用户名</span>
                <input type="text" id="username" name="username">
            </div>
            <div class="row1">
                <span>密码</span>
                <input type="password" id="password" name="password">
            </div>
            <div class="row2">
                <input type="submit" value="登录" id="submit">
                <input type="button" value="注册" id="register" onclick="location.href='jsp/register.jsp'">
            </div>
        </form>
        <div id="attention" style="color:red;font-size: 20px;margin-left: 150px;margin-top: 50px">
            ${empty requestScope.attention?"":requestScope.attention}
        </div>
    </div>
</div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <base href="<%=basePath%>">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/blog-login.css">
</head>
<script src="js/jquery-3.6.3.js"></script>
<script>
    function check() {
        var u = $("#username").val()
        var pwd1 = $("#password1").val()
        var pwd2 = $("#password2").val()
        if (u === '' || pwd1 === '' || pwd2 === '') {
            alert("用户名或密码不能为空")
            return false;
        }
        if (u.length < 8) {
            alert("用户名至少为8位")
            $("#username").prop('value','')
            return false;
        }
        if (pwd1 !== pwd2) {
            alert("两次密码输入不相同")
            $("#password1").prop('value','')
            $("#password2").prop('value','')
            return false;
        }
        return true;
    }
</script>
<body>
<div class="nav">
    <img src="image/head.jpg" alt="">
    <span class="title">邮件管理系统</span>
    <!-- 使用 span 把左右两侧的元素给撑开 -->
    <span class="spacer"></span>
</div>
<!-- 注册页面的版心 -->
<div class="login-container">
    <div class="login-dialog">
        <h3>注册</h3>
        <form action="register" method="post" onsubmit="return check()">
            <div class="row1">
                <span>用户名</span>
                <input type="text" id="username" name="username">
            </div>
            <div class="row1">
                <span>密码</span>
                <input type="password" id="password1" name="password">
            </div>
            <div class="row1">
                <span>确认密码</span>
                <input type="password" id="password2" name="con_password">
            </div>
            <div class="rr">
                <span>注册类型</span>
                <input type="radio" name="usertype" value="usr" checked>普通用户 <input type="radio" name="usertype"
                                                                                        value="admin">管理员
            </div>
            <div class="row2">
                <input type="submit" value="注册" id="register" style="width:200px; margin-right:20px;">
                <span><a href="../index.jsp">已有账号？立即登录</a></span>
            </div>
        </form>
        <div id="attention" style="color:red;font-size: 20px;margin-left: 150px;margin-top: 50px">
            ${empty requestScope.attention?"":requestScope.attention}
        </div>
    </div>
</div>
</body>
</html>
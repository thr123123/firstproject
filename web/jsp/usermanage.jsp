<%--
  Created by IntelliJ IDEA.
  User: 田浩然
  Date: 2023/4/2
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>用户管理</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="css/mainface.css">
    <link rel="stylesheet" href="css/send.css">
    <link rel="stylesheet" href="css/attentionmsg.css">
    <script src="js/checkinfo.js"></script>
    <script src="js/jquery-3.6.3.js"></script>
</head>
<body>
<div class="main">
    <div class="leftmain">
        <div class="welcome">
            <img height="80" width="80" class="head" src="image/head.jpg">
            <p>欢迎,您好<span id="username">${user}</span></p>
        </div>
        <ul>
            <li id="bg"><a href="jsp/sender.jsp">发件箱</a></li>
            <li id="bg"><a href="jsp/write.jsp">写邮件</a></li>
            <li id="bg"><a href="jsp/receive.jsp">收件箱</a></li>
            <li id="bg"><a href="jsp/draft.jsp">草稿箱</a></li>
            <li id="bg"><a href="jsp/addr.jsp">联系人</a></li>
            <li id="bg" style="background-color: black"><a href="#">用户管理</a></li>
        </ul>
    </div>
    <div class="rightmain">
        <h1 style="font-weight: bold">用户列表</h1>
        <c:if test="${allUser.size()==0}">
            <span style="font-size: 20px;">暂无其他用户</span>
        </c:if>
        <c:if test="${allUser.size()!=0}">
            <form action="delUser" method="post" onsubmit="return delconfirm()">
                <table style="font-size: 20px; margin-top: 20px;">
                    <tr>
                        <td>操作</td>
                        <td style="width: 150px;">用户</td>
                        <td style="width: 150px;">用户类型</td>
                    </tr>
                    <c:forEach items="${allUser}" var="a">
                        <tr>
                            <td><input name="select" type="checkbox" value="${a.id}"></td>
                            <td>${a.id}</td>
                            <td>${a.isadmin==true?"管理员":"普通用户"}</td>
                        </tr>
                    </c:forEach>
                </table>
                <input type="button" onclick="showPopup()" value="添加"><input type="submit" name="del" value="删除">
            </form>
        </c:if>
        <div style="color:red;font-size: 20px;margin-left: 150px;margin-top: 50px">
            ${empty requestScope.att?"":requestScope.att}
        </div>
    </div>
    <div id="overlay">
        <div class="popup">
            <p class="popup_title">请输入添加的用户信息</p>
            <form action="addUser" method="post" onsubmit="return checkuser()">
                <p class="popup_content">
                    <span>学号</span><input type="text" minlength="8" name="id" id="uu"><br>
                    <span>密码</span><input type="text" maxlength="16" name="pwd" id="pwd"><br>
                    <span>用户类型</span><input type="radio" name="usertype" value="admin" checked>管理员 <input
                        type="radio" name="usertype" value="usr">普通用户
                </p>
                <div class="popup_btn">
                    <input type="button" onclick="hidePopup()" value="取消">
                    <input type="submit" value="确认">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

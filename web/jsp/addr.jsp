<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>联系人</title>
    <link rel="stylesheet" href="css/mainface.css">
    <link rel="stylesheet" href="css/send.css">
    <link rel="stylesheet" href="css/attentionmsg.css">
    <style>
        td {
            border: black 1px solid;
            background-color: transparent;
        }
    </style>
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
            <li id="bg" style="background-color: black"><a href="#">联系人</a></li>
            <c:if test="${usertype==true}">
                <li id="bg"><a href="jsp/usermanage.jsp">用户管理</a></li>
            </c:if>
        </ul>
    </div>
    <div class="rightmain">
        <h1 style="font-weight: bold">联系人</h1>
        <c:if test="${allAddress.size()==0}">
            <span style="font-size: 20px;">暂无联系人</span>
        </c:if>
        <c:if test="${allAddress.size()!=0}">
            <form action="delAddr" method="post" onsubmit="return delconfirm();">
                <table style="font-size: 20px; margin-top: 20px;">
                    <tr>
                        <td>操作</td>
                        <td style="width: 100px;">联系人</td>
                    </tr>
                    <c:forEach items="${allAddress}" var="a">
                        <tr>
                            <td><input name="select" type="checkbox" value="${a}"></td>
                            <td>${a}</td>
                        </tr>
                    </c:forEach>
                </table>
                <input type="button" onclick="showPopup()" value="添加"><input type="submit" name="del" value="删除">
            </form>
        </c:if>
        <span style="color:red;font-size: 20px;margin-left: 150px;margin-top: 50px">
            ${empty requestScope.att?"":requestScope.att}
        </span>
    </div>
    <div id="overlay">
        <div class="popup">
            <p class="popup_title">请输入要添加的学号</p>
            <form action="addAddr" method="post" onsubmit="return checkaddr(this)">
                <p class="popup_content">
                    <span>学号</span>
                    <label>
                        <input type="text" maxlength="8" name="id" id="uu">
                    </label>
                </p>
                <div class="popup_btn">
                    <input type="button" class="cancelBtn" onclick="hidePopup()" value="取消">
                    <input type="submit" class="confirmBtn" value="确认" name="insert">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

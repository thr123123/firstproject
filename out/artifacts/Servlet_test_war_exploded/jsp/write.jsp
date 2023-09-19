<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basepath%>">
    <meta charset="utf-8">
    <title>写邮件</title>
    <link rel="stylesheet" href="./css/mainface.css">
    <link rel="stylesheet" href="./css/wm.css">
    <link rel="stylesheet" href="./css/attentionmsg.css">
    <script src="./js/jquery-3.6.3.js"></script>
    <script>
        $(document).ready(function () {
            $("input.inp").focus(function () {
                $(this).css("background-color", "#cccccc");
            });
            $("input.inp").blur(function () {
                $(this).css("background-color", "#ffffff");
            });
        });
        function check(form){
            if(form.receiver.value==="null"){
                alert("请选择一个收件人");
                return false;
            }
            return true;
        }
        function savetodraft(){
            document.forms[0].action="save";
            document.forms[0].submit();
        }
    </script>
</head>
<body>
<div class="main">
    <div class="leftmain">
        <div class="welcome">
            <img height="80" width="80" class="head" src="image/head.jpg" alt="帅">
            <p>欢迎,您好<span id="username">${user}</span></p>
        </div>
        <ul>
            <li id="bg"><a href="jsp/sender.jsp">发件箱</a></li>
            <li id="bg" style="background-color: black"><a href="#">写邮件</a></li>
            <li id="bg"><a href="jsp/receive.jsp">收件箱</a></li>
            <li id="bg"><a href="jsp/draft.jsp">草稿箱</a></li>
            <li id="bg"><a href="jsp/addr.jsp">联系人</a></li>
            <c:if test="${usertype==true}">
                <li id="bg"><a href="jsp/usermanage.jsp">用户管理</a></li>
            </c:if>
        </ul>
    </div>
    <div class="rightmain">
        <form action="send" method="post" onsubmit="return check(this)" name="mail">
            <h1>新邮件</h1>
            <div class="write">
                <ul>
                    <li><span>标题:</span><input type="text" maxlength="32" class="inp" id="mail-title"
                                                 name="theme" placeholder="标题"><br></li>
                    <li>
                        <label>
                            收件人:
                            <select style="width: 150px;border-radius: 70px;" id="mail-receiver" name="receiver">
                                <option value="null">-请选择-</option>
                                <c:forEach items="${allAddress}" var="a">
                                    <option value="${a}">${a}</option>
                                </c:forEach>
                            </select>
                        </label><br>
                    </li>
                    <li>
                        <span style="vertical-align: top;">邮件内容:</span>
                        <textarea id="mail-content" rows="6" cols="40" name="content" placeholder="邮件内容"></textarea>
                    </li>
                </ul>
            </div>
            <div class="buttons">
                <input type="submit" class="button" value="发送">
                <input type="button" class="button" value="存入草稿箱" onclick="savetodraft()">
            </div>
        </form>
        <span style="margin-left: 50px;color:red;font-size: 20px;">${empty requestScope.msg?"":requestScope.msg}</span>
    </div>
</div>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: 田浩然
  Date: 2023/4/2
  Time: 19:03
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
    <base href="<%=basePath%>">
    <title>编辑草稿箱</title>
    <link rel="stylesheet" href="css/mail.css">
    <script src="js/checkinfo.js"></script>
</head>
<body>
<div class="mail">
    <input type="button" value="返回" onclick="history.back(-1);">
    <form action="Send" method="post" onsubmit="return check(this)">
        <div class="mail-message">
            <div class="mails">
                标题: <input type="text" class="mail-theme" id="theme" value="${theme}" name="theme">
                <div class="mailer">
                    <label>
                        收件人:
                        <select style="border-radius: 40px;width: 150px;" name="receiver">
                            <option value="null">-请选择-</option>
                            <c:forEach items="${allAddress}" var="a">
                                <option value="${a}">${a}</option>
                            </c:forEach>
                        </select>
                    </label>
                </div>
            </div>
        </div>
        <label>
            <textarea class="content">${requestScope.content}</textarea>
        </label>
        <div class="bb">
            <a href="saved?${requestScope.emailid}" style="text-decoration: none;">保存</a><input type="submit" value="发送">
        </div>
    </form>
    <span style="margin-left: 50px;color:red;font-size: 20px;">${empty requestScope.msg?"":requestScope.msg}</span>
</div>
</body>
</html>

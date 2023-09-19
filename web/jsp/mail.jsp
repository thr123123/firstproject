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
    <title>${empty requestScope.title?"":requestScope.title}</title>
    <link rel="stylesheet" href="css/mail.css">
</head>
<body>
    <div class="mail">
        <input type="button" value="返回" onclick="history.back(-1);">
        <div class="mail-message">
            <div class="mails">
                <div class="mail-theme" id="theme">${theme}</div>
                <div class="mailer">
                    <c:if test="${mailtype==1}">
                        收件人:
                    </c:if>
                    <c:if test="${mailtype==2}">
                        发件人:
                    </c:if>
                    <span>${receiver}</span>
                </div>
                <div class="timer">
                    发件时间: <span id="time" style="color: #ff8d7c">${date}</span>
                </div>
            </div>
        </div>
        <div class="content">${content}</div>
    </div>
</body>
</html>

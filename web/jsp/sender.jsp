<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>发件箱</title>
    <link rel="stylesheet" href="css/mainface.css">
    <link rel="stylesheet" href="css/send.css">
    <style>
        .F:hover {
            background-color: #00aeec;
        }
    </style>
</head>
<body>
<div class="main">
    <div class="leftmain">
        <div class="welcome">
            <img height="80" width="80" class="head" src="image/head.jpg" alt="帅">
            <p>欢迎,您好<span id="username">${user}</span></p>
        </div>
        <ul>
            <li id="bg" style="background-color: black"><a href="#">发件箱</a></li>
            <li id="bg"><a href="jsp/write.jsp">写邮件</a></li>
            <li id="bg"><a href="jsp/receive.jsp">收件箱</a></li>
            <li id="bg"><a href="jsp/draft.jsp">草稿箱</a></li>
            <li id="bg"><a href="jsp/addr.jsp">联系人</a></li>
            <c:if test="${usertype==true}">
                <li id="bg"><a href="jsp/usermanage.jsp">用户管理</a></li>
            </c:if>
        </ul>
    </div>
    <div class="rightmain">
        <span style="font-size: 20px;">发件箱</span>
        <h1>共<span>${allsendEmails.size()}</span>封邮件</h1>
        <table style="table-layout:fixed;width:100%;*width:auto;" class="tt">
            <tbody>
            <tr>
                <td class="o_title2" style="width:135px;">收件人</td>
                <td class="o_title2">主题</td>
                <td class="o_title2" style="padding-left:5px;width:200px;">发件时间</td>
            </tr>
            </tbody>
        </table>
        <div class="toarea">
            <c:if test="${allsendEmails.size()==0}">
                <span>暂无邮件</span>
            </c:if>
            <c:if test="${allsendEmails.size()!=0}">
                <c:forEach items="${allsendEmails}" var="e">
                    <a href="read?1${e.id}">
                        <table class="i F">
                            <tbody>
                            <tr>
                                <td class="l">
                                    <table class="i bold">
                                        <tbody>
                                        <tr>
                                            <td class="tl tf"><span>${e.to_id}</span></td>
                                            <td class="fg_n"></td>
                                            <td class="gt">
                                                <div class="tf no">
                                                    <span class="theme tt">${e.theme}</span>
                                                </div>
                                            </td>
                                            <td class="dt">${e.email_Date}</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </a>
                </c:forEach>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
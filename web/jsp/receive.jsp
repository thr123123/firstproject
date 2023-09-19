<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 田浩然
  Date: 2023/3/30
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>收件箱</title>
    <link rel="stylesheet" href="css/mainface.css">
    <link rel="stylesheet" href="css/send.css">
    <style>
        .F:hover{
            background-color: #00aeec;
        }
    </style>
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
            <li id="bg" style="background-color: black"><a href="#">收件箱</a></li>
            <li id="bg"><a href="jsp/draft.jsp">草稿箱</a></li>
            <li id="bg"><a href="jsp/addr.jsp">联系人</a></li>
            <c:if test="${usertype==true}">
                <li id="bg"><a href="jsp/usermanage.jsp">用户管理</a></li>
            </c:if>
        </ul>
    </div>
    <div class="rightmain">
        <span style="font-size: 20px;">收件箱</span>
        <h1>共<span>${allreceiveEmails.size()}</span>封邮件</h1>
        <table style="table-layout:fixed;width:100%;*width:auto;" class="tt">
            <tbody>
            <tr>
                <td class="o_title2" style="width:135px;*width:134px;">收件人</td>
                <td class="o_title2">主题</td>
                <td class="o_title2" style="padding-left:5px;width:200px;">发件时间</td>
            </tr>
            </tbody>
        </table>
        <div class="toarea">
            <c:if test="${allreceiveEmails.size()==0}">
                <span>暂无邮件</span>
            </c:if>
            <c:if test="${allreceiveEmails.size()!=0}">
                <c:forEach items="${allreceiveEmails}" var="e">
                    <a href="read?2${e.id}">
                    <table class="i F" id="${e.id}">
                        <tbody>
                        <tr>
                            <td class="l">
                                <table class="i bold">
                                    <tbody>
                                    <tr>
                                        <td class="tl tf"><span>${e.from_id}</span></td>
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

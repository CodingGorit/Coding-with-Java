<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<jsp:include page="base.jsp"/>

<body>
<div class="container">

    <div class="jumbotron">
        <c:choose>
            <c:when test="${empty sessionScope.loginUser}">
                您还未登录，请先<a href="login.jsp">登录</a>
            </c:when>
            <c:otherwise>
                欢迎用户${sessionScope.loginUser.username }!来到购物车

                <dl class="dl-horizontal">
                    <dt>用户信息：</dt>
                    <dd>Id: ${sessionScope.loginUser.userId}</dd>
                    <dt>用户账户</dt>
                    <dd>account：${sessionScope.loginUser.username}</dd>
                    <dt>用户年龄</dt>
                    <dd>age: ${sessionScope.loginUser.age}</dd>
                    <dt>用户爱好</dt>
                    <dd>hobbies：${sessionScope.loginUser.hobbies}</dd>
                </dl>
                测试 session：<span>${sessionScope.aaa}</span>
            </c:otherwise>
        </c:choose><br/>
    </div>
</div>

</body>
</html>

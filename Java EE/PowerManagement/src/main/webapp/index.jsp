<%--
  Created by IntelliJ IDEA.
  User: 伟
  Date: 2020/5/18
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%--系统管理员都可以操作

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>操作界面</title>
    <meta charset="UTF-8">
</head>
<style>
    .container {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%,-50%);
        display: flex;
        justify-content: space-around;
        width: 1080px;
        height: auto;
        margin: 0 auto;
    }

    .opt {
        width: 150px;
        height: 150px;
        line-height: 150px;
        background-color: orange;
    }

    .opt:visited {
        background-color: aqua;
    }

    span {
        margin-left: 20px;
    }
</style>
<body>
<h3>欢迎 ${user} ${power} 登录</h3>
<div class="container">

    <div class="opt">
        <span><a href="getAllUser.action">queryUser 操作</a></span>
    </div>

    <div class="opt">
        <span><a href="addUser.action">addUser 操作</a></span>
    </div>

    <div class="opt">
        <span><a href="deleteUser.action">deleteUser 操作</a></span>
    </div>

    <div class="opt">
        <span><a href="updateUser.action">updateUser 操作</a></span>
    </div>

</div>
</body>
</html>

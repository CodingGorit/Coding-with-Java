<%--
  Created by IntelliJ IDEA.
  User: 伟
  Date: 2020/9/9
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<style type="text/css">
    * {
        margin: 0;
        padding: 0;
    }
    .login-form {
        display: flex;
        justify-content: center;
        align-content: center;
        width: 200px;
        height: 200px;
        border: 1px salmon solid;
    }
</style>
<body>
    <div class="login-form">
        <form action="/user/login" method="post">
            <label>账户：</label>
            <input type="text" name="userId"/><br>
            <label>密码：</label>
            <input type="password" name="password"/><hr>
            <input type="submit" value="登录">
        </form>
    </div>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 伟
  Date: 2020/9/9
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>欢迎您，来到注册页面</h3>
    <div class="container">
        <form action="/user/register" method="post">
            <label>账户:</label>
            <input type="text" name="userId" placeholder="请输入你登录的账户"><br>
            <label>密码:</label>
            <input type="password" name="password"><br>
            <label>姓名:</label>
            <input type="text" name="username" placeholder="请输入你真是的姓名"><br>
            <label>年龄:</label>
            <input type="text" name="age"><br>
            <label>邮箱:</label>
            <input type="email" name="email" placeholder="请输入你登录的邮箱"><br>
            <input type="submit" value="注册">
        </form>
    </div>
</body>
</html>

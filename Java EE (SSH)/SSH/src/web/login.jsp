<%--
  Created by IntelliJ IDEA.
  User: Gorit
  Date: 2020/6/13
  Time: 23:18
  Contact: gorit@qq.com
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="checklogin" method="post">
        <label for="username">账户：</label>
        <input type="text" name="username" id="username"><br>
        <label for="password">密码：</label>
        <input type="password" name="password" id="password"><br>
        <input type="submit" value="登录">
    </form>

</body>
</html>

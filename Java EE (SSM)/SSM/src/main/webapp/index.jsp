<%--
  Created by IntelliJ IDEA.
  User: 伟
  Date: 2020/5/6
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试</title>
</head>
<body>

    <h3>SpringMVC </h3>
    <a href="account/findAll">findAll</a>

    <h3>测试保存</h3>
    <form action="account/save" method="post">
        姓名：<input type="text" name="name"><br>
        金额：<input type="text" name="money"><br>
        <input type="submit" value="保存">
    </form>
</body>
</html>

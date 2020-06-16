<%--
  Created by IntelliJ IDEA.
  User: 伟
  Date: 2020/5/19
  Time: 8:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="base.jsp"></jsp:include>
<html>
<head>
    <title>更改用户</title>
</head>
<body>
<div class="container" style="margin-top: 20px">
    <table class="table table-striped table-bordered text-center table-hover table-condensed" style="margin-top: 20px;">
        <div>
            <button class="btn btn-primary"  style="float: left" name="Submit" onclick="javascript:history.back(-1);" value="返回上一页">返回上一页</button>
        </div>
        <thead>
        <tr>
            <td>id</td>
            <td>账户</td>
            <td>密码</td>
            <td>状态</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${list}">
            <tr>
                <td>${item.getId()}</td>
                <td>${item.getUsername()}</td>
                <td>${item.getPassword()}</td>
                <td>${item.getStatus()}</td>
                <td><a href="" class="btn btn-primary">修改</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>

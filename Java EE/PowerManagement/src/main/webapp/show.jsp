<%--
  Created by IntelliJ IDEA.
  User: 伟
  Date: 2020/5/18
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="base.jsp"></jsp:include>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container" style="margin-top: 30px">
    <table class="table table-striped table-bordered text-center table-hover table-condensed" style="margin-top: 20px;">
        <input class="btn btn-primary" type="button" name="Submit" onclick="javascript:history.back(-1);" value="返回上一页">
        <thead>
        <tr>
            <td>id</td>
            <td>账户</td>
            <td>密码</td>
            <td>状态</td>
            <%--        <td>操作</td>--%>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${list}">
            <tr>
                <td>${item.getId()}</td>
                <td>${item.getUsername()}</td>
                <td>********</td>
                <td>*</td>
                    <%--            <td><a href="edit_student.jsp?stuId=${item.getStuId()}&StuName=${item.getStuName()}&StuAge=${item.getStuAge()}&Classz=${item.getClassz()}"--%>
                    <%--                   class="btn btn-primary"--%>
                    <%--            >修改</a>--%>
                    <%--                <a href="DeleteStudentServlet"--%>
                    <%--                   class="btn btn-danger"--%>
                    <%--                   id="delete_student"--%>
                    <%--                   onclick="Values(${item.getStuId()})"--%>
                    <%--                   data-toggle="modal"--%>
                    <%--                   data-target="#myModal">删除</a></td>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>

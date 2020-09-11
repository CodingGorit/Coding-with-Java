
<%--
  Created by IntelliJ IDEA.
  User: ΰ
  Date: 2020/4/22
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生页面分页实现</title>
    <jsp:include page="base.jsp"/>
</head>
<body>
<div class="container">
    <table class="table table-striped table-bordered text-center table-hover table-condensed" style="margin-top: 20px;">
        <thead>
        <tr>
            <td>学号</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>班级</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${list}">
            <tr>
                <td>${list.getStuId()}</td>
                <td>${list.getStuName()}</td>
                <td>${list.getStuAge()}</td>
                <td>${list.getClassz()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <nav style="align-content: center">
        <ul id="pagination" class="pagination">
            <c:choose>
                <c:when test="${pageNo>1}">
                    <li class="page-item"><a class="page-link" href="GetAllServlet?pageNo=${pageNo-1}">上一页</a></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item disabled"><a class="page-link" href="#">上一页</a></li>
                </c:otherwise>
            </c:choose>
                    &nbsp;&nbsp;
                    <li class="page-item"><a class="page-link" href=GetAllServlet?pageNo=1">1</a></li>
                    &nbsp;&nbsp;
                     <li class="page-item disabled"><a class="page-link" href="#">...</a></li>
                     &nbsp;&nbsp;
                    <li class="page-item"><a class="page-link" href="GetAllServlet?pageNo=${pageCount}">${pageCount}</a></li>
                    &nbsp;&nbsp;
            <c:choose>
                <c:when test="${pageNo<pageCount}">
                    <li class="page-item"><a class="page-link" href="GetAllServlet?pageNo=${pageNo+1 }">下一页</a></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item disabled"><a class="page-link" href="#">下一页</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </nav>
</div>
</body>
</html>

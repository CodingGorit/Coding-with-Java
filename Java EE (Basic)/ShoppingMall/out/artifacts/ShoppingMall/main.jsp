<%--
  Created by IntelliJ IDEA.
  User: ΰ
  Date: 2020/4/26
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品展示界面</title>
</head>
<jsp:include page="base.jsp"/>
<body>
<div class="container">

    <div class="jumbotron">
        <c:choose>
            <c:when test="${empty loginUser}">
                您还未登录，请先<a href="login.jsp">登录</a>
            </c:when>
            <c:otherwise>
                欢迎用户${loginUser.username }!来到购物车
            </c:otherwise>
        </c:choose><br/>
    </div>

    <table class="table table-striped table-bordered text-center table-hover table-condensed" style="margin-top: 20px;">
        <h3>欢迎来到商城页面</h3>
        <div class="text-right">
            <a class="btn-primary btn" href="ShowAllServlet" >查看购物车</a>
        </div>
        <thead>
        <tr>
            <td>商品列</td>
            <td>商品名</td>
            <td>价格</td>
            <td>介绍</td>
            <td>地址</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${list}">
            <tr>
                <td>${item.getId()}</td>
                <td>${item.getProduct_name()}</td>
                <td>${item.getPrice()}</td>
                <td>${item.getInroduce()}</td>
                <td>${item.getAddress()}</td>
                <td><a href="AddProIntoShopcartServlet?pid=${item.getId()}"
                       class="btn btn-primary">加入购物车</a>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p align="center">
        <nav>
            <ul id="pagination" class="pagination">
                <c:choose>
                    <c:when test="${pageNo>1}">
                        <li class="page-item"><a class="page-link" href="GetAllServlet?pageNo=${pageNo-1 }">上一页</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item"><a class="page-link" href="javascript:void(0);">上一页</a></li>
                    </c:otherwise>
                </c:choose>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <c:choose>
                    <c:when test="${pageNo<pageCount}">
                        <li class="page-item"><a class="page-link" href="GetAllServlet?pageNo=${pageNo+1 }">下一页</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item"><a class="page-link" href="javascript:void(0);">下一页</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </nav>
    </p>

</body>
</html>

<%@ page import="java.io.File" %><%--
  Created by IntelliJ IDEA.
  User: 伟
  Date: 2020/5/20
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String str = application.getRealPath("/upload");
    File f = new File(str);
    File[] fs = f.listFiles(); // 所有上传的文件
    pageContext.setAttribute("fs",fs);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach var="f" items="${fs}">
        <a href="down.action?fileName=${f.getName()}">${f.getName()}</a><br>
    </c:forEach>
</body>
</html>

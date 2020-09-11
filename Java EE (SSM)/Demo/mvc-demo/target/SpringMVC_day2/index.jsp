<%--
  Created by IntelliJ IDEA.
  User: 伟
  Date: 2020/9/11
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/toregesiter">注册</a>

    <form action="/user/fileupload" method="post" enctype="multipart/form-data">
        <input type="file" name="upload"/><br>
        <input type="submit" value="上传">
    </form>
</body>
</html>

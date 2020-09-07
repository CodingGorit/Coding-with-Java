<%--
  Created by IntelliJ IDEA.
  User: 伟
  Date: 2020/5/19
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="base.jsp"></jsp:include>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3> JSON 测试</h3>
    <span id="res"></span>
<script type="text/javascript">
    fetch("ArrayAjax.action").then(function (data) {
        return data.json();
    }).then(function (data) {
        // console.log(JSON.parse(data.str));
        var res = JSON.parse(data.str);
        console.log(res);
        const id = document.getElementById("res");
        $(res).each(function (i, s) {
            document.write(s.uname, s.uage, s.hobby, "</br>");
        })
        // res.forEach(function (item, index, data) {
        //     id.innerHTML = item.uname + item.uage + item.hobby + "</br>";
        // })
    })
</script>
</body>
</html>

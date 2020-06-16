<%--
  Created by IntelliJ IDEA.
  User: 伟
  Date: 2020/5/8
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>结算页面</title>
</head>
<body>
<jsp:include page="base.jsp"/>
<div class="container">
    <h3>欢迎来到结算页面</h3>
    您当前需要支付：<span>${money}</span>
    <div>
        请选择支付方式
        <select>
            <option value="支付宝">支付宝</option>
            <option value="支付宝">支付宝</option>
            <option value="支付宝">支付宝</option>
        </select>
    </div>

    <a class="btn-warning" href="AliPay.jsp">支付宝</a>
</div>

</body>
</html>

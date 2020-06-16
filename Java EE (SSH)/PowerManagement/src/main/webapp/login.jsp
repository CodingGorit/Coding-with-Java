<%--
  Created by IntelliJ IDEA.
  User: 伟
  Date: 2020/5/18
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<jsp:include page="base.jsp"></jsp:include>
<html>
<head>
    <title>Title</title>
</head>
<style>
    .container{
        display:table;
        height:100%;
    }

    .row{
        display: table-cell;
        vertical-align: middle;
    }
    /* centered columns styles */
    .row-centered {
        text-align:center;
    }
    .col-centered {
        display:inline-block;
        float:none;
        text-align:left;
        margin-right:-4px;
    }

    .code_a {
        font-size: 16px;
        cursor: pointer;
    }
    #imgCode {
        cursor: pointer;
    }

    .input-group {
        margin-top: 15px;
    }
</style>
<body>
<div class="container">
    <div class="row row-centered">
        <div class="well col-md-6 col-centered">
            <h2>欢迎登录</h2>
            <%--            <font color="red">${sessionScope.msg}</font>--%>
            <form action="checkLogin" method="post" role="form">
                <div class="input-group input-group-md">
                    <span class="input-group-addon">账户：</span>
                    <input type="text" class="form-control" id="userid" name="u.username" placeholder="请输入用户账户" value=""   maxlength="20"/><span id="res"></span>
                </div>
                <div class="input-group input-group-md">
                    <span class="input-group-addon" >密码：</span>
                    <input type="password" class="form-control" id="password" name="u.password" placeholder="请输入密码" value=""  maxlength="12"/><span></span>
                </div>
                <br/>
                <button type="submit" class="btn btn-success btn-block">登录</button>
                <div>
                    <font color="red"> ${msg} </font>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

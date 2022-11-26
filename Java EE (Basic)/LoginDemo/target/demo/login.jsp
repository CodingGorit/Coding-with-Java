<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style>
        .container {
            display: table;
            height: 20vh;
        }

        .login-form {
            display: grid;
            place-items: center;
        }

    </style>
</head>
<jsp:include page="base.jsp"/>
<body>
<div class="container">
    <div class="row row-centered">
        <div class="login-form">
            <h2>欢迎登录</h2>
            <span style="color: red; ">${sessionScope.err}</span>
            <form action="CheckLoginServlet" method="post" role="form">
                <div class="input-group input-group-md">
                    <span class="input-group-addon">账户：</span>
                    <input type="text" class="form-control" id="userid" name="username" placeholder="请输入用户账户" value="admin"  minlength="4" maxlength="20"/><span id="res"></span>
                </div>
                <div class="input-group input-group-md">
                    <span class="input-group-addon" >密码：</span>
                    <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码" value="admin" minlength="4" maxlength="12"/><span></span>
                </div>
                <br/>
                <button type="submit" class="btn btn-success btn-block">登录</button>
            </form>
        </div>
    </div>
    <script type="text/javascript">

        $("#userid").on("blur",function () {
            $.ajax({
                url:"CheckNameServlet",
                type:"post",
                data:{
                    username:$(this).val()
                },success:function (data) {
                    console.log(data);
                    if (data == 1) {
                        console.log("合法");
                        $("input:first").next().html("<font color='green'>账号合法</font>");
                    } else {
                        console.log("不合法");
                        $("input:first").next().html("<font color='red'>账号不合法</font>");
                    }
                }
            })
        })

        $("button[type=submit]").onclick(function () {

        })

    </script>
</body>
</html>

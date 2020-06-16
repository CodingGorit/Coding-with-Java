
<%--
  Created by IntelliJ IDEA.
  User: 伟
  Date: 2020/4/22
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <jsp:include page="base.jsp"/>
    <style type="text/css">
        /*web background*/
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
    </style>
</head>
<body>
<div class="container">
    <div class="row row-centered">
        <div class="well col-md-6 col-centered">
            <h2>欢迎登录</h2>
            <form action="checkLogin" method="post" role="form">
                <div class="input-group input-group-md">
                    <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-user" aria-hidden="true"></i></span>
                    <input type="text" class="form-control" id="userid" name="u.username" placeholder="请输入用户账户" value="Administrator"  maxlength="20"/><span></span>
                </div>
                <div class="input-group input-group-md">
                    <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-lock"></i></span>
                    <input type="password" class="form-control" id="password" name="u.password" placeholder="请输入密码" value="123456"  maxlength="12"/><span></span>
                </div>
                <br/>
                <button type="submit" class="btn btn-success btn-block">登录</button>
                <span>
                        <%
                            String msg = (String) request.getAttribute("msg");
                            if (msg != null) {
                                out.print("<font color='red'>"+msg+"</font>");
                            }
                        %>
                    </span>
            </form>
        </div>
    </div>

</div>
<script type="text/javascript">

    $("input[type=submit]").on("submit",function () {
        if (userid === true && password === true) {
            return true;
        } else {
            return false;
        }
    })

    // 监听账户
    let userid =$("#userid").on("change",function () {
        let username = $(this).val();
        // console.log(username);
        if (username.length >=6 && username.length <=20) {
            $(this).next().text("√");
            return true;
        }else {
            $(this).next().text("账号必须至少6位，至多20位");
            return false;
        }
    })

    let password =$("#password").on("change", function () {
        let password = $(this).val();
        // console.log(password);
        if (password.length >=6 && password.length<=12) {
            $(this).next().html("√");
            return true;
        } else {
            $(this).next().html("密码不符合要求（至少六位）");
            return false;
        }
    })

</script>

</body>
</html>

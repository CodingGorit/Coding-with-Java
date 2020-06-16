
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
    <%
        Cookie[] cs = request.getCookies();
        for (Cookie c:cs) {
            if ("accessMsg".equals(c.getName())) {
                // 登录情况还在
                // 1. 取出对应的 cookie 保存的值，存在 session 中
                session.setAttribute("username",c.getValue());
                // 2. 跳转到首页
                response.sendRedirect("show.jsp");
            }
        }
    %>
    <title>登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
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
</head>
<body>
<div class="container">
    <div class="row row-centered">
        <div class="well col-md-6 col-centered">
            <h2>欢迎登录</h2>
            <font color="red">${msg }</font>
            <form action="CheckLoginServlet" method="post" role="form">
                <div class="input-group input-group-md">
                    <span class="input-group-addon">账户：</span>
                    <input type="text" class="form-control" id="userid" name="username" placeholder="请输入用户账户" value="admin"  minlength="4" maxlength="20"/><span id="res"></span>
                </div>
                <div class="input-group input-group-md">
                    <span class="input-group-addon" >密码：</span>
                    <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码" value="admin" minlength="4" maxlength="12"/><span></span>
                </div>
                <div class="input-group input-group-md">
                    <span class="input-group-addon" >验证码：</span>
                    <input type="text" name="inCode" id="inCode" value="" />
                    <br><img src="CodeServlet" align="center" id="ImgCode" onclick="changeCode();"/>
                    <a class="code_a" onclick="changeCode();" style="line-height: 40px">换一张图片 </a> <span><font color="red">${requestScope.err}</font></span> <br/>
                </div>
                <br/>
                <button type="submit" class="btn btn-success btn-block">登录</button>
                <span></span>
            </form>
        </div>
    </div>

</div>
<script type="text/javascript" src="bootstrap/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
    function changeCode(img) {
        var imgCode = document.getElementById("ImgCode");
        imgCode.src = "CodeServlet?"+Math.random();
        //js 每次访问的路径相同，就不会进行刷新,但是加上一个随机数，每次访问的路径不一样，就会产生刷新的效果
    }

    $("#userid").on("blur",function () {
        $.ajax({
            url:"CheckNameServlet",
            type:"post",
            data:{
                username:$(this).val()
            },success:function (data) {
                console.log(data);
                if (data == "true") {
                    console.log("合法");
                    $("input:first").next().html("<font color='green'>账号合法</font>");
                } else {
                    console.log("不合法");
                    $(this).next().html("<font color='red'>账号不合法</font>");
                }
            }
        })
    })

</script>
</body>
</html>

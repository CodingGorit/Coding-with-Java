<!-- SpringMVC默认不支持EL表达式，需要使用isELIgnored="false"开启-->
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
	<title>登录</title>
</head>
<body>
	<div class="hight_def"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<form class="form-signin" action="loginSubmit.action" method="post">
					<h2 class="form-signin-heading">请输入用户名与密码</h2>
					<br> <label for="inputname" class="sr-only">用户名</label> <input
						type="text" id="inputname" name="account" value="admin"
						class="form-control" placeholder="请输入系统账户" required autofocus>
					<label for="inputPassword" class="sr-only">密 码</label> <input
						type="password" id="inputPassword" type="password" name="password"
						value="admin" class="form-control" placeholder="请输入密码" required>
					<div class="checkbox">
						<label style="color: red"> 
						<%
 							String loginErrMsg = (String) request.getAttribute("loginErrMsg");
							 if (loginErrMsg != null) {
							 	out.print(loginErrMsg);
							 }
						 %>
						</label>
					</div>
					<button type="submit" class="btn btn-lg btn-primary btnblock"
						type="submit">登 录 (Sign in)</button>
					<a class="btn btn-lg btn-info" href="${pageContext.request.contextPath}/register.action">去注册 (Sign Up)</a>
				</form>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
</body>
</html>
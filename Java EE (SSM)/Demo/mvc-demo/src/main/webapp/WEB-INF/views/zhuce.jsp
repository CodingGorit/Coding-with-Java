<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/regesiter" method="post">
		<label>用户名：</label>
		<input type="text" name="account" /><br/>
		<label>密码：</label>
		<input type="password" name="passwrod" /><br/>
		<label>性别：</label>
		<input type="radio" name="gender" value="男" />男
		<input type="radio" name="gender" value="女" />女<br/>
		<label>年龄：</label>
		<input type="text" name="age" /><br/>
		<label>电话：</label>
		<input type="text" name="phoneNum" /><br/>
		<label>身份证：</label>
		<input type="text" name="idCard" /><br/>
		<input type="submit" value="注册" />
	</form>
</body>
</html>
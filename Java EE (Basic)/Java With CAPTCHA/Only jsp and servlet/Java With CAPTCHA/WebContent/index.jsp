<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>随机验证码</title>
<style type="text/css">
	.code_a {
		color: #0000ff;
		font-size: 12px;
		text-decoration: none;
		cursor: pointer;
	}
	#imgCode {
		cursor: pointer;
	}
</style>

<script type="text/javascript">
	function changeCode() {
		var imgCode = document.getElementById("ImgCode");
		imgCode.src = "image?"+Math.random();
		//js 每次访问的路径相同，就不会进行刷新,但是加上一个随机数，每次访问的路径不一样，就会产生刷新的效果
		
	}
</script>
</head>
<body>
	<form action="CheckNewCode" method="post">
		<label>验证码：</label>
		<input type="text" name="inCode" id="inCode" value="" />
		<br><img src="image" align="center" id="ImgCode" onclick="changeCode();"/>
		<a class="code_a" onclick="changeCode();">换一张图片</a><br/>
		<input type="submit" value="登录"/>

	</form>
		<div style="color:red">${err}</div>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/style.css">
<!-- ============================= JavaScript =============================
-->
<script type="text/javascript">
	//【提交】增加用户
	function addUser() {
		var frm = document.getElementById("frm");
		frm.action = "${pageContext.request.contextPath}/userManage/doUserAdd.action"
		if (checkPwd() === false) {
			return false;
		}
		frm.submit();
	}
	//【校验】1）密码不能为空； 2）两次密码一致
	function checkPwd() {
		var pwd = document.getElementById("pwd").value;
		var cfm = document.getElementById("cfm").value;
		if (pwd === "") {
			alert("密码不能为空！");
			return false;
		} else if (pwd !== cfm) {
			alert("两次输入的密码不一致，请重新输入！");
			return false;
		}
		return true;
	}

	function handleBackPreviousPage() {
		window.history.back();
	}
</script>
</head>
<body>
	<div class="hight_def2"></div>
	<div class="container">
		<div class="well">
			<div class="row text-right">
				<a class="btn btn-danger" href="${pageContext.request.contextPath}/logout.action">登出</a>
				<button class="btn btn-info" onclick="handleBackPreviousPage()">返回</button>
			</div>
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-7">
					<form id="frm" method="post" class="form-horizontal">
						<h3>添加用户</h3>
						<table width="100%" class="table">
							<tr>
								<td align="right">系统账户：</td>
								<td><input type="text" name="account" class="form-control">
									<div style="color: red">${attrInfoUserAdd}</div></td>
							</tr>
							<tr>
								<td align="right">用户名：</td>
								<td><input type="text" name="name" class="form-control"></td>
							</tr>
							<tr>
								<td align="right">密码：</td>
								<td><input type="password" id="pwd" name="password"
									class="form-control"></td>
							</tr>
							<tr>
								<td align="right">密码确认：</td>
								<td><input type="password" id="cfm" name="cfmPassword"
									onblur="checkPwd()" class="form-control"></td>
							</tr>
							<tr>
								<td align="right">岗位：</td>
								<td><input type="text" name="job" class="form-control"></td>
							</tr>
							<tr>
								<td align="right">部门：</td>
								<td><select name="deptId" class="form-control">
										<c:forEach items="${attrDeptList}" var="dept">
											<option value="${dept.deptId}" selected="selected">${dept.deptName}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td align="right"><input type="checkbox" id="chk"
									name="enable" value="1" checked="checked"></td>
								<td><label for="chk"> 账户启用</label></td>
							</tr>
							<tr>
								<td align="right"></td>
								<td><input type="button" value="增加用户" onclick="addUser()"
									class="btn btn-success btn-block"></td>
							</tr>
						</table>
					</form>
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>
	</div>
</body>
</html>
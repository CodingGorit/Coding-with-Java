<!-- ********************* userUpdate.jsp ********************* -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<!-- ============================= JavaScript =============================
-->
<script type="text/javascript">
	//【提交】修改用户
	function updUser() {
		var frm = document.getElementById("frm");
		frm.action = "${pageContext.request.contextPath}/userManage/doUserUpdate.action";
		if (chkPassword() == true) {
			frm.submit();
		}
	}
	//【账户启用】点击checkbox时，改变它的值
	function changeValue() {
		var chk = document.getElementById("chkEnable");
		if (chk.checked) {
			chk.value = 1;
		} else {
			chk.value = 0;
		}
	}
	//【提交】修改用户
	function chkPassword() {
		//密码中必须包含字母、数字，至少8个字符，最多30个字符。
		var regex = new RegExp('(?=.*[0-9])(?=.*[a-zA-Z]).{8,30}');
		var objPwd = document.getElementById('pwd');
		if (objPwd.value != "") {
			if (objPwd.value.search(regex) == -1) {
				alert("密码长度为8-30个字符，且必须包含字母、数字！");
				objPwd.value = "";
				return false;
			}
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
						<h3>修改信息</h3>
						<table width="100%" class="table">
							<tr>
								<td align="right">系统账户：</td>
								<td><label style="fontsize: 20px">${attrUser.account}</label>
									<input type="hidden" name="id" value="${attrUser.id}" /></td>
							</tr>
							<tr>
								<td align="right">用户名：</td>
								<td><input type="text" name="name" value="${attrUser.name}"
									class="form-control"></td>
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
								<td><input type="text" name="job" value="${attrUser.job}"
									class="form-control"></td>
							</tr>
							<tr>
								<td align="right">部门：</td>
								<td><select name="deptId" class="form-control">
										<c:forEach items="${attrDeptList}" var="dept">
											<c:choose>
												<c:when test="${dept.deptId eq attrUser.deptId }">
													<option value="${dept.deptId}" selected="selected">${dept.deptName}</option>
												</c:when>
												<c:otherwise>
													<option value="${dept.deptId}">${dept.deptName}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td align="right"><input type="checkbox" name="enable"
									id="chkEnable"
									value="${empty attrUser.enable? 1:attrUser.enable }"
									onclick="changeValue()" ${attrUser.enable==1?"checked":"" } />
								</td>
								<td><label for="chkEnable"> 账户启用</label></td>
							</tr>
							<tr>
								<td align="right"></td>
								<td><input type="button" value="修改用户" onclick="updUser()"
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
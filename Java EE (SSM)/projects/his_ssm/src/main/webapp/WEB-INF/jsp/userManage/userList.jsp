<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/style.css">
</head>
<body>
	<div class="hight_def2"></div>
	<div class="container">
		<div class="row text-right">
			<a class="btn btn-danger" href="/logout.action">登出</a>
		</div>
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<form id="frmQuery" method="post" class="form-inline">
					<div class="form-group">
						<input type="search" name="txtUserName" value="${attrUserName}"
							placeholder="请输入账户或用户名"  class="form-control"/>
						<input type="button" value="查询用户" onclick="findUser()"
							class="btn btn-primary btn-sm" />
						<input type="button"
							value="添加用户" onclick="addUser()" class="btn btn-success btn-sm" />
						<input type="button" value="一键删除" onclick="delAll()"
							class="btn btn-danger btn-sm"
						/>
					</div>
				</form>
				<p></p>
				<form id="frmList">
					<table
						class="table table-striped table-bordered table-hover table-condensed">
						<tr>
							<th>多选<input
									type="checkbox"
									id="chooseAll"/></th>
							<th>系统账号</th>
							<th>用户名</th>
							<th>岗位</th>
							<th>部门</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${list}" var="user">
							<tr>
								<td class="text-center">
									<input type="checkbox" class="checkList" data-id="${user.id}"/>
								</td>
								<td>${user.account}</td>
								<td>${user.name}</td>
								<td>${user.job}</td>
								<td>${user.deptName}</td>
								<td><a
									href="${pageContext.request.contextPath}/userManage/userUpdate.action?id=${user.id}"
									class="btn btn-info btn-xs">修改 </a>&nbsp;&nbsp; 
									<a href="javascript:void(0)"
									onclick="delUser('${user.account}','${user.id}')"
									class="btn btn-danger btn-xs"> 删除</a></td>
							</tr>
						</c:forEach>
					</table>
					<input type="hidden" name="id" />
				</form>
				<nav class="text-right">
					<ul id="pagination" class="pagination">
						<c:choose>
							<c:when test="${pageNo>1}">
								<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/userManage/userList.action?pageNo=${pageNo-1 }">上一页</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link disabled" href="javascript:void(0);">上一页</a></li>
							</c:otherwise>
						</c:choose>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<c:choose>
							<c:when test="${pageNo<pageCount}">
								<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/userManage/userList.action?pageNo=${pageNo+1 }">下一页</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link disabled" href="javascript:void(0);">下一页</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</nav>
			</div>
		</div>
	</div>
	<!-- ============================= JavaScript ============================= -->
	<script type="text/javascript">
		const chooseAll = document.getElementById("chooseAll");
		const checkList = document.getElementsByTagName("input");

		const checkListArr = [];

		for (let i = 0; i < checkList.length; i++) {
			const obj = checkList[i];
			if (obj.className === "checkList") {
				checkListArr.push(obj);
			}
		}

		chooseAll.onclick = function() {
			const flag = chooseAll.checked;

			if (flag) {
				checkListArr.forEach(function(item) {
					item.checked = true;
				});
			} else {
				checkListArr.forEach(function(item) {
					item.checked = false;
				});
			}
		}


		//【提交】查询用户
		function findUser() {
			var frm = document.getElementById("frmQuery");
			frm.action = "${pageContext.request.contextPath}/userManage/userListbyName.action";
			frm.submit();
		}
		//【提交】增加用户
		function addUser() {
			var frm = document.getElementById("frmQuery");
			frm.action = "${pageContext.request.contextPath}/userManage/userAdd.action";
			frm.submit();
		}
		//【提交】删除用户
		function delUser(account, id) {
			var frm = document.getElementById("frmList");
			var isDel = confirm("确定要删除系统账户：" + account + " 吗？");
			if (isDel === true) {
				var hidden = document.getElementsByName("id")[0];
				hidden.value = id;
				frm.action = "${pageContext.request.contextPath}/userManage/doUserDelete.action";
				frm.submit();
			}
		}

		function delAll () {
			// if (!chooseAll.checked) {
			// 	alert("请先选中全部数据才能执行一键删除");
			// 	return;
			// }

			const isDel = confirm("确定要删除选中数据吗？");
			if (isDel) {
				const url = "${pageContext.request.contextPath}/userManage/doUserDeleteAll.action";
				const deleteId = [];
				for (let i = 0; i < checkListArr.length; i++) {
					if (checkListArr[i].checked) {
						if (checkListArr[i].dataset.id) {
							deleteId.push(checkListArr[i].dataset.id);
						}
					}
				}
				console.log(deleteId);

				fetch(url,{
					method: "POST",
					headers: {
						'Content-Type': 'application/json'
					},
					body: JSON.stringify({
						list: deleteId
					})
				}).then((data) => {
					return  data.text();
				}).then((res) => {
					console.log(res);

					// 刷新当前页面
					window.location.reload();
					if (res === "success") {
						alert("删除成功！");
					} else {
						alert("删除失败");
					}
				})
			}
		}

	</script>
</body>
</html>
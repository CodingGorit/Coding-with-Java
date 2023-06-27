<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
  <title>注册</title>
</head>
<body>
<div class="hight_def"></div>
<div class="container">
  <div class="well">
    <div class="row">
      <div class="col-md-2"></div>
      <div class="col-md-7">
        <form id="frm" method="post" class="form-horizontal">
          <div class="text-center">
            <h3>注册账户</h3>
          </div>
          <table width="100%">
            <tr>
              <td align="right">账户：</td>
              <td><input type="text" name="account" class="form-control">
                <div style="color: red">${attrInfoUserAdd}</div>
              </td>
            </tr>
            <tr>
              <td align="right">昵称：</td>
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
              <td>
                <select name="deptId" class="form-control">
                  <c:forEach items="${list}" var="dept">
                    <option value="${dept.deptId}" selected="selected">${dept.deptName}</option>
                  </c:forEach>
              </select>
              </td>
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
<script type="text/javascript">
  //【提交】增加用户
  function addUser() {
    var frm = document.getElementById("frm");
    frm.action = "${pageContext.request.contextPath}/doUserRegister.action"
    if (checkPwd() == false) {
      return false;
    }
    frm.submit();
  }
  //【校验】1）密码不能为空； 2）两次密码一致
  function checkPwd() {
    var pwd = document.getElementById("pwd").value;
    var cfm = document.getElementById("cfm").value;
    if (pwd == "") {
      alert("密码不能为空！");
      return false;
    } else if (pwd != cfm) {
      alert("两次输入的密码不一致，请重新输入！");
      return false;
    }
    return true;
  }
</script>
</body>
</html>
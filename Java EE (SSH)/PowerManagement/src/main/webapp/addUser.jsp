<%--
  Created by IntelliJ IDEA.
  User: 伟
  Date: 2020/5/19
  Time: 8:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="base.jsp"></jsp:include>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<div class="container" style="margin-top: 20px">
    <table class="table table-striped table-bordered text-center table-hover table-condensed" style="margin-top: 20px;">
        <div>
            <button class="btn btn-primary"  style="float: left" name="Submit" onclick="javascript:history.back(-1);" value="返回上一页">返回上一页</button>
            <button class="btn btn-primary"
                    style="float: right;margin: 5px"
                    data-toggle="modal"
                    data-target="#myModal">添加</button>
        </div>
        <thead>
        <tr>
            <td>id</td>
            <td>账户</td>
            <td>密码</td>
            <td>状态</td>
            <%--        <td>操作</td>--%>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${list}">
            <tr>
                <td>${item.getId()}</td>
                <td>${item.getUsername()}</td>
                <td>********</td>
                <td>${item.getStatus()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- 模态框 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title text-primary" id="myModalLabel">添加用户</h4>
                <button type="button" class="close float-left" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">
                <form method="post" class="from-horizontal" role="form" style="margin: 20px">
                    <div class="form-group">
                        <label for="user_id" class="col-sm-3 control-label">用户账户</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="user_id" name="addStuId" value=""
                                   placeholder="请输入用户账户">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="user_id" class="col-sm-3 control-label">用户密码</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="user_id" name="addStuId" value=""
                                   placeholder="请输入用户密码">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="user_id" class="col-sm-3 control-label">用户状态</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="user_id" name="addStuId" value=""
                                   placeholder="请输入用户状态">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id="delete" class="btn btn-primary">确定添加</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>

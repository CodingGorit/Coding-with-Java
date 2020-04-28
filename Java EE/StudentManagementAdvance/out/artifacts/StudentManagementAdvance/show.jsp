<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.gorit.entity.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 伟
  Date: 2020/4/22
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%     // 登录验证: 如何验证用户的登录状态
    if (session.getAttribute("username") == null) {
        // 没有登录
        response.sendRedirect("login.jsp");
    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎来到学生管理系统</title>
    <jsp:include page="base.jsp"/>
</head>
<body>
    <div class="container">

        <div class="jumbotron">
            <h3 class="text-center">欢迎${sessionScope.username} 进入学生管理系统</h3>
        </div>

        <table class="table table-striped table-bordered text-center table-hover table-condensed" style="margin-top: 20px;">
            <button class="btn btn-primary text-right" value="添加" data-toggle="modal" data-target="#addUserModal" data->添加</button>
            <thead>
            <tr>
                <td>学号</td>
                <td>姓名</td>
                <td>年龄</td>
                <td>班级</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${list}">
                    <tr>
                        <td>${item.getStuId()}</td>
                        <td>${item.getStuName()}</td>
                        <td>${item.getStuAge()}</td>
                        <td>${item.getClassz()}</td>
                        <td><a href="edit_student.jsp?stuId=${item.getStuId()}&StuName=${item.getStuName()}&StuAge=${item.getStuAge()}&Classz=${item.getClassz()}"
                               class="btn btn-primary"
                        >修改</a>
                            <a href="DeleteStudentServlet"
                               class="btn btn-danger"
                               id="delete_student"
                               onclick="Values(${item.getStuId()})"
                               data-toggle="modal"
                               data-target="#myModal">删除</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <%
//            int num = 0;
//            if (application.getAttribute("num") != null ) {
//                Integer n = (Integer)application.getAttribute("num");
//                num = n;
//            }
//            num++;
//            application.setAttribute("num",num);

            List loginerdUsers = new ArrayList(); //访问者列表
            if (application.getAttribute("LOGINED_USER") != null) {
                loginerdUsers = (List)application.getAttribute("LOGINED_USER");
            }
        %>
        <div class="text-right">您是第 <%=loginerdUsers.size()%> 位成员</div>
    </div>

    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title text-danger" id="myModalLabel">Warming ！！！</h4>
                    <button type="button" class="close float-left" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">你确认要删除该学生的信息吗？一旦删除就无法逆转</div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" id="delete" class="btn btn-primary">确定删除</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

    <!-- 模态框示例（Modal） -->
    <form method="post" action="" class="form-horizontal" role="form" id="form_data"  style="margin: 20px;">
        <div class="modal fade" id="addUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title text-left text-primary" id="myModalLabel">
                            用户信息
                        </h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            &times;
                        </button>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" role="form" method="AddStudentServlet" method="post">
                            <div class="form-group">
                                <label for="user_id" class="col-sm-3 control-label">用户ID</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="user_id" name="addStuId" value=""
                                           placeholder="请输入学生学号">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="user_name" class="col-sm-3 control-label">学生姓名</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="addStuName" value="" id="user_name"
                                           placeholder="用户名">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="stuAge" class="col-sm-3 control-label">年龄</label>
                                <div class="col-sm-9">
                                    <input type="text"
                                           class="form-control"
                                           name="addStuAge"
                                           value=""
                                           id="stuAge"
                                           placeholder="请输入学生的年龄"
                                           maxlength="8"
                                    >
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="stuClazz" class="col-sm-3 control-label">专业班级</label>
                                <div class="col-sm-9" style="display: flex">
                                    <select class="dropup" id="grade">
                                        <option selected value="大一">大一</option>
                                        <option value="大二">大二</option>
                                        <option value="大三">大三</option>
                                        <option value="大四">大四</option>
                                    </select>
                                    <input type="text" class="form-control" name="addStuClazz" value="" id="stuClazz"
                                           placeholder="eg：物联网3班">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                        </button>
                        <button type="submit" class="btn btn-primary" id="btn_submit_addStu">
                            提交
                        </button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->


    <script type="text/javascript">
        // 删除时定义的全局变量
        let stuID; // 删除时需要的学生的 ID，不可乱改！！！

        // 添加时定义的全局变量
        let Grade = "大一"; // 学生年级
        let studentClazz; // 学生班级
        let user_id;  // 添加时的，学生的 id
        let user_name; //
        let stuAge;
        let stuClazz; // 添加时学生的 年级，拼接之后的数据 ！！！

        $("#delete").on('click',function () {
            console.log((stuID));
            window.location.href = $("#delete_student").prop("href") + "?stuID="+stuID;
        })

        function Values(id) {
            stuID = id;
        }



        // 获取添加表单的学号
        $("#user_id").on("blur",function () {
            console.log($(this).val());
            user_id = $(this).val();
        })

        // 获取添加表单的学生姓名
        $("#user_name").on("blur",function () {
            console.log($(this).val());
            user_name = $(this).val();
        })

        // 获取添加表单的学生的年龄
        $("#stuAge").on("blur",function () {
            console.log($(this).val());
            stuAge = $(this).val();
        })

        // 获取下拉选择框的值
        $("#grade").on("change",function () {
            Grade = $('#grade option:selected').val();
            console.log($('#grade option:selected').val());
        })

        // 获取班级信息
        $("#stuClazz").on("blur",function () {
            studentClazz = $(this).val();
            let Claszz = "";
            Claszz =Grade +" "+$(this).val();
            stuClazz = Claszz; // 保存至全局变量
            console.log(Claszz);
            $(this).val(Claszz); // 替换数据
        })


        $("#btn_submit_addStu").on("click",function () {
            window.location.href = "show.jsp";
            $.ajax({
                type :"POST",
                url:"AddStudentServlet",
                data: {
                    addStuId:user_id,
                    addStuName:user_name,
                    addStuAge:stuAge,
                    addStuClazz:stuClazz,
                    Grade:Grade,
                    studentClazz:studentClazz
                },

            })
        })

    </script>
</body>
</html>

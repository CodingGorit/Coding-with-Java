<%--
  Created by IntelliJ IDEA.
  User: 伟
  Date: 2020/4/22
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%     // 登录验证: 如何验证用户的登录状态
    if (session.getAttribute("user") == null) {
        // 没有登录
        response.sendRedirect("login.jsp");
    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学生信息</title>
    <jsp:include page="base.jsp"/>
    <style type="text/css">
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

        form {
            border: 1px solid #333;
            height: 400px;
        }

        #btn_submit_addStu {
            margin-top: 15px;
        }
    </style>
</head>
<body>
<%
    String StuId = request.getParameter("stuId");
    String StuName = request.getParameter("StuName");
    String StuAge = request.getParameter("StuAge");
    String Classz = request.getParameter("Classz");
%>
<div class="container ">
    <div class="row row-centered">
        <h4>当前学生的信息</h4>
        <table class="table table-striped table-bordered text-center table-hover table-condensed">
            <thead>
                <td>类别</td>
                <td>信息</td>
            </thead>
            <tbody>
                <tr>
                    <td>学号：</td>
                    <td><%=StuId%></td>
                </tr>
                <tr>
                    <td>姓名：</td>
                    <td><%=StuName%></td>
                </tr>
                <tr>
                    <td>年龄：</td>
                    <td><%=StuAge%></td>
                </tr>
                <tr>
                    <td>班级：</td>
                    <td><%=Classz%></td>
                </tr>
            </tbody>
        </table>

        <h3 class="text-primary">修改学生信息</h3>
        <div class="well col-md-6 col-centered">
            <form action="updateStudent?stuId=<%=StuId%>" method="post" role="form">
                <div class="form-group">
                    <label for="user_id" class="col-sm-3 control-label">用户ID</label>
                    <div class="col-sm-9">
                        <input type="text"
                               disabled
                               class="form-control"
                               id="user_id"
                               name="stu.stuId"
                               value="<%=StuId%>"
                        >
                    </div>
                </div>

                <div class="form-group">
                    <label for="user_name" class="col-sm-3 control-label">学生姓名</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="stu.stuName" value="" id="user_name"
                               placeholder="用户名">
                    </div>
                </div>

                <div class="form-group">
                    <label for="stuAge" class="col-sm-3 control-label">年龄</label>
                    <div class="col-sm-9">
                        <input type="text"
                               class="form-control"
                               name="stu.stuAge"
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
                        <input type="text"
                               class="form-control"
                               name="stu.classz"
                               value=""
                               id="stuClazz"
                               placeholder="eg：物联网3班">
                    </div>

                    <div class="col-sm-9" style="display: flex">
                        <input type="submit" class="btn btn-primary"  id="btn_submit_addStu"/>
                        <button type="button" class="btn btn-primary" onclick="window.history.back(-1);">
                            返回
                        </button>
                    </div>
                </div>

            </form>
        </div>
    </div>
</div>

    <script type="text/javascript">
        // 添加时定义的全局变量
        let Grade = "大一"; // 学生年级
        let studentClazz; // 学生班级
        let user_id=$("#user_id").val();  // 添加时的，学生的 id
        let user_name; //
        let stuAge;
        let stuClazz; // 添加时学生的 年级，拼接之后的数据 ！！！

        // 获取添加表单的学号

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

        // $("#btn_submit_addStu").on("click",function () {
        //     $.ajax({
        //         type :"POST",
        //         url:"updateServlet",
        //         data: {
        //             addStuId:user_id,
        //             addStuName:user_name,
        //             addStuAge:stuAge,
        //             addStuClazz:stuClazz,
        //             Grade:Grade,
        //             studentClazz:studentClazz
        //         },
        //         success:function (res) {
        //             console.log("发送成功！！！");
        //             window.location.reload(); // 刷新页面
        //         }
        //     })
        // })
    </script>

</body>
</html>

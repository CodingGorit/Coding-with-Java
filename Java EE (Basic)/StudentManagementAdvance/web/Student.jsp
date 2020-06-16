<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生页面分页实现</title>
    <jsp:include page="base.jsp"/>
</head>
<body>
<div class="container">
    <table class="table table-striped table-bordered text-center table-hover table-condensed" style="margin-top: 20px;">

        <tbody>

        </tbody>
    </table>
    <nav style="align-content: center">
        <ul id="pagination" class="pagination">
            <li class="page-item"><button class="page-link"  id="lastPage" >上一页</button></li>
            &nbsp;&nbsp;&nbsp;
            <li class="page-item"><button class="page-link" id="currentPage" value="${pageNo}" >${pageNo}</button></li>
            &nbsp;&nbsp;&nbsp;
            <li class="page-item"><button class="page-link"  value="..." >...</button></li>
            &nbsp;&nbsp;&nbsp;
            <li class="page-item"><button class="page-link" id="maxPage" value="${pageCount}">${pageCount}</button></li>
            <li class="page-item"><button class="page-link"  id="nextPage">下一页</button></li>
        </ul>
    </nav>
</div>
<script>
    let pageNo = $("#currentPage").val();
    let pageCount = $("#maxPage").val();
    $("#lastPage").on("click",function () {
        console.log("点击了上一页");

        if (pageNo<=1) {
            // 如果本身就是第一个，就禁用按钮
            alert("已经是第一个了");
            pageNo = 1;
            $(this).parent().addClass("disabled");
        } else {
            pageNo--;
            $(this).parent().remove("disabled");
        }
        $.ajax({
            url:"GetStuServlet",
            type:'post',
            data:{
                "pageNo":pageNo
            },success:function (data) {
                // console.log(data);
                let msg = "";
                $(data).each(function (i, s) {
                    msg += "<tr>";
                    msg += "<td>" + s.stuId + "</td>";
                    msg += "<td>" + s.stuName + "</td>";
                    msg += "<td>" + s.stuAge + "</td>";
                    msg += "<td>" + s.classz + "</td>";
                    msg += "</tr>";
                })
                $("tbody").html(msg);
            }
    })

    $("#nextPage").on("click",function () {
        pageNo++;
        if (pageNo<pageCount) {
            $(this).parent().remove("disabled");
        } else {
            alert("已经是最后一个了");
            pageNo = 3;
            $(this).parent().addClass("disabled");
        }
        $.ajax({
            url:"GetStuServlet",
            type:'post',
            data:{
                "pageNo":pageNo
            },success:function (data) {
                console.log(data);
                let msg = "";
                $(data).each(function (i,s) {
                    msg+="<tr>";
                    msg+="<td>"+s.stuId+"</td>";
                    msg+="<td>"+s.stuName+"</td>";
                    msg+="<td>"+s.stuAge+"</td>";
                    msg+="<td>"+s.classz+"</td>";
                    msg+="</tr>";
                })
                $("tbody").html(msg);
            }
        })
    })
</script>
</body>
</html>

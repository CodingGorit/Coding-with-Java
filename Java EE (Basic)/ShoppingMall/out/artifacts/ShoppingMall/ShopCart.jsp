<%--
  Created by IntelliJ IDEA.
  User: 伟
  Date: 2020/4/26
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>购物车界面</title>
</head>
<body>
<jsp:include page="base.jsp"/>
    <div class="container">
        <h3 class="text-sm-center"> 欢迎来到购物车界面</h3>
        <table class="table table-striped table-bordered text-center table-hover table-condensed" style="margin-top: 20px;">
            <thead>
            <tr>
                <td>全选<input type="checkbox" id="chooseAll"></td>
                <td>商品编号</td>
                <td>商品名称</td>
                <td>单价</td>
                <td>数量</td>
                <td>小计</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="list" items="${slist1}">
                    <tr>
                            <%--所有复选框--%>
                        <td><input type="checkbox" class="i2"/></td>
                        <td>${list.getShopNO()}</td>
                        <td>${list.getProductName()}</td>
                        <td>${list.getPrice()}</td>
                        <td>
                            <button class="b1">-</button>
                            <input type="text" value="${list.getNum()}" size="1" />
                            <button class="b2">+</button>
                        </td>
                        <td>${list.getPrice()*list.getNum()}</td>
                        <td><button class="btn btn-danger b3">删除</button></td>
                    </tr>
                </c:forEach>
                    <tr>
                        <td colspan="7" align="right">已选<span id="productCount">0</span>件商品 应付金额：<label id="payment">0</label>元</td>
                    </tr>
            </tbody>

        </table>
        <div style="display: flex;justify-content: space-between">
            <div>
                <button class="btn-primary text-right" value="返回" onclick="window.history.back()">返回</button>
            </div>
            <div>
                <button  id="cost" class="btn-primary">去付款</button>
            </div>
        </div>

        <script>
            $("#cost").on('click',function () {
                console.log($("#payment").text());
                let money = $("#payment").text();
                window.location.href = "CostServlet?money="+money;
            })

            // 计算总金额以及总数
            function calc() {
                let productCount = 0; // 单个总数
                let payment = 0; // 单个小计总金额

                $(".i2").each(function (i,s) { // 拿到所有复选框
                    // 是否选中
                    if ($(s).prop("checked" )) {
                        console.log($(this).parent().next().next().next().next().children("input").val()); // 数量
                        console.log($(this).parent().next().next().next().text()); // 单价
                        console.log($(this).parent().next().next().next().next().next().text());
                        // 得到这一行的数量和小计
                        productCount+=parseFloat($(this).parent().next().next().next().next().children("input").val());
                             payment+=parseInt($(this).parent().next().next().next().text()); // 小计
                        $(this).parent().next().next().next().next().next().text(payment*productCount)
                    }
                })
                // 更新总量
                $("span").text(productCount);
                $("label").text(payment*productCount);
            }

            $(function(){
                //全选效果
                $("#chooseAll").click(function(){
                    //判断是选中还是取消
                    var flag=$(this).prop("checked");
                    if(flag){
                        //选中了
                        //获取下面商品所有的checkbox
                        $(".i2").prop("checked",true);
                    }else{
                        //取消了
                        $(".i2").prop("checked",false);
                    }
                    // 计算一下总数 以及 总价格
                    calc();
                })

                //单选判断
                $(".i2").click(function(){
                    //获取所有的复选框是否选中
                    var f=$(this).prop("checked");
                    if(f){//当前这个按钮是选中的
                        //判断其他的复选框也是否选中
                        $(".i2").each(function(i,s){
                            if(!$(s).prop("checked")){//如果有一个没有选中
                                f=false;
                            }
                        })

                        if(f){//全部选中的
                            $("#i1").prop("checked",true);
                        }
                    }else{//当前这个按钮是取消的
                        $("#i1").prop("checked",false);
                    }
                    // 计算一下总数 以及 总价格
                    calc();
                })

                //减法
                $(".b1").click(function(){
                    //获取后面的input标签的值
                    var num=$(this).next().val();
                    let ShopNO = $(this).parent().parent().children()[1].outerText; // 商品编号

                    if(num>1){
                        //视图的数据发生更改
                        num--;
                        $.ajax({
                            url:"updateProductCountServlet",
                            type:"post",
                            data:{
                                ShopNO:ShopNO,
                                num:num
                            },success:function (data) {
                                if (data == "ok") {
                                    alert("修改成功");
                                } else {
                                    alert("修改失败");
                                }
                            }
                        })
                        $(this).next().val(num);
                        var price=$(this).parent().next().text();
                        // 总量变化
                        $(this).parent().next().text(price*num);
                        //数据库的数据发生更改
                    }else{//数量等于或小于1
                        var flag=confirm("数量为1，不可再减，点击确定商品删除！");
                        if(flag){
                            //找到当前的父标签的父标签tr，把整行数据全部删除
                            let td = $(this).parent().parent();
                            //数据库中删除当前这行数据
                            console.log(ShopNO);
                            $.ajax({
                                url: 'deleteShopCartByShopNoServlet',
                                type:"get",
                                data: {ShopNO:ShopNO},
                                success:function (data) {
                                    console.log(data);
                                    if (data == "1") {
                                        td.remove();
                                        alert("删除成功！！！");
                                    } else {
                                        alert("删除失败");
                                    }
                                    calc();
                                }
                            })
                        }
                    }
                    // 计算一下总数 以及 总价格
                    calc();
                })

                //加法
                $(".b2").click(function(){
                    var num=$(this).prev().val();
                    let ShopNO = $(this).parent().parent().children()[1].outerText;
                    console.log(ShopNO);
                    num++;
                    $.ajax({
                        url:"updateProductCountServlet",
                        type:"post",
                        data:{
                            ShopNO:ShopNO,
                            num:num
                        },success:function (data) {
                            if (data == "ok") {
                                alert("修改成功");
                            } else {
                                alert("修改失败");
                            }
                        }
                    })
                    $(this).prev().val(num);
                    var price=$(this).parent().next().text();

                    //小计更改
                    $(this).parent().next().text(price*num);
                    // 计算一下总数 以及 总价格
                    calc();
                })

                //删除数据
                $(".b3").click(function(){
                    let td =  $(this).parent().parent();
                    let ShopNO = $(this).parent().parent().children()[1].outerText;
                    console.log(ShopNO);
                    $.ajax({
                        url: 'deleteShopCartByShopNoServlet',
                        type:"get",
                        data: {ShopNO:ShopNO},
                        success:function (data) {
                            console.log(data);
                            if (data == "1") {
                                td.remove();
                                alert("删除成功！！！")
                            } else {
                                alert("删除失败！！！");
                            }

                            calc();
                        }
                    })

                })

            })
        </script>
    </div>
</body>
</html>

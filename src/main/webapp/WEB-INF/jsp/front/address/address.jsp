<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>首页</title>
    <link type="text/css" rel="stylesheet" href="${ctx}/resource/user/css/style.css">
    <style type="text/css">
        .address:hover{
            cursor: pointer;
        }
    </style>
</head>
<body>
<%@include file="/common/utop.jsp" %>
<!--导航条-->
<div class="width100" style="height: 45px;background: #bed73e;margin-top: 40px;position: relative;z-index: 100;">
    <!--中间的部分-->
    <div class="width1200 center_yh relative_yh" style="height: 45px;">
        <!--普通导航-->
        <div class="left_yh font16" id="pageNav">
            <a href="${ctx}/front/index">首页</a>
        </div>
    </div>
</div>

<div class="width1200 center_yh hidden_yh font14" style="height: 40px;line-height: 40px;">
    <span>当前位置：</span><a href="${ctx}/front/index" class="c_66">首页</a>
    ><a href="javascript:;" class="c_66">填写地址</a>
</div>
<div class="width1200 center_yh hidden_yh font14" >
    <form action="${pageContext.request.contextPath}/front/address/insertaddress" method="POST">
        <input type="hidden" name="uid" value="${iusers.id}"/>
        收货人：<input type="text" name="name" lay-verify="required" autocomplete="off" placeholder="请输入收货人" maxlength="24" style="border:0;border-bottom: 1px solid #ccc;"/>
        收货地址<input type="text" name="address" lay-verify="required" autocomplete="off" placeholder="请输入收货地址" maxlength="24"style="border:0;border-bottom: 1px solid #ccc;"/>
        电话：<input type="text" name="phone" lay-verify="required" autocomplete="off" placeholder="请输入电话" maxlength="24"style="border:0;border-bottom: 1px solid #ccc;"/>
        <button type="submit" class="address" style="width: 112px;height: 30px;text-align: center;font-size: 16px;color: #000;display: inline-block;vertical-align: middle;">新增收货地址</button>
    </form>
</div>
<div class="width1198 hidden_yh center_yh" style="margin-top: 18px;min-height: 300px;">
    <div class="width100 hidden_yh font14" style="height: 32px;line-height: 32px;
    background: #f0f0f0;text-indent: 21px;color: #000; font-weight: 600;border-bottom: 1px solid #ddd;">所有地址
    </div>
    <div class="width100 hidden_yh fon14" style="height: 42px;line-height: 42px;border-bottom: 1px solid #ddd;">
        <div class="left_yh tcenter font14" style="width: 350px;">收货人</div>
        <div class="left_yh tcenter font14" style="width: 175px;">收货地址</div>
        <div class="left_yh tcenter font14" style="width: 175px;">电话</div>

    </div>
    <c:forEach items="${addressList}" var="address" varStatus="l">
        <div class="speCific" data-addressId="${address.id}">
<%--            <div class="xzWxz" style="margin-top: 28px;">--%>
<%--                <b><img src="${ctx}/resource/user/images/xzwxz.png"></b>--%>
<%--            </div>--%>
            <div class="xzSp">
                    <%--                <img src="${pageContext.request.contextPath}/DisplayImage?src=${data.goods.goodsImg}">--%>
                <div class="xzSpIn" style="width: 318px;margin-top:51px">
                    <h3 class="font16 c_33 font100">${address.name}</h3>
                </div>
            </div>
            <div class="xzJg">
                <font>${address.address}</font>
            </div>
            <div class="xzXj" style="color:#000"><font>${address.phone}</font></div>
            <div class="xzSz">
                <div class="xzCzIn">
                    <a href="javascript:void(0)" class="Dels" data-id="${address.id}">删除</a>
                </div>
            </div>
            <div class="sXd">
                <a href="javascript:void(0)" class="ifJs" onclick="ifJs()">下单</a>
            </div>
        </div>
    </c:forEach>
</div>


<script src="${ctx}/resource/user/js/jquery-1.8.3.min.js"></script>
<script src="${ctx}/resource/user/js/jquery.luara.0.0.1.min.js"></script>
<script>
    //总的子项数量
    var es = $(".speCific").length;
    //给小计赋值

    //选择或不选择一项


    //计算总计

    //保留两位小数
    function sswr(num) {
        return num.toFixed(2);
    }



    //单项删除
    $(".Dels").click(function () {
        var id = $(this).attr("data-id");
        $.ajax({
            type: "DELETE",
            url: "${ctx}/rest/address/delete/" + id,
            contentType: "application/json",
            success: function (result) {
            }
        });
        alert("删除成功");
        $(this).parent().parent().parent().remove();

    });

    //批量删除


    /**
     * 结算--进入购买流程
     */
    function ifJs() {
        var addressId = null
        var obj = {}
        // $(".xzWxz.on").each(function () {
        //     addressId = $(this).parent().attr("data-addressId");
        //     addressId = parseInt(addressId)
        //     obj["addressId"] = addressId
        // });


        console.log(typeof addressId)
        if (${!!iuser.id}) {
            alert("请登录");
            window.location.href = "${ctx}/front/indexlogin";
        } else {
            // sXd
            addressId = $(".sXd").parent().attr("data-addressId");
            addressId = parseInt(addressId)
            obj["addressId"] = addressId
            $.ajax({
                type: "POST",
                url: "${ctx}/rest/orders/add",
                data: JSON.stringify(obj),
                contentType: "application/json",
                success: function (result) {
                    if (result.code == -1) {
                        alert("库存不足");
                    } else {
                        alert("下单成功");
                        window.location.href = "${ctx}/front/itemOrders";
                    }
                }
            });
        }


    }
</script>
<%@include file="/common/ufooter.jsp" %>
</body>
</html>




















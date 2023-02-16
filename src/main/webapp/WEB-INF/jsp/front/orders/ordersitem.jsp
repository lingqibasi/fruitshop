<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>首页</title>
    <link type="text/css" rel="stylesheet" href="${ctx}/resource/user/css/style.css">
    <script src="${ctx}/resource/user/js/jquery-1.8.3.min.js"></script>
    <script src="${ctx}/resource/user/js/jquery.luara.0.0.1.min.js"></script>
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
<%--            <a href="${ctx}/news/list">公告</a>--%>
            <%--            <a href="${ctx}/message/add">留言</a>--%>
        </div>
    </div>
</div>

<div class="width1200 center_yh hidden_yh font14" style="height: 40px;line-height: 40px;">
    <span>当前位置：</span><a href="${ctx}/front/index" class="c_66">首页</a>
    ><a href="#" class="c_66">个人中心</a>
    ><a href="#" class="c_66">我的订单</a>
</div>
<div class="width100 hidden_yh" style="background: #f0f0f0;padding-top: 34px;padding-bottom: 34px;">
    <div class="width1200 hidden_yh center_yh">
        <div id="vipNav">
            <a href="${ctx}/front/my">个人信息</a>
            <a href="${ctx}/front/itemOrders" class="on">我的订单</a>
            <%--            <a href="${ctx}/sc/findBySql">商品收藏</a>--%>
            <%--            <a href="${ctx}/login/pass">修改密码</a>--%>
        </div>
        <div id="vipRight">
            <div style="width: 938px;border:1px solid #ddd;background: #fff;">
                <div class="width100 hidden_yh"
                     style="height: 74px;line-height: 74px;background: #f5f8fa;border-bottom: 1px solid #ddd;"
                     id="navLt">
                    <span class="left_yh font24 width20 tcenter cursor onHover onorange slect">全部订单（${detail.size()}）</span>

                </div>
                <!--全部订单-->
                <div class="allGoods width100 hidden_yh hhD" style="display: block;">
                    <c:forEach items="${detail}" var="data" varStatus="l">

                        <div class="width100 hidden_yh">
                            <div class="width100 hidden_yh fon20 c_66"
                                 style="background:#faf5f5;text-indent: 47px;height: 50px;line-height: 50px;border-bottom: 1px solid #ddd;">
                                    <%--                                <fmt:formatDate value="" type="both"/>&nbsp;&nbsp;订单号${data.orderSn}&nbsp;&nbsp;--%>
                                <c:if test="${data.state==0}">待发货(货到付款)</c:if>
                                <c:if test="${data.state==1}">已发货(货到付款)</c:if>
                                    <%--                                <c:if test="${data.state==2}">待收货</c:if>--%>
                                <c:if test="${data.state==2}">已收货</c:if>
                            </div>
                            <c:forEach items="${data.ordersDetail}" var="chil" varStatus="l">
                                <div style="width: 838px;border-bottom: 1px dashed #ddd;padding-top: 30px;padding-bottom: 30px;"
                                     class="hidden_yh center_yh">
                                    <img src="${pageContext.request.contextPath}/DisplayImage?src=${chil.goods_img}"
                                         width="100" height="100" class="left_yh" style="padding-right: 10px">
                                    <div class="left_yh" style="width: 580px;">
                                        <h3 class="font18 c_33 font100">${chil.goods_name}</h3>
                                            <%--                                        <p class="c_66 font16" style="margin-top: 16px;">折扣：${chil.item.zk}</p>--%>
                                        <p class="red" style="margin-top: 10px;">￥${chil.price}</p>
                                        <span>数量${chil.num}</span>
                                    </div>
                                        <%--                                    <div class="right_yh">--%>
                                        <%--                                        <c:if test="${data.state==3}">--%>
                                        <%--                                            <a href="${ctx}/itemOrder/pj?id=${chil.goodsId}" class="onfff block_yh tcenter font16 onHoverr" style="margin-top: 10px;padding-right: 6px;">--%>
                                        <%--                                                去评价--%>
                                        <%--                                            </a>--%>
                                        <%--                                        </c:if>--%>
                                        <%--                                    </div>--%>
                                </div>
                            </c:forEach>
                            <div style="margin: 10px 40px;padding: 10px;border-bottom: 1px dashed #ccc;">
                                <span>收货人：&nbsp;&nbsp;&nbsp; <p
                                        style="display: inline-block;color: #e46262;">${data.address.name}</p></span>
                                <span style="margin:0 10px">收货地址：&nbsp;&nbsp;&nbsp; <p
                                        style="display: inline-block;color: #e46262;">${data.address.address}</p></span>
                                <span>联系电话：&nbsp;&nbsp;&nbsp; <p
                                        style="display: inline-block;color: #e46262;">${data.address.phone}</p></span>
                            </div>
                            <div style="width: 838px;padding-top:30px;padding-bottom: 30px;"
                                 class="hidden_yh center_yh tleft">
                                <font class="font24">总金额</font>
                                <font class="font24 red">￥${data.totalPrice}</font>
                                <c:if test="${data.state==0}">
                                    <a href="${ctx}/front/orders/delete?id=${data.id}"
                                       class="c_33 onHover font20 onorange right_yh cancel" data-oid="${data.id}"
                                       style="margin-top: 10px;padding-right: 6px;">
                                        取消订单
                                    </a>
                                </c:if>
                                <c:if test="${data.state==1}">
                                    <a href="javascript:;" class="c_33 onHover font20 onorange right_yh shouhuo"
                                       data-id="${data.id}" style="margin-top: 10px;padding-right: 6px;">
                                        确定收货
                                    </a>
                                </c:if>
                                    <%--                                <c:if test="${data.state==2}">--%>
                                    <%--                                    <a href="${ctx}/itemOrder/sh?id=${data.id}" class="c_33 onHover font20 onorange right_yh" style="margin-top: 10px;padding-right: 6px;">--%>
                                    <%--                                        去收货--%>
                                    <%--                                    </a>--%>
                                    <%--                                </c:if>--%>
                                <c:if test="${data.state==3}">
                                    <a href="#" class="c_33 onHover font20 onorange right_yh"
                                       style="margin-top: 10px;padding-right: 6px;">
                                        已收货
                                    </a>
                                </c:if>
                            </div>
                        </div>
                    </c:forEach>
                </div>


            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/layui/lay/modules/jquery.js"></script>
<script type="text/javascript">
    $("#navLt span").click(function () {
        var t = $(this).index();
        $(this).addClass("slect").siblings().removeClass("slect");
        $(".hhD").eq(t).css({display: "block"}).siblings(".hhD").css({display: "none"});
    });

    $(".cancel").each(function () {
        $(this).click(function () {
            var id = $(this).attr("data-oid")
            console.log(id)
            return confirm("确定取消这条订单吗？")

        })
    })

    $(".shouhuo").each(function () {
        $(this).on('click', function () {
            var orderId = $(this).attr("data-id");
            window.top.layer.confirm("确认收货？",{offset:"300px",btn:["确定","取消"]}, function () {
                console.log("收货")
                console.log(orderId)
                $.ajax({
                    type: "POST",
                    url: "${ctx}/rest/orders/updateState",
                    data: JSON.stringify({"state": 2, "id": parseInt(orderId)}),
                    contentType: "application/json",
                    success: function (result) {
                        window.location.href = "${ctx}/front/itemOrders";
                    }
                })
                layer.closeAll("dialog")
            },function () {
                layer.closeAll("dialog")
            })
        })
    })

</script>

<%@include file="/common/ufooter.jsp" %>
</body>
</html>




















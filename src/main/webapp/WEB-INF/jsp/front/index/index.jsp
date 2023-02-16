<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>首页</title>
    <link type="text/css" rel="stylesheet" href="${ctx}/resource/user/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
    <script src="${ctx}/resource/user/js/jquery-1.8.3.min.js"></script>
    <script src="${ctx}/resource/user/js/jquery.luara.0.0.1.min.js"></script>

</head>
<body>
<%@include file="/common/utop.jsp" %>
<!--导航条-->
<div class="width100" style="height: 45px;background: #bed73e;margin-top: 40px;position: relative;z-index: 100;">
    <!--中间的部分-->
    <div class="width1200 center_yh relative_yh" style="height: 45px;">
        <!--列表导航-->
        <!--普通导航-->
        <div class="left_yh font16" id="pageNav">
            <a href="${ctx}/front/index">首页</a>

        </div>
    </div>
</div>
<!--轮动广告-->
<div class="width1200 center_yh hidden_yh" style="position: relative;z-index:80;">
    <%--    页面轮播图--%>
    <div class="layui-carousel" id="test10">
        <div carousel-item="">
            <div><img src="${ctx}/resource/images/a.webp" style="width:100%;height:100%"></div>
            <div><img src="${ctx}/resource/images/b.webp" style="width:100%;height:100%"></div>
            <div><img src="${ctx}/resource/images/c.webp" style="width:100%;height:100%"></div>
            <div><img src="${ctx}/resource/images/d.webp" style="width:100%;height:100%"></div>
        </div>
    </div>
</div>
<!--折扣商品-->
<div class="width1200 center_yh hidden_yh">
    <div class="width100" style="height: 45px;line-height: 45px; margin-top: 20px;">
        <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
            <ul class="layui-tab-title">
                <li class="layui-this queryAll">全部</li>
                <c:forEach items="#{typeList}" var="type">
                    <li class="queryType" data_id="${type.id}">${type.name}</li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="width100 hidden_yh ">
        <div class="normalPic goodsList">
            <%--            <c:forEach items="${goodsList}" var="data" varStatus="l">--%>
            <%--                <a href="item/detail?id=${data.id}" class="typeItem">--%>
            <%--                    <h3 class="yihang c_33 font14 font100"--%>
            <%--                        style="padding-left: 10px;padding-right: 10px;"></h3>--%>
            <%--                    <p class="red font14" style="padding-left: 10px;"></p>--%>
            <%--                    <img src="${pageContext.request.contextPath}/DisplayImage?src="--%>
            <%--                         width="150" height="150" alt="" style="margin:0 15px 0">--%>
            <%--                </a>--%>
            <%--            </c:forEach>--%>
        </div>
    </div>
</div>

<!--热门商品-->
<div class="width1200 center_yh hidden_yh">
    <div class="width100" style="height: 45px;line-height: 45px;border-bottom: 2px solid #dd4545; margin-top: 20px;">
        <font class="left_yh font20">热销TOP前5</font>
    </div>
    <div class="width100 hidden_yh">
        <div class="normalPic">
            <c:forEach items="${hot}" var="hot" varStatus="l">
                <a href="item/detail?id=${hot.id}">
                    <h3 class="yihang c_33 font14 font100"
                        style="padding-left: 10px;padding-right: 10px;">${hot.goodsName}</h3>
                    <p class="red font14" style="padding-left: 10px;">${hot.price}</p>
                    <img src="${pageContext.request.contextPath}/DisplayImage?src=${hot.goodsImg}" width="150"
                         height="150" alt="" style="margin:0 15px 0">
                </a>
            </c:forEach>
        </div>
    </div>
</div>
<%@include file="/common/ufooter.jsp" %>
</body>

<script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8" type="text/javascript"></script>
<script>
    layui.use(['jquery', 'layer', 'carousel'], function () {
        var $ = layui.jquery,
            carousel = layui.carousel,
            layer = layui.layer;

        //图片轮播
        carousel.render({
            elem: '#test10'
            , width: '1205px'
            , height: '490px'
            , interval: 5000
        });

        $(document).ready(function () {
            $.ajax({
                type: 'GET',
                contentType: "application/json;charset=UTF-8",
                url: "${ctx}/rest/goods/list",
                // data: JSON.stringify({"typeid": typeid}),
                dataType: 'json',
                success: function (result) {
                    goodsList = result.data;
                    // console.log("商品"+goodsList)
                    $.each(goodsList, function (index, item) {
                        var goodsName = item.goodsName;
                        // console.log(item)
                        var h3 = "<h3 class='yihang c_33 font14 font100' style='padding-left: 10px;padding-right: 10px;'>" + goodsName + "</h3>"

                        var p = " <p class='red font14' style='padding-left: 10px;'>" + item.price + "</p>"

                        var img = "<img src='${pageContext.request.contextPath}/DisplayImage?src=" + item.goodsImg + "' width='150' height='150'  style='margin:0 15px 0'>"

                        var a = "<a href='item/detail?id=" + item.id + "' class='typeItem'>" + h3 + p + img + "</a>"

                        // console.log($(".goodsList").get(0))
                        $(".goodsList").append(a)

                    })

                }
            })
        })

        // 查询全部
        $(".queryAll").click(function () {
            $.ajax({
                type: 'GET',
                contentType: "application/json;charset=UTF-8",
                url: "${ctx}/rest/goods/list",
                // data: JSON.stringify({"typeid": typeid}),
                dataType: 'json',
                success: function (result) {
                    goodsList = result.data;
                    // console.log("商品"+goodsList)
                    $(".goodsList").each(function () {
                        $(this).children("a").remove()
                    })
                    $.each(goodsList, function (index, item) {
                        var goodsName = item.goodsName;

                        // console.log(item)
                        var h3 = "<h3 class='yihang c_33 font14 font100' style='padding-left: 10px;padding-right: 10px;'>" + goodsName + "</h3>"

                        var p = " <p class='red font14' style='padding-left: 10px;'>" + item.price + "</p>"

                        var img = "<img src='${pageContext.request.contextPath}/DisplayImage?src=" + item.goodsImg + "' width='150' height='150'  style='margin:0 15px 0'>"

                        var a = "<a href='item/detail?id=" + item.id + "' class='typeItem'>" + h3 + p + img + "</a>"

                        // console.log($(".goodsList").get(0))
                        $(".goodsList").append(a)

                    })

                }
            })
        })

        // 查询分类
        $(".queryType").each(function () {
            $(this).click(function () {
                // console.log($(this).attr("data_id"));
                tid = $(this).attr("data_id");
                typeid = parseInt(tid);
                $.ajax({
                    type: 'GET',
                    contentType: "application/json;charset=UTF-8",
                    url: "${ctx}/rest/goods/type/" + typeid,
                    // data: JSON.stringify({"typeid": typeid}),
                    dataType: 'json',
                    success: function (result) {
                        goodsList = result.data;
                        // console.log("商品"+goodsList)
                        $(".goodsList").each(function () {
                            $(this).children("a").remove()
                        })
                        $.each(goodsList, function (index, item) {

                            var goodsName = item.goodsName;

                            // console.log(item)
                            var h3 = "<h3 class='yihang c_33 font14 font100' style='padding-left: 10px;padding-right: 10px;'>" + goodsName + "</h3>"

                            var p = " <p class='red font14' style='padding-left: 10px;'>" + item.price + "</p>"

                            var img = "<img src='${pageContext.request.contextPath}/DisplayImage?src=" + item.goodsImg + "' width='150' height='150'  style='margin:0 15px 0'>"

                            var a = "<a href='item/detail?id=" + item.id + "' class='typeItem'>" + h3 + p + img + "</a>"

                            // console.log($(".goodsList").get(0))
                            $(".goodsList").append(a)

                        })

                    }
                });
            })
        })

        // 模糊查询
        $(".btnSearh").click(function () {
            console.log($(".search").val())
            var goodsName = $(".search").val();
            $.ajax({
                type: 'POST',
                contentType: "application/json;charset=UTF-8",
                url: "${ctx}/rest/goods/like",
                data: JSON.stringify({"goodsName": goodsName}),
                dataType: 'json',
                success: function (result) {
                    goodsList = result.data;
                    console.log(goodsList)
                    // console.log("商品"+goodsList)
                    $(".goodsList").each(function () {
                        $(this).children("a").remove()
                    })
                    $.each(goodsList, function (index, item) {
                        var goodsName = item.goodsName;

                        console.log(item)
                        var h3 = "<h3 class='yihang c_33 font14 font100' style='padding-left: 10px;padding-right: 10px;'>" + goodsName + "</h3>"

                        var p = " <p class='red font14' style='padding-left: 10px;'>" + item.price + "</p>"

                        var img = "<img src='${pageContext.request.contextPath}/DisplayImage?src=" + item.goodsImg + "' width='150' height='150'  style='margin:0 15px 0'>"

                        var a = "<a href='item/detail?id=" + item.id + "' class='typeItem'>" + h3 + p + img + "</a>"

                        // console.log($(".goodsList").get(0))
                        $(".goodsList").append(a)

                    })
                }
            })
        })
    })
</script>
</html>




















<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>商品列表</title>

    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/public.css" media="all">


    <script>
        window.onload = function () {
            dateFormat = function (date, format) {
                date = new Date(date);
                var o = {
                    'M+': date.getMonth() + 1, //month
                    'd+': date.getDate(), //day
                    'H+': date.getHours() + 10, //hour
                    'm+': date.getMinutes(), //minute
                    's+': date.getSeconds(), //second
                    'S': date.getMilliseconds()
                    //millisecond
                };

                if (/(y+)/.test(format))
                    format = format.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length));
                for (var k in o)
                    if (new RegExp('(' + k + ')').test(format))
                        format = format.replace(RegExp.$1,
                            RegExp.$1.length == 1 ? o[k] : ('00' + o[k]).substr(('' + o[k]).length));
                return format;
            }
            var create = null;
            create = document.getElementsByClassName("create");
            var update = null
            update = document.getElementsByClassName("update");
            // console.log(create[0]);
            for (var i = 0; i <= create.length; i++) {
                var date_str = dateFormat(create[i].innerHTML, 'yyyy-MM-dd ');
                var date_str11 = dateFormat(update[i].innerHTML, 'yyyy-MM-dd');
                if (date_str11 == 'NaN-aN-aN aN:aN:aN') {
                    update[i].innerText = '';
                } else {
                    update[i].innerText = date_str11;
                }
                create[i].innerText = date_str;

            }

        }
    </script>
    <%--    分页--%>

    <style>
        #name {
            float: left;
        }

        .layui-input {
            float: left;
            width: 200px;
            height: 38px;
            line-height: 1.3;
            line-height: 38px;
            border-width: 1px;
            border-style: solid;
            background-color: #fff;
            border-radius: 2px;
            height: 38px;
        }

        .layui-form-label {
            width: 30px;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/assets/goods/likeSelectGoods" method="POST">
    <div style="margin-bottom: 5px;">
        <div id="id_name">
            <lable for="id" class="layui-form-label required">编号</lable>
            <input type="text" id="goodsNo" name="goodsNo" class="layui-input" autocomplete="off"
                   placeholder="按编号查询">
        </div>
        <div id="name" style="margin-right:20px">
            <lable for="name" class="layui-form-label required">名称</lable>
            <input type="text" id=" goodsName" name="goodsName" class="layui-input" autocomplete="off"
                   placeholder="按名称查询">
        </div>
        <input type="submit" value="搜索" class="layui-btn layui-btn-normal">
    </div>
</form>
<table class="layui-table" lay-filter="test">
    <thead>
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>采购地</th>
        <th>说明</th>
        <th>图片</th>
        <th>价格</th>
        <th>类型</th>
        <th>库存</th>
        <th>销量</th>
        <th>入库时间</th>
        <th>更新时间</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${goodsListByPage.list}" var="goods">
        <tr>
            <td>${goods.goodsNo}</td>
            <td>${goods.goodsName}</td>
            <td>${goods.supplier}</td>
            <td>${goods.des}</td>
            <td><img src="${pageContext.request.contextPath}/DisplayImage?src=${goods.goodsImg}"
                     alt="" width="80" height="80" id='coverImage'/></td>
            <td>${goods.price}</td>
            <td>${goods.typeName}</td>
            <td>${goods.stock}</td>
            <td>${goods.sell}</td>
            <td class="create">${goods.createTime}</td>
            <td class="update">${goods.updateTime}</td>
            <td style="width:110px"><a href="${pageContext.request.contextPath}/assets/goods/toDetail?id=${goods.id}"
                   class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
                <a href="${pageContext.request.contextPath}/assets/goods/deleteGoods?id=${goods.id}" onclick="return confirm('确定将编号为${goods.id}记录删除?')"
                   class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div id="demo2"></div>



<%--分页--%>

<script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/layui/lay/modules/jquery.js"></script>

<script>
    layui.use(['laypage', 'layer','jquery'], function () {
        var laypage = layui.laypage,
            layer = layui.layer,
            $ = layui.jquery
        // var first1 = true;
        var pageNum = ${goodsListByPage.pageNum}
        console.log(pageNum)

        //自定义样式
        laypage.render({
            elem: 'demo2',
            count: ${goodsListByPage.total},
            limit: ${goodsListByPage.pageSize},
            curr: pageNum,
            theme: '#1E9FFF',
            jump:function (obj,first) {
                if (!first){
                    console.log(obj.curr);
                    console.log(obj.limit)
                    pageNum = obj.curr;
                    window.location.href= ${basePath}+obj.curr;
                }
                <%--else{--%>
                <%--    first1 = false;--%>
                <%--    &lt;%&ndash;window.location.href= ${basePath}+${goodsListByPage.nextPage};&ndash;%&gt;--%>
                <%--}--%>
            }
        });

    });


</script>


</body>
</html>

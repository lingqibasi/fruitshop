<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/public.css" media="all">
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
<form action="${pageContext.request.contextPath}/assets/user/likeSelectUser" method="POST">
    <div style="margin-bottom: 5px;">
        <div id="id_name">
            <lable for="id" class="layui-form-label required">用户名</lable>
            <input type="text" id="id" name="username" class="layui-input" autocomplete="off"
                   placeholder="按id查询">
        </div>
        <div id="name" style="margin-right:20px">
            <lable for="name" class="layui-form-label required">姓名</lable>
            <input type="text" id="username" name="name" class="layui-input" autocomplete="off"
                   placeholder="按名称查询">
        </div>
        <input type="submit" value="搜索" class="layui-btn layui-btn-normal">
    </div>
</form>
<table class="layui-table" lay-filter="test">
    <thead>
    <tr align="center">
        <td>id</td>
        <td>用户名</td>
        <td>密码</td>
        <td>姓名</td>
        <td>权限</td>
        <td>性别</td>
        <td>年龄</td>
        <td>创建时间</td>
        <td>更新时间</td>
        <td></td>
    </tr>
    <c:forEach items="${users.list}" var="sys_user">
        <tr align="center">
            <th scope="row">${sys_user.id}</th>
            <td>${sys_user.username}</td>
            <td>${sys_user.password}</td>
            <td>${sys_user.name}</td>
            <td>${sys_user.role}</td>
            <td class="sex">${sys_user.sex}</td>
            <td>${sys_user.age}</td>
            <td class="create">${sys_user.createTime}</td>
            <td class="update">${sys_user.updateTime}</td>
            <td><a href="${pageContext.request.contextPath}/assets/user/toUserDetail?id=${sys_user.id}"
                   class="layui-btn layui-btn-xs" lay-event="edit">修改</a> <a
                    href="${pageContext.request.contextPath}/assets/user/deleteUser?id=${sys_user.id}"
                    onclick="return confirm('确定将编号为${sys_user.id}记录删除?')"
                    class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a></td>
        </tr>
    </c:forEach>
    </thead>
</table>
<div id="demo2"></div>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>

</script>

<script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8" type="text/javascript"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script src="${pageContext.request.contextPath}/layui/lay/modules/jquery.js"></script>

<script>
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
            format = format.replace(RegExp.$1, (date.getFullYear() + '')
                .substr(4 - RegExp.$1.length));
        for (var k in o)

            if (new RegExp('(' + k + ')').test(format))
                format = format.replace(RegExp.$1,
                    RegExp.$1.length == 1 ? o[k] : ('00' + o[k])
                        .substr(('' + o[k]).length));
        return format;

    }

    var create = document.getElementsByClassName("create");
    var update = document.getElementsByClassName("update");
    // console.log(create[0]);
    for (var i = 0; i <= create.length; i++) {
        var date_str = dateFormat(create[i].innerText,
            'yyyy-MM-dd ');
        var date_str11 = dateFormat(update[i].innerText,
            'yyyy-MM-dd');
        if (date_str11 == 'NaN-aN-aN aN:aN:aN') {
            update[i].innerText = '';
        } else {
            update[i].innerText = date_str11;
        }
        create[i].innerText = date_str;

    }
</script>

<script>
    layui.use(['form', 'jquery', 'layer','laypage'], function () {
        var $ = layui.jquery,
            laypage = layui.laypage,
            layer = layui.layer;

		$(".sex").each(function(i,n){
		    // console.log($(n)[0].innerText)
		    if ($(n)[0].innerText == 1 || $(n)[0].innerText == '1'){
                $(n)[0].innerText = '男'
            }else if($(n)[0].innerText == 0 || $(n)[0].innerText == '0'){
                $(n)[0].innerText = '女'
            }

		})

        var pageNum = ${users.pageNum};
        //自定义样式
        laypage.render({
            elem: 'demo2',
            count: ${users.total},
            limit: ${users.pageSize},
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


    })
</script>
</body>
</html>

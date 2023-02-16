<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/public.css" media="all">
    <style>
        body {
            background-color: #ffffff;
        }

        #file {
            opacity: 0;
            /* display: none; */
            width: 93px;
            height: 100%;
            position: absolute;
            left: 0;
            z-index: 99;
        }

        img[src=""], img:not([src]) {
            opacity: 0;

        }

        #file {
            opacity: 0;
            /* display: none; */
            width: 93px;
            height: 100%;
            position: absolute;
            left: 0;
            z-index: 99;
        }

        img[src=""], img:not([src]) {
            opacity: 0;

        }

        .iid {
            width: 20px;
            line-height: 20px;
            padding-top: 9px;
        }
    </style>
</head>
<body>
<form action="updateType" method="post">
    <div class="layui-form layuimini-form">
        <input type="hidden" name="id" value="${typeDetail.id}"/>

        <div class="layui-form-item">
            <label class="layui-form-label required">商品编号</label>
            <div class="layui-input-block">
                <input type="text" name="name" lay-verify="required"
                       lay-reqtext="类型不能为空" placeholder="请输入分类类型" value="${typeDetail.name}"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <input type="submit" value="提交" class="layui-btn layui-btn-normal"
                >
            </div>
        </div>
    </div>
</form>
<script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
<script>


</script>
</body>
</html>
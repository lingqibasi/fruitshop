<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/layui/css/layui.css"
          media="all">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/layui/css/public.css"
          media="all">
    <style>
        body {
            background-color: #ffffff;
        }
    </style>
</head>
<body>
<form action="iuserUpdate" method="post" enctype="multipart/form-data">
    <input type="hidden" value="${iuserinfo.id}" name="id"/>
    <div class="layui-form layuimini-form">
        <div class="layui-form-item">
            <label class="layui-form-label required">用户名</label>
            <div class="layui-input-block">
                <input type="text" name="name" lay-verify="required"
                       lay-reqtext="用户名不能为空" placeholder="请输入用户名" value="${iuserinfo.name}"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label required">邮箱</label>
            <div class="layui-input-block">
                <input type="text" name="email" lay-verify="required"
                       lay-reqtext="邮箱不能为空" placeholder="请输入邮箱" value="${iuserinfo.email}"
                       class="layui-input">
            </div>
        </div>

<%--        <div class="layui-form-item">--%>
<%--            <label class="layui-form-label required">角色</label>--%>
<%--            <div class="layui-input-block">--%>
<%--                <input type="text" name="role" lay-verify="required"--%>
<%--                       lay-reqtext="角色不能为空" placeholder="请输入角色" value="${iuserinfo.role}"--%>
<%--                       class="layui-input">--%>
<%--            </div>--%>
<%--        </div>--%>

<%--        <div class="layui-form-item">--%>
<%--            <label class="layui-form-label">性别</label>--%>
<%--            <div class="layui-input-block">--%>
<%--                <input type="hidden" value="${iuserinfo.sex}" id="sex"/>--%>
<%--                <input type="radio" name="sex" value="1" title="男" id="man"  >--%>
<%--                <input type="radio" name="sex" value="0" title="女" id="girl" >--%>
<%--            </div>--%>
<%--        </div>--%>
                <div class="layui-form-item">
                    <label class="layui-form-label required">性别</label>
                    <div class="layui-input-block">
                        <input type="text" name="sex" lay-verify="required"
                               lay-reqtext="不能为空" placeholder="请输入性别" value="${iuserinfo.sex}"
                               class="layui-input">
                    </div>
                </div>

<%--        <div class="layui-form-item layui-form-text">--%>
<%--            <label class="layui-form-label required">年龄</label>--%>
<%--            <div class="layui-input-block">--%>
<%--                <input type="text" name="age" lay-verify="required"--%>
<%--                       placeholder="请输入年龄..." value="${userinfo.age}" class="layui-input">--%>
<%--            </div>--%>
<%--        </div>--%>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <input type="submit" value="提交" class="layui-btn layui-btn-normal">
            </div>
        </div>
    </div>
</form>
<script src="${pageContext.request.contextPath}/layui/layui.js"
        charset="utf-8"></script>
<script>
    layui.use(['form','jquery','layer'], function () {
        var $ = layui.jquery,form = layui.form;

        // var sex = document.getElementById("sex")
        // console.log(sex.va)
        console.log($("#sex").val() == '1')
        if ($("#sex").val() == 1 || $("#sex").val() == "1"){
            console.log($("#man").get(0))
            $("#man").prop('checked','true')
            form.render();
        }else if($("#sex").val() == 0 || $("#sex").val() == "0"){
            console.log($("#girl").get(0));
            $("#girl").prop('checked','true')
            form.render();

        }

    })



</script>
</body>
</html>

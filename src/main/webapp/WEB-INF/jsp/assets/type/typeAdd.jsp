<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>商品添加</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/public.css" media="all">
    <style>
        body {
            background-color: #ffffff;
        }
        #file{
            opacity: 0;
            /* display: none; */
            width: 93px;
            height: 100%;
            position: absolute;
            left: 0;
            z-index: 99;
        }
        img[src=""],img:not([src]){
            opacity: 0;

        }
    </style>
</head>
<body>
<form action="addType" method="post" >
    <div class="layui-form layuimini-form">

        <div class="layui-form-item">
            <label class="layui-form-label required">类型名</label>
            <div class="layui-input-block">
                <input type="text" name="name" lay-verify="required"
                       lay-reqtext="类型不能为空" placeholder="请输入分类类型" value="" autocomplete="off"
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
    var pic = document.getElementById("preview"), file = document.getElementById("file");

    file.onchange = function () {
        var ext = file.value.substring(file.value.lastIndexOf(".") + 1).toLowerCase();
        // gif在IE浏览器暂时无法显示
        if (ext != 'png' && ext != 'jpg' && ext != 'jpeg') {
            alert("图片的格式必须为png或者jpg或者jpeg格式！");
            file.value = '';
            return;
        }
        var isIE = navigator.userAgent.match(/MSIE/) != null, isIE6 = navigator.userAgent.match(/MSIE 6.0/) != null;
        if (isIE) {
            file.select();
            var reallocalpath = document.selection.createRange().text;
            // IE6浏览器设置img的src为本地路径可以直接显示图片
            if (isIE6) {
                pic.src = reallocalpath;
            } else {
                // 非IE6版本的IE由于安全问题直接设置img的src无法显示本地图片，但是可以通过滤镜来实现
                pic.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='image',src=\""
                    + reallocalpath + "\")";
                // 设置img的src为base64编码的透明图片 取消显示浏览器默认图片
                pic.src = 'data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==';
            }
        } else {
            html5Reader(file);
        }
    }

    function html5Reader(file) {
        var file = file.files[0];
        var reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = function (e) {
            var pic = document.getElementById("preview");
            pic.src = this.result;
        }
    }


</script>
</body>
</html>

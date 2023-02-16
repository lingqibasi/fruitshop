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
<form action="updateGoods" method="post" enctype="multipart/form-data">
    <div class="layui-form layuimini-form">
        <input type="hidden" name="id" value="${goodsDetail.id}"/>
        <div class="layui-form-item">
            <label class="layui-form-label required">商品编号</label>
            <div class="layui-input-block">
                <input type="text" name="goodsNo" lay-verify="required"
                       lay-reqtext="编号不能为空" placeholder="请输入商品编号" value="${goodsDetail.goodsNo}"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label required">商品名称</label>
            <div class="layui-input-block">
                <input type="text" name="goodsName" lay-verify="required"
                       lay-reqtext="商品不能为空" placeholder="请输入商品名称" value="${goodsDetail.goodsName}"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label required">采购地</label>
            <div class="layui-input-block">
                <input type="text" name="supplier" lay-verify="required"
                       lay-reqtext="输入不能为空" placeholder="请输入..." value="${goodsDetail.supplier}"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label required">类型编号</label>
            <div class="layui-input-block">
                <select name="typeId" id="danger_mend_state">
                    <option value="" disabled></option>
                    <c:forEach items="${typeList}" var="type">
                        <option value="${type.id}" checked>${type.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">图片上传</label>
            <div class="layui-input-block">
                <button type="button" class="layui-btn">上传图片
                    <input type="file" name="file" value="${goodsDetail.goodsImg}"
                           accept="images/jpeg" id='file' onchange="change()">
                </button>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"></label>
            <div class="layui-input-block">
                <img src="${pageContext.request.contextPath}/DisplayImage?src=${goodsDetail.goodsImg}"
                     alt="" width="200" height="200" id='preview'/>

            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">价格</label>
            <div class="layui-input-block">
                <input type="text" name="price" lay-reqtext="价格不能为空"
                       placeholder="请输入价格..." value="${goodsDetail.price}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">库存</label>
            <div class="layui-input-block">
                <input type="text" name="stock"
                       placeholder="请输入价格..." value="${goodsDetail.stock}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">商品信息</label>
            <div class="layui-input-block">
					<textarea name="des" class="layui-textarea"
                              placeholder="请输入信息">${goodsDetail.des}</textarea>
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

    function change() {
        var ext = file.value.substring(file.value.lastIndexOf(".") + 1).toLowerCase();
        // gif在IE浏览器暂时无法显示
        if (ext != 'png' && ext != 'jpg' && ext != 'jpeg') {
            alert("图片的格式必须为png或者jpg或者jpeg格式！");
            file.value = '';
            return;
        }
        var isIE = navigator.userAgent.match(/MSIE/) != null, isIE6 = navigator.userAgent
            .match(/MSIE 6.0/) != null;
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
        pic.src = ""
        console.log(pic.src)
        var file = file.files[0];
        var reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = function (e) {
            var pic = document.getElementById("preview");
            pic.src = this.result;
        }
    }


    layui.use(['form','jquery','layer'], function () {
        var $ = layui.jquery,form = layui.form;

        function set_select(value){

            $("#danger_mend_state").find("option[value="+value+"]").prop("selected",true)
            $("#danger_mend_state").parent().find(".layui-form-select").find(".layui-select-title").find("input").val(value);
            // console.log($("#danger_mend_state").parent().find(".layui-form-select").find(".layui-select-title").find("input"))
        }
        set_select(${goodsDetail.typeId})

        form.render("select")

    })

    // layui.use(['form'], function () {
    //     var form = layui.form, layer = layui.layer, $ = layui.$;
    //
    //     //监听提交
    //     form.on('submit(saveBtn)', function (data) {
    //         var index = layer.alert(JSON.stringify(data.field), {
    //             title: '最终的提交信息'
    //         }, function () {
    //             // 关闭弹出层
    //             layer.close(index);
    //             var iframeIndex = parent.layer.getFrameIndex(window.name);
    //             parent.layer.close(iframeIndex);
    //         });
    //
    //         return false;
    //     });
    //
    // });
</script>
</body>
</html>
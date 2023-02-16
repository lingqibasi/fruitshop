<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>后台管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script>
        window.onload = function () {
            setIframeHeight(document.getElementById('external-frame'));
        };
		function setIframeHeight(iframe) {
			if (iframe) {
				var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
				if (iframeWin.document.body) {
					iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
				}
			}
		};
    </script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">后台管理</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">

        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item"><a href="javascript:;"> <img
                    src="http://t.cn/RCzsdCq" class="layui-nav-img"> 欢迎您：${user.username}
            </a>
                <dl class="layui-nav-child">
                    <dd>
                        <a href="">基本资料</a>
                    </dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/assets/logout">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed"><a class="" href="javascript:;">商品管理</a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="goods/list/1" target="content">产品列表</a>
                        </dd>
                        <dd>
                            <a href="goods/toAdd" target="content">产品添加</a>
                        </dd>
                    </dl>
                </li>

                <li class="layui-nav-item"><a href="javascript:;">用户管理</a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="iuser/list/1" target="content">用户列表</a>
                        </dd>
                    </dl>
                </li>


                <li class="layui-nav-item"><a href="javascript:;">订单管理</a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="orders/ordersiList/1" target="content">订单列表</a>
                        </dd>
                    </dl>
                </li>

                <li class="layui-nav-item"><a href="javascript:;">分类管理</a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="type/list/1" target="content">分类列表</a>
                        </dd>
                        <dd>
                            <a href="type/toAdd" target="content">添加分类</a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a class="" href="javascript:;">管理员管理</a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="user/list/1" target="content">管理员列表</a>
                        </dd>
                        <dd>
                            <a href="user/toUserAdd" target="content">管理员添加</a>
                        </dd>

                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div>
            <iframe id="external-frame" src="goods/list/1" name="content" width="100%" height="836px;"
                    scrolling="no"></iframe>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->

    </div>
</div>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/public.css" media="all">
    <style>
        .div-flex {
            display: flex;
            align-items: center;
            justify-content: left;
        }

        .width-160 {
            width: 200px;
        }

        .layui-table th {
            text-align: center;
        }

        .table-margin {
            margin-left: 50px;
            margin-right: 50px;
            text-align: center;
        }

        .image {
            height: 80px;
            width: 80px;
        }

        .mt50 {
            margin-left: 50px;
        }

    </style>
</head>
<body>
<div class="layui-card-body">
    <!--基本信息-->
    <div class="layui-form" lay-filter="layuiadmin-form-order" id="layuiadmin-form-order">
        <input type="hidden" class="order_id" name="order_id" value="{$detail.id}">

        <div class="layui-form-item">
            <fieldset class="layui-elem-field layui-field-title">
                <legend>订单信息</legend>
            </fieldset>
        </div>

        <div class="layui-form-item div-flex">
            <label class="layui-form-label ">订单编号:</label>
            <div class="width-160">${detail[0].orderSn}</div>
            <%--            <label class="layui-form-label ">订单类型:</label>--%>
            <%--            <div class="width-160">{$detail.order_type_text}({$detail.order_source_text})</div>--%>
            <label class="layui-form-label ">下单时间:</label>
            <div class="width-160">${detail[0].createTime}</div>
        </div>

        <div class="layui-form-item div-flex">
            <%--            <label class="layui-form-label ">支付时间:</label>--%>
            <%--            <div class="width-160">{$detail.pay_time}</div>--%>
            <label class="layui-form-label ">支付状态:</label>
            <div class="width-160">货到付款</div>
            <label class="layui-form-label ">订单状态:</label>
            <div class="width-160 state">${detail[0].state}</div>
        </div>

        <div class="layui-form-item">
            <fieldset class="layui-elem-field layui-field-title">
                <legend>用户信息</legend>
            </fieldset>
        </div>

        <div class="layui-form-item div-flex">
            <label class="layui-form-label ">用户id:</label>
            <div class="width-160">${detail[0].uid}</div>
            <label class="layui-form-label ">用户昵称:</label>
            <div class="width-160">${detail[0].username}</div>
            <%--            <label class="layui-form-label ">手机号码:</label>--%>
            <%--            <div class="width-160">{$detail.user.mobile}</div>--%>
        </div>

        <div class="layui-form-item div-flex">
            <label class="layui-form-label ">性别:</label>
            <div class="width-160">${detail[0].sex}</div>
            <label class="layui-form-label ">注册时间:</label>
            <div class="width-160">${detail[0].createTime}</div>
        </div>


        <div class="layui-form-item">
            <fieldset class="layui-elem-field layui-field-title">
                <legend>收货信息</legend>
            </fieldset>
        </div>

        <div class="layui-form-item div-flex">
            <label class="layui-form-label ">收货人:</label>
            <div class="width-160">${detail[0].address.name}</div>
            <label class="layui-form-label ">手机号:</label>
            <div class="width-160">${detail[0].address.phone}</div>
            <label class="layui-form-label ">收货地址:</label>
            <div class="width-160">${detail[0].address.address}</div>
        </div>


        <div class="layui-form-item">
            <fieldset class="layui-elem-field layui-field-title">
                <legend>商品信息</legend>
            </fieldset>
        </div>

        <div class="layui-form-item table-margin">
            <table class="layui-table">
                <colgroup>
                    <col width="250">
                    <col width="100">
                    <col width="100">
                    <col width="100">
                </colgroup>
                <thead>
                <tr>
                    <th>商品信息</th>
                    <th>价格(元)</th>
                    <th>数量</th>
                    <th>小计(元)</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${detail[0].ordersDetail}" var="goods">
                    <tr>
                        <td>
                            <div style="text-align: left">
                                <div class="layui-col-md3">
                                    <img src="${pageContext.request.contextPath}/DisplayImage?src=${goods.goods_img}"
                                         class="image-show image">
                                </div>
                                <div class="layui-col-md9">
                                    <p style="margin-top: 10px">${goods.goods_name}</p>
                                    <br>
                                        <%--                                    <p>{goods.des}</p>--%>
                                </div>
                            </div>
                        </td>
                        <td>￥${goods.price}</td>
                        <td>${goods.num}</td>
                        <td>${goods.price * goods.num}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="3">
                        <p>商品金额:￥${detail[0].totalPrice}</p>
                        <p>应付金额:￥${detail[0].totalPrice}</p>
                        <p>支付方式:货到付款</p></td>
                    <td style="text-align: left">

                    </td>
                </tr>
                </tbody>
            </table>
        </div>

        <!--        <div class="layui-form-item">-->
        <!--            <fieldset class="layui-elem-field layui-field-title">-->
        <!--                <legend>买家留言</legend>-->
        <!--            </fieldset>-->
        <!--        </div>-->

        <!--        <div class="layui-form-item table-margin">-->
        <!--            <textarea class="layui-textarea" disabled>{$detail.user_remark}</textarea>-->
        <!--        </div>-->


        <%--        <div class="layui-form-item">--%>
        <%--            <fieldset class="layui-elem-field layui-field-title">--%>
        <%--                <legend>订单操作</legend>--%>
        <%--            </fieldset>--%>
        <%--        </div>--%>

        <!--        <div class="layui-form-item div-flex ">-->
        <!--            <div class="layui-input-block ">-->
        <!--                {eq name="$detail.order_status" value="0"}-->
        <!--                <button type="submit" class="layui-btn layui-btn-sm layui-btn-danger width_160 " id="cancel">取消订单</button>-->
        <!--                {/eq}-->

        <!--                {eq name="$detail.order_status" value="1"}-->
        <!--                &lt;!&ndash;            <button type="submit" class="layui-btn layui-btn-normal width_160 " id="refund">退款</button>&ndash;&gt;-->
        <!--                <button type="submit" class="layui-btn layui-btn-sm layui-btn-normal width_160 " id="delivery">发货</button>-->
        <!--                {/eq}-->

        <!--                {eq name="$detail.order_status" value="2"}-->
        <!--                <button type="submit" class="layui-btn layui-btn-sm layui-btn-normal width_160 " id="confirm">确认收货</button>-->
        <!--                {/eq}-->

        <!--                {if ($detail.order_status == 4) && ($detail.del == 0) }-->
        <!--                <button type="submit" class="layui-btn layui-btn-sm layui-btn-danger width_160 " id="del">删除订单</button>-->
        <!--                {/if}-->
        <!--                <button type="button" class="layui-btn layui-btn-sm layui-btn-primary width_160 " id="back">返回</button>-->
        <!--            </div>-->
        <!--        </div>-->


    </div>
</div>
<script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript">
    //注意：选项卡 依赖 element 模块，否则无法进行功能性操作

    layui.config({
        version: "{$front_version}",
        base: '/static/plug/layui-admin/dist/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'element', 'jquery', 'like'], function () {
        var $ = layui.$;
        var like = layui.like;

        $(".state").each(function (i, n) {
            console.log($(n)[0].innerText)
            if ($(n)[0].innerText == 1 || $(n)[0].innerText == '1') {
                $(n)[0].innerText = '已发货'
            } else if ($(n)[0].innerText == 0 || $(n)[0].innerText == '0') {
                $(n)[0].innerText = '未发货'
            } else if ($(n)[0].innerText == 2 || $(n)[0].innerText == '2') {
                $(n)[0].innerText = '已收货'
            }

        })

        //主图放大
        $(document).on('click', '.image-show', function () {
            var src = $(this).attr('src');
            like.showImg(src, 600);
        });


        $('#back').click(function () {
            var index = parent.layer.getFrameIndex(window.name); //获取当前窗口的name
            parent.layer.close(index);
            parent.layui.table.reload('order-lists');
            return true;
        });

        //取消订单
        // $('#cancel').click(function () {
        //     var order_id = $('.order_id').val();
        //     layer.confirm('确认取消订单吗?', {
        //         btn: ['确认', '取消'] //按钮
        //     }, function () {
        //         like.ajax({
        //             url: '{:url("order/cancel")}'
        //             , data: {'order_id': order_id}
        //             , type: 'post'
        //             , success: function (res) {
        //                 if (res.code == 1) {
        //                     layui.layer.msg(res.msg, {
        //                         offset: '15px'
        //                         , icon: 1
        //                         , time: 1000
        //                     }, function () {
        //                         location.reload();
        //                     });
        //                 }
        //             }
        //         });
        //     });
        // });


        //删除订单
        // $('#del').click(function () {
        //     var order_id = $('.order_id').val();
        //     layer.confirm('删除后订单将消失，确认删除订单吗?', {
        //         btn: ['确认', '取消'] //按钮
        //     }, function () {
        //         like.ajax({
        //             url: '{:url("order/del")}'
        //             , data: {'order_id': order_id}
        //             , type: 'post'
        //             , success: function (res) {
        //                 if (res.code == 1) {
        //                     layui.layer.msg(res.msg, {
        //                         offset: '15px'
        //                         , icon: 1
        //                         , time: 1000
        //                     }, function () {
        //                         location.reload();
        //                     });
        //                 }
        //             }
        //         });
        //     });
        // });


        //退款
        // $('#refund').click(function () {
        //     var order_id = $('.order_id').val();
        //     layer.msg('暂不可退');
        // });

        //发货
        $('#delivery').click(function () {
            var id = $('.order_id').val();
            layer.open({
                type: 2
                , title: '订单发货'
                , content: '{:url("order/delivery")}?id=' + id
                , area: ['90%', '90%']
                , yes: function (index, layero) {
                }
            })
        });

        //确认收货
        $('#confirm').click(function () {
            var id = $('.order_id').val();
            layer.confirm('确认订单商品已收货吗？?', {
                btn: ['确认', '取消'] //按钮
            }, function () {
                like.ajax({
                    url: '{:url("order/confirm")}'
                    , data: {'order_id': id}
                    , type: 'post'
                    , success: function (res) {
                        if (res.code == 1) {
                            layui.layer.msg(res.msg, {
                                offset: '15px'
                                , icon: 1
                                , time: 1000
                            }, function () {
                                location.reload();
                            });
                        }
                    },
                });
            });
        });

    });
</script>
</body>
</html>
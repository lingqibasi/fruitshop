package com.qs.fruitshop.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qs.fruitshop.mapper.GoodsMapper;
import com.qs.fruitshop.mapper.OrderDetailMapper;
import com.qs.fruitshop.mapper.OrdersMapper;
import com.qs.fruitshop.pojo.*;
import com.qs.fruitshop.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersMapper ordersMapper;
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    OrderDetailMapper orderDetailMapper;
    @Autowired
    Page pages;
    @Autowired
    OrderDetail orderDetail;
    @Autowired
    Orders orders1;
    @Autowired
    Goods goods;

    @Override
    public List<Orders> listOrders() {
        return ordersMapper.list();
    }

    @Override
    public PageInfo<Orders> list(Integer page) {
        PageHelper.startPage(page,10);
        List<Orders> list = ordersMapper.list();
        PageInfo<Orders> listPage = new PageInfo<>(list);
        return listPage;
    }

    @Override
    public PageInfo<Orders> listByCondition(Orders orders) {
        PageHelper.startPage(pages.getPageNum(),pages.getPageSize());
        List<Orders> listByCondition = ordersMapper.listByCondition(orders);
        PageInfo<Orders> listPage = new PageInfo<>(listByCondition);
        return listPage;
    }

    @Override
    @Transactional
    public int addOrders(Orders orderRequest) {
        if (orderRequest.getOrderSn() == null){
            Date date = new Date();
            orderRequest.setOrderSn(DateUtil.format(date,"yyyyMMdd")+ Math.abs(IdUtil.fastSimpleUUID().hashCode()) + orderRequest.getUid());
        }
        orders1.setOrderSn(orderRequest.getOrderSn());
        orders1.setTotalPrice(orderRequest.getTotalPrice());
        orders1.setUid(orderRequest.getUid());
        orders1.setAddressId(orderRequest.getAddressId());
        System.out.println("orders1--"+orders1);
//        创建订单
        int res = ordersMapper.addOrders(orders1);
//        添加订单详情
        List<OrderDetail> goodsInfo = orderRequest.getGoodsInfo();
        System.out.println("goodsInfo"+goodsInfo);

        for (OrderDetail orderdetail : goodsInfo){
            System.out.println("orderdetail"+orderdetail);
            orderdetail.setOrdersId(orders1.getId());
            int num = orderdetail.getNum();
            Goods goods = goodsMapper.queryGoodsById(orderdetail.getGoodsId());
            if (goods.getStock() < num){
                return -1;
            }
            System.out.println("设置值");
            goods.setStock(goods.getStock() - num);
            goods.setSell(goods.getSell() + num);
            goodsMapper.updateGoodsById(goods);
//            同时修改库存跟销量
        }
        System.out.println("goodsInfo--"+goodsInfo);
        orderDetailMapper.insertDetail(goodsInfo);

        return res;
    }

    @Override
    public List<Orders> listById(Integer id) {
        return ordersMapper.listById(id);
    }

    @Override
    public List<Orders> getByUid(Integer uid) {
        System.out.println("uid"+uid);
        return ordersMapper.getByUid(uid);
    }

    @Override
    public void updateState(Orders orders) {
        ordersMapper.updateState(orders);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        ordersMapper.deleteById(id);
        int res = orderDetailMapper.delete(id);

    }

    @Override
    public PageInfo<Orders> likeSelectSnAndUid(Orders orders) {
        PageHelper.startPage(pages.getPageNum(),pages.getPageSize());
        List<Orders> listByCondition = ordersMapper.likeSelectSnAndUid(orders);
        PageInfo<Orders> listPage = new PageInfo<>(listByCondition);
        return listPage;
    }
}

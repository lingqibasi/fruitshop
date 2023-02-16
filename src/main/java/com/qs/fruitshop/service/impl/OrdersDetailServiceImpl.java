package com.qs.fruitshop.service.impl;


import com.qs.fruitshop.mapper.OrderDetailMapper;
import com.qs.fruitshop.pojo.OrderDetail;
import com.qs.fruitshop.service.OedersDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersDetailServiceImpl implements OedersDetailService {
    @Autowired
    OrderDetailMapper orderDetailMapper;
    @Override
    public List<OrderDetail> selectDetail(Integer orderId) {
        return orderDetailMapper.selectOrderStep(orderId);
    }
}

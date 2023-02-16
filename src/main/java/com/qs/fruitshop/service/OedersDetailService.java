package com.qs.fruitshop.service;

import com.qs.fruitshop.pojo.OrderDetail;

import java.util.List;

public interface OedersDetailService {

    List<OrderDetail> selectDetail(Integer orderId);
}

package com.qs.fruitshop.service;

import com.github.pagehelper.PageInfo;
import com.qs.fruitshop.pojo.OrderDetail;
import com.qs.fruitshop.pojo.OrderRequest;
import com.qs.fruitshop.pojo.Orders;

import java.util.List;

public interface OrdersService {
    List<Orders> listOrders();

    PageInfo<Orders> list(Integer page);

    PageInfo<Orders> listByCondition(Orders orders);

    int addOrders(Orders orders);

    List<Orders> listById(Integer id);

    List<Orders> getByUid(Integer uid);

    void updateState(Orders orders);

    void deleteById(Integer id);

    PageInfo<Orders> likeSelectSnAndUid(Orders orders);
}

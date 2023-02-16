package com.qs.fruitshop.mapper;

import com.qs.fruitshop.pojo.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersMapper {

    List<Orders> list();

    List<Orders> listByCondition(Orders orders);

    List<Orders> listById(Integer id);

    int addOrders(Orders orders);

    List<Orders> getByUid(Integer uid);

    void updateState(Orders orders);

    void deleteById(Integer id);

    List<Orders> likeSelectSnAndUid(Orders orders);
}

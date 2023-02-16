package com.qs.fruitshop.mapper;

import com.qs.fruitshop.pojo.Goods;
import com.qs.fruitshop.pojo.OrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDetailMapper {

    List<OrderDetail> selectListByConditon(OrderDetail orderDetail);

    List<OrderDetail> selectOrderStep(Integer id);

    int delete(Integer orderId);

    int insertDetail(@Param("goodsInfo") List<OrderDetail> goodsInfo);

}

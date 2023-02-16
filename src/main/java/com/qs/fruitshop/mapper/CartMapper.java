package com.qs.fruitshop.mapper;

import com.qs.fruitshop.pojo.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {

    int addCart(Cart cart);

    List<Cart> cartList(Integer userId);

    Cart queryCart(Cart cart);

    int updateCart(Cart cart);

    void deleteCart(@Param("goodsId") Integer goodsId,@Param("userId") Integer userId);
}

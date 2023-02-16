package com.qs.fruitshop.service;

import com.qs.fruitshop.pojo.Cart;
import com.qs.fruitshop.pojo.Goods;

import java.util.List;

public interface CartService {

    int addCart(Cart cart);

    List<Cart> cartList(Integer userId);

    Cart queryCart(Cart cart);

    int updateCart(Cart cart);

    void deleteCart(Integer goodsId, Integer userId);
}

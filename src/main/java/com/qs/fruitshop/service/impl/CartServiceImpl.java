package com.qs.fruitshop.service.impl;

import com.qs.fruitshop.mapper.CartMapper;
import com.qs.fruitshop.pojo.Cart;
import com.qs.fruitshop.pojo.Goods;
import com.qs.fruitshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartMapper cartMapper;
    @Autowired
    Cart cart;

    @Override
    public int addCart(Cart c) {
        Integer userId = c.getUserId();
        Integer goodsId = c.getGoodsId();
        cart.setUserId(userId);
        cart.setGoodsId(goodsId);
        Cart cartInfo = cartMapper.queryCart(c);
        if (cartInfo != null){
            Integer number = cartInfo.getNumber() + c.getNumber();
            c.setNumber(number);
            int res = cartMapper.updateCart(c);
            if (res == 1){
                return res;
            }
        }
        return cartMapper.addCart(c);
    }

    @Override
    public List<Cart> cartList(Integer userId) {
        return cartMapper.cartList(userId);
    }

    @Override
    public Cart queryCart(Cart userId) {
        return null;
    }

    @Override
    public int updateCart(Cart cart) {
        return 0;
    }

    @Override
    public void deleteCart(Integer goodsId, Integer userId) {
        cartMapper.deleteCart(goodsId,userId);
    }
}

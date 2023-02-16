package com.qs.fruitshop.controller.rest;

import com.qs.fruitshop.pojo.Cart;
import com.qs.fruitshop.pojo.Result;
import com.qs.fruitshop.service.CartService;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rest")
public class CartRest {

    @Autowired
    CartService cartService;

    @Autowired
    Result<Cart> result;

    @ResponseBody
    @RequestMapping(value = "/cart",method = RequestMethod.POST)
    public Result<Cart> insertCart(@RequestBody Cart cart){
//        System.out.println("cart"+cart);
        int res = cartService.addCart(cart);
        if (res >= 1){
            result.setCode(200);
            result.setMsg("成功");
            result.setData(null);
        }else{
            result.setCode(400);
            result.setMsg("失败");
            result.setData(null);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/cart/{userid}",method = RequestMethod.GET)
    public Result<Cart> cartList(@PathVariable Integer userid){
        List<Cart> carts = cartService.cartList(userid);
        if (carts != null){
            result.setCode(200);
            result.setMsg("成功");
            result.setData(carts);
        }else{
            result.setCode(400);
            result.setMsg("失败");
            result.setData(null);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/cart/delete/{goodsId}/{userId}",method = RequestMethod.DELETE)
    public Result<Cart> deleteCart (@PathVariable Integer goodsId,@PathVariable Integer userId){
//        System.out.println("goodsId"+goodsId);
//        System.out.println("userId"+userId);
        cartService.deleteCart(goodsId,userId);
        result.setCode(200);
        result.setMsg("成功");
        return result;
    }
}

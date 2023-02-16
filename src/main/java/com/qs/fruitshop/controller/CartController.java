package com.qs.fruitshop.controller;

import com.qs.fruitshop.pojo.Cart;

import com.qs.fruitshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/front/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @RequestMapping("/addCart")
    public String addCart(Cart cart){
        cartService.addCart(cart);
        return "redirect:/front/cartlist";
    }

    @RequestMapping("/cartlist")
    public String cartList(Integer id, Model model){
        List<Cart> cartList = cartService.cartList(id);
        System.out.println("cartList-----"+cartList);
        model.addAttribute("cartList",cartList);
        return "/front/cart/car";
    }

}

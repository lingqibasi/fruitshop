package com.qs.fruitshop.controller;

import com.github.pagehelper.PageInfo;
import com.qs.fruitshop.pojo.OrderDetail;
import com.qs.fruitshop.pojo.Orders;
import com.qs.fruitshop.service.OedersDetailService;
import com.qs.fruitshop.service.OrdersService;
import com.qs.fruitshop.service.impl.OrdersDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/assets/orders")
public class OrdersController {

    @Autowired
    OrdersService ordersService;
    @Autowired
    OedersDetailService  oedersDetailService;

    @RequestMapping("/ordersiList/{page}")
    public String ordersList(@PathVariable Integer page, Model model){
        PageInfo<Orders> listPage = ordersService.list(page);
        model.addAttribute("listPage",listPage);
        return "assets/orders/ordersList";
    }

    @RequestMapping("/toOrdersDetail")
    public String toOrdersDetail(Integer orderid,Model model){
//        System.out.println("orderid"+orderid);
        List<Orders> detail = ordersService.listById(orderid);
        System.out.println("detail"+detail);
        model.addAttribute("detail",detail);
        return "assets/orders/orderDetail";
    }

    @RequestMapping("/likeSelect")
    public String likeSelect(Orders orders, Model model){
        PageInfo<Orders> listPage = ordersService.likeSelectSnAndUid(orders);
        model.addAttribute("listPage",listPage);
        return "assets/orders/ordersList";

    }
}

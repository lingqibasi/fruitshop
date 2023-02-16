package com.qs.fruitshop.controller.rest;


import com.github.pagehelper.PageInfo;
import com.qs.fruitshop.pojo.*;
import com.qs.fruitshop.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/rest")
public class OrdersRest {

    @Autowired
    OrdersService ordersService;

    @Autowired
    Result result;

    @RequestMapping(value = "/orders/updateState",method = RequestMethod.POST)
    public Result<Orders> updateState(@RequestBody Orders orders){
        ordersService.updateState(orders);
        result.setCode(200);
        result.setMsg("成功");
        result.setData(null);
        return result;

    }
    @RequestMapping(value = "/orders/add",method = RequestMethod.POST)
    public Result<Orders> insertOrders(@RequestBody OrderRequest orderRequest, HttpSession session){

        Orders orders = (Orders)session.getAttribute("orders");
        orders.setAddressId(orderRequest.getAddressId());
        System.out.println("orders>>>>"+orders);
        int res = ordersService.addOrders(orders);
        if (res >= 1){
            result.setCode(200);
            result.setMsg("成功");
            result.setData(null);
        }else if (res == -1){
            result.setCode(-1);
            result.setMsg("库存不足");
            result.setData(null);
        }
        return result;
    }
    @RequestMapping(value = "/orders",method = RequestMethod.GET)
    public Result<Orders> ListOrder(@RequestBody Orders orders){
        List<Orders> list = ordersService.listOrders();
        if (list != null){
            result.setCode(200);
            result.setMsg("成功");
            result.setData(list);
        }else{
            result.setCode(400);
            result.setMsg("失败");
            result.setData(null);
        }
        return result;
    }

    @RequestMapping(value = "/ordersById/{id}",method = RequestMethod.GET)
    public Result<Orders> listOrdersById(@PathVariable Integer id){
        List<Orders> listById = ordersService.listById(id);
        if (listById != null){
            result.setCode(200);
            result.setMsg("成功");
            result.setData(listById);
        }else{
            result.setCode(400);
            result.setMsg("失败");
            result.setData(null);
        }
        return result;
    }

    @RequestMapping(value = "/ordersByUid/{uid}",method = RequestMethod.GET)
    public Result<Orders> selectOrderByUid(@PathVariable Integer uid){
        List<Orders> byUid = ordersService.getByUid(uid);
        if (!byUid.isEmpty()){
            result.setCode(200);
            result.setMsg("成功");
            result.setData(byUid);
        }else{
            result.setCode(400);
            result.setMsg("失败");
            result.setData(null);
        }
        return result;
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public Result<Orders> deleteOrders(@PathVariable Integer id){
        ordersService.deleteById(id);
        result.setCode(200);
        result.setMsg("成功");
        result.setData(null);
        return result;
    }

}

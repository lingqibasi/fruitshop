package com.qs.fruitshop.controller;

import com.qs.fruitshop.mapper.GoodsTypeMapper;
import com.qs.fruitshop.pojo.Goods;
import com.qs.fruitshop.pojo.GoodsType;
import com.qs.fruitshop.pojo.Iuser;
import com.qs.fruitshop.pojo.Orders;
import com.qs.fruitshop.service.GoodsService;
import com.qs.fruitshop.service.IuserService;
import com.qs.fruitshop.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/front")
public class IndexController {

    @Autowired
    GoodsService goodsService;
    @Autowired
    OrdersService ordersService;
    @Autowired
    IuserService iuserService;
    @Autowired
    GoodsTypeMapper goodsTypeMapper;

    @RequestMapping(value = {"/index","/INDEX"})
    public String index(Model model, HttpSession session){
//        获取商品集合
//        List<Goods> goodsList = goodsService.goodsList();
//        获取销量前5的商品
        List<Goods> hotGoods = goodsService.queryHotGoods();
//        获取分类列表
        List<GoodsType> typeList = goodsTypeMapper.list();
        System.out.println("typeList"+typeList);
//        将信息，存入request域中
//        model.addAttribute("goodsList",goodsList);
        model.addAttribute("hot",hotGoods);
        model.addAttribute("typeList",typeList);
//        将用户信息存入session中
        session.getAttribute("user");
        return "front/index/index";
    }

    @RequestMapping("/item/detail")
    public String itemDetail(Integer id,Model model){
        Goods goodsDetail = goodsService.toGoodsDetailById(id);
        if (goodsDetail == null){
            return "index";
        }
        model.addAttribute("goodsDetail",goodsDetail);
        return "/front/item/view";
    }

    @RequestMapping("/itemOrders")
    public String itemOrders(Model model,HttpSession session){
        Iuser iuser = (Iuser) session.getAttribute("iusers");
        List<Orders> detail = ordersService.getByUid(iuser.getId());
        System.out.println("detail---"+detail);
        model.addAttribute("detail",detail);
        return "front/orders/ordersitem";
    }

    @RequestMapping("/my")
    public String toMy(Model model,HttpSession session){
        Iuser iuser = (Iuser) session.getAttribute("iusers");
        Iuser my = iuserService.queryIuerById(iuser.getId());
        model.addAttribute("obj",my);
        return "/front/user/my";
    }

    @RequestMapping("/orders/delete")
    public String deleteOrders(Integer id, HttpServletRequest request){
        String contextPath = request.getContextPath();
        ordersService.deleteById(id);
        return "redirect:/front/itemOrders";
    }


}

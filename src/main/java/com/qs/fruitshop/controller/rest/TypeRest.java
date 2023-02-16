package com.qs.fruitshop.controller.rest;

import com.qs.fruitshop.pojo.Goods;
import com.qs.fruitshop.pojo.Orders;
import com.qs.fruitshop.pojo.Result;
import com.qs.fruitshop.service.GoodsService;
import com.qs.fruitshop.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/rest")
public class TypeRest {
    @Autowired
    GoodsService goodsService;
    @Autowired
    Result result;

    @RequestMapping(value = "/goods/type/{typeid}", method = RequestMethod.GET)
    public Result<Goods> listGoodsByTypeName(@PathVariable Integer typeid, Model model) {
        List<Goods> listById = goodsService.getByTypeName(typeid);
        model.addAttribute("goodsList",listById);
        result.setCode(200);
        result.setMsg("成功");
        result.setData(listById);
        return result;
    }
}

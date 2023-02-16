package com.qs.fruitshop.controller.rest;

import com.qs.fruitshop.pojo.Cart;
import com.qs.fruitshop.pojo.Goods;
import com.qs.fruitshop.pojo.Result;
import com.qs.fruitshop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/rest")
public class IndexRest {
    @Autowired
    GoodsService goodsService;
    @Autowired
    Result result;

    @ResponseBody
    @RequestMapping(value = "/goods/list", method = RequestMethod.GET)
    public Result<Goods> goodsList() {
        List<Goods> goodsList = goodsService.goodsList();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(goodsList);
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/goods/like", method = RequestMethod.POST)
    public Result<Goods> goodsListLike(@RequestBody Goods goods) {
        List<Goods> goodsList = goodsService.selectGoodsByGoodsName(goods);
        result.setCode(200);
        result.setMsg("成功");
        result.setData(goodsList);

        return result;
    }
}

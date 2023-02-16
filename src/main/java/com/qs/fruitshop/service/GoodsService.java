package com.qs.fruitshop.service;

import com.github.pagehelper.PageInfo;
import com.qs.fruitshop.pojo.Goods;
import com.qs.fruitshop.pojo.Page;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

public interface GoodsService {

    PageInfo<Goods> goodsListByPage(Integer page);

    List<Goods> goodsList();

    Integer addGoods(Goods goods);

    Goods toGoodsDetailById(Integer id);

    int updateGoods(Goods goods);

    int deleteGoods(Integer id);

    PageInfo<Goods> selectGoodsByNoAndName(Goods goods);

    List<Goods> queryHotGoods();

    List<Goods> getByTypeName(Integer typeid);

    List<Goods> selectGoodsByGoodsName(Goods goods);
}

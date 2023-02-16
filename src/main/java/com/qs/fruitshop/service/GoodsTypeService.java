package com.qs.fruitshop.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.qs.fruitshop.pojo.Goods;
import com.qs.fruitshop.pojo.GoodsType;

import java.util.List;

public interface GoodsTypeService {

    List<GoodsType> typeList();

    PageInfo<GoodsType> list(Integer page);

    int insert(GoodsType goodsType);

    GoodsType  queryById(Integer id);

    int updateById(GoodsType goodsType);

    int deleteById(Integer id);
}

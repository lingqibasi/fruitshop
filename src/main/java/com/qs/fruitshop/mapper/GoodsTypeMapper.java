package com.qs.fruitshop.mapper;

import com.qs.fruitshop.pojo.GoodsType;

import java.util.List;

public interface GoodsTypeMapper {

    List<GoodsType> list();

    int insert(GoodsType goodsType);

    GoodsType  queryById(Integer id);

    int updateById(GoodsType goodsType);

    int deleteById(Integer id);

}

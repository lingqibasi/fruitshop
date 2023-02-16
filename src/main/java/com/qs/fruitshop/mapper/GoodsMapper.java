package com.qs.fruitshop.mapper;

import com.github.pagehelper.PageInfo;
import com.qs.fruitshop.pojo.Cart;
import com.qs.fruitshop.pojo.Goods;
import com.qs.fruitshop.pojo.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {

    PageInfo<Goods> listByPage(Page page);
    List<Goods> list();

    Integer insertGoods(Goods goods);

    Goods queryGoodsById(Integer id);

    int updateGoodsById(Goods goods);

    int deleteGoodsById(Integer id);

    List<Goods> selectGoodsByNoAndName(Goods goods);

    List<Goods> queryHotGoods();

    int updateCart(Cart cart);

    List<Goods> selectBatch(@Param("goodsid") List<Integer> goodsId);

    List<Goods> getGoodsByTypeName(@Param("typeid") Integer typeid);

}

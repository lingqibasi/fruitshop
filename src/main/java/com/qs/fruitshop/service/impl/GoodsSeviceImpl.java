package com.qs.fruitshop.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qs.fruitshop.mapper.GoodsMapper;
import com.qs.fruitshop.pojo.Goods;
import com.qs.fruitshop.pojo.Page;
import com.qs.fruitshop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GoodsSeviceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    Page pages;

//    @Override
//    public PageInfo<Goods> goodsListByPage(Page page) {
//        PageHelper.startPage(page.getPageNum(),page.getPageSize());
//        List<Goods> list = goodsMapper.list();
//        PageInfo<Goods> userList = new PageInfo<>(list);
//        return userList;
//    }


    @Override
    public PageInfo<Goods> goodsListByPage(Integer page) {

        PageHelper.startPage(page,pages.getPageSize());
        List<Goods> list = goodsMapper.list();
        PageInfo<Goods> userList = new PageInfo<>(list);
        return userList;
    }

    @Override
    public List<Goods> goodsList() {
        return goodsMapper.list();
    }

    @Override
    public int deleteGoods(Integer id) {
        return goodsMapper.deleteGoodsById(id);
    }

    @Override
    public PageInfo<Goods> selectGoodsByNoAndName(Goods goods) {
        PageHelper.startPage(pages.getPageNum(),pages.getPageSize());
        List<Goods> listByCondition = goodsMapper.selectGoodsByNoAndName(goods);
        PageInfo<Goods> userList = new PageInfo<>(listByCondition);
        return userList;
    }

    @Override
    public List<Goods> queryHotGoods() {
        return goodsMapper.queryHotGoods();
    }

    @Override
    public List<Goods> getByTypeName(Integer typeid) {
        return goodsMapper.getGoodsByTypeName(typeid);
    }

    @Override
    public List<Goods> selectGoodsByGoodsName(Goods goods) {
        System.out.println("我是模糊查询"+goods.getGoodsName());
        return goodsMapper.selectGoodsByNoAndName(goods);
    }

    @Override
    public Integer addGoods(Goods goods) {
        return goodsMapper.insertGoods(goods);
    }

    @Override
    public Goods toGoodsDetailById(Integer id) {
        return goodsMapper.queryGoodsById(id);
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsMapper.updateGoodsById(goods);
    }


}

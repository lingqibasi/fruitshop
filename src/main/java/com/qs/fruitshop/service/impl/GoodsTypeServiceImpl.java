package com.qs.fruitshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qs.fruitshop.mapper.GoodsTypeMapper;
import com.qs.fruitshop.pojo.GoodsType;
import com.qs.fruitshop.pojo.Page;
import com.qs.fruitshop.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Autowired
    GoodsTypeMapper goodsTypeMapper;
    @Autowired
    Page pages;

    @Override
    public List<GoodsType> typeList() {
        return goodsTypeMapper.list();
    }

    @Override
    public PageInfo<GoodsType> list(Integer page) {
        PageHelper.startPage(page,pages.getPageSize());
        List<GoodsType> list = goodsTypeMapper.list();
        PageInfo<GoodsType> goodsTypePageInfo = new PageInfo<>(list);
        return goodsTypePageInfo;
    }

    @Override
    public int insert(GoodsType goodsType) {
       return goodsTypeMapper.insert(goodsType);
    }

    @Override
    public GoodsType queryById(Integer id) {
        return goodsTypeMapper.queryById(id);
    }

    @Override
    public int updateById(GoodsType goodsType) {
        return goodsTypeMapper.updateById(goodsType);
    }

    @Override
    public int deleteById(Integer id) {
        return goodsTypeMapper.deleteById(id);
    }
}

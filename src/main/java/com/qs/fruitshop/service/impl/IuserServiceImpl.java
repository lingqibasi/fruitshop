package com.qs.fruitshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qs.fruitshop.mapper.IuserMapper;
import com.qs.fruitshop.pojo.Iuser;
import com.qs.fruitshop.pojo.Page;
import com.qs.fruitshop.pojo.User;
import com.qs.fruitshop.service.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IuserServiceImpl implements IuserService {

    @Autowired
    IuserMapper iuserMapper;
    @Autowired
    Page pages;

    @Override
    public Iuser queryIuer(Iuser iuser) {
        return iuserMapper.queryIuer(iuser);
    }

//    注册
    @Override
    public int insertIuser(Iuser iuser) {
        return iuserMapper.insertIuser(iuser);
    }

    @Override
    public Iuser queryIuerById(Integer id) {
        return iuserMapper.queryIuerById(id);
    }

    @Override
    public PageInfo<Iuser> selectByPage(Integer id) {
        PageHelper.startPage(pages.getPageNum(),pages.getPageSize());
        List<Iuser> listByCondition = iuserMapper.selectIuser();
        PageInfo<Iuser> List = new PageInfo<>(listByCondition);
        return List;
    }

    @Override
    public int insert(Iuser iuser) {
        return iuserMapper.insert(iuser);
    }

    @Override
    public PageInfo<Iuser> selectByCondition(Iuser iuser) {
        PageHelper.startPage(pages.getPageNum(),pages.getPageSize());
        List<Iuser> listByCondition = iuserMapper.selectByCondition(iuser);
        PageInfo<Iuser> List = new PageInfo<>(listByCondition);
        return List;
    }


    @Override
    public Iuser selectById(Integer id) {
        return iuserMapper.queryIuerById(id);
    }

    @Override
    public int update(Iuser iuser) {
        return iuserMapper.updateIuser(iuser);
    }

    @Override
    public int deleteById(Integer id) {
        return iuserMapper.deleteById(id);
    }


}

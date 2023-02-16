package com.qs.fruitshop.service;

import com.github.pagehelper.PageInfo;
import com.qs.fruitshop.pojo.Iuser;
import com.qs.fruitshop.pojo.User;

import java.util.List;

public interface IuserService {
    //    查询所有
    Iuser queryIuer(Iuser iuser);


    int insertIuser(Iuser iuser);

//    根据id 查询
    Iuser queryIuerById(Integer id);


    PageInfo<Iuser> selectByPage(Integer id);

    int insert(Iuser iuser);

    Iuser selectById(Integer id);

    int update(Iuser iuser);

    int deleteById(Integer id);

    PageInfo<Iuser> selectByCondition(Iuser iuser);
}

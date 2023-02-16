package com.qs.fruitshop.mapper;

import com.github.pagehelper.PageInfo;
import com.qs.fruitshop.pojo.Iuser;


import java.util.List;

public interface IuserMapper {

    Iuser queryIuer(Iuser iuser);

//    注册
    int insertIuser(Iuser iuser);

//    根据id 查询
    Iuser queryIuerById(Integer id);

//    更新信息
    int updateIuser(Iuser iuser);

//    根据id 删除
    int deleteById(Integer id);

//    查询所有
    List<Iuser> selectIuser();

//    条件查询
    List<Iuser> selectByCondition(Iuser iuser);

//    添加信息
    int insert(Iuser iuser);
}

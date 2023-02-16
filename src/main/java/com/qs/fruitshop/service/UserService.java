package com.qs.fruitshop.service;

import com.github.pagehelper.PageInfo;
import com.qs.fruitshop.pojo.User;

import java.util.List;

public interface UserService {
    List<User> selectUsers();

    PageInfo<User> selectUsersByPage(Integer id);

    int insertUser(User user);
    User selectUserById(Integer id);

    int updateUser(User user);

    int deleteUserById(Integer id);

    PageInfo<User> selectByCondition(User user);
}

package com.qs.fruitshop.mapper;

import com.qs.fruitshop.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> selectUsers();

    int insertUser(User user);

    User selectUserById(Integer id);

    int updateUser(User user);

    int deleteUserById(Integer id);

    List<User> selectByCondition(User user);

}

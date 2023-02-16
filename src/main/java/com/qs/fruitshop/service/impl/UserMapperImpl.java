package com.qs.fruitshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qs.fruitshop.mapper.UserMapper;
import com.qs.fruitshop.pojo.Goods;
import com.qs.fruitshop.pojo.Page;
import com.qs.fruitshop.pojo.User;
import com.qs.fruitshop.service.UserService;
import com.qs.fruitshop.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMapperImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    Page pages;

    private static final String DEFAULT_PASSWORD = "123456";
    private static final String PASSWORD_SOLT = "zjl";

    @Override
    public List<User> selectUsers() {
        PageHelper.startPage(pages.getPageNum(),pages.getPageSize());
        List<User> listByCondition = userMapper.selectUsers();
        PageInfo<User> userList = new PageInfo<>(listByCondition);
        return listByCondition;
    }

    @Override
    public PageInfo<User> selectUsersByPage(Integer id) {
        if (id == null){
            id = 1;
        }
        PageHelper.startPage(id,pages.getPageSize());
        List<User> list = userMapper.selectUsers();
        PageInfo<User> userList = new PageInfo<>(list);
        return userList;
    }

    @Override
    public int insertUser(User user) {
        if (user.getPassword() == null){
            user.setPassword(DEFAULT_PASSWORD);
        }
        user.setPassword(MD5.secureUtil(user.getPassword(),PASSWORD_SOLT));
        return userMapper.insertUser(user);
    }

    @Override
    public User selectUserById(Integer id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public int updateUser(User user) {
        user.setPassword(MD5.secureUtil(user.getPassword(),PASSWORD_SOLT));
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUserById(Integer id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public PageInfo<User> selectByCondition(User user) {
        System.out.println("用户条件查询"+user);
        PageHelper.startPage(pages.getPageNum(),pages.getPageSize());
        List<User> listByCondition = userMapper.selectByCondition(user);
        PageInfo<User> userListByCondition = new PageInfo<>(listByCondition);
        return userListByCondition;
    }


}

package com.qs.fruitshop.service.impl;

import com.qs.fruitshop.mapper.LoginMapper;
import com.qs.fruitshop.pojo.User;
import com.qs.fruitshop.service.LoginService;
import com.qs.fruitshop.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.spi.LoginModule;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginMapper loginMapper;

    private static final String PASSWORD_SALT = "zjl";

    @Override
    public User login(User user) {
        user.setPassword(MD5.secureUtil(user.getPassword(),PASSWORD_SALT));
        return loginMapper.userLogin(user);
    }
}

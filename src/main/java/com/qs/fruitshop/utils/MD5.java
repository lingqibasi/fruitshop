package com.qs.fruitshop.utils;

import cn.hutool.crypto.SecureUtil;

public class MD5 {

    public static String secureUtil(String password,String solt){
        return SecureUtil.md5(password + solt);
    }
}

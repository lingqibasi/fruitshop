package com.qs.fruitshop.controller.rest;

import com.qs.fruitshop.pojo.Cart;
import com.qs.fruitshop.pojo.Iuser;

import com.qs.fruitshop.pojo.Result;
import com.qs.fruitshop.service.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/rest")
public class IndexLoginRest {
    @Autowired
    Result<Iuser> result;
    @Autowired
    IuserService iuserService;

    @ResponseBody
    @RequestMapping(value = "/iuser/insert",method = RequestMethod.POST)
    public Result<Iuser> insertCart(@RequestBody Iuser Iuser){
//        System.out.println("cart"+cart);
        int res = iuserService.insertIuser(Iuser);
        if (res >= 1){
            result.setCode(200);
            result.setMsg("成功");
            result.setData(null);
        }else{
            result.setCode(400);
            result.setMsg("失败");
            result.setData(null);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/iuser",method = RequestMethod.POST)
    public Result<Iuser> queryIuer(@RequestBody Iuser Iuser){
//        System.out.println("cart"+cart);
        Iuser iuser = iuserService.queryIuer(Iuser);
        if (iuser != null){
            result.setCode(200);
            result.setMsg("成功");
//            result.setData(iuser);
        }else{
            result.setCode(400);
            result.setMsg("失败");
            result.setData(null);
        }
        return result;
    }


}

package com.qs.fruitshop.controller;

import com.github.pagehelper.PageInfo;
import com.qs.fruitshop.pojo.Goods;
import com.qs.fruitshop.pojo.User;
import com.qs.fruitshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("assets/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/list/{id}")
    public String getUserList(Model model, @PathVariable Integer id){
        PageInfo<User> users = userService.selectUsersByPage(id);
        model.addAttribute("users",users);
        return "assets/user/userList";
    }

    @RequestMapping("/toUserAdd")
    public String toUserAdd(){
        return "assets/user/userAdd";
    }

    @RequestMapping(value = "/userAdd",method = RequestMethod.POST)
    public String userAdd(User user,Model model){
        int result = userService.insertUser(user);
        if (result != 1){
            model.addAttribute("url", "toUserAdd");
            model.addAttribute("infomation", "添加失败！");
            model.addAttribute("second", 2);
        }else{
            model.addAttribute("url", "list/1");
            model.addAttribute("infomation", "添加成功！");
            model.addAttribute("second", 2);
        }
        return "tip";
    }

    @RequestMapping("/toUserDetail")
    public String toUserDetail(Integer id,Model model){
        User user = userService.selectUserById(id);
        model.addAttribute("userinfo",user);
        return "assets/user/userUpdate";
    }

    @RequestMapping("/userUpdate")
    public String updateUser(User user,Model model){
        int result = userService.updateUser(user);
        if (result == 1) {
            model.addAttribute("url", "list/1");
            model.addAttribute("infomation", "修改成功！");
            model.addAttribute("second", 2);
        } else {
            model.addAttribute("url", "list/1");
            model.addAttribute("infomation", "修改失败！");
            model.addAttribute("second", 2);
        }
        return "tip";
    }


    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    public String deleteUser(Integer id){
//        System.out.println("删除");
        int result = userService.deleteUserById(id);
        return "redirect:list/1";
    }

    @RequestMapping(value = "/likeSelectUser",method =  RequestMethod.POST)
    public String likeSelectUser(User user, Model model){
        PageInfo<User> userPageInfo = userService.selectByCondition(user);
        model.addAttribute("users",userPageInfo);
        return "assets/user/userList";
    }

//    @RequestMapping(value = "/likeSelectGoods",method = RequestMethod.POST)
//    public String likeSelectGoods(Goods goods, Model model){
//        PageInfo<Goods> goodsListByPage = goodsService.selectGoodsByNoAndName(goods);
////        System.out.println("条件---"+goodsList);
//        model.addAttribute("goodsListByPage",goodsListByPage);
//        return "assets/goods/goodsList";
//    }
}

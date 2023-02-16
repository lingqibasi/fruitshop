package com.qs.fruitshop.controller;

import com.github.pagehelper.PageInfo;
import com.qs.fruitshop.pojo.Iuser;
import com.qs.fruitshop.pojo.User;
import com.qs.fruitshop.service.IuserService;
import com.qs.fruitshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("assets/iuser")
public class IUserController {
    @Autowired
    IuserService iuserService;

    @RequestMapping("/list/{id}")
    public String getList(Model model, @PathVariable Integer id){
        PageInfo<Iuser> iusers = iuserService.selectByPage(id);
        model.addAttribute("iusers",iusers);
        return "assets/iuser/iuserList";
    }

    @RequestMapping("/toIuserAdd")
    public String toAdd(){
        return "assets/iuser/iuserAdd";
    }

    @RequestMapping(value = "/userAdd",method = RequestMethod.POST)
    public String Add(Iuser iuser,Model model){
        int result = iuserService.insert(iuser);
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

    @RequestMapping("/toDetail")
    public String toDetail(Integer id,Model model){
        Iuser iuser = iuserService.selectById(id);
        model.addAttribute("iuserinfo",iuser);
        return "assets/iuser/iuserUpdate";
    }

    @RequestMapping("/iuserUpdate")
    public String updateUpdate(Iuser iuser,Model model){
        int result = iuserService.update(iuser);
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


    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String delete(Integer id){
//        System.out.println("删除");
        int result = iuserService.deleteById(id);
        return "redirect:list/1";
    }

    @RequestMapping(value = "/likeSelect",method =  RequestMethod.POST)
    public String likeSelect(Iuser iuser, Model model){
        PageInfo<Iuser> userPageInfo = iuserService.selectByCondition(iuser);
        model.addAttribute("iusers",userPageInfo);
        return "assets/iuser/iuserList";
    }

}

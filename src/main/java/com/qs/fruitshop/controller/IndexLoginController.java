package com.qs.fruitshop.controller;

import com.qs.fruitshop.pojo.Iuser;
import com.qs.fruitshop.service.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/front")
public class IndexLoginController {

    @Autowired
    IuserService iuserService;

    @RequestMapping(value = {"/indexlogin", "/indexLogin", "/INDEXLOGIN"})
    public String indexLogin() {
        return "/front/indexlogin/login";
    }

    @RequestMapping(value = {"/indexRegist", "/indexregist", "/INDEXREGIST"})
    public String indexRegist() {
        return "/front/indexlogin/regist";
    }


    @RequestMapping("/signIn")
    public String signIn(Iuser iuser, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        Iuser iusers = iuserService.queryIuer(iuser);
        if (iusers != null) {
            System.out.println("iusers---------" + iusers);
//            session.setAttribute("iusers",iusers);
            request.getSession().setAttribute("iusers", iusers);
//            redirectAttributes.addFlashAttribute("iusers",iusers);
            return "redirect:/front/index";
        } else {
            return "/front/indexlogin/login";
        }
    }

    @RequestMapping("/regist")
    public String regist(Iuser iuser, HttpServletRequest request,Model model) {
        int iusers = iuserService.insertIuser(iuser);

        if (iusers == 1) {
            model.addAttribute("url", "indexlogin");
            model.addAttribute("infomation", "注册成功");
            model.addAttribute("second", 2);
        } else {
            model.addAttribute("url", "regist");
            model.addAttribute("infomation", "注册失败");
            model.addAttribute("second", 2);
        }
        return "tip";




//        if (iusers > 0) {
////            System.out.println("iusers---------" + iusers);
////            request.getSession().setAttribute("iusers", iusers);
//            return "redirect:/front/indexlogin";
//        } else {
//            return "/front/indexlogin/regist";
//        }
    }

}

package com.qs.fruitshop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @RequestMapping("assets/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:userlogin";
    }

    @RequestMapping("front/logout")
    public String frontLogout(HttpSession session){
        session.removeAttribute("iusers");
        return "redirect:index";
    }
}

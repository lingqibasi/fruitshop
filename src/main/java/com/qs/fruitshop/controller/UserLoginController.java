package com.qs.fruitshop.controller;

import com.qs.fruitshop.pojo.User;
import com.qs.fruitshop.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/assets")
public class UserLoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping("/default")
    public String defaults(Model model){
        return "assets/default";
    }


    @RequestMapping(value = {"/userLogin","/userlogin","/USERLOGIN"})
    public String userLogin(){
        return "assets/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user, String captcha, HttpServletRequest request, RedirectAttributes redirectAttributes){

        String sessionCode = (String)request.getSession().getAttribute("captcha");
            //销毁验证码
        request.getSession().removeAttribute("captcha");
//        判断验证码不为空,跟session域中的验证码比较
        System.out.println("验证码"+sessionCode);
        if (sessionCode != null && sessionCode.equalsIgnoreCase(captcha)){
            User users = loginService.login(user);
            if (users == null){
                redirectAttributes.addFlashAttribute("info","用户名或密码错误");
                return "redirect:userLogin";
            }else{
                request.getSession().setAttribute("user",users);
                return "redirect:default";
            }
        }else{
            redirectAttributes.addFlashAttribute("info","验证码错误");
            return "redirect:userlogin";
        }




    }


}

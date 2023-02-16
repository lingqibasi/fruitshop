package com.qs.fruitshop.interceptor;

import com.qs.fruitshop.pojo.Iuser;
import com.qs.fruitshop.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
//        System.out.println("url"+url);
        //login.jsp、index.jsp、/index可以放行  /uIndex  /item/detail
        if ( url.indexOf("/assets/userLogin")>0 ||
                url.indexOf("/assets/userlogin")>0 ||
                url.indexOf("/assets/USERLOGIN")>0  ||
                url.indexOf("/assets/login")>0 ||
                url.indexOf("/assets/captcha")>0  ) {
            return true;
        }

        //判断用用户是否登陆，如果是，则返回true(放行)
        HttpSession userSession= request.getSession();
        User user = (User) userSession.getAttribute("user");

//        System.out.println("user---"+user);
        if (user!=null) {
            System.out.println("session用户"+user);
            return true;
        } else{ //不符合条件的给出提示，并转发到登陆页面
            String contextPath = request.getContextPath();
            System.out.println("路径"+contextPath);
            request.setAttribute("url", ""+contextPath+"/assets/userLogin");
                request.setAttribute("infomation", "您还没有登陆，请先登陆！");
                request.setAttribute("second", 2);
                request.getRequestDispatcher("/WEB-INF/jsp/tip.jsp").forward(request, response);
                return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

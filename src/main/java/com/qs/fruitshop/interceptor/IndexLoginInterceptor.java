package com.qs.fruitshop.interceptor;

import com.qs.fruitshop.pojo.Iuser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IndexLoginInterceptor  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
//        System.out.println("url"+url);
        //login.jsp、index.jsp、/index可以放行  /index  /item/detail
        if (url.indexOf("/front/indexlogin")>0  ||
                url.indexOf("/front/indexLogin")>0  ||
                url.indexOf("/front/INDEXLOGIN")>0  ||
                url.indexOf("/front/index")>0  ||
                url.indexOf("/front/item/detail")>0 ||
                url.indexOf("/front/signIn")>0 ||
                url.indexOf("/front/regist")>0 ||
                url.indexOf("/front/indexRegist")>0 ||
                url.indexOf("/front/indexregist")>0 ||
                url.indexOf("/front/INDEXREGIST")>0

        )
        {
            return true;
        }
        String contextPath = request.getContextPath();

        //判断用用户是否登陆，如果是，则返回true(放行)
        HttpSession indexSession= request.getSession();
        Iuser indexuser = (Iuser) indexSession.getAttribute("iusers");
//        User user = (User) userSession.getAttribute("user");
//        System.out.println("前端用户"+indexuser);
        if (indexuser!=null) {
            System.out.println("user"+indexuser);
            return true;
        }
        else{ //不符合条件的给出提示，并转发到登陆页面
            request.setAttribute("url", contextPath + "/front/indexlogin");
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

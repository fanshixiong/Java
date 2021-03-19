package com.frans.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 登录成功

        Object loginUser = request.getSession().getAttribute("loginUser");
        if(null == loginUser){
            request.setAttribute("msg", "没有权限");
            request.getRequestDispatcher("index.html").forward(request, response);
            return false;
        }
        else{
            return true;
        }
    }
}

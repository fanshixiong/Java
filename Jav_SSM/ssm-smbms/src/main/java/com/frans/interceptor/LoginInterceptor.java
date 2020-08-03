package com.frans.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        Object obj = (Object) request.getSession().getAttribute("userSession");

        String requestURI = request.getRequestURI();
        System.err.println("===========>>" + requestURI);
        if (requestURI.contains("login") || requestURI.equals("/")) {
            return true;
        }

        if (obj != null && obj != ""){
            return true;
        }
        response.sendRedirect("../error.jsp");
        return false;
    }
}

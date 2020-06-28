package com.frans.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

public class CookieDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        PrintWriter writer = resp.getWriter();

        //Cookie，服务器端从客户端获取；
        Cookie[] cookies = req.getCookies(); //获得Cookie 这里返回数组，说明Cookies可能存在多个

        //判断cookie是否存在
        if(cookies != null){

            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("name")) {
                    //获取cookie中的值
                    writer.write(URLDecoder.decode(cookie.getValue(), "utf-8"));
                }
            }
        }else{
            writer.print("这是第一次访问");
        }

        //服务器给客户端响应一个cookie

        Cookie cookie = new Cookie("name", URLEncoder.encode("frans", "utf-8"));
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

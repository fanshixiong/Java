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

//保存用户上一次访问的时间
public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //服务器，告诉你，你来的时间，把这个时间封装成一个信件，下次带来就知道你来了


        //解决中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        PrintWriter writer = resp.getWriter();

        //Cookie，服务器端从客户端获取；
        Cookie[] cookies = req.getCookies(); //获得Cookie 这里返回数组，说明Cookies可能存在多个

        //判断cookie是否存在
        if(cookies != null){
            //如果存在
            writer.print("上次访问时间：");

            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("LastLoginTime")) {
                    //获取cookie中的值
                    Date date = new Date(Long.parseLong(cookie.getValue()));

                    writer.write(URLDecoder.decode(date.toString(), "utf-8"));
                }
            }
        }else{
            writer.print("这是第一次访问");
        }

        //服务器给客户端响应一个cookie

        Cookie cookie = new Cookie("LastLoginTime", URLEncoder.encode(System.currentTimeMillis() + "", "utf-8"));
        //设置cookie的有效期
        cookie.setMaxAge(24*60*60);

        resp.addCookie(cookie);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

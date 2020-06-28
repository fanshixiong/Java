package com.frans.servlet;

import com.frans.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.awt.*;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset = utf-8");

        //得到session
        HttpSession session = req.getSession();

        //给Session中存数据
        session.setAttribute("name", new Person("frans", 12));

        //获取session的id
        String id = session.getId();

        //判断Session是不是新创建的
        if(session.isNew()){
            resp.getWriter().write("session创建成功, ID: " + id);
        }else {
            resp.getWriter().write("session已经在服务器中创建了, ID: " + id);
        }

        //Session创建的时候做了什么事情
        Cookie cookie = new Cookie("JSESSIONID", id);
        resp.addCookie(cookie);

    }
}

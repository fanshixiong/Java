package com.frans.servlet;

import com.frans.pojo.User;
import com.frans.utils.Sendmail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String email = req.getParameter("email");

            User user = new User(username, password, email);
            //用户注册成功之后，给用户发送一封邮件
            //我们使用线程来专门发送邮件，防止出现耗时，和网站注册人数过多的情况；
            Sendmail send = new Sendmail(user);
            //启动线程，线程启动之后就会执行run方法来发送邮件
            send.start();

            //注册用户
            req.setAttribute("message", "注册成功，我们已经发了一封带了注册信息的电子邮件，请查收！如网络不稳定，可能过会儿才能收到！！");
            req.getRequestDispatcher("info.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("message", "注册失败！！");
            req.getRequestDispatcher("info.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

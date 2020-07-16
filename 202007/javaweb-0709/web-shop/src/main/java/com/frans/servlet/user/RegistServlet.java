package com.frans.servlet.user;

import com.frans.pojo.User;
import com.frans.service.user.UserService;
import com.frans.service.user.UserServiceImple;
import com.frans.tools.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("reg()================");
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String email = request.getParameter("userEmail");

        User user = new User();
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setUserEmail(email);
        user.setUserPermitted("customer");

        UserService userService = new UserServiceImple();
        if(userService.add(user)){
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }else{
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}

package com.frans.servlet.user;

import com.frans.pojo.User;
import com.frans.service.user.UserServiceImple;
import com.frans.tools.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("login ============ " );
		//获取用户名和密码
		String userCode = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		//用户匹配
		UserServiceImple userService = new UserServiceImple();
		User user = userService.login(userCode,userPassword);
		if(null != user){//登录成功
			request.getSession().setAttribute(Constants.USER_SESSION, user);
			response.sendRedirect("jsp/frame.jsp");
		}else{
			request.setAttribute("error", "用户名或密码不正确");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}


}
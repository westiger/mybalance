package com.tl.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tl.bean.User;
import com.tl.service.UserService;
import com.tl.service.UserServiceImp;


public class Login extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Login() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserService us = new UserServiceImp();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = us.login(email, password);
		if(user != null){
			request.getSession().setAttribute("loginUser", user);
			response.sendRedirect(request.getContextPath()+"/servlet/Controller?op=gotoBalanceSheet");
		}else{
			request.getSession().setAttribute("email", email);
			String error = "用户名或密码错误！";
			request.setAttribute("error", error);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}


	public void init() throws ServletException {
	}

}

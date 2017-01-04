package com.tl.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.tl.bean.User;
import com.tl.service.UserService;
import com.tl.service.UserServiceImp;
import com.tl.service.exception.UserExistsException;
import com.tl.utils.IDUtils;
import com.tl.utils.WebUtils;
import com.tl.web.formbean.UserFormBean;


public class Register extends HttpServlet {

	public Register() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		UserFormBean ufb = WebUtils.fillFormBean(UserFormBean.class, request);
		if(ufb.validate()){
			User user = new User();
			try {
				ConvertUtils.register(new DateLocaleConverter(), Date.class);
				BeanUtils.copyProperties(user, ufb);
				user.setId(IDUtils.createNewId());
			} catch (Exception e) {
				e.printStackTrace();
			}
			UserService us = new UserServiceImp();
			try {
				us.register(user);
				out.write("恭喜："+user.getEmail()+"，注册成功！即将转向登录页面。");
				request.getSession().setAttribute("email", user.getEmail());
				response.setHeader("Refresh", "5;url="+request.getContextPath()+"/login.jsp");
				//response.sendRedirect(request.getContextPath()+"/login.jsp");
			} catch (UserExistsException e) {
				ufb.getErrors().put("email", "此邮箱已被注册！");
				request.setAttribute("user", ufb);
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}
			
		}else{
			request.setAttribute("user", ufb);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}


	public void init() throws ServletException {
	}

}

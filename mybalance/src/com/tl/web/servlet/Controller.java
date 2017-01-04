package com.tl.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tl.service.UserService;
import com.tl.service.UserServiceImp;

public class Controller extends HttpServlet {

	UserService us = new UserServiceImp();
	
	public Controller() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}
	
	public void init() throws ServletException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("op");
		if("gotoLogin".equals(op)){
			gotoLogin(request,response);
		}else if("confirmLogin".equals(op)){
			confirmLogin(request,response);
		}else if("confirmRegister".equals(op)){
			confirmRegister(request,response);
		}else if("gotoBalanceSheet".equals(op)){
			gotoBalanceSheet(request,response);
		}else if("addRecord".equals(op)){
			addRecord(request,response);
		}else if("deleteAllSelected".equals(op)){
			deleteAllSelected(request,response);
		}else if("confirmFindRecord".equals(op)){
			confirmFindRecord(request,response);
		}else if ("loadDataForKchart".equals(op)){
			loadDataForKchart(request,response);
		}
	}

	private void gotoLogin(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}

	private void confirmLogin(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
		
		request.getRequestDispatcher("/servlet/Login").forward(request, response);	
	}

	private void confirmRegister(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{

		request.getRequestDispatcher("/servlet/Register").forward(request, response);
	}
	
	private void gotoBalanceSheet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{

		request.getRequestDispatcher("/servlet/BalanceSheet").forward(request, response);
	}
	
	private void addRecord(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{

		request.getRequestDispatcher("/servlet/AddRecord").forward(request, response);
	}
	
	private void deleteAllSelected(HttpServletRequest request,
			HttpServletResponse response)  throws ServletException, IOException{
		
		request.getRequestDispatcher("/servlet/DeleteAllSelected").forward(request, response);
	}
		
	private void confirmFindRecord(HttpServletRequest request,
			HttpServletResponse response)  throws ServletException, IOException{
		
		request.getRequestDispatcher("/servlet/FindRecord").forward(request, response);
	}
	
	private void loadDataForKchart(HttpServletRequest request,
			HttpServletResponse response)  throws ServletException, IOException{
		
		request.getRequestDispatcher("/servlet/LoadDataForKchart").forward(request, response);
	}

}

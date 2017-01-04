package com.tl.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tl.bean.Record;
import com.tl.bean.User;
import com.tl.service.RecordService;
import com.tl.service.RecordServiceImp;

public class BalanceSheet extends HttpServlet {

	public BalanceSheet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User)request.getSession().getAttribute("loginUser");
		RecordService  rs = new RecordServiceImp();
		List<Record> balanceSheet = rs.findByUser(user);
		request.getSession().setAttribute("balanceSheet", balanceSheet);
		response.sendRedirect(request.getContextPath()+"/balancesheet.jsp");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}

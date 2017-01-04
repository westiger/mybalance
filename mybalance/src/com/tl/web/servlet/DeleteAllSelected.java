package com.tl.web.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tl.service.RecordService;
import com.tl.service.RecordServiceImp;

public class DeleteAllSelected extends HttpServlet {

	public DeleteAllSelected() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RecordService rs = new RecordServiceImp();
		String idsStr = request.getParameter("idsStr");
		if(!"".equals(idsStr)){
			idsStr = idsStr.substring(0,idsStr.length()-1);
			String[] ids = idsStr.split(",");
			for (int i = 0; i < ids.length; i++) {
				rs.deleteById(ids[i]);
			}
		}
		response.sendRedirect(request.getContextPath()+"/servlet/Controller?op=gotoBalanceSheet");
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}

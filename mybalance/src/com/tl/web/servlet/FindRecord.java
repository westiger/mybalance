package com.tl.web.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tl.bean.Record;
import com.tl.bean.User;
import com.tl.service.RecordService;
import com.tl.service.RecordServiceImp;

public class FindRecord extends HttpServlet {

	public FindRecord() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String beginTime = request.getParameter("beginTime");
		String endTime = request.getParameter("endTime");
		
		User user = (User)request.getSession().getAttribute("loginUser");
		
		
		RecordService  rs = new RecordServiceImp();
		List<Record> records = rs.findByUser(user);
		
		
		
		List<Record> recordFinded = new ArrayList<Record>();

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date beginDate = sdf.parse(beginTime);
			Date endDate = sdf.parse(endTime); 
			for (int i = 0; i < records.size(); i++) {
				if(records.get(i).getOptime().after(beginDate) && records.get(i).getOptime().before(endDate)){
					recordFinded.add(records.get(i));
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		

		request.getSession().setAttribute("beginTime", beginTime);
		request.getSession().setAttribute("endTime", endTime);
		request.getSession().setAttribute("recordFinded",recordFinded);
		response.sendRedirect(request.getContextPath()+"/findrecord.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	public void init() throws ServletException {
		// Put your code here
	}

}

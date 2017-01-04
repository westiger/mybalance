package com.tl.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.tl.bean.Record;
import com.tl.bean.User;
import com.tl.service.RecordService;
import com.tl.service.RecordServiceImp;
import com.tl.utils.IDUtils;
import com.tl.utils.WebUtils;
import com.tl.web.formbean.RecordFormBean;

public class AddRecord extends HttpServlet {

	public AddRecord() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User)request.getSession().getAttribute("loginUser");
		
		RecordFormBean rfb = WebUtils.fillFormBean(RecordFormBean.class, request);
		Record record = new Record();
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		try {
			BeanUtils.copyProperties(record, rfb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		record.setId(IDUtils.createNewId());
		record.setSid(user.getId());
		
		RecordService rs = new RecordServiceImp();
		List<Record> balanceSheet = (List<Record>)request.getSession().getAttribute("balanceSheet");
		if(balanceSheet != null && balanceSheet.size() != 0){
			Record lastRecord = balanceSheet.get(0);
			record.setAssets(lastRecord.getBalance());
		}else{
			record.setAssets(0);
		}
		record.setBalance(record.getAssets()+record.getIncome()-record.getExpend());
		
		if(rs.add(record)){
			response.sendRedirect(request.getContextPath()+"/servlet/Controller?op=gotoBalanceSheet");
		}else{
			request.setAttribute("error", "ÃÌº” ß∞‹£°");
			request.getRequestDispatcher("/addRecord.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}

package com.tl.web.servlet;

import java.awt.BufferCapabilities.FlipContents;
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.tl.bean.Record;
import com.tl.bean.User;
import com.tl.service.RecordService;
import com.tl.service.RecordServiceImp;

public class LoadDataForKchart extends HttpServlet {

	
	public LoadDataForKchart() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User)request.getSession().getAttribute("loginUser");
		
		RecordService rs = new RecordServiceImp();
		
        List<Record> records = rs.findByUserAsc(user);
        
        
        List<String> dataX = new ArrayList<String>();
        List<List> dataY = new ArrayList<List>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        DecimalFormat   df  =   new  DecimalFormat("##0.00"); 
        
        for (int i = 0; i < records.size(); i++) {
        	String time = sdf.format(records.get(i).getOptime());
        	dataX.add(time);
        	
//        	List<String> dataYCell = new ArrayList<String>();
//        	if(i != 0){
//        		dataYCell.add(df.format(records.get(i-1).getBalance()));
//            	dataYCell.add(df.format(records.get(i).getBalance()));
//            	dataYCell.add(df.format(records.get(i-1).getBalance()));
//            	dataYCell.add(df.format(records.get(i).getBalance()));
//        	}else{
//        		dataYCell.add(df.format(0));
//            	dataYCell.add(df.format(records.get(i).getBalance()));
//            	dataYCell.add(df.format(0));
//            	dataYCell.add(df.format(records.get(i).getBalance()));
//        	}
//        	
//        	System.out.println(dataYCell);
//
//        	dataY.add(dataYCell);

		}
        dataX = new ArrayList<String>(new HashSet<String>(dataX));//去重
        Collections.sort(dataX);//上升排序
        
        int countMonth =12*( Integer.parseInt(dataX.get(dataX.size()-1).split("-")[0]) - Integer.parseInt(dataX.get(0).split("-")[0])) + Integer.parseInt(dataX.get(dataX.size()-1).split("-")[1]) - Integer.parseInt(dataX.get(0).split("-")[1]) + 1;
        
        String[] dataXBeginTime = dataX.get(0).split("-");
    	String year = dataXBeginTime[0];
    	String month = dataXBeginTime[1];
    	
    	
    	dataX.clear();
        for (int i = 0; i < countMonth; i++) {

        	Date beginTime = new Date();
        	Date endTime = new Date();
        	
        	dataX.add(year + "-" + month);
        	
			try {
				beginTime = sdf.parse(year + "-" + month + "-" + "1");
				if(month.equals("12")){
					month = "1";
					year = (Integer.parseInt(year) + 1) + "";
				}else{
					month = (Integer.parseInt(month) + 1) + "";
				}
				endTime = sdf.parse(year + "-" + month + "-" + "1");
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			
			List<Float> balancesInOneMonth = new ArrayList<Float>();
			for (int ii = 0; ii < records.size(); ii++) {
				if(records.get(ii).getOptime().after(beginTime) && records.get(ii).getOptime().before(endTime)){
					balancesInOneMonth.add(records.get(ii).getBalance());
				}
			}
			
			List<String> dataYCell = new ArrayList<String>();
			
			dataYCell.add(df.format(balancesInOneMonth.get(0)));//月初
			dataYCell.add(df.format(balancesInOneMonth.get(balancesInOneMonth.size()-1)));//月末
			dataYCell.add(df.format(Collections.min(balancesInOneMonth)));//最低
			dataYCell.add(df.format(Collections.max(balancesInOneMonth)));//最高
			
			dataY.add(dataYCell);
			
		}
        

        List<List> data = new ArrayList<List>();
        data.add(dataX);
        data.add(dataY);
       
        JSONArray json = JSONArray.fromObject(data);
        
        //System.out.println(json.toString());
        //返回给前端页面
        PrintWriter out = response.getWriter();  
        out.println(json);  
        out.flush();  
        out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}

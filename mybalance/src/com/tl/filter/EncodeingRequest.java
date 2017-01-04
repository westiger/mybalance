package com.tl.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.tl.utils.IDUtils;

/**
 * 解决全站中文乱码（Get方式）
 */
public class EncodeingRequest extends HttpServletRequestWrapper {

	public EncodeingRequest(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String name) {
		String value = super.getParameter(name);
		if(super.getMethod().equalsIgnoreCase("GET")){
			try {
				value = new String(value.getBytes("ISO-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return value;
	}

}
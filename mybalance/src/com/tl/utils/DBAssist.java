package com.tl.utils;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBAssist {

	public boolean update(String sql, Object... params){
		
		Connection connection = null;
		int n = 0;
		try {
			connection = JDBCUtils.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ParameterMetaData pmd = ps.getParameterMetaData();
			if(pmd.getParameterCount() > 0){
				if(params == null || params.length != pmd.getParameterCount()){
					throw new RuntimeException("参数个数不匹配");
				}else{
					for (int i = 0; i < params.length; i++) {
						ps.setObject(i + 1, params[i]);
					}
				}
			}
			n = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return n > 0 ? true : false;
	}
	
	public Object query(Class clazz, String sql, Object... params){
		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ParameterMetaData pmd = ps.getParameterMetaData();
			if(pmd.getParameterCount() > 0){
				if(params == null || params.length != pmd.getParameterCount()){
					throw new RuntimeException("参数个数不匹配");
				}else{
					for (int i = 0; i < params.length; i++) {
						ps.setObject(i + 1, params[i]);
					}
				}
			}
			ResultSet rs = ps.executeQuery();
			return new ResultSetHandlerImp().handler(rs, clazz);
		} catch (Exception e) {
			throw new RuntimeException();
		}finally{
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
public boolean execute(String sql, Object... params){
		
		Connection connection = null;
		boolean b = false;
		try {
			connection = JDBCUtils.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ParameterMetaData pmd = ps.getParameterMetaData();
			if(pmd.getParameterCount() > 0){
				if(params == null || params.length != pmd.getParameterCount()){
					throw new RuntimeException("参数个数不匹配");
				}else{
					for (int i = 0; i < params.length; i++) {
						ps.setObject(i + 1, params[i]);
					}
				}
			}
			b = ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return b;
	}
}

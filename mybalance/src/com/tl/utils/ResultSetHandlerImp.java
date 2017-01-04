package com.tl.utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class ResultSetHandlerImp implements ResultSetHandler {

	@Override
	public Object handler(ResultSet rs, Class clazz) {
		List<Object> list = new ArrayList<Object>();
		
		try {
			while(rs.next()){
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnCount = rsmd.getColumnCount();
				Object obj = clazz.newInstance();
				for (int i = 0; i < columnCount; i++) {
					String columnName = rsmd.getColumnName(i+1);
					Field field = clazz.getDeclaredField(columnName);
					field.setAccessible(true);
					Object value = rs.getObject(i+1);
					field.set(obj, value);
				}
				list.add(obj);
			}
			return list;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}

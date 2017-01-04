package com.tl.service;

import java.util.List;

import com.tl.bean.Record;
import com.tl.bean.User;

public interface RecordService {
	/**
	 * 创建一个资产负债表
	 */
	public void createBalanceSheet();
	
	/**
	 * 添加一个记录
	 */
	public boolean add(Record record);
	
	/**
	 * 修改一个记录
	 */
	public boolean update(Record record);
	
	/**
	 * 删除一个记录
	 */
	public boolean deleteById(String id);
	
	/**
	 * 查询所有记录
	 */
	public List<Record> findAll();
	
	/**
	 * 查询一个记录
	 */
	public Record findById(String id);
	
	/**
	 * 根据用户查询记录
	 */
	public List<Record> findByUser(User user);
	
	public List<Record> findByUserAsc(User user);
}

package com.tl.service;

import java.util.List;

import com.tl.bean.Record;
import com.tl.bean.User;

public interface RecordService {
	/**
	 * ����һ���ʲ���ծ��
	 */
	public void createBalanceSheet();
	
	/**
	 * ���һ����¼
	 */
	public boolean add(Record record);
	
	/**
	 * �޸�һ����¼
	 */
	public boolean update(Record record);
	
	/**
	 * ɾ��һ����¼
	 */
	public boolean deleteById(String id);
	
	/**
	 * ��ѯ���м�¼
	 */
	public List<Record> findAll();
	
	/**
	 * ��ѯһ����¼
	 */
	public Record findById(String id);
	
	/**
	 * �����û���ѯ��¼
	 */
	public List<Record> findByUser(User user);
	
	public List<Record> findByUserAsc(User user);
}

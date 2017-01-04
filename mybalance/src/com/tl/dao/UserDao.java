package com.tl.dao;

import java.util.List;

import com.tl.bean.User;

public interface UserDao {

	/**
	 * �½�һ���ͻ���
	 */
	public void createUserTable();
	
	/**
	 * ���һ���ͻ�
	 */
	public boolean add(User user);
	
	/**
	 * �޸�һ���ͻ�
	 */
	public boolean update(User user);
	
	/**
	 * ɾ��һ���ͻ�
	 */
	public boolean deleteById(String id);
	
	/**
	 * ��ѯ���пͻ�
	 */
	public List<User> findAll();
	
	/**
	 * ��ѯһ���ͻ�
	 */
	public User findById(String id);
	
	/**
	 * ͨ�������ѯ�ͻ�
	 */
	public User findByEmail(String email);
	
	/**
	 * ͨ������������ѯ�ͻ�
	 */
	public User findByEmailAndPassword(String email, String password);
}

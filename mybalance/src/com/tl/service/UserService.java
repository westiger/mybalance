package com.tl.service;

import java.util.List;

import com.tl.bean.User;
import com.tl.service.exception.UserExistsException;

public interface UserService {

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
	 * ͨ���ʼ���ѯ�ͻ�
	 */
	public User findByEmail(String email);
	
	/**
	 * �û���¼
	 */
	public User login(String email, String password);
	
	/**
	 * �û�ע��
	 */
	public void register(User user) throws UserExistsException;
}

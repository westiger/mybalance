package com.tl.service;

import java.util.List;

import com.tl.bean.User;
import com.tl.service.exception.UserExistsException;

public interface UserService {

	/**
	 * 新建一个客户表
	 */
	public void createUserTable();
	
	/**
	 * 添加一个客户
	 */
	public boolean add(User user);
	
	/**
	 * 修改一个客户
	 */
	public boolean update(User user);
	
	/**
	 * 删除一个客户
	 */
	public boolean deleteById(String id);
	
	/**
	 * 查询所有客户
	 */
	public List<User> findAll();
	
	/**
	 * 查询一个客户
	 */
	public User findById(String id);
	
	/**
	 * 通过邮件查询客户
	 */
	public User findByEmail(String email);
	
	/**
	 * 用户登录
	 */
	public User login(String email, String password);
	
	/**
	 * 用户注册
	 */
	public void register(User user) throws UserExistsException;
}

package com.tl.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tl.bean.User;
import com.tl.utils.JDBCUtils;

public class UserDaoImp implements UserDao {

	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	
	public UserDaoImp(){
		this.createUserTable();
	}
	
	@Override
	public void createUserTable(){
		String sql = "create table if not exists user"
				+ "(id VARCHAR(100) PRIMARY KEY,"
				+ "password VARCHAR(100),"
				+ "name VARCHAR(100),"
				+ "email VARCHAR(100),"
				+ "cellphone VARCHAR(100),"
				+ "optime TIMESTAMP)";
		try {
			qr.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean add(User user) {
		
		String sql = "insert into user(id,password,name,email,cellphone) values(?,?,?,?,?)";
		int n = 0;
		try {
			n = qr.update(sql,
					user.getId(),
					user.getPassword(),
					user.getName(),
					user.getEmail(),
					user.getCellphone()
					);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0?true:false;
	}

	@Override
	public boolean update(User user) {
		
		String sql = "update user set password=?,name=?,email=?,cellphone=? where id=?";
		int n = 0;
		try {
			n = qr.update(sql,
					user.getPassword(),
					user.getName(),
					user.getEmail(),
					user.getCellphone(),
					user.getId()
					);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0?true:false;
	}

	@Override
	public boolean deleteById(String id) {
		
		String sql = "delete from user where id=?";
		int n = 0;
		try {
			n = qr.update(sql,
					id
					);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0?true:false;
	}

	@Override
	public List<User> findAll() {
		
		String sql = "select id,password,name,email,cellphone,optime from user";
		try {
			return qr.query(sql, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User findById(String id) {
		
		String sql = "select id,password,name,email,cellphone,optime from user where id=?";
		try {
			return qr.query(sql, new BeanHandler<User>(User.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User findByEmail(String email) {
		
		String sql = "select id,password,name,email,cellphone,optime from user where email=?";
		try {
			return qr.query(sql, new BeanHandler<User>(User.class),email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User findByEmailAndPassword(String email, String password){
		
		String sql = "select id,password,name,email,cellphone,optime from user where email=? and password=?";
		try {
			return qr.query(sql, new BeanHandler<User>(User.class),email,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

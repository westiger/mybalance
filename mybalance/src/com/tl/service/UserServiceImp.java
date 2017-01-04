package com.tl.service;

import java.util.List;

import com.tl.bean.User;
import com.tl.dao.UserDao;
import com.tl.dao.UserDaoImp;
import com.tl.service.exception.UserExistsException;

public class UserServiceImp implements UserService {

	UserDao ud = new UserDaoImp();
	
	@Override
	public void createUserTable(){
		ud.createUserTable();
	}
	
	@Override
	public boolean add(User user) {
		return ud.add(user);
	}

	@Override
	public boolean update(User user) {
		return ud.update(user);
	}

	@Override
	public boolean deleteById(String id) {
		return ud.deleteById(id);
	}

	@Override
	public List<User> findAll() {
		return ud.findAll();
	}

	@Override
	public User findById(String id) {
		return ud.findById(id);
	}

	@Override
	public User findByEmail(String email) {
		return ud.findByEmail(email);
	}

	@Override
	public User login(String email, String password) {
		return ud.findByEmailAndPassword(email, password);
	}

	@Override
	public void register(User user) throws UserExistsException{
		User u = ud.findByEmail(user.getEmail());
		if(u == null){
			ud.add(user);
			RecordService rs = new RecordServiceImp();
			rs.createBalanceSheet();
		}else{
			throw new UserExistsException();
		}
	}
}

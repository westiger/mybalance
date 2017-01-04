package com.tl.service;

import java.util.List;

import com.tl.bean.Record;
import com.tl.bean.User;
import com.tl.dao.RecordDao;
import com.tl.dao.RecordDaoImp;

public class RecordServiceImp implements RecordService {

	RecordDao rd = null;
	
	public RecordServiceImp(){
		this.rd = new RecordDaoImp();
	}
	
	@Override
	public void createBalanceSheet() {
		rd.createBalanceSheet();
	}

	@Override
	public boolean add(Record record) {
		return rd.add(record);
	}

	@Override
	public boolean update(Record record) {
		return rd.update(record);
	}

	@Override
	public boolean deleteById(String id) {
		return rd.deleteById(id);
	}

	@Override
	public List<Record> findAll() {
		return rd.findAll();
	}

	@Override
	public Record findById(String id) {
		return rd.findById(id);
	}

	@Override
	public List<Record> findByUser(User user) {
		return rd.findByUser(user);
	}
	
	@Override
	public List<Record> findByUserAsc(User user) {
		return rd.findByUserAsc(user);
	}
}

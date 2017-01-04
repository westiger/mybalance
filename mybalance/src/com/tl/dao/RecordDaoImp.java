package com.tl.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tl.bean.Record;
import com.tl.bean.User;
import com.tl.utils.JDBCUtils;

public class RecordDaoImp implements RecordDao {

	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	
	public RecordDaoImp(){
		this.createBalanceSheet();
	}
	
	@Override
	public void createBalanceSheet(){
		String sql = "create table if not exists record"
				+ "(id varchar(100) primary key,"
				+ "sid varchar(100),"
				+ "assets float, "
				+ "income float, "
				+ "expend float, "
				+ "balance float, "
				+ "remark varchar(255),"
				+ "optime timestamp)";
		 try {
			qr.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean add(Record record) {
		String sql = "insert into record(id,sid,assets,income,expend,balance,remark) values(?,?,?,?,?,?,?)";
		int n = 0;
		try {
			n = qr.update(sql,
					record.getId(),
					record.getSid(),
					record.getAssets(),
					record.getIncome(),
					record.getExpend(),
					record.getBalance(),
					record.getRemark()
					);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0?true:false;
	}

	@Override
	public boolean update(Record record) {
		String sql = "update record set assets=?,income=?,expend=?,balance=?,remark=? where id=?";
		int n = 0;
		try {
			n = qr.update(sql,
					record.getAssets(),
					record.getIncome(),
					record.getExpend(),
					record.getBalance(),
					record.getRemark(),
					record.getId()
					);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0?true:false;
	}

	@Override
	public boolean deleteById(String id) {
		String sql = "delete from record where id=?";
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
	public List<Record> findAll() {
		String sql = "select id,assets,income,expend,balance,remark,optime from record order by optime desc";
		try {
			return qr.query(sql, new BeanListHandler<Record>(Record.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Record findById(String id) {		
		String sql = "select id,assets,income,expend,balance,remark,optime from record where id=?";
		try {
			return qr.query(sql, new BeanHandler<Record>(Record.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Record> findByUser(User user) {
		String sql = "select id,sid,assets,income,expend,balance,remark,optime from record where sid=? order by optime desc";
		try {
			return qr.query(sql, new BeanListHandler<Record>(Record.class),user.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Record> findByUserAsc(User user) {
		String sql = "select id,sid,assets,income,expend,balance,remark,optime from record where sid=? order by optime asc";
		try {
			return qr.query(sql, new BeanListHandler<Record>(Record.class),user.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}

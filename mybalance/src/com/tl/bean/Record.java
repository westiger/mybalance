package com.tl.bean;

import java.io.Serializable;
import java.util.Date;

public class Record implements Serializable{

	private String id;
	private String sid;
	private float assets;
	private float income;
	private float expend;
	private float balance;
	private String remark;
	private Date optime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public float getAssets() {
		return assets;
	}
	public void setAssets(float assets) {
		this.assets = assets;
	}
	public float getIncome() {
		return income;
	}
	public void setIncome(float income) {
		this.income = income;
	}
	public float getExpend() {
		return expend;
	}
	public void setExpend(float expend) {
		this.expend = expend;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getOptime() {
		return optime;
	}
	public void setOptime(Date optime) {
		this.optime = optime;
	}

	
}

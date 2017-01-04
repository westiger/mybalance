package com.tl.bean;

import java.io.Serializable;
import java.util.Date;

/*
CREATE TABLE USER(
		id VARCHAR(100) PRIMARY KEY,
		name VARCHAR(100),
		email VARCHAR(100),
		cellphone VARCHAR(100),
		optime TIMESTAMP
	);
*/

public class User implements Serializable{

	private String id;
	private String password;
	private String name;
	private String email;
	private String cellphone;
	private Date optime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public Date getOptime() {
		return optime;
	}
	public void setOptime(Date optime) {
		this.optime = optime;
	}
		
	
}

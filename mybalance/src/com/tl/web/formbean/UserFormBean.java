package com.tl.web.formbean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class UserFormBean implements Serializable{

	private String id;
	private String password;
	private String repassword;
	private String name;
	private String email;
	private String cellphone;
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
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
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
	
	private Map<String, String> errors = new HashMap<String, String>();
	public Map<String, String> getErrors() {
		return errors;
	}
	public boolean validate(){

		if(email=="" || email==null){
			errors.put("email","邮箱不能为空!");
		}else{
			if(!email.matches("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$")){
				errors.put("email","邮箱格式错误!");
			}
		}
		
		if(password=="" || password==null){
			errors.put("password","密码不能为空!");
		}else{
			if(password.length()>18||password.length()<6){
				errors.put("password","密码长度必须在6~18位之间!");
			}
		}
		if(!repassword.equals(password)){
			errors.put("repassword","密码不一致!");
		}
		
		return errors.isEmpty();
	}
	
}

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
			errors.put("email","���䲻��Ϊ��!");
		}else{
			if(!email.matches("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$")){
				errors.put("email","�����ʽ����!");
			}
		}
		
		if(password=="" || password==null){
			errors.put("password","���벻��Ϊ��!");
		}else{
			if(password.length()>18||password.length()<6){
				errors.put("password","���볤�ȱ�����6~18λ֮��!");
			}
		}
		if(!repassword.equals(password)){
			errors.put("repassword","���벻һ��!");
		}
		
		return errors.isEmpty();
	}
	
}

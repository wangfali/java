package com.briup.entity;

import java.io.Serializable;

/**
 * 
* @ClassName: User
* @Description: 用户类
* @author wangfali
* @date 2017年7月15日 下午3:39:31
*
 */
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String account;
	private String password;
	private String address;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}

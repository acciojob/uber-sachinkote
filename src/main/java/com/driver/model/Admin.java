package com.driver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int adminId;
	private String username;
	private String password;
	
	public Admin() {
		super();
	}

	public int getAdminId() {
		return adminId;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
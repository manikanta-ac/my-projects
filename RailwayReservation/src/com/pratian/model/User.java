package com.pratian.model;

import java.util.Date;

public class User 
{
	private int userId;
	private String emailId;
	private String password;
	private boolean active;
	private Date createdDate;
	
	public User(int userId, String emailId, String password, boolean active,
			Date createdDate) 
	{
		this.userId = userId;
		this.emailId = emailId;
		this.password = password;
		this.active = active;
		this.createdDate = createdDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
}

package com.pratian.bean;

import com.pratian.db.ReservationDAO;

public class LoginBean 
{
	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean authenticate() 
	{
		boolean status = ReservationDAO.authenticate(userName,password);
		System.out.println("Login Bean");
		return status;
	}
}

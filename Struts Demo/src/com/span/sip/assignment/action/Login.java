package com.span.sip.assignment.action;

import com.opensymphony.xwork2.ActionSupport;
import com.span.sip.assignment.dao.UserDAO;

public class Login extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	
	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public void validate()
	{
		//System.out.println("Validating User **************");
		if(userName.length()==0)
			addFieldError("userName", "Please Enter User Name");
		if(password.length()==0)
			addFieldError("password", "Please Enter Password");
		if(userName.length()==0 || password.length()==0)
			addActionError("Login Failed");
	}	
	
	public String authenticate()
	{
		//System.out.println("Authenticate User..........................");
		boolean status = UserDAO.authenticate(userName,password); 
		if(status)
			return "success";
		else
			return "input";
	}
}

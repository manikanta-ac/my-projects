package com.pratian;

import java.util.Date;

public class Administrator extends User 
{

	public Administrator(int userId, String emailId, String password,
			boolean active, Date createdDate) 
	{
		super(userId, emailId, password, active, createdDate);
	}
	
}

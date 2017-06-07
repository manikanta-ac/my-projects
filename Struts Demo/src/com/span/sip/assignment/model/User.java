package com.span.sip.assignment.model;

import java.io.File;

public class User
{
	private String userName;
	private String password;
	private String gender;
	private String college;
	private String address;
	private long phoneNo;
	private String email;
	private String aboutYou;
	private boolean alerts;
	private File resume; 
	private String resumeContentType;
    private String resumeFileName;

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

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String getCollege()
	{
		return college;
	}

	public void setCollege(String college)
	{
		this.college = college;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public long getPhoneNo()
	{
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo)
	{		
		this.phoneNo = phoneNo;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getAboutYou()
	{
		return aboutYou;
	}

	public void setAboutYou(String aboutYou)
	{
		this.aboutYou = aboutYou;
	}

	public boolean isAlerts()
	{
		return alerts;
	}

	public void setAlerts(boolean alerts)
	{
		this.alerts = alerts;
	}

	public File getResume()
	{
		return resume;
	}

	public void setResume(File resume)
	{
		this.resume = resume;
	}
	
	public String getResumeContentType()
	{
		return resumeContentType;
	}

	public void setResumeContentType(String resumeContentType)
	{
		this.resumeContentType = resumeContentType;
	}

	public String getResumeFileName()
	{
		return resumeFileName;
	}

	public void setResumeFileName(String resumeFileName)
	{
		this.resumeFileName = resumeFileName;
	}
}

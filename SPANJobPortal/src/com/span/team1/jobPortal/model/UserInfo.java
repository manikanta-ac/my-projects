package com.span.team1.jobPortal.model;

public class UserInfo 
{
	private int Id;
	private String firstName;
	private String email;
	private String password;
	private String qualification;
	private String collegeName;
	private String stream;
	private String percentage;
	private String YearOfPassing;
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFirstName() 
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getQualification() 
	{
		return qualification;
	}
	public void setQualification(String qualification) 
	{
		this.qualification = qualification;
	}
	public String getCollegeName() 
	{
		return collegeName;
	}
	public void setCollegeName(String collegeName) 
	{
		this.collegeName = collegeName;
	}
	public String getStream() 
	{
		return stream;
	}
	public void setStream(String stream) 
	{
		this.stream = stream;
	}
	public String getPercentage() 
	{
		return percentage;
	}
	public void setPercentage(String percentage) 
	{
		this.percentage = percentage;
	}
	public String getYearOfPassing() 
	{
		return YearOfPassing;
	}
	public void setYearOfPassing(String yearOfPassing) 
	{
		YearOfPassing = yearOfPassing;
	}
}

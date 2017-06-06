package com.span.hungerZone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer
{
	@Id
	@GeneratedValue
	@Column(name="cust_Id")
	private int id;
	
	private String emaiId;
	private String name;
	private String password;
	private boolean isRegular;
	private String mobileNo;
	private String address;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getEmaiId()
	{
		return emaiId;
	}
	public void setEmaiId(String emaiId)
	{
		this.emaiId = emaiId;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public boolean isRegular()
	{
		return isRegular;
	}
	public void setRegular(boolean isRegular)
	{
		this.isRegular = isRegular;
	}
	public String getMobileNo()
	{
		return mobileNo;
	}
	public void setMobileNo(String mobileNo)
	{
		this.mobileNo = mobileNo;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
}

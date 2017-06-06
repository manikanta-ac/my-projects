package com.pratian.bean;

import java.sql.SQLException;

import com.pratian.db.ReservationDAO;

public class PaymentBean 
{
	private String number;
	private String name;
	private String month;
	private String year;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	public boolean authenticate() 
	{
		boolean status = false;
		try {
			status = ReservationDAO.validateCard(number,name,month,year);
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return status;
	}
}

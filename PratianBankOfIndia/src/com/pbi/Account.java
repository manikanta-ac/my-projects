package com.pbi;

import java.util.Calendar;
import java.util.Date;

public abstract class Account implements IAccount
{
	private String accNo;
	private String name;
	private int PIN;
	protected boolean active;
	private Date dateOfOpening;
	private double balance;
	private PrivilegeType privilegeType;
	
	public Account(double balance, PrivilegeType privilegeType) 
	{
		this.balance = balance;
		this.privilegeType = privilegeType;
		this.dateOfOpening = new Date();
		this.accNo = NumberGenerator.getNewAccNo();
		this.PIN = 2012;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPIN() {
		return PIN;
	}

	public void setPIN(int pIN) {
		PIN = pIN;
	}

	public boolean getActive() {
		return active;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public PrivilegeType getPrivilegeType() {
		return privilegeType;
	}

	public void setPrivilegeType(PrivilegeType privilegeType) {
		this.privilegeType = privilegeType;
	}

	public String getAccNo() {
		return accNo;
	}

	public Date getDateOfOpening() {
		return dateOfOpening;
	}	
}

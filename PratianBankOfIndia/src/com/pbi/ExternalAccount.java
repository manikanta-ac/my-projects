package com.pbi;

public class ExternalAccount 
{
	private String bankId;
	private String accNo;
	private double balance;
	
	public ExternalAccount(String bankId, String accNo) 
	{
		this.bankId = bankId;
		this.accNo = accNo;
	}

	public String getBankId() {
		return bankId;
	}

	public String getAccNo() {
		return accNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}

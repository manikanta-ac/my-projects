package com.pbi;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Transaction 
{
	private String transactionId;
	private IAccount fromAccount;
	private double amount;
	private Date transactionDate;
	private TransactionStatus status;
	
	public Transaction(IAccount fromAccount, double amount) 
	{
		this.fromAccount = fromAccount;
		this.amount = amount;
		transactionId = NumberGenerator.getNewTransactionId();
		status = TransactionStatus.OPEN;
		transactionDate = new Date("2012/12/24");
	}

	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public IAccount getFromAccount() {
		return fromAccount;
	}

	public double getAmount() {
		return amount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}
	
	
}

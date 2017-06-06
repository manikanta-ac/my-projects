package com.pbi;

public class ExternalTransfer  
{
	private IAccount fromAccount;
	private double amount;
	private ExternalAccount toAccount;
	private int pin;
	private TransactionStatus status;
	
	public ExternalTransfer(IAccount fromAccount, double amount,ExternalAccount toAccount,int pin) 
	{
		this.fromAccount = fromAccount;
		this.amount = amount;
		this.toAccount = toAccount;
		this.pin = pin;
		this.status = TransactionStatus.OPEN;
	}
	
	public ExternalAccount getToAccount() {
		return toAccount;
	}
	public void setToAccount(ExternalAccount toAccount) {
		this.toAccount = toAccount;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}

	public IAccount getFromAccount() {
		return fromAccount;
	}

	public double getAmount() {
		return amount;
	}

	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(TransactionStatus status) {
		this.status = status;
	}
	
	
}
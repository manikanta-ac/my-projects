package com.pbi;

public class TransferTransaction extends Transaction 
{
	IAccount toAccount;
	public TransferTransaction(IAccount fromAccount,IAccount toAccount, double amount) 
	{
		super(fromAccount, amount);
		this.toAccount = toAccount;
	}
	
	public IAccount getToAccount() {
		return toAccount;
	}
}

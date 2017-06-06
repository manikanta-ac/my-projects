package com.pbi;

public class SavingsAccount extends Account 
{
	public SavingsAccount(double balance, PrivilegeType privilegeType)
	{
		super(balance, privilegeType);
	}

	@Override
	public void open() 
	{
		setName("Savings");
		super.active = true;
	}

	@Override
	public void close() 
	{
		super.active = false;
	}

	@Override
	public AccountType getAccountType() 
	{
		return AccountType.SAVINGS;
	}
}

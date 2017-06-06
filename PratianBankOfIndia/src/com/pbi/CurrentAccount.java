package com.pbi;

public class CurrentAccount extends Account 
{
	public CurrentAccount(double balance, PrivilegeType privilegeType) 
	{
		super(balance, privilegeType);
	}

	@Override
	public void open() 
	{
		setName("Current");
		active = true;
	}

	@Override
	public void close() 
	{
		active = false;
	}

	@Override
	public AccountType getAccountType() 
	{
		return AccountType.CURRENT;
	}

}

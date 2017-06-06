package com.pbi;

import java.io.IOException;

public class TestMain 
{
	public static void main(String[] args) 
			throws MinimumBalanceException, AccountInActiveException, 
			PinNotMatchedException, MaxDailyLimitExceedException ,DataBaseException,
			AccountNotExistsException, BankNotExistsException, IOException
	{
		AccountFactory factory = new AccountFactory();

		factory.manageAccount();
		
		factory.generateResult();
	}
}

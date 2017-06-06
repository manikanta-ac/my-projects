package com.pbi;

public class ICICIBankService implements IExternalBankService 
{
	@Override
	public boolean deposit(String accId, double amount) 
			throws AccountNotExistsException, BankNotExistsException 
	{
		String bankcode = "ICICI";
		
		BankDAO.updateBankAccount(bankcode,accId,amount);
		
		return true;
	}
}

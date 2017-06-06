package com.pbi;

public class CITIBankService implements IExternalBankService 
{
	@Override
	public boolean deposit(String accId, double amount) 
			throws AccountNotExistsException, BankNotExistsException 
	{
		String bankcode = "CITI";
		
		BankDAO.updateBankAccount(bankcode,accId,amount);
		
		return true;
	}
}

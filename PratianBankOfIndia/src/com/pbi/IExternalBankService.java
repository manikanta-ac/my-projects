package com.pbi;

public interface IExternalBankService 
{
	boolean deposit(String accId ,double amt) 
			throws AccountNotExistsException, BankNotExistsException;
}

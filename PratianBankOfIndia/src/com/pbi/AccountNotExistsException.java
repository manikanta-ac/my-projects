package com.pbi;

public class AccountNotExistsException extends Exception 
{
	public AccountNotExistsException() 
	{
		System.out.println("Account with This Number Is Not Exists");
	}
	public AccountNotExistsException(String msg) 
	{
		System.out.println(msg);
	}
}

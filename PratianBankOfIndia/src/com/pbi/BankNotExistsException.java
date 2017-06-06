package com.pbi;

public class BankNotExistsException extends Exception 
{
	public BankNotExistsException() 
	{
		System.out.println("Bank with This Code Is Not Exists");
	}
	public BankNotExistsException(String msg) 
	{
		System.out.println(msg);
	}
}

package com.pbi;

public class AccountInActiveException extends Exception 
{
	public AccountInActiveException() 
	{
		System.out.println("Cann't Able To Proceed Because Account is Closed");
	}
	public AccountInActiveException(String msg) 
	{
		System.out.println(msg);
	}
}

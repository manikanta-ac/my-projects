package com.pbi;

public class MinimumBalanceException extends Exception 
{
	public MinimumBalanceException() 
	{
		System.out.println("Cann't able to proceed because of Insufficient Funds Found in This Account");
	}
	public MinimumBalanceException(String msg) 
	{
		System.out.println(msg);
	}
}

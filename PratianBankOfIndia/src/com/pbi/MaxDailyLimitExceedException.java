package com.pbi;

public class MaxDailyLimitExceedException extends Exception 
{
	public MaxDailyLimitExceedException() 
	{
		System.out.println("Cann't able to proceed as Max Daily Limit is Exceeding");
	}
	public MaxDailyLimitExceedException(String msg) 
	{
		System.out.println(msg);
	}
}

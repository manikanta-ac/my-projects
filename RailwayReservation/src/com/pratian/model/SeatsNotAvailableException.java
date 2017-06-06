package com.pratian.model;

public class SeatsNotAvailableException extends Exception 
{
	public SeatsNotAvailableException() 
	{
		System.out.println("Seats Not Available");
	}
	public SeatsNotAvailableException(String msg) 
	{
		System.out.println(msg);
	}
}

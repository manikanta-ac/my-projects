package com.pbi;

public class PinNotMatchedException extends Exception 
{
	public PinNotMatchedException() 
	{
		System.out.println("Cann't Able To Proceed Because PIN is Not Matched");
	}
	public PinNotMatchedException(String msg) 
	{
		System.out.println(msg);
	}
}

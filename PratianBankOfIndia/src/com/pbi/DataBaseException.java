package com.pbi;

public class DataBaseException extends Exception
{
	public DataBaseException() 
	{
		System.out.println("Problem Occured Due to DataBase");
	}
	public DataBaseException(String msg) 
	{
		System.out.println(msg);
	}
}

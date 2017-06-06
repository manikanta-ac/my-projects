package com.pbi;

public class NumberGenerator 
{
	private static int ACCNO;
	private static int TRANS_ID;
	static
	{
		ACCNO = 2012003400;
		TRANS_ID = 3000;
	}
	public static String getNewAccNo() 
	{
		ACCNO++;
		return "PBI"+ACCNO;
	}
	public static String getNewTransactionId() 
	{
		TRANS_ID++;
		return "TR"+TRANS_ID;
	}
}

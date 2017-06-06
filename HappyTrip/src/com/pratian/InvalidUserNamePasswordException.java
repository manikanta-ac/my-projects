package com.pratian;

public class InvalidUserNamePasswordException extends Exception
{
	public InvalidUserNamePasswordException()
	{
		System.out.println("Invalid Username/Password");
	}
	public InvalidUserNamePasswordException(String msg)
	{
		System.out.println(msg);
	}
}

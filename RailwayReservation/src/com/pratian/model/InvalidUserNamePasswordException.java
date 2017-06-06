package com.pratian.model;

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

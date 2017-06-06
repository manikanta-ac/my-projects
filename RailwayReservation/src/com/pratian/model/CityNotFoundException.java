package com.pratian.model;

public class CityNotFoundException extends Exception 
{
	public CityNotFoundException() {
		System.out.println("City with this name is not found");
	}
	public CityNotFoundException(String msg) {
		System.out.println(msg);
	}
}

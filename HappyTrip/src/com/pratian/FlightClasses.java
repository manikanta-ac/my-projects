package com.pratian;

public class FlightClasses 
{
	private int firstClass;
	private int bussinessClass;
	private int economyClass;
	
	public FlightClasses(int firstClass, int bussinessClass, int economyClass) 
	{
		this.firstClass = firstClass;
		this.bussinessClass = bussinessClass;
		this.economyClass = economyClass;
	}

	public int getFirstClass() {
		return firstClass;
	}

	public void setFirstClass(int firstClass) {
		this.firstClass = firstClass;
	}

	public int getBussinessClass() {
		return bussinessClass;
	}

	public void setBussinessClass(int bussinessClass) {
		this.bussinessClass = bussinessClass;
	}

	public int getEconomyClass() {
		return economyClass;
	}

	public void setEconomyClass(int economyClass) {
		this.economyClass = economyClass;
	}
}

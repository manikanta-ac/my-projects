package com.pbi;

public class Transfer 
{
	private Account sourceAcc;
	private Account destinationAcc;
	private double amount;
	private int pin;
	
	public Transfer(Account sourceAcc, Account destinationAcc,
			double transferBal, int pin) 
	{
		this.sourceAcc = sourceAcc;
		this.destinationAcc = destinationAcc;
		this.amount = transferBal;
		this.pin = pin;
	}

	public Account getSourceAcc() {
		return sourceAcc;
	}

	public Account getDestinationAcc() {
		return destinationAcc;
	}

	public double getAmount() {
		return amount;
	}

	public int getPin() {
		return pin;
	}
	
}

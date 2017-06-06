package com.pbi;

public class Policy implements IPolicy
{
	private String policyType;
	private double minBalance;
	private double rateOfIntrest;
	
	public Policy(String policyType, double minBalance, double rateOfIntrest) {
		this.policyType = policyType;
		this.minBalance = minBalance;
		this.rateOfIntrest = rateOfIntrest;
	}

	public double getMinBalance()	{
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

	public double getRateOfIntrest() {
		return rateOfIntrest;
	}

	public void setRateOfIntrest(double rateOfIntrest) {
		this.rateOfIntrest = rateOfIntrest;
	}

	public String getPolicyType() {
		return policyType;
	}	
}

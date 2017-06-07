package org.sip.span;

public class CustomerDetails {
	
	private String custAddress;
	private int custCredit;
	private int custReward;
	
	private Customer customer;
	
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public int getCustCredit() {
		return custCredit;
	}
	public void setCustCredit(int custCredit) {
		this.custCredit = custCredit;
	}
	public int getCustReward() {
		return custReward;
	}
	public void setCustReward(int custReward) {
		this.custReward = custReward;
	}
}

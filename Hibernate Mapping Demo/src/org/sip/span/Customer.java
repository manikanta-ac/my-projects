package org.sip.span;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
@SecondaryTable(name="CustomerDetail")
public class Customer {
	
	@Id
	private int custId;
	private String custName;
	@Column(table="CustomerDetail")
	private String custAddress;
	@Column(table="CustomerDetail")
	private int custCredit;
	@Column(table="CustomerDetail")
	private int custReward;
	
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
	
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
}

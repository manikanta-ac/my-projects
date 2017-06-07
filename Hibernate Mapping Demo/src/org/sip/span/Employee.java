package org.sip.span;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
/*@Table(name="EmplyeeInfo")
@TableGenerator(name="empId", table="emppktb", pkColumnName="empKey", 
pkColumnValue="empValue", allocationSize=1)*/

public class Employee {
	
	@Id
	//@Column(name="EmployeeId")
	//@GeneratedValue(strategy=GenerationType.TABLE, generator="empId")
	private int empId;
	@Basic
	private String employeeName;
	@Transient
	private String empPassword;
	@Column(nullable=false)
	private String empEmail;
	@Temporal(TemporalType.DATE)
	private Calendar empJoinDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date empLoginTime;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public Calendar getEmpJoinDate() {
		return empJoinDate;
	}
	public void setEmpJoinDate(Calendar empJoinDate) {
		this.empJoinDate = empJoinDate;
	}
	public Date getEmpLoginTime() {
		return empLoginTime;
	}
	public void setEmpLoginTime(Date empLoginTime) {
		this.empLoginTime = empLoginTime;
	}
	

}

package com.pratian.model;

import java.util.Date;

public class Passenger 
{
	private int passengerId;
	private String fullName;
	private char gender;
	private Date dateOfBirth;
	private Booking booking;
	
	public Passenger(int passengerId, String fullName, char gender,
			Date dateOfBirth) 
	{
		this.passengerId = passengerId;
		this.fullName = fullName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
	}
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
}

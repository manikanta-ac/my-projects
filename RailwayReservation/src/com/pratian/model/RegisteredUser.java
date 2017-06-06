package com.pratian.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegisteredUser extends User 
{
	private String fullName;
	private String email;
	private char gender;
	private Date dateOfBirth;
	private String address;
	private String city;
	private String state;
	private String country;
	private int pinCode;
	private String mobileNo;
	private List<Booking> bookings = new ArrayList<Booking>();
	
	public RegisteredUser(int userId, String emailId, String password,
			boolean active, Date createdDate, String fullName, String email,
			char gender, Date dateOfBirth, String address, String city,
			String state, String country, int pinCode, String mobileNo) 
	{
		super(userId, emailId, password, active, createdDate);
		this.fullName = fullName;
		this.email = email;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pinCode = pinCode;
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getFullName() {
		return fullName;
	}

	public char getGender() {
		return gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void addBooking(Booking booking) {
		this.bookings.add(booking);
	}
	
}

package com.pratian.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Booking 
{
	private int bookingId;
	private Date bookingDate;
	private int noOfSeats;
	private double totalCost;
	private int referenceNo;
	private FlightRoute flightRoute;
	private List<Passenger> passengers = new ArrayList<Passenger>();
	private RegisteredUser regUser;
	
	public Booking(int bookingId, Date bookingDate, int noOfSeats,
			double totalCost, int referenceNo) {
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.noOfSeats = noOfSeats;
		this.totalCost = totalCost;
		this.referenceNo = referenceNo;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public int getReferenceNo() {
		return referenceNo;
	}
	public void setReferenceNo(int referenceNo) {
		this.referenceNo = referenceNo;
	}
	public FlightRoute getFlightRoute() {
		return flightRoute;
	}
	public void setFlightRoute(FlightRoute flightRoute) {
		this.flightRoute = flightRoute;
	}
	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void addPassenger(Passenger passenger) {
		this.passengers.add(passenger);
	}
	public RegisteredUser getRegUser() {
		return regUser;
	}
	public void setRegUser(RegisteredUser regUser) {
		this.regUser = regUser;
	}
		
}

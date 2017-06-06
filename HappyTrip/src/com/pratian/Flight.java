package com.pratian;

public class Flight 
{
	private int flightId;
	private String flightName;
	private int noOfSeats;
	
	public Flight(int flightId, String flightName, int noOfSeats) 
	{
		this.flightId = flightId;
		this.flightName = flightName;
		this.noOfSeats = noOfSeats;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	
}

package com.pratian;

import java.util.ArrayList;
import java.util.List;

public class Airline 
{
	private int airlineId;
	private String airlineName;
	public String airlineCode;
	private List<Flight> flights = new ArrayList<Flight>();
	
	public Airline(int airlineId, String airlineName, String airlineCode) 
	{
		this.airlineId = airlineId;
		this.airlineName = airlineName;
		this.airlineCode = airlineCode;
	}
	public int getAirlineId() {
		return airlineId;
	}
	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public List<Flight> getFlights() {
		return flights;
	}
	public void addFlight(Flight flight) {
		this.flights.add(flight);
	}	
	
}

package com.pratian;

import java.util.ArrayList;
import java.util.List;

public class FlightRoute 
{
	private int flightRouteId;
	private String departureTime;
	private String arrivalTime;
	private double costPerTicket;
	private Flight flight;
	private Route route;
	private FlightClasses allClasses;
	private List<Booking> bookings = new ArrayList<Booking>();
	
	public FlightRoute(int flightRouteId, String departureTime,
			String arrivalTime, double costPerTicket) 
	{
		this.flightRouteId = flightRouteId;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.costPerTicket = costPerTicket;
	}

	public int getFlightRouteId() {
		return flightRouteId;
	}

	public void setFlightRouteId(int flightRouteId) {
		this.flightRouteId = flightRouteId;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public double getCostPerTicket() {
		return costPerTicket;
	}

	public void setCostPerTicket(double costPerTicket) {
		this.costPerTicket = costPerTicket;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {		
		this.flight = flight;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void addBooking(Booking booking) {
		this.bookings.add(booking);
	}

	public FlightClasses getAllClasses() {
		return allClasses;
	}

	public void setAllClasses(FlightClasses allClasses) {
		this.allClasses = allClasses;
	}
}

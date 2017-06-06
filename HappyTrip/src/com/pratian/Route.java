package com.pratian;

public class Route 
{
	private int routeId;
	private double distanceInKms;
	private int duartionInHours;
	private City fromCity;
	private City toCity;
	public Route(int routeId, double distanceInKms, int duartionInHours) 
	{
		this.routeId = routeId;
		this.distanceInKms = distanceInKms;
		this.duartionInHours = duartionInHours;
	}
	public Route() {
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public double getDistanceInKms() {
		return distanceInKms;
	}
	public void setDistanceInKms(double distanceInKms) {
		this.distanceInKms = distanceInKms;
	}
	public int getDuartionInHours() {
		return duartionInHours;
	}
	public void setDuartionInHours(int duartionInHours) {
		this.duartionInHours = duartionInHours;
	}
	public City getFromCity() {
		return fromCity;
	}
	public void setFromCity(City fromCity) {
		this.fromCity = fromCity;
	}
	public City getToCity() {
		return toCity;
	}
	public void setToCity(City toCity) {
		this.toCity = toCity;
	}	
}

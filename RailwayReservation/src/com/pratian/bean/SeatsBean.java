package com.pratian.bean;

import java.sql.SQLException;

import com.pratian.db.ReservationDAO;
import com.pratian.model.SeatsNotAvailableException;

public class SeatsBean 
{
	private String type;
	private int noOfSeats;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	
	public boolean isAvailable(int routeId) throws SQLException, SeatsNotAvailableException 
	{
		return ReservationDAO.isAvailable(routeId,type,noOfSeats);
	}
}

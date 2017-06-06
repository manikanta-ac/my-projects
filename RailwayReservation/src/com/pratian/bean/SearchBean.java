package com.pratian.bean;
import java.sql.SQLException;

import com.pratian.db.ReservationDAO;
import com.pratian.model.CityNotFoundException;

public class SearchBean 
{
	private String fromCityName;
	private String toCityName;

	public String getFromCityName() {
		return fromCityName;
	}

	public void setFromCityName(String fromCityName) {
		this.fromCityName = fromCityName;
	}

	public String getToCityName() {
		return toCityName;
	}

	public void setToCityName(String toCityName) {
		this.toCityName = toCityName;
	}

	public boolean validateCities()
	{
		boolean status = false;
		
		try 
		{
			int t = ReservationDAO.getCityIdByName(toCityName);
			int f = ReservationDAO.getCityIdByName(fromCityName);
			System.out.println(t+"-----"+f);
			if(f!=0&&t!=0)
			{
				status = true;
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}			
		return status;
	}
}

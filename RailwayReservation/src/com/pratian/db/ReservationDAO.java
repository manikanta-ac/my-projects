package com.pratian.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.pratian.model.City;
import com.pratian.model.CityNotFoundException;
import com.pratian.model.Route;
import com.pratian.model.SeatsNotAvailableException;


public class ReservationDAO 
{
	private static Connection con;
	private static Statement stmt;
	private static int id=800;

	public static void openConnection() 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/happy_trip", "root", "");

			stmt = con.createStatement();
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	public static boolean authenticate(String userName, String password) 
	{
		openConnection();

		boolean status = true;
		ResultSet rs;
		String sql = "select password from registereduser2 where username='"+userName+"'";

		try 
		{
			rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				String pass = rs.getString(1);
				if(!pass.equals(password))
				{
					status = false;
				}
			}
			else
			{
				status = false;
			}
		} 
		catch (SQLException e) 
		{  
			System.out.println(e);
		}

		closeConnection();
		return status;
	}

	public static boolean addAccount(String username, String emailId,
			String password, boolean active, String createdDate,
			String fullName, String gender, String dateOfBirth, String address,
			String city, String state, int pin, String phone) 
	{
		openConnection();
		boolean flag = false;
		String sql = "insert into registereduser2 values('"+username+"','"+emailId+"','"+password+"',"+active+",'"+createdDate+"',"+
				"'"+fullName+"','"+gender+"','"+dateOfBirth+"','"+address+"','"+city+"','"+state+"',"+pin+",'"+phone+"');";

		try 
		{
			int i = stmt.executeUpdate(sql);
			if(i==1)
			{
				flag = true;
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e);
		}

		closeConnection();

		return flag;
	}
	public static int getCityIdByName(String cityName) throws SQLException, CityNotFoundException
	{
		openConnection();

		int cityId = 0;
		String sql ="select cityId from city where cityName='"+cityName+"'";
		ResultSet rs;
		System.out.println(sql);
		rs = stmt.executeQuery(sql);

		if(rs.next())
		{
			cityId = rs.getInt(1);
		}
		else
		{
			throw new CityNotFoundException();
		}
		closeConnection();
		return cityId;
	}

	public static List<Route> getRoutes(City fromCity,City toCity) throws SQLException, CityNotFoundException 
	{
		openConnection();

		List<Route> routes = new ArrayList<Route>();
		Route route;

		String sql = "select * from route where fromCityId="+fromCity.getCityId()+" and toCityId="+toCity.getCityId();

		ResultSet rs = null;		

		rs = stmt.executeQuery(sql);

		while(rs.next())
		{
			route = new Route();
			route.setRouteId(rs.getInt(1));
			route.setDistanceInKms(rs.getDouble(2));
			route.setDuartionInHours(rs.getInt(3));
			route.setFromCity(new City(rs.getInt(4),getCityNameById(rs.getInt(4))));
			route.setToCity(new City(rs.getInt(5),getCityNameById(rs.getInt(5))));

			routes.add(route);
		}

		openConnection();

		sql = "select r1.routeId,r2.routeId from route r1 join route r2 on r1.toCityId=r2.fromCityId "+
				"where r1.fromCityId="+fromCity.getCityId()+" and r2.toCityId="+toCity.getCityId()+" ;";

		ResultSet rs2 = stmt.executeQuery(sql);

		if(rs2.next())
		{
			String routeIds="";
			do
			{
				routeIds += "'"+rs2.getString(1)+"','"+rs2.getString(2)+"' ";
			}while(rs2.next());

			openConnection();
			sql = "select * from route where routeId in ("+routeIds+")";

			ResultSet rs3 = stmt.executeQuery(sql);

			while(rs3.next())
			{
				route = new Route();
				route.setRouteId(rs3.getInt(1));
				route.setDistanceInKms(rs3.getDouble(2));
				route.setDuartionInHours(rs3.getInt(3));
				route.setFromCity(new City(rs3.getInt(4),getCityNameById(rs3.getInt(4))));
				route.setToCity(new City(rs3.getInt(5),getCityNameById(rs3.getInt(5))));

				routes.add(route);
			}
		}

		openConnection();
		sql = "select r1.routeId,r2.routeId,r3.routeId from route r1 join route r2 on r1.toCityId=r2.fromCityId "+
				" join route r3 on r2.toCityId=r3.fromCityId where r1.fromCityId="+fromCity.getCityId()+" and r3.toCityId="+toCity.getCityId()+" ;";

		ResultSet rs4 = stmt.executeQuery(sql);

		if(rs4.next())
		{
			String routeIds="";
			do
			{
				routeIds += "'"+rs4.getString(1)+"','"+rs4.getString(2)+"','"+rs4.getString(3)+"' ";
			}while(rs4.next());

			openConnection();
			sql = "select * from route where routeId in ("+routeIds+")";

			ResultSet rs5 = stmt.executeQuery(sql);

			while(rs5.next())
			{
				route = new Route();
				route.setRouteId(rs5.getInt(1));
				route.setDistanceInKms(rs5.getDouble(2));
				route.setDuartionInHours(rs5.getInt(3));

				route.setFromCity(new City(rs5.getInt(4),getCityNameById(rs5.getInt(4))));
				route.setToCity(new City(rs5.getInt(5),getCityNameById(rs5.getInt(5))));

				routes.add(route);
			}
		}
			closeConnection();
			return routes;
		}
		public static String getCityNameById(int cityId) throws SQLException, CityNotFoundException 
		{
			openConnection();

			String cityName = "";
			String sql ="select cityName from city where cityId="+cityId+"";
			ResultSet rs;

			rs = stmt.executeQuery(sql);

			if(rs.next())
			{
				cityName = rs.getString(1);
			}
			else
			{
				throw new CityNotFoundException();
			}
			closeConnection();

			return cityName;
		}

		public static String getDepartureTimeByRouteId(int routeId) throws SQLException 
		{
			openConnection();

			String departureTime="";
			String sql = "select deoartureTime from flightroute where routeId="+routeId;

			ResultSet rs;

			rs = stmt.executeQuery(sql);

			if(rs.next())
			{
				departureTime = rs.getString(1);
			}
			closeConnection();
			return departureTime;
		}

		public static String getArrivalTimeByRouteId(int routeId) throws SQLException
		{
			openConnection();

			String arrivalTime="";
			String sql = "select arrivalTime from flightroute where routeId="+routeId;

			ResultSet rs;

			rs = stmt.executeQuery(sql);

			if(rs.next())
			{
				arrivalTime = rs.getString(1);
			}
			closeConnection();
			return arrivalTime;
		}
		public static int[] getSeatsAvailableInAllClasses(int routeId) throws SQLException
		{
			openConnection();

			int seats[] = new int[3];

			String sql = "select firstClass,bussinessClass,economyClass from flightroute where routeId="+routeId;
			ResultSet rs;

			rs = stmt.executeQuery(sql);

			if(rs.next())
			{
				seats[0] = rs.getInt(1);
				seats[1] = rs.getInt(2);
				seats[2] = rs.getInt(3);
			}
			System.out.println(routeId);

			closeConnection();
			return seats;
		}
		public static double bookTicket(int routeId, String type,
				String passengerId, String passengerName, String gender,
				String dateOfBirth) throws SQLException, SeatsNotAvailableException 
				{
			openConnection();
			int noOfSeats = 1;
			int availableSeats = 0;

			String sql = "select "+type+" from flightroute where routeId="+routeId;
			ResultSet rs;
			System.out.println(type+"----"+routeId);

			rs = stmt.executeQuery(sql);

			if(rs.next())
			{
				availableSeats = rs.getInt(1);
			}

			System.out.println(availableSeats+"----"+noOfSeats);

			if(availableSeats-noOfSeats<0)
			{
				throw new com.pratian.model.SeatsNotAvailableException();
			}

			openConnection();
			sql = "insert into passenger values("+passengerId+",'"+passengerName+"','"+gender+"','"+dateOfBirth+"',601)";
			stmt.execute(sql);

			openConnection();
			sql = "select costPerTicket from flightroute where routeId="+routeId;

			rs = stmt.executeQuery(sql);
			rs.next();
			double totalCost = rs.getDouble(1);

			openConnection();
			sql = "select flightRouteId from flightroute where routeId="+routeId;
			rs = stmt.executeQuery(sql);
			rs.next();
			double flightRouteId = rs.getInt(1);

			int bookingId = 100+id;
			id +=1;
			String bookingDate = "2012-12-19";
			openConnection();
			sql = "insert into booking values("+bookingId+",'"+bookingDate+"',"+noOfSeats+","+totalCost+",60,"+passengerId+","+flightRouteId+")";
			stmt.execute(sql);

			availableSeats = availableSeats-noOfSeats;

			openConnection();
			sql = "update flightroute set "+type+"="+availableSeats+" where routeId="+routeId;
			stmt.execute(sql);

			/*System.out.println("-------------------------------------------------------Ticket Details------------------------------------------------");
		System.out.println("Booking Id \t Booking Date \t Passenger Id \t Passenger Name \t Gender \t No.Of Seats \t Total Cost \t ");
		System.out.println("=====================================================================================================================");
		System.out.println(bookingId+"\t\t"+bookingDate+"\t"+passId+"\t\t"+passName+"\t\t\t"+gen+"\t\t"+noOfSeats+"\t\t"+totalCost);
		System.out.println("=====================================================================================================================");
			 */

			closeConnection();
			return totalCost;
				}
		public static String[] getBookingDetails(int routeId) throws SQLException 
		{
			openConnection();

			String values[] = new String[2];
			String sql = "select bookingId,bookingDate from booking where flightRouteId= (select flightRouteId from flightroute where routeId="+routeId+")";

			ResultSet rs = stmt.executeQuery(sql);

			if(rs.next())
			{
				values[0] = rs.getString(1);
				values[1] = rs.getString(2);
			}

			closeConnection();
			return values;
		}
		public static void closeConnection()
		{
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		public static boolean validateCard(String number, String name,
				String month, String year) throws SQLException 
				{
			openConnection();

			boolean status = false;
			String sql = "select * from card where number='" + number
					+ "' and name='" + name + "' and expiryDate like '"
					+ year + "-" + month + "-" + "%'";

			Date date = new Date();
			ResultSet rs = stmt.executeQuery(sql);

			if (!rs.next()) 
			{
				status = false;			
			}
			else
			{
				if(Integer.parseInt(year)>(date.getYear()+1900))
				{					
					status = true;
				}
				else if(Integer.parseInt(year)==(date.getYear()+1900))
				{
					if(!(Integer.parseInt(month)>=(date.getMonth()+1)))
					{
						System.out.println("Card is Expired \n Contact Your Bank");
					}
					else
					{
						status = true;
						System.out.println("Your Transaction Successfully Completed \n Thank You.....! for Shopping with Us");
					}
				}
				else
				{
					System.out.println("Card is Expired \n Contact Your Bank");
				}
			}

			closeConnection();
			return status;
				}
		public static boolean isAvailable(int routeId,String type, int noOfSeats) throws SQLException, SeatsNotAvailableException 
		{
			openConnection();
			int availableSeats = 0;

			String sql = "select "+type+" from flightroute where routeId="+routeId;
			ResultSet rs;
			System.out.println(type+"----"+routeId);

			rs = stmt.executeQuery(sql);

			if(rs.next())
			{
				availableSeats = rs.getInt(1);		
				System.out.println(availableSeats+"----"+noOfSeats);
			}

			if(availableSeats-noOfSeats>=0)
			{
				return true;
			}

			closeConnection();
			return false;
		}
	}
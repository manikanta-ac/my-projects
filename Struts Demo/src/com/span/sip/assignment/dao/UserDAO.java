package com.span.sip.assignment.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.span.sip.assignment.model.User;

public class UserDAO
{	
	private static String driverName;
	private static Connection connection;
	private static ResultSet resultSet;
	private static PreparedStatement preparedStatement;
	private static String url;
	private static String userName;
	private static String password;

	static
	{
		driverName = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3309/user_db";
		userName = "root";
		password = "acmk";
	}

	private static void openConnection()
	{
		try
		{
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, userName, password);

		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static void closeConnection()
	{
		try
		{
			if(connection!=null)
				connection.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	public static void closePreparedStatement()
	{
		try
		{
			if(preparedStatement!=null)
				preparedStatement.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static void closeResultSet()
	{
		try
		{
			if(resultSet!=null)
				resultSet.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static boolean authenticate(String userName, String password)
	{
		openConnection();

		boolean status = false;

		try
		{
			preparedStatement = connection.prepareStatement("select * from user where userName=? and password=?");

			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);

			resultSet = preparedStatement.executeQuery();

			status = resultSet.next();

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			closeResultSet();
			closePreparedStatement();
			closeConnection();
		}

		return status;
	}

	public static boolean addUser(User user)
	{
		openConnection();

		boolean status = false;

		//System.out.println(user.getUserName()+"----------");

		try
		{
			preparedStatement = connection.prepareStatement("select * from user where userName=?");

			preparedStatement.setString(1, user.getUserName());

			resultSet = preparedStatement.executeQuery();

			if(!resultSet.next())
			{
				closeResultSet();
				closePreparedStatement();

				preparedStatement = connection.prepareStatement("insert into user values(?,?,?,?,?,?,?,?,?,?)");

				preparedStatement.setString(1, user.getUserName());
				preparedStatement.setString(2, user.getPassword());
				preparedStatement.setString(3, user.getGender());
				preparedStatement.setString(4, user.getCollege());
				preparedStatement.setString(5, user.getAddress());
				preparedStatement.setLong(6, user.getPhoneNo());
				preparedStatement.setString(7, user.getEmail());
				preparedStatement.setString(8, user.getAboutYou());
				preparedStatement.setBoolean(9, user.isAlerts());

				if(user.getResume()!=null)
				{
					FileInputStream is = new FileInputStream (user.getResume());
					preparedStatement.setBinaryStream (10, is, (int) user.getResume().length() );
				}
				else
					preparedStatement.setBlob(10, null, 0);

				int count = preparedStatement.executeUpdate();

				//System.out.println("Data inserted successfully......."+count);
				if(count==1)
					status = true;
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		finally{
			closeResultSet();
			closePreparedStatement();
			closeConnection();
		}
		return status;
	}

	public static List<User> getAllUsers()
	{
		openConnection();

		List<User> users = new ArrayList<User>();
		User user;

		try
		{
			preparedStatement = connection.prepareStatement("select * from user");

			resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{
				user = new User();

				user.setUserName(resultSet.getString(1));
				user.setPassword(resultSet.getString(2));
				user.setGender(resultSet.getString(3));
				user.setCollege(resultSet.getString(4));
				user.setAddress(resultSet.getString(5));
				user.setPhoneNo(resultSet.getLong(6));
				user.setEmail(resultSet.getString(7));
				user.setAboutYou(resultSet.getString(8));
				user.setAlerts(resultSet.getBoolean(9));
				user.setResume(null);

				users.add(user);
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			closeResultSet();
			closePreparedStatement();
			closeConnection();
		}

		return users;
	}

	public static boolean deleteUser(String userName2)
	{
		openConnection();

		boolean status = false;

		try
		{
			preparedStatement = connection.prepareStatement("delete from user where userName=?");

			preparedStatement.setString(1, userName2);

			preparedStatement.executeUpdate();

			int count = preparedStatement.executeUpdate();

			System.out.println(userName2+" deleted successfully.......");
			if(count==1)
				status = true;

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			closeResultSet();
			closePreparedStatement();
			closeConnection();
		}
		return status;
	}
	public static User getUser(String userName)
	{
		openConnection();

		User user = new User();;

		try
		{
			preparedStatement = connection.prepareStatement("select * from user where userName=?");

			preparedStatement.setString(1, userName);

			resultSet = preparedStatement.executeQuery();
			
			resultSet.next();
			
			user.setUserName(resultSet.getString(1));
			user.setPassword(resultSet.getString(2));
			user.setGender(resultSet.getString(3));
			user.setCollege(resultSet.getString(4));
			user.setAddress(resultSet.getString(5));
			user.setPhoneNo(resultSet.getLong(6));
			user.setEmail(resultSet.getString(7));
			user.setAboutYou(resultSet.getString(8));
			user.setAlerts(resultSet.getBoolean(9));
			user.setResume(null);

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			closeResultSet();
			closePreparedStatement();
			closeConnection();
		}

		return user;
	}

	public static boolean editUser(User user, String userNameOld)
	{
		openConnection();

		boolean status = false;

		//System.out.println(user.getUserName()+"----------");

		try
		{
			preparedStatement = connection.prepareStatement("update user set userName=?,password=?," +
						"gender=?,college=?,address=?,phoneNo=?,emailId=?,aboutYou=?,alerts=?,resume=? " +
						"where userName=?)");

			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getGender());
			preparedStatement.setString(4, user.getCollege());
			preparedStatement.setString(5, user.getAddress());
			preparedStatement.setLong(6, user.getPhoneNo());
			preparedStatement.setString(7, user.getEmail());
			preparedStatement.setString(8, user.getAboutYou());
			preparedStatement.setBoolean(9, user.isAlerts());

			if(user.getResume()!=null)
			{
				FileInputStream is = new FileInputStream (user.getResume());
				preparedStatement.setBinaryStream (10, is, (int) user.getResume().length() );
			}
			else
				preparedStatement.setBlob(10, null, 0);
			
			preparedStatement.setString(11, userNameOld);
			
			int count = preparedStatement.executeUpdate();

			//System.out.println("Data inserted successfully......."+count);
			if(count==1)
				status = true;

		} catch (SQLException e)
		{
			e.printStackTrace();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		finally{
			closeResultSet();
			closePreparedStatement();
			closeConnection();
		}
		return status;
	}
}

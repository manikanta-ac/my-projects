package com.pbi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class BankDAO 
{
	static Connection con;
	static Statement stmt;

	public static void openConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_app","root","");
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*public static boolean createTables() 
	{
		openConnection();

		boolean status = false;
		String sql = "create database bank_application; " +
				"use bank_application;  " +
				"CREATE TABLE Account" +
				"(accNo varchar(15) NOT NULL," +
				"name varchar(30) NOT NULL," +
				"pin varchar(4) NOT NULL," +
				"active boolean," +
				"dateOfOpening date," +
				"privilegeType varchar(15) NOT NULL," +
				"accType varchar(15) NOT NULL," +
				"CONSTRAINT pk_accNo PRIMARY KEY (accNo)," +
				"CONSTRAINT chk_privil CHECK (privilegeType IN ('REGULAR','GOLD','PREMIUM'))," +
				"CONSTRAINT chk_accType CHECK (accType IN ('SAVINGS','CURRENT')));";

		sql = sql+"CREATE TABLE Transaction(" +
				"transId int NOT NULL," +
				"transType varchar(10) NOT NULL," +
				"accNo varchar(15) NOT NULL," +
				"transDate date," +
				"amount double," +
				"FOREIGN KEY (accNo) REFERENCES account(accNo));";

		sql = sql+"CREATE TABLE PratianBank" +
				"(accId varchar(15) NOT NULL," +
				"amount double);";

		sql = sql+"CREATE TABLE ICICIBank" +
				"(accId varchar(15) NOT NULL," +
				"amount double);";

		sql = sql+"CREATE TABLE CITIBank" +
				"(accId varchar(15) NOT NULL," +
				"amount double);";

		System.out.println("SQL  "+sql);

		try 
		{
			status=stmt.execute(sql.toString());
			System.out.println(status);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeConnection();
		return status;

	}*/

	public static void addAccount(String accNo,String name,int pin,boolean active,
			Date dateOfOpening,double balance,String privil,String accType) 
	{
		openConnection();
		String date = "2012-12-24";
		System.out.println("Date is "+date);

		String sql1 = " insert into Account values('"+accNo+"','"+name+"','"+pin+"',"+
				active+",'"+date+"',"+balance+",'"+privil+"', '"+accType+"')";
		
		String sql2 = " insert into Pratianbank values('"+accNo+"',"+balance+")";

		System.out.println("SQL  "+sql1);
		System.out.println("SQL  "+sql2);
		try 
		{
			stmt.execute(sql1);
			stmt.execute(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeConnection();
	}

	public static void addTransaction(String tansId,String transType,String accNo,Date transDate,double balance) 
	{
		openConnection();

		String date = "2012-12-24";
		String sql = "insert into Transaction values('"+tansId+"','"+transType+"','"+accNo+"','"+
				date+"',"+balance+")";

		System.out.println("SQL  "+sql);

		try 
		{
			stmt.execute(sql.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeConnection();

	}


	public static void updateAccount(String accNo, double balance) 
	{
		openConnection();

		String sql = "update Account set amount="+balance+" where accNo='"+accNo+"'";
		System.out.println("SQL  "+sql);

		try 
		{
			stmt.execute(sql.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeConnection();
	}

	public static void updateBankAccount(String bankcode, String accId,
			double amount) throws AccountNotExistsException, BankNotExistsException 
			{
		openConnection();
		String sql;
		String tableName;
		if(bankcode.equalsIgnoreCase("ICICI"))
		{
			tableName = "icicibank";
		}
		else if(bankcode.equalsIgnoreCase("CITI"))
		{
			tableName = "citibank";
		}
		else if(bankcode.equalsIgnoreCase("PRATIAN"))
		{
			tableName = "pratianbank";
		}
		else
		{
			throw new BankNotExistsException();
		}

		String check = "select * from "+tableName+" where accId='"+accId+"'";
		ResultSet account = null;
		try 
		{
			account = stmt.executeQuery(check);
			if(!account.next())
			{
				throw new AccountNotExistsException();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		String prev = "select amount from "+tableName+" where accId='"+accId+"'";
		ResultSet rs = null;
		double prevBalance = 0;
		try 
		{
			rs = stmt.executeQuery(prev);
			if(rs.next())
			{
				prevBalance = rs.getDouble(1);
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		sql = "update "+tableName+" set amount="+(prevBalance+amount)+" where accId='"+accId+"'";
		System.out.println("SQL  "+sql);

		try 
		{
			stmt.execute(sql.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeConnection();
			}



	public static Statement getStmt() 
	{
		return stmt;
	}

	public static void closeConnection()
	{
		try {
			if(stmt!=null)
			{
				stmt.close();
				stmt=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if(con!=null)
			{
				con.close();
				con=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


}


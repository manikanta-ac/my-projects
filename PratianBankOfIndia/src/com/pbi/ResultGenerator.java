package com.pbi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultGenerator 
{

	public void PrintAllLogTransactions() throws IOException
	{
		
		File file = new File("F:/Pratian-Dec/PratianBankOfIndia/transactions.log");
		FileWriter writer = new FileWriter(file,false);

		System.out.println("======================================================================================================");
		System.out.println("Account No	Transaction Id	Transaction Type	Transaction Date	Amount	   ");
		System.out.println("=======================================================================================================");

		BankDAO.openConnection();

		String sql = "select * from transaction";
		ResultSet rs = null;

		try 
		{
			rs = BankDAO.getStmt().executeQuery(sql);

			while(rs.next())
			{
				writer.write(rs.getString(3)+"\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getDate(4)+"\t"+rs.getDouble(5)+"\n");
				System.out.println(rs.getString(3)+"\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getDate(4)+"\t"+rs.getDouble(5));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		writer.close();
		BankDAO.closeConnection();
	}

	public void PrintAllLogTransactions(String accNo) throws AccountNotExistsException
	{
		System.out.println("==========================================================================================");
		System.out.println("Transaction Id	Transaction Type	Transaction Date	Amount		");
		System.out.println("==========================================================================================");

		BankDAO.openConnection();

		String sql = "select * from transaction where accNo='"+accNo+"'";
		ResultSet rs = null;

		try 
		{
			rs = BankDAO.getStmt().executeQuery(sql);

			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getDate(4)+"\t"+rs.getDouble(5));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		BankDAO.closeConnection();
	}

	public void PrintAllLogTransactions(TransactionType transType)
	{
		System.out.println("==========================================================================================");
		System.out.println("Account No	Transaction Id	Transaction Date	Amount		");
		System.out.println("==========================================================================================");

		BankDAO.openConnection();

		String sql = "select * from transaction where transType='"+transType+"'";
		ResultSet rs = null;

		try 
		{
			rs = BankDAO.getStmt().executeQuery(sql);

			while(rs.next())
			{
				System.out.println(rs.getString(3)+"\t"+rs.getString(1)+"\t"+rs.getDate(4)+"\t"+rs.getDouble(5));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		BankDAO.closeConnection();
	}

	public void dispTotalNoOfAccounts()
	{
		BankDAO.openConnection();

		String sql = "select count(*) from account";
		ResultSet rs = null;
		int totalNoOfAccount = 0;

		try 
		{
			rs = BankDAO.getStmt().executeQuery(sql);
			if(rs.next())
			{
				totalNoOfAccount += rs.getInt(1);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		System.out.println("Total Number of Accounts in the Bank:"+totalNoOfAccount);

		BankDAO.closeConnection();
	}

	public void  displayNoOfAccTypeWise()
	{
		BankDAO.openConnection();

		String sql1 = "select count(*) from account where name ='Savings'";
		String sql2 = "select count(*) from account where name ='Current'";

		ResultSet rs = null;
		int totalSavingsAccounts = 0;
		int totalCurrentAccounts = 0;

		try 
		{
			rs = BankDAO.getStmt().executeQuery(sql1);
			if(rs.next())
			{
				totalSavingsAccounts += rs.getInt(1);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try 
		{
			rs = BankDAO.getStmt().executeQuery(sql2);
			if(rs.next())
			{
				totalCurrentAccounts += rs.getInt(1);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		System.out.println("============================================");
		System.out.println("Account Type		No Of Accounts");
		System.out.println("============================================");
		System.out.println("  Savings			"+totalSavingsAccounts);
		System.out.println("  Current			"+totalCurrentAccounts);

		BankDAO.closeConnection();
	}

	public void dispTotalAmountOfBank()
	{
		BankDAO.openConnection();

		String sql = "select sum(amount) from account";
		ResultSet rs = null;
		double totalAmount = 0;

		try 
		{
			rs = BankDAO.getStmt().executeQuery(sql);
			if(rs.next())
			{
				totalAmount += rs.getDouble(1);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("+-------------------------------------------+");
		System.out.println("Total Amount in the Bank:"+totalAmount);
		System.out.println("+-------------------------------------------+");

		BankDAO.closeConnection();
	}

	public void dispPolicyInfo()
	{
		System.out.println("======================================================================");
		System.out.println("Account Type		Policy Type		Minimum Balance		RateOfInterest");
		System.out.println("======================================================================");

		PolicyTypeManager ptm = PolicyTypeManager.getInstance();

		for(AccountType accType:AccountType.values())
		{
			for(PrivilegeType privilType:PrivilegeType.values())
			{
				String key = accType+"-"+privilType;
				System.out.println(accType+"\t\t"+privilType+"\t\t"+ptm.getMinimumBalance(key)+"\t\t"+ptm.getRateOfIntrest(key));
			}
		}
	}

	public void dispTransfers() 
	{
		System.out.println("==================================================");
		System.out.println("From		Date		Amount");
		System.out.println("==================================================");

		BankDAO.openConnection();

		String sql = "select * from transaction where transType='TRANSFER'";
		ResultSet rs = null;

		try 
		{
			rs = BankDAO.getStmt().executeQuery(sql);

			while(rs.next())
			{
				System.out.println(rs.getString(3)+"\t"+rs.getDate(4)+"\t"+rs.getDouble(5));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		BankDAO.closeConnection();
	}

	public void dispWithdraws() 
	{
		System.out.println("================================");
		System.out.println("From		Date		Amount");
		System.out.println("================================");

		BankDAO.openConnection();

		String sql = "select * from transaction where transType='WITHDRAW'";
		ResultSet rs = null;

		try 
		{
			rs = BankDAO.getStmt().executeQuery(sql);

			while(rs.next())
			{
				System.out.println(rs.getString(3)+"\t"+rs.getDate(4)+"\t"+rs.getDouble(5));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		BankDAO.closeConnection();
	}

	public void dispDeposits() 
	{
		System.out.println("================================");
		System.out.println("To		Date		Amount");
		System.out.println("================================");

		BankDAO.openConnection();

		String sql = "select * from transaction where transType='DEPOSIT'";
		ResultSet rs = null;

		try 
		{
			rs = BankDAO.getStmt().executeQuery(sql);

			while(rs.next())
			{
				System.out.println(rs.getString(3)+"\t"+rs.getDate(4)+"\t"+rs.getDouble(5));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		BankDAO.closeConnection();
	}

	public void dispTransactionsOfDay(String date) 
	{		
		System.out.println("===========================================================================");
		System.out.println("Account No		Transaction Id		Transaction Type		Amount	   ");
		System.out.println("============================================================================");

		BankDAO.openConnection();

		String sql = "select * from transaction where transDate='"+date+"'";
		ResultSet rs = null;

		try 
		{
			rs = BankDAO.getStmt().executeQuery(sql);

			while(rs.next())
			{
				System.out.println(rs.getString(3)+"\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(5));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		BankDAO.closeConnection();
	}
}

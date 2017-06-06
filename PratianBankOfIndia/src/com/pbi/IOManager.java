package com.pbi;

public class IOManager 
{
	public AccountType getAccountType() 
	{
		while(true)
		{
			System.out.println("Select Account Type");
			System.out.println("-------------------");
			System.out.println("     1.Savings");
			System.out.println("     2.Current");
			int choice = Console.readInt();
			if(choice==1)
			{
				return AccountType.SAVINGS;
			}
			else if(choice==2)
			{
				return AccountType.CURRENT;
			}
			else
			{
				System.out.println("Wrong Choice");
			}
		}
	}
	
	public double getIntialDeposit() 
	{
		System.out.println("Enter Your Intial Deposit:");
		return Console.readDouble();
	}
	public PrivilegeType getPrivilegeType() 
	{
		while(true)
		{
			System.out.println("Select Privilege Type");
			System.out.println("-------------------");
			System.out.println("     1.REGULAR");
			System.out.println("     2.GOLD");
			System.out.println("     3.PREMIUM");
			int choice = Console.readInt();
			if(choice==1)
			{
				return PrivilegeType.REGULAR;
			}
			else if(choice==2)
			{
				return PrivilegeType.GOLD;
			}
			else if(choice==3)
			{
				return PrivilegeType.PREMIUM;
			}
			else
			{
				System.out.println("Wrong Choice");
			}
		}
	}
	public double getDepositAmount() 
	{
		System.out.println("Enter Your Deposit Amount:");
		return Console.readDouble();
	}
	public double getWithdrawAmount() 
	{
		System.out.println("Enter Your Withdraw Amount:");
		return Console.readDouble();
	}
	public double getTransferAmount() 
	{
		System.out.println("Enter Your Transfer Amount:");
		return Console.readDouble();
	}

	public double getExternalTransferAmount()
	{
		System.out.println("Enter External Transfer Amount:");
		return Console.readDouble();
	}

	public String getExternalBankId() 
	{
		System.out.println("Enter External Bank Id:");
		return Console.readLine();
	}

	public String getExternalAccountNo() 
	{
		System.out.println("Enter External Account Number:");
		return Console.readLine();
	}
}

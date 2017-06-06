package com.pbi;

import java.io.IOException;
import java.util.Date;

public class AccountFactory 
{		
	public void manageAccount() 
			throws MinimumBalanceException, AccountInActiveException, PinNotMatchedException,
			MaxDailyLimitExceedException,DataBaseException, AccountNotExistsException, BankNotExistsException 
	{
		IOManager ioManager = new IOManager();
		
		AccountManager manager = new AccountManager();

		Account acc1 = manager.create(ioManager.getAccountType(),ioManager.getIntialDeposit(),ioManager.getPrivilegeType());
		System.out.println("-------------------------------------------");
		Account acc2 = manager.create(ioManager.getAccountType(),ioManager.getIntialDeposit(),ioManager.getPrivilegeType());
		
		
		//======================Deposit==========================
		
		System.out.println("----------------Deposit--------------------");
		
		double depositBal = ioManager.getDepositAmount();
		boolean success1 = manager.deposit(acc1,depositBal);

		if(success1)
		{
			System.out.println("Transaction is Successfully Completed");
			System.out.println(depositBal+"Rs deposited to "+acc1.getAccNo());
			System.out.println("Balance in the account now:"+acc1.getBalance());
		}

		//======================Withdraw==========================
		
		System.out.println("----------------Withdraw--------------------");

		double withdrawBal = ioManager.getWithdrawAmount();
		int pin1 = 2012;
		boolean success2 = manager.withdraw(acc1,withdrawBal,pin1);

		if(success2)
		{
			System.out.println("Transaction is Successfully Completed");
			System.out.println(withdrawBal+"Rs withdrawn from "+acc1.getAccNo());
			System.out.println("Balance in the account now:"+acc1.getBalance());
		}
		
		//======================Transfer==========================
		
		System.out.println("---------------Transfer---------------------");
		System.out.println("Balance in the acc1 account now:"+acc1.getBalance());
		System.out.println("Balance in the acc2 account now:"+acc2.getBalance()+"\n");
		
		double transferBal = ioManager.getTransferAmount();
		int pin2 = 2012;
		Transfer transferOperation1 = new Transfer(acc1, acc2, transferBal, pin2);
		
		boolean success3 = manager.transfer(transferOperation1);
		
		if(success3)
		{
			System.out.println("Transaction is Successfully Completed\n");
			System.out.println(transferBal+"Rs transformed from "+acc1.getAccNo()+" to "+acc2.getAccNo());
			System.out.println("Balance in the acc1 account now:"+acc1.getBalance());
			System.out.println("Balance in the acc2 account now:"+acc2.getBalance());
		}
		
		System.out.println("---------------Transfer---------------------");
		
		double transferBal2 = ioManager.getTransferAmount();
		Transfer transferOperation2 = new Transfer(acc1, acc2, transferBal2, pin2);
		
		boolean success4 = manager.transfer(transferOperation2);
		
		if(success4)
		{
			System.out.println("Transaction is Successfully Completed\n");
			System.out.println(transferBal2+"Rs transformed from "+acc1.getAccNo()+" to "+acc2.getAccNo());
			System.out.println("Balance in the acc1 account now:"+acc1.getBalance());
			System.out.println("Balance in the acc2 account now:"+acc2.getBalance());
		}
		
		//==========================External Transfer======================
		
		System.out.println("----------------External Transfer--------------------");
		
		ExternalAccount externalAccount = new ExternalAccount(ioManager.getExternalBankId(), ioManager.getExternalAccountNo());
		double externalTransferBal = ioManager.getExternalTransferAmount();
		ExternalTransfer externalTrans = new ExternalTransfer(acc1, externalTransferBal, externalAccount, 2012);
		
		boolean success5 = manager.externalTransfer(externalTrans);
		
		if(success5)
		{
			System.out.println("Transaction is Successfully Completed\n");
			System.out.println(externalTransferBal+"Rs transformed from "+acc1.getAccNo()+" to "+externalAccount.getAccNo());
			System.out.println("Balance in the acc1 account now:"+acc1.getBalance());
		}
	}
	
	public void generateResult() throws AccountNotExistsException, IOException 
	{		
		ResultGenerator result = new ResultGenerator();
		
		result.PrintAllLogTransactions();
		
		result.PrintAllLogTransactions("PBI2012000001");
		
		result.PrintAllLogTransactions(TransactionType.DEPOSIT);
		
		result.dispTotalNoOfAccounts();
		
		result.displayNoOfAccTypeWise();
		
		result.dispTotalAmountOfBank();
		
		result.dispPolicyInfo();
		
		result.dispTransfers();
		
		result.dispWithdraws();
		
		result.dispDeposits();
		
		result.dispTransactionsOfDay("2012/12/24");
	}
}

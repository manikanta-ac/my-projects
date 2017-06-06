package com.pbi;
import java.util.List;
public class AccountManager
{
	PrivilegeTypeManager privilegeManager = PrivilegeTypeManager.getInstance();
	TransactionLog transactionLog = new TransactionLog();
	PolicyTypeManager policyManager = PolicyTypeManager.getInstance();
	
	public Account create(AccountType accType, double balance, PrivilegeType privilegeType) 
			throws MinimumBalanceException, DataBaseException 
	{
		Account acc1;

		if(balance<policyManager.getMinimumBalance(accType+"-"+privilegeType))
		{
			throw new MinimumBalanceException("Intial Deposit must be atleast Minimum Balance");
		}
		if(accType==AccountType.CURRENT)
		{
			acc1 = new CurrentAccount(balance,privilegeType);
			acc1.open();
		}
		else
		{
			acc1 = new SavingsAccount(balance, privilegeType);
			acc1.open();
		}
		BankDAO.addAccount(acc1.getAccNo(), acc1.getName(), acc1.getPIN(),
				acc1.getActive(), acc1.getDateOfOpening(),acc1.getBalance(),acc1.getPrivilegeType().toString(), 
				acc1.getAccountType().toString());
		
		return acc1;
	}

	public boolean deposit(Account acc,double depositeBal) throws AccountInActiveException, DataBaseException, AccountNotExistsException, BankNotExistsException 
	{
		Transaction trs1 = new Transaction(acc, depositeBal);
		if(!acc.getActive())
		{
			throw new AccountInActiveException();
		}
		acc.setBalance(acc.getBalance()+depositeBal);
		transactionLog.logTransaction(acc.getAccNo(), TransactionType.DEPOSIT, trs1);
		BankDAO.addTransaction(trs1.getTransactionId(), "DEPOSIT",
				acc.getAccNo(), trs1.getTransactionDate(), trs1.getAmount());
		
		BankDAO.updateAccount(acc.getAccNo(),acc.getBalance()+depositeBal);
		BankDAO.updateBankAccount("PRATIAN", acc.getAccNo(), depositeBal);
		
		return true;
	}

	public boolean withdraw(Account acc,double withdrawBal,int pin) 
			throws MinimumBalanceException, PinNotMatchedException, AccountInActiveException, 
			MaxDailyLimitExceedException, DataBaseException, AccountNotExistsException, BankNotExistsException 
			{
		Transaction trs1 = new Transaction(acc, withdrawBal);
		Double dailyAmount = 0.0;
		if(transactionLog.getLogDetails().containsKey(acc.getAccNo()))
		{
			List<Transaction> withdrawTrans = transactionLog.getTransactions(acc.getAccNo(), TransactionType.WITHDRAW);
			List<Transaction> transferTrans = transactionLog.getTransactions(acc.getAccNo(), TransactionType.TRANSFER);
			if(withdrawTrans!=null)
			{
				for(Transaction trans:withdrawTrans)
				{
					dailyAmount += trans.getAmount();
				}
			}
			if(transferTrans!=null)
			{
				for(Transaction trans:transferTrans)
				{
					dailyAmount += trans.getAmount();
				}
			}
		}
		double maxDailyLimit = privilegeManager.getDailyLimit(acc.getPrivilegeType());

		if((dailyAmount+withdrawBal)>maxDailyLimit)
		{
			throw new MaxDailyLimitExceedException();
		}
		else
		{
			if(acc.getActive())
			{
				if(pin==acc.getPIN())
				{
					double affectedBal = acc.getBalance()-withdrawBal;
					if(affectedBal<policyManager.getMinimumBalance(acc.getAccountType()+"-"+acc.getPrivilegeType()))
					{
						throw new MinimumBalanceException("This Withdraw makes you to reach less than Minimum Balance");
					}
					acc.setBalance(affectedBal);
					
					transactionLog.logTransaction(acc.getAccNo(), TransactionType.WITHDRAW, trs1);
					
					BankDAO.addTransaction(trs1.getTransactionId(), "WITHDRAW",
							acc.getAccNo(), trs1.getTransactionDate(), trs1.getAmount());
					
					BankDAO.updateAccount(acc.getAccNo(),affectedBal);
					BankDAO.updateBankAccount("PRATIAN", acc.getAccNo(), (-withdrawBal));
					
					return true;
				}
				else
				{
					throw new PinNotMatchedException();
				}
			}
			else
			{
				throw new AccountInActiveException();
			}
		}
	}

	public boolean transfer(Transfer transferOperation)
			throws AccountInActiveException, MinimumBalanceException,
			PinNotMatchedException, MaxDailyLimitExceedException ,DataBaseException, AccountNotExistsException, BankNotExistsException
			{
		Account sourceAcc = transferOperation.getSourceAcc();
		Account destinationAcc = transferOperation.getDestinationAcc();
		double amount = transferOperation.getAmount();
		int pin = transferOperation.getPin();

		TransferTransaction tranaferTrans = new TransferTransaction(sourceAcc, destinationAcc, amount);
		
		Double dailyAmount = 0.0;
		if(transactionLog.getLogDetails().containsKey(sourceAcc.getAccNo()))
		{
			List<Transaction> withdrawTrans = transactionLog.getTransactions(sourceAcc.getAccNo(), TransactionType.WITHDRAW);
			List<Transaction> transferTrans = transactionLog.getTransactions(sourceAcc.getAccNo(), TransactionType.TRANSFER);
			if(withdrawTrans!=null)
			{
				for(Transaction trans:withdrawTrans)
				{
					dailyAmount += trans.getAmount();
				}
			}
			if(transferTrans!=null)
			{
				for(Transaction trans:transferTrans)
				{
					dailyAmount += trans.getAmount();
				}
			}
		}		double maxDailyLimit = privilegeManager.getDailyLimit(sourceAcc.getPrivilegeType());

		if((dailyAmount+amount)>maxDailyLimit)
		{
			throw new MaxDailyLimitExceedException();
		}
		else
		{
			if(withdraw(sourceAcc, amount, pin)&&deposit(destinationAcc, amount))
			{	
				transactionLog.logTransaction(sourceAcc.getAccNo(), TransactionType.TRANSFER, tranaferTrans);
				
				BankDAO.addTransaction(tranaferTrans.getTransactionId(), "TRANSFER",
						sourceAcc.getAccNo(), tranaferTrans.getTransactionDate(), tranaferTrans.getAmount());
			}
			return true;
		}
	}

	public boolean externalTransfer(ExternalTransfer externalTrans) 
			throws MaxDailyLimitExceedException, MinimumBalanceException, PinNotMatchedException, 
			AccountInActiveException, DataBaseException, AccountNotExistsException, BankNotExistsException 
	{
		ExternalTransferService externaltransfer = new ExternalTransferService(externalTrans);
		
		Account sourceAcc = (Account)externalTrans.getFromAccount();
		
		double amount = externalTrans.getAmount();
		int pin = externalTrans.getPin();

		Transaction trs1 = new Transaction(sourceAcc,amount);

		Double dailyAmount = 0.0;
		if(transactionLog.getLogDetails().containsKey(sourceAcc.getAccNo()))
		{
			List<Transaction> withdrawTrans = transactionLog.getTransactions(sourceAcc.getAccNo(), TransactionType.WITHDRAW);
			List<Transaction> transferTrans = transactionLog.getTransactions(sourceAcc.getAccNo(), TransactionType.TRANSFER);
			
			if(withdrawTrans!=null)
			{
				for(Transaction trans:withdrawTrans)
				{
					dailyAmount += trans.getAmount();
				}
			}
			if(transferTrans!=null)
			{
				for(Transaction trans:transferTrans)
				{
					dailyAmount += trans.getAmount();
				}
			}
		}		double maxDailyLimit = privilegeManager.getDailyLimit(sourceAcc.getPrivilegeType());

		if((dailyAmount+amount)>maxDailyLimit)
		{
			throw new MaxDailyLimitExceedException();
		}
		else
		{
			if(withdraw(sourceAcc, amount, pin))
			{				
				transactionLog.logTransaction(sourceAcc.getAccNo(), TransactionType.EXTERNAL_TRANSFER, trs1);
				
				externaltransfer.start();
				
				BankDAO.addTransaction(trs1.getTransactionId(), "EXTERNAL",
						sourceAcc.getAccNo(), trs1.getTransactionDate(), trs1.getAmount());
			}
			return true;
		}

	}
}

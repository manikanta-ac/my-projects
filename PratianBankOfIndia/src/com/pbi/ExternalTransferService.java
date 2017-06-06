package com.pbi;

public class ExternalTransferService extends Thread 
{
	ExternalTransactionLog log = ExternalTransactionLog.getInstance();

	public ExternalTransferService(ExternalTransfer transfer) 
	{
		log.getExternaltransferLog().add(transfer);
	}
	
	@Override
	public void run() 
	{
		checkTransactions();
	}

	public void checkTransactions() 
	{
		for(ExternalTransfer transfer:log.getExternaltransferLog())
		{
			if(transfer.getStatus()==TransactionStatus.OPEN)
			{
				ExternalBankServiceFactory factory = ExternalBankServiceFactory.getInstance();

				IExternalBankService bank = factory.getBankObject(transfer.getToAccount().getBankId());

				try 
				{
					bank.deposit(transfer.getToAccount().getAccNo(), transfer.getAmount());

					BankDAO.updateBankAccount(transfer.getToAccount().getBankId(), 
							transfer.getToAccount().getAccNo(), transfer.getAmount());

					transfer.setStatus(TransactionStatus.CLOSE);
				} 
				catch (AccountNotExistsException e) {
				} catch (BankNotExistsException e) {
				}
			}
		}
	}
}	


package com.pbi;

import java.util.ArrayList;
import java.util.List;

public class ExternalTransactionLog 
{
	private List<ExternalTransfer> externaltransferLog = new ArrayList<ExternalTransfer>();
	private static ExternalTransactionLog externalTransactionLog = null;
	
	private ExternalTransactionLog() 
	{
		
	}
	
	public void logExternalTransaction(ExternalTransfer transaction)
	{
		externaltransferLog.add(transaction);
	}

	public List<ExternalTransfer> getExternaltransferLog() {
		return externaltransferLog;
	}
	
	public static ExternalTransactionLog getInstance() 
	{
		if(externalTransactionLog==null)
		{
			externalTransactionLog = new ExternalTransactionLog();
		}
		return externalTransactionLog;
	}
}

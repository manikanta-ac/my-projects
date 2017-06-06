package com.pbi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionLog 
{
	private List<Transaction> transactions = new ArrayList<Transaction>();
	private Map<TransactionType,List<Transaction>> transactionMap = new HashMap<TransactionType, List<Transaction>>();
	private Map<String, Map<TransactionType,List<Transaction>>> log = new HashMap<String, Map<TransactionType,List<Transaction>>>();
	
	public Map<String, Map<TransactionType,List<Transaction>>> getLogDetails() 
	{
		return log;
	}
	public Map<TransactionType,List<Transaction>> getTransactionMap(String accountNo) 
	{
		return log.get(accountNo);
	}
	public List<Transaction> getTransactions(String accountNo,TransactionType type) 
	{
		return log.get(accountNo).get(type);
	}
	public void logTransaction(String accountNo,TransactionType type,Transaction transaction) 
	{
		transactions.add(transaction);
		transactionMap.put(type, transactions);
		log.put(accountNo, transactionMap);
		transaction.setStatus(TransactionStatus.CLOSE);
	}
}
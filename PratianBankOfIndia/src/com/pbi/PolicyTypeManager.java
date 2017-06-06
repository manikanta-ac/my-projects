package com.pbi;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PolicyTypeManager 
{
	private Map<String,IPolicy> policies = new HashMap<String,IPolicy>();
	private static PolicyTypeManager ptm = null;

	private PolicyTypeManager() 
	{
		loadDailyLimitPropertyFile();
	}

	private void loadDailyLimitPropertyFile() 
	{
		FileReader reader;
		try {
			reader = new FileReader("policy.properties");
			Properties parser = new Properties();
			parser.load(reader);
			
			for(AccountType accType:AccountType.values())
			{
				for(PrivilegeType privilType:PrivilegeType.values())
				{
					String key = accType+"-"+privilType;
					String values[] = parser.getProperty(key).split(",");
					policies.put(key,new Policy(key, Double.parseDouble(values[0]), Double.parseDouble(values[1])));
				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public double getMinimumBalance(String key) 
	{		
		return policies.get(key).getMinBalance();
	}
	public double getRateOfIntrest(String key) 
	{		
		return policies.get(key).getRateOfIntrest();
	}

	public static PolicyTypeManager getInstance() 
	{
		if(ptm==null)
		{
			ptm = new PolicyTypeManager();
		}
		return ptm;
	}
}

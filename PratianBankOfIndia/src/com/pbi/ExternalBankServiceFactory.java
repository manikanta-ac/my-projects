package com.pbi;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ExternalBankServiceFactory 
{
	private Map<String,IExternalBankService> serviceBankPool = new HashMap<String,IExternalBankService>();
	private static ExternalBankServiceFactory  factory = null;

	private ExternalBankServiceFactory() 
	{
		loadBankCodesPropertyFile();
	}

	private void loadBankCodesPropertyFile() 
	{
		FileReader reader;
		try {
			reader = new FileReader("banks.properties");
			Properties parser = new Properties();
			parser.load(reader);
			
			for(Object key:parser.keySet())
			{
				String code = key.toString();
				String className= "com.pbi."+parser.getProperty(code);
				
				IExternalBankService bankObj= (IExternalBankService)Class.forName(className).newInstance();
				serviceBankPool.put(code, bankObj);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public IExternalBankService getBankObject(String key) 
	{		
		return serviceBankPool.get(key);
	}

	public static ExternalBankServiceFactory getInstance() 
	{
		if(factory==null)
		{
			factory = new ExternalBankServiceFactory();
		}
		return factory;
	}
}

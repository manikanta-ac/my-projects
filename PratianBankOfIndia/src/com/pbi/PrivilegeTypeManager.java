package com.pbi;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PrivilegeTypeManager 
{
	private Map<PrivilegeType, Integer> privilegeTypes = new HashMap<PrivilegeType, Integer>();
	private static PrivilegeTypeManager ptm = null;
	
	private PrivilegeTypeManager() 
	{
		loadDailyLimitPropertyFile();
	}
	
	private void loadDailyLimitPropertyFile() 
	{
		FileReader reader;
		try {
			reader = new FileReader("DailyLimit.properties");
			Properties parser = new Properties();
			parser.load(reader);
			for(PrivilegeType key:PrivilegeType.values())
			{
				privilegeTypes.put(key, Integer.parseInt(parser.getProperty(key.toString())));
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public double getDailyLimit(PrivilegeType key) 
	{
		return privilegeTypes.get(key);
	}
	
	public static PrivilegeTypeManager getInstance() 
	{
		if(ptm==null)
		{
			ptm = new PrivilegeTypeManager();
		}
		return ptm;
	}
}

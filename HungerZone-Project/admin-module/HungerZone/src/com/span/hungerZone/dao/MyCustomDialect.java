package com.span.hungerZone.dao;

import org.hibernate.dialect.MySQLDialect;

public class MyCustomDialect extends MySQLDialect 
{
	@Override
	public String getTableTypeString() 
	{
		return " ENGINE=MyISAM DEFAULT CHARSET=utf8";
	}	
}

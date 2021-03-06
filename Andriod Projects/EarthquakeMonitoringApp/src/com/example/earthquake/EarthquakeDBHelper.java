package com.example.earthquake;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class EarthquakeDBHelper extends SQLiteOpenHelper 
{
	public static final String DB_NAME = "eartquakes.db";
	public static final String  TBL_NAME = "entry";

	public EarthquakeDBHelper(Context context,int version) 
	{
		super(context, DB_NAME, null, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		Log.i("EQMS", "Creating Table");
		String strCreate = "create table " + TBL_NAME + "(_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
											" id TEXT NOT NULL,"+
											" title TEXT NOT NULL,"+
											" updated TEXT NOT NULL,"+
											" link TEXT NOT NULL,"+
											" georss TEXT NOT NULL,"+
											" category TEXT NOT NULL,"+
											" summary TEXT NOT NULL)";
		db.execSQL(strCreate);
		Log.i("EQMS", "Table Created");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) 
	{

	}
}

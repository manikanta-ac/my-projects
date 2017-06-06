package com.example.earthquake;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class EarthquakeContentProvider extends ContentProvider
{
	EarthquakeDBHelper dBHelper;
	public static String  CNTENT_URI="content://com.example.earthquake.earthquakecontentprovider/entry";
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) 
	{
		return 0;
	}

	@Override
	public String getType(Uri uri) 
	{
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) 
	{
		Uri curi=Uri.parse(CNTENT_URI);

		if(uri.equals(curi));
		{
			SQLiteDatabase db=dBHelper.getReadableDatabase();
			db.insert(EarthquakeDBHelper.TBL_NAME, null, values);
		}
		return uri;
	}

	@Override
	public boolean onCreate() 
	{
		dBHelper=new EarthquakeDBHelper(getContext(),1);
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,String[] selectionArgs, String sortOrder) 
	{
    	Uri curi=Uri.parse(CNTENT_URI);
    	Cursor cur=null;
    	if(uri.equals(curi));
    	{
    		SQLiteDatabase db=dBHelper.getReadableDatabase();
    		cur=db.query(EarthquakeDBHelper.TBL_NAME, projection, selection, selectionArgs, null, null, sortOrder);
    	}
    	return cur;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,String[] selectionArgs) 
	{
		return 0;
	}
}

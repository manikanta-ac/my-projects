package com.example.earthquake;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;

public class EarthquakeService extends Service 
{
	AlarmManager alarmManager;	
	PendingIntent alarmIntent;
	
	@Override
	public void onCreate() 
	{
		alarmManager=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
		Intent intentToFire = new Intent("com.example.earthquake.action.ALARM_ACTION");
		alarmIntent = PendingIntent.getBroadcast(this, 0, intentToFire, 0);

		super.onCreate();
	}

	@Override
	public void onDestroy() 
	{
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		SharedPreferences sp=getSharedPreferences("PREFS", MODE_PRIVATE);
		long alarmTime=sp.getLong("alarmTime", -1);
		
		if(alarmTime==-1)
			alarmManager.cancel(alarmIntent);
		else 
			alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+alarmTime, alarmIntent);

		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent arg0) 
	{
		return null;
	}

}

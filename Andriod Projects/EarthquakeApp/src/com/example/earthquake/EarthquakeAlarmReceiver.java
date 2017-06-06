package com.example.earthquake;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class EarthquakeAlarmReceiver extends BroadcastReceiver 
{
	@Override
	public void onReceive(Context context, Intent intent) 
	{
		Intent startIntent=new Intent(context,EarthquakeService.class);
		context.startActivity(startIntent);
	}
}

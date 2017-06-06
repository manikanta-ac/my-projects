package com.example.earthquake;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class EarthquakeAlarmReceiver extends BroadcastReceiver 
{
	@Override
	public void onReceive(Context context, Intent intent) 
	{
		Log.i("EQMS", "Alarm Completed(Alarm Broadcast Reciever),Starting Services Again to Update the List");
		Intent startIntent=new Intent(context,EarthquakeService.class);
		context.startService(startIntent);
	}
}
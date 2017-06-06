package com.example.earthquake;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ProximityReciever extends BroadcastReceiver 
{
	@Override
	public void onReceive(Context context, Intent intent) 
	{
		Notification n=new Notification();
		n.tickerText="EartQuakeRegion Alert";
		n.icon=R.drawable.ic_launcher;
		n.when=System.currentTimeMillis();
		n.flags=Notification.FLAG_AUTO_CANCEL;
		NotificationManager nm=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

		CharSequence contentTitle = "EartQuakeRegion Alert";
		CharSequence contentText = "Alert..! EartQuake Happened nearer your current location";
		Intent notificationIntent = new Intent(context, MainActivity.class);
		PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);

		n.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
		
		nm.notify(100, n);
	}
}

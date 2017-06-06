package com.example.earthquake;

import android.app.Activity;
import android.location.LocationManager;
import android.os.Bundle;

public class ProximityActivity extends Activity 
{
	LocationManager lm;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		//lm.addProximityAlert(latitude, longitude, radius, expiration, intent);
	}
	
}

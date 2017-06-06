package com.example.earthquake;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class EarthquakeSettings extends Activity implements OnClickListener
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);

		Button btn=(Button)findViewById(R.id.save);
		btn.setOnClickListener(this);

		btn=(Button)findViewById(R.id.cancel);
		btn.setOnClickListener(this);
		
		RadioButton prevButton;
		SharedPreferences sp=getSharedPreferences("PREFS", MODE_PRIVATE);
		long previous=sp.getLong("previous", AlarmManager.INTERVAL_DAY);
		
		if(previous==60000)
		{
			prevButton=(RadioButton)findViewById(R.id.radio1);
			prevButton.setChecked(true);
		}
		else if(previous==AlarmManager.INTERVAL_DAY)
		{
			prevButton=(RadioButton)findViewById(R.id.radioButton1);
			prevButton.setChecked(true);
		}
		else if(previous==AlarmManager.INTERVAL_HOUR)
		{
			prevButton=(RadioButton)findViewById(R.id.radio2);
			prevButton.setChecked(true);
		}
		else 
		{
			prevButton=(RadioButton)findViewById(R.id.radio0);
			prevButton.setChecked(true);
		}

		Log.i("EQMS", "Setting Activity");
	}

	@Override
	public void onClick(View v) 
	{
		RadioGroup rg=(RadioGroup)findViewById(R.id.radioGroup1);

		if(rg.getCheckedRadioButtonId()==-1)
		{
			Toast.makeText(this, "Please Select Any One of Types", Toast.LENGTH_LONG).show();
		}

		else
		{
			RadioButton rb=(RadioButton)findViewById(rg.getCheckedRadioButtonId());
			SharedPreferences sp=getSharedPreferences("PREFS", MODE_PRIVATE);
			
			String selectedType=rb.getText().toString();
			long timeToAlarm=-1;			
			
			if(selectedType.equals("5 minutes"))
			{
				Log.i("EQMS", "Alarm Set To 5 minutes");
				timeToAlarm=60000;
			}
			else if(selectedType.equals("1 Hour"))
			{
				timeToAlarm=AlarmManager.INTERVAL_HOUR;
			}
			else if(selectedType.equals("1 Day"))
			{
				timeToAlarm=AlarmManager.INTERVAL_DAY;
			}
			else 
			{
				timeToAlarm=-1;
			}

			
			if(v.getId()==R.id.save)
			{				
				Editor ed=sp.edit();
				ed.putLong("alarmTime", timeToAlarm);
				ed.putLong("previous", timeToAlarm);
				ed.commit();
				Log.i("EQMS", "Saving Preferences");
				this.finish();
			}

			AlarmManager alarmManager=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
			Intent intentToFire = new Intent("com.example.earthquake.action.ALARM_ACTION");
			PendingIntent alarmIntent = PendingIntent.getBroadcast(this, 0, intentToFire, 0);

			if(timeToAlarm==-1)
			{
				alarmManager.cancel(alarmIntent);
				Log.i("EQMS", "Alarm Canceled");
			}
			else
			{
				//alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+timeToAlarm, alarmIntent);
				alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+timeToAlarm,timeToAlarm, alarmIntent);
				Toast.makeText(getApplicationContext(), "Alarm has been set to next "+timeToAlarm/1000+" Seconds", Toast.LENGTH_LONG).show();
				Log.i("EQMS", "Alarm Set to "+timeToAlarm);
			}

		}

		if(v.getId()==R.id.cancel)
		{
			this.finish();
		}		
	}
}

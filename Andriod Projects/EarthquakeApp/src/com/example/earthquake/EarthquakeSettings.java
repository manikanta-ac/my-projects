package com.example.earthquake;

import android.app.Activity;
import android.app.AlarmManager;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
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

			String selectedType=rb.getText().toString();
			long timeToAlarm;
			if(selectedType.equals("5 minutes"))
			{
				timeToAlarm=5*60*1000;
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
			
			SharedPreferences sp=getSharedPreferences("PREFS", MODE_PRIVATE);

			if(v.getId()==R.id.save)
			{				
				Editor ed=sp.edit();
				ed.putLong("alarmTime", timeToAlarm);
				ed.commit();
				
				this.finish();
			}
		}

		if(v.getId()==R.id.cancel)
		{
			this.finish();
		}		
	}
}

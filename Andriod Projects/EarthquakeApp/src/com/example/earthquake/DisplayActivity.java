package com.example.earthquake;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.entry);
		
		Intent intent=getIntent();
		
		TextView tv=(TextView)findViewById(R.id.title);
		tv.setText(intent.getStringExtra("title"));
		
		tv=(TextView)findViewById(R.id.id_val);
		tv.setText(intent.getStringExtra("id"));
		
		tv=(TextView)findViewById(R.id.update_val);
		tv.setText(intent.getStringExtra("update"));
		
		tv=(TextView)findViewById(R.id.link_val);
		tv.setText(intent.getStringExtra("link"));
		
		tv=(TextView)findViewById(R.id.point_val);
		tv.setText(intent.getStringExtra("georss"));
		
		tv=(TextView)findViewById(R.id.catg_val);
		tv.setText(intent.getStringExtra("category"));
	}
	
}

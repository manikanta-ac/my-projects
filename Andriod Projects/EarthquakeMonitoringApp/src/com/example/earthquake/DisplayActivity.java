package com.example.earthquake;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.TextView;

public class DisplayActivity extends Activity 
{
	String georss;
	String link;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		Log.i("EQMS", "Displaying Data");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.details);

		Intent intent=getIntent();

		TextView tv=(TextView)findViewById(R.id.title1);
		tv.setText(intent.getStringExtra("title"));

		tv=(TextView)findViewById(R.id.id_val);
		tv.setText(intent.getStringExtra("id"));

		tv=(TextView)findViewById(R.id.update_val);
		tv.setText(intent.getStringExtra("updated"));

		tv=(TextView)findViewById(R.id.link_val1);
		link=intent.getStringExtra("link");
		tv.setText(link);

		tv=(TextView)findViewById(R.id.point_val);
		tv.setText(intent.getStringExtra("georss"));
		georss=intent.getStringExtra("georss");

		tv=(TextView)findViewById(R.id.catg_val);
		tv.setText(intent.getStringExtra("category"));

		tv=(TextView)findViewById(R.id.linkMap);
		//tv.setText(Html.fromHtml("<u><<Click Here To View In Map>></u>"));

		WebView wv=(WebView)findViewById(R.id.webView1);
		wv.loadData(intent.getStringExtra("summary"), "text/html", null);
	}

	public void doClick(View v) 
	{
		if(v.getId()==R.id.linkMap)
		{
			Log.i("EQMS", "Link Data Clicked");
			Intent intent=new Intent("com.example.earthquake.action.MAP");
			//Intent intent=new Intent(this,EarthquakeMapActivity.class);
			String points[]=georss.split(" ");
			intent.putExtra("latitude",points[0]);
			intent.putExtra("longitude", points[1]);
			startActivity(intent);
			Log.i("EQMS", "Map Activity Started");
		}
		else if(v.getId()==R.id.link_val1)
		{
			Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(link));
			startActivity(intent);
		}
	}
}

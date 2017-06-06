package com.example.earthquake;

import java.util.ArrayList;
import java.util.List;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Matrix;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener 
{
	ListView lv;
	List<String> titlesList=new ArrayList<String>();
	EartquakeReciever reciever;
	IntentFilter filter;


	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv=(ListView)findViewById(R.id.listView1);
		lv.setOnItemClickListener(this);
		
		SharedPreferences sp=getSharedPreferences("PREFS", MODE_PRIVATE);
		long timeToAlarm=sp.getLong("alarmTime", 0);
		Log.i("EQMS", "Shared Preference Value:"+timeToAlarm);
		
		if(timeToAlarm==0)
		{
			defaultAlarm();
		}
		
		reciever= new EartquakeReciever();
		filter=new IntentFilter("com.example.earthquake.reciever.EARTHQUAKE_RECIEVER");
		registerReceiver(reciever, filter);
		Log.i("EQMS", "In MainActivity before Service start");
		
		Intent intent = new Intent("com.example.earthquake.service.EARTHQUAKE_SERVICE");
		startService(intent);
		
		/*Intent proximityIntent= new Intent(this,ProximityActivity.class);
		startActivity(proximityIntent);*/
	}
	
	public void defaultAlarm() 
	{		
		AlarmManager alarmManager=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
		Intent intentToFire = new Intent("com.example.earthquake.action.ALARM_ACTION");
		PendingIntent alarmIntent = PendingIntent.getBroadcast(this, 0, intentToFire, 0);
		
		SharedPreferences sp=getSharedPreferences("PREFS", MODE_PRIVATE);
		//long timeToAlarm=AlarmManager.INTERVAL_DAY;
		long timeToAlarm=30000;
		
		Editor ed=sp.edit();
		ed.putLong("alarmTime", timeToAlarm);
		ed.commit();
		
		alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+timeToAlarm,timeToAlarm, alarmIntent);
		Toast.makeText(getApplicationContext(), "Default Alarm has been set to next "+timeToAlarm/1000+" Seconds", Toast.LENGTH_LONG).show();
		Log.i("EQMS", "Alarm Set to "+timeToAlarm);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		Log.i("EQMS", "Menu Item Clicked");
		switch(item.getItemId())
		{
		case R.id.update:
			updateList();
			break;
		case R.id.settings :
			Intent intent = new Intent("com.example.earthquake.SETTINGS");
			startActivity(intent);
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	public void updateList()
	{		
		Log.i("EQMS", "Updating User Interface List");
		ContentResolver cr=getContentResolver();

		Uri uri=Uri.parse("content://com.example.earthquake.earthquakecontentprovider");
		Cursor cur=cr.query(uri, null, null, null, null);

		if(cur.moveToLast())
		{
			do
			{
				titlesList.add(cur.getString(cur.getColumnIndex("title")));
			}while(cur.moveToPrevious());
		}

		ArrayAdapter<String> ca=new ArrayAdapter<String>(this,R.layout.item,R.id.textView1,titlesList);
		lv.setAdapter(ca);
		lv.startAnimation(new ViewAnimation());
	}

	class EartquakeReciever extends BroadcastReceiver
	{
		@Override
		public void onReceive(Context context, Intent intent) 
		{
			Log.i("EQMS", "Broadcast Reciver Recived");
			updateList();
		}

	}
	
	class ViewAnimation extends Animation {
    	float centerX, centerY;
		@Override
		public void initialize(int width, int height, int parentWidth,
				int parentHeight) {
			super.initialize(width, height, parentWidth, parentHeight);
			centerX = width/2.0f;
			centerY = height/2.0f;
			setDuration(2500);
			setFillAfter(true);
			setInterpolator(new LinearInterpolator());
		}

		@Override
		protected void applyTransformation(float interpolatedTime,
				Transformation t) {
			final Matrix matrix = t.getMatrix();
			matrix.setScale(interpolatedTime, interpolatedTime);
			matrix.preTranslate(-centerX, -centerY);
			matrix.postTranslate(centerX, centerY);
		}
    }


	@Override
	protected void onPause() 
	{
		unregisterReceiver(reciever);
		super.onPause();
	}

	@Override
	protected void onResume() 
	{
		registerReceiver(reciever, filter);
		super.onResume();
	}

	@Override
	public void onItemClick(AdapterView listview, View v, int position, long itemId) 
	{
		Log.i("EQMS", "Item clicked"+position);
		
		Intent displayIntent = new Intent(getApplicationContext(),DisplayActivity.class);

		ContentResolver cr=getContentResolver();

		Uri uri=Uri.parse("content://com.example.earthquake.earthquakecontentprovider");
		Cursor cur=cr.query(uri, null, null, null, null);
		
		cur.moveToPosition(cur.getCount()-position-1);
		
		String title=cur.getString(cur.getColumnIndex("title"));
		String id=cur.getString(cur.getColumnIndex("id"));
		String update=cur.getString(cur.getColumnIndex("updated"));
		String link=cur.getString(cur.getColumnIndex("link"));
		String georss=cur.getString(cur.getColumnIndex("georss"));
		String category=cur.getString(cur.getColumnIndex("category"));
		String summary=cur.getString(cur.getColumnIndex("summary"));

		displayIntent.putExtra("title", title);
		displayIntent.putExtra("id", id);
		displayIntent.putExtra("updated", update);
		displayIntent.putExtra("link", link);
		displayIntent.putExtra("georss", georss);
		displayIntent.putExtra("category", category);
		displayIntent.putExtra("summary", summary);
		
		Log.i("EQMS", "Values Sending through Intent");
		
		startActivity(displayIntent);
		
		Log.i("EQMS", "Display Activity Started");
		//super.onListItemClick(listview, v, position, itemId);
	}	
}

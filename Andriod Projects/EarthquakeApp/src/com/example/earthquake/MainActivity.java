package com.example.earthquake;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemClickListener 
{
	ListView lv;
	List<String> titlesList=new ArrayList<String>();

	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv=(ListView)findViewById(R.id.listView1);
		lv.setOnItemClickListener(this);
		ArrayAdapter<String> ca=new ArrayAdapter<String>(this,R.layout.item,R.id.textView1,titlesList);
		lv.setAdapter(ca);
	}

	class EartquakeReciever extends BroadcastReceiver
	{
		@Override
		public void onReceive(Context context, Intent intent) 
		{
			EarthquakeDBHelper dbHelper=new EarthquakeDBHelper(MainActivity.this, 1);
			SQLiteDatabase db=dbHelper.getWritableDatabase();
			Cursor cur=db.query(EarthquakeDBHelper.TBL_NAME, null, null,null,null,null,null);

			if(cur.moveToLast())
			{
				do
				{
					titlesList.add(cur.getString(cur.getColumnIndex("title")));
				}while(cur.moveToPrevious());
			}

		}

	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) 
	{
		Intent displayIntent = new Intent(MainActivity.this,DisplayActivity.class);
		TextView tv=(TextView)findViewById(v.getId());
		String selectedItemText=tv.getText().toString();

		EarthquakeDBHelper dbHelper=new EarthquakeDBHelper(MainActivity.this, 1);
		SQLiteDatabase db=dbHelper.getWritableDatabase();
		Cursor cur=db.query(EarthquakeDBHelper.TBL_NAME, null, null,null,null,null,null);

		cur.moveToFirst();
		do
		{
			String title=cur.getString(cur.getColumnIndex("title"));
			if(selectedItemText.equals(title))
			{
				break;
			}
		}while(cur.moveToNext());

		String id=cur.getString(cur.getColumnIndex("id"));
		String update=cur.getString(cur.getColumnIndex("update"));
		String link=cur.getString(cur.getColumnIndex("link"));
		String georss=cur.getString(cur.getColumnIndex("georss"));
		String category=cur.getString(cur.getColumnIndex("category"));

		displayIntent.putExtra("title", selectedItemText);
		displayIntent.putExtra("id", id);
		displayIntent.putExtra("update", update);
		displayIntent.putExtra("link", link);
		displayIntent.putExtra("georss", georss);
		displayIntent.putExtra("category", category);

		startActivity(displayIntent);
	}	
}

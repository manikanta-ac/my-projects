package com.example.earthquake;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;

public class EarthquakeService extends Service 
{
	AlarmManager alarmManager;	
	PendingIntent alarmIntent;

	@Override
	public void onCreate() 
	{
		Log.i("EQMS", "Service started");
		EarthquakeDBHelper dbhelper=new EarthquakeDBHelper(getBaseContext(),1);

		/*alarmManager=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
		Intent intentToFire = new Intent("com.example.earthquake.action.ALARM_ACTION");
		alarmIntent = PendingIntent.getBroadcast(this, 0, intentToFire, 0);*/

		super.onCreate();
	}

	@Override
	public void onDestroy() 
	{
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		PopulateTask pt= new PopulateTask();
		pt.execute();

		return super.onStartCommand(intent, flags, startId);
	}

	class PopulateTask extends AsyncTask<Void, Void, Void> 
	{
		@Override
		protected Void doInBackground(Void... params)
		{
			try
			{
				Log.i("EQMS", "do in background started");
				//URL url = new URL("http://earthquake.usgs.gov/eqcenter/catalogs/1day-M2.5.xml");
				URL url = new URL("http://10.0.2.2:8080/earthquake.xml");
				URLConnection connection;
				connection = url.openConnection();
				HttpURLConnection httpConnection = (HttpURLConnection) connection;
				int responseCode = httpConnection.getResponseCode();
				Log.i("EQMS", "connecton success");
				if (responseCode == HttpURLConnection.HTTP_OK) {

					ContentResolver cr = getContentResolver();

					Uri uri = Uri.parse("content://com.example.earthquake.earthquakecontentprovider");

					cr.delete(uri, null, null);
					Log.i("EQMS", "content deleted");

					InputStream in = httpConnection.getInputStream();
					DocumentBuilderFactory dbf = DocumentBuilderFactory
							.newInstance();
					DocumentBuilder db = dbf.newDocumentBuilder();
					
					// Parse the catalog feed.
					Document dom = db.parse(in);
					Element docEle = dom.getDocumentElement();

					// Get a list of each earthquake entry.
					NodeList nl = docEle.getElementsByTagName("entry");
					Log.i("EQMS", "parsing xml file");
					if (nl != null && nl.getLength() > 0)
					{
						for (int i = 0; i < nl.getLength(); i++)
						{
							Element entry=(Element) nl.item(i);

							Element id=(Element) entry.getElementsByTagName("id").item(0);
							Element title=(Element) entry.getElementsByTagName("title").item(0);
							Element updated=(Element) entry.getElementsByTagName("updated").item(0);
							Element link=(Element) entry.getElementsByTagName("link").item(0);
							Element georssPoint=(Element) entry.getElementsByTagName("georss:point").item(0);
							Element catogery=(Element) entry.getElementsByTagName("category").item(0);
							Element summary=(Element)entry.getElementsByTagName("summary").item(0);

							String id_value=id.getFirstChild().getNodeValue();
							String title_value=title.getFirstChild().getNodeValue();					
							String updated_value=updated.getFirstChild().getNodeValue();
							String link_value=link.getAttribute("href");
							String georssPoint_value=georssPoint.getFirstChild().getNodeValue();
							String catogery_value=catogery.getAttribute("label");
							String summary_val=summary.getFirstChild().getNodeValue();
							String summary_val1="<body bgcolor='black'><font color='white'>"+summary_val+"</font></body>";
							ContentValues cv = new ContentValues();

							cv.put("id", id_value);
							cv.put("title", title_value);
							cv.put("updated", updated_value);
							cv.put("link", link_value);
							cv.put("georss", georssPoint_value);
							cv.put("category", catogery_value);
							cv.put("summary", summary_val1);

							cr.insert(uri, cv);											

						}
						Log.i("EQMS", "database updated");

						Intent intent = new Intent("com.example.earthquake.reciever.EARTHQUAKE_RECIEVER");
						sendBroadcast(intent);
						Log.i("EQMS", "broadcast fired");
					}
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

	}

	@Override
	public IBinder onBind(Intent arg0) 
	{
		return null;
	}

}

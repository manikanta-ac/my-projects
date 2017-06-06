package com.example.earthquake;

import java.util.ArrayList;
import java.util.Iterator;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;

public class EarthquakeMapActivity extends MapActivity 
{
	MapView mapView;
	double latitude;
	double longitude;

	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		Log.i("EQMS", "Map View Activity Started");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapview);
		mapView = (MapView)findViewById(R.id.mapView1);
		mapView.setBuiltInZoomControls(true);

		Log.i("EQMS", "MapView has been Set");
		Drawable marker=getResources().getDrawable(R.drawable.marker);
		marker.setBounds( (int) (-marker.getIntrinsicWidth()/2),-marker.getIntrinsicHeight(),(int) (marker.getIntrinsicWidth()/2), 0);
		latitude=Double.parseDouble(getIntent().getStringExtra("latitude"));
		longitude=Double.parseDouble(getIntent().getStringExtra("longitude"));
		
		EarthquakeLocation earthquakeLocation = new EarthquakeLocation(marker);

		mapView.getOverlays().add(earthquakeLocation);
		GeoPoint pt=earthquakeLocation.getCenterPt();
		
		/*int latSpan = earthquakeLocation.getLatSpanE6();
		int lonSpan = earthquakeLocation.getLonSpanE6();

		Log.v("Overlays", "Lat span is " + latSpan);
		Log.v("Overlays", "Lon span is " + lonSpan);*/

		MapController mc = mapView.getController();

		mc.setCenter(pt);
		
		mc.zoomToSpan((int)(latitude*1000000*0.1), (int)(longitude*1000000*0.1));
	}

	@Override
	protected boolean isLocationDisplayed() {
		return false;
	}

	@Override
	protected boolean isRouteDisplayed() {
		return true;
	}

	class EarthquakeLocation extends ItemizedOverlay<OverlayItem> 
	{
		private GeoPoint center = null;
		private ArrayList<OverlayItem> locations = new ArrayList<OverlayItem>();

		public EarthquakeLocation(Drawable marker)
		{
			super(marker);
			
			GeoPoint pt =  new GeoPoint((int)(latitude*1000000),(int)(longitude*1000000));

			locations.add(new OverlayItem(pt ,"Magic Kingdom", "Magic Kingdom"));
			populate();
		}

		public GeoPoint getCenterPt() 
		{
			if(center == null)
			{
				int northEdge = -90000000; // i.e., -90E6 microdegrees
				int southEdge = 90000000;
				int eastEdge = -180000000;
				int westEdge = 180000000;
				Iterator<OverlayItem> iter = locations.iterator();

				while(iter.hasNext()) 
				{
					GeoPoint pt = iter.next().getPoint();
					
					if(pt.getLatitudeE6() > northEdge)
						northEdge = pt.getLatitudeE6();
					if(pt.getLatitudeE6() < southEdge) 
						southEdge = pt.getLatitudeE6();
					if(pt.getLongitudeE6() > eastEdge)
						eastEdge = pt.getLongitudeE6();
					if(pt.getLongitudeE6() < westEdge)
						westEdge = pt.getLongitudeE6();
				}
				center = new GeoPoint((int)((northEdge +southEdge)/2),(int)((westEdge + eastEdge)/2));
			}
			return center;
		}

		public void draw(Canvas canvas, MapView mapView, boolean shadow)
		{
			shadow = false;
			super.draw(canvas, mapView, shadow);
		}

		@Override
		protected OverlayItem createItem(int i) 
		{
			return locations.get(i);
		}

		@Override
		public int size() 
		{
			return locations.size();
		}
	}
}

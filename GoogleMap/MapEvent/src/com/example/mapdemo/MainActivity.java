package com.example.mapdemo;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerDragListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {
	
	private GoogleMap mMap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
		mMap.setOnMapClickListener(new OnMapClickListener() {
			
			@Override
			public void onMapClick(LatLng latlng) {
				addMarker(latlng);
			}
		});
		mMap.setOnMapLongClickListener(new OnMapLongClickListener() {
			
			@Override
			public void onMapLongClick(LatLng latlng) {
				Toast.makeText(MainActivity.this, "長按地圖: " + latlng.latitude + "," + latlng.longitude, Toast.LENGTH_SHORT).show();
			}
		});
		mMap.setOnMarkerDragListener(new OnMarkerDragListener() {
			
			@Override
			public void onMarkerDragStart(Marker marker) {
				
			}
			
			@Override
			public void onMarkerDragEnd(Marker marker) {
				Toast.makeText(MainActivity.this, "將marker放在: " + marker.getPosition(), Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void onMarkerDrag(Marker marker) {
				
			}
		});
		mMap.setOnMarkerClickListener(new OnMarkerClickListener() {
			
			@Override
			public boolean onMarkerClick(Marker marker) {
				String snippet = marker.getSnippet();
				Toast.makeText(MainActivity.this, "點到marker: " + snippet, Toast.LENGTH_SHORT).show();
				
				marker.remove();
				return true;
			}
		});
		
		
		setDefaultCamera();
		addMarker(new LatLng(24.99016, 121.54539));
	}
	
	private void setDefaultCamera() {
		CameraUpdate update = CameraUpdateFactory.newLatLngZoom(new LatLng(24.99016, 121.54539), 15.f);
		mMap.animateCamera(update);
	}
	
	private void addMarker(LatLng latlng) {
		MarkerOptions marker = new MarkerOptions();
		marker.position(latlng);
		marker.title(latlng.latitude + "," + latlng.longitude);
		marker.snippet("You are click " + latlng);
		marker.draggable(true);
		BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.pin);
		marker.icon(icon);
		mMap.addMarker(marker);
	}
	
}

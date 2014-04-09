package com.example.mapdemo;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class MainActivity extends FragmentActivity {
	
	private GoogleMap mMap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mMap = ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
		
		CameraPosition pos = new CameraPosition(new LatLng(25.04188, 121.53309), 19.f, 75.0f, 0f);
		CameraUpdate initialize = CameraUpdateFactory.newCameraPosition(pos);
		mMap.moveCamera(initialize);
		
		CheckBox building = (CheckBox) findViewById(R.id.building);
		building.setChecked(mMap.isBuildingsEnabled());
		building.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean checked) {
				mMap.setBuildingsEnabled(checked);
			}
		});
		
		CheckBox traffic = (CheckBox) findViewById(R.id.traffic);
		traffic.setChecked(mMap.isTrafficEnabled());
		traffic.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mMap.setTrafficEnabled(isChecked);
			}
		});
		
		CheckBox indoor = (CheckBox) findViewById(R.id.indoor);
		indoor.setChecked(mMap.isIndoorEnabled());
		indoor.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mMap.setIndoorEnabled(isChecked);
			}
		});
		
		Button indoorExample = (Button) findViewById(R.id.btn_indoor_example);
		indoorExample.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				CameraUpdate update = CameraUpdateFactory.newLatLngZoom(new LatLng(37.614631, -122.385153), 18.f);
				mMap.moveCamera(update);
			}
		});
	}

}

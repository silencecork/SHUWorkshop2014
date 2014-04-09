package com.example.mapdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		GoogleMap map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
		
		map.setMyLocationEnabled(true);
		
		MarkerOptions options = new MarkerOptions();
		
		options.position(new LatLng(24.989926, 121.545414));
		
		options.title("�@�s�j��");
		
		options.snippet("�x�_����s�ϸհ|��154��1��7��");
		
		map.addMarker(options);
	}

}

package com.example.mapdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity implements OnClickListener {
	
	private LatLng mShihHsinUniversityLocation = new LatLng(24.989926, 121.545414);
	private GoogleMap mMap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
		Button goToShihHsin = (Button) findViewById(R.id.button1);
		goToShihHsin.setOnClickListener(this);
		mMap.setMyLocationEnabled(true);
		MarkerOptions options = new MarkerOptions();
		options.position(mShihHsinUniversityLocation);
		options.title("�@�s�j��");
		options.snippet("�x�_����s�ϸհ|��154��1��7��");
		mMap.addMarker(options);
	}

	@Override
	public void onClick(View v) {
		CameraPosition cameraPosition = new CameraPosition.Builder().zoom(15.5f).target(mShihHsinUniversityLocation).build();
		CameraUpdate update = CameraUpdateFactory.newCameraPosition(cameraPosition);
		mMap.animateCamera(update);
	}

}

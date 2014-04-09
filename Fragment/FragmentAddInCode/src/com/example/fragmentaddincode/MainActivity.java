package com.example.fragmentaddincode;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

public class MainActivity extends FragmentActivity {
	
	private static final String TAG = "LifeCycleFragment";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, "Activity: onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		getSupportFragmentManager().beginTransaction().replace(R.id.root, new SimpleFragment()).commit();
	}
	
	
	@Override
	protected void onRestart() {
		Log.i(TAG, "Activity: onRestart");
		super.onRestart();
	}



	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		Log.i(TAG, "Activity: onRestoreInstanceState");
		super.onRestoreInstanceState(savedInstanceState);
	}



	@Override
	public void onAttachFragment(Fragment fragment) {
		Log.i(TAG, "Activity: onAttachFragment");
		super.onAttachFragment(fragment);
	}



	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		Log.i(TAG, "Activity: onConfigurationChanged");
		super.onConfigurationChanged(newConfig);
	}



	@Override
	protected void onDestroy() {
		Log.i(TAG, "Activity: onDestroy");
		super.onDestroy();
	}



	@Override
	protected void onPause() {
		Log.i(TAG, "Activity: onPause");
		super.onPause();
	}



	@Override
	protected void onPostResume() {
		Log.i(TAG, "Activity: onPostResume");
		super.onPostResume();
	}



	@Override
	protected void onResume() {
		Log.i(TAG, "Activity: onResume");
		super.onResume();
	}



	@Override
	protected void onResumeFragments() {
		Log.i(TAG, "Activity: onResumeFragments");
		super.onResumeFragments();
	}



	@Override
	public Object onRetainCustomNonConfigurationInstance() {
		Log.i(TAG, "Activity: onRetainCustomNonConfigurationInstance");
		return super.onRetainCustomNonConfigurationInstance();
	}



	@Override
	protected void onSaveInstanceState(Bundle outState) {
		Log.i(TAG, "Activity: onSaveInstanceState");
		super.onSaveInstanceState(outState);
	}



	@Override
	protected void onStart() {
		Log.i(TAG, "Activity: onStart");
		super.onStart();
	}



	@Override
	protected void onStop() {
		Log.i(TAG, "Activity: onStop");
		super.onStop();
	}


	

}

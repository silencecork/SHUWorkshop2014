package com.example.activityorientationchange;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Configuration;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private static final String TAG = "MainActivity";

	private int mCount;
	
	private TextView mTextView;
	
	private Button mButtonAddOne;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if (savedInstanceState != null) {
			mCount = savedInstanceState.getInt("count");
		}
		
		mTextView = (TextView) findViewById(R.id.count);
		
		mTextView.setText(String.valueOf(mCount));
		
		mButtonAddOne = (Button) findViewById(R.id.btn_add_one);
		
		mButtonAddOne.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mCount++;
				mTextView.setText(String.valueOf(mCount));
			}
		});
	}
	

	@Override
	protected void onResume() {
		Log.i(TAG, "onResume");
		super.onResume();
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		Log.i(TAG, "onRestoreInstanceState");
		super.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		Log.i(TAG, "onSaveInstanceState");
		super.onSaveInstanceState(outState);
		
		outState.putInt("count", mCount);
	}

}

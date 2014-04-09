package com.example.activityresourcechooser;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private TextView mTextView;
	
	private int mCount;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mTextView = (TextView) findViewById(R.id.count);
		
		if (savedInstanceState != null) {
			mCount = savedInstanceState.getInt("count");
		}
		
		mTextView.setText(String.valueOf(mCount));
		
		Button addButton = (Button) findViewById(R.id.btn_add);
		addButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mCount++;
				mTextView.setText(String.valueOf(mCount));
			}
		});
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		
		outState.putInt("count", mCount);
	}

	
}

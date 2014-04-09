package com.example.serviceupdate;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
	
	private ProgressBar mProgressBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main_layout);
		
		mProgressBar = (ProgressBar) findViewById(R.id.progressBar1);
		
		Button execute = (Button) findViewById(R.id.button1);
		execute.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mProgressBar.setProgress(0);
				mProgressBar.setMax(100);
				Intent intent = new Intent(MainActivity.this, UpdateService.class);
				startService(intent);
			}
		});
		
		IntentFilter filter = new IntentFilter();
		filter.addAction("com.example.serviceupdate.UPDATE");
		registerReceiver(mReceiver, filter);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		unregisterReceiver(mReceiver);
	}

	public BroadcastReceiver mReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context c, Intent intent) {
			int progress = intent.getIntExtra("progress", 0);
			
			mProgressBar.setProgress(progress);
		}
		
	};
	
}

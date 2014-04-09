package com.example.bindservicepassobject;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	private ICalculateService mService;

	private ServiceConnection mConnection = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName arg0) {
			
		}
		
		@Override
		public void onServiceConnected(ComponentName arg0, IBinder arg1) {
			mService = ICalculateService.Stub.asInterface(arg1);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Intent intent = new Intent(MainActivity.this, CalculateService.class);
		bindService(intent, mConnection , Service.BIND_AUTO_CREATE);
		
		Button btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (mService == null) {
					return;
				}
				
				EditText inputOne = (EditText) findViewById(R.id.editText1);
				EditText inputTwo = (EditText) findViewById(R.id.editText2);
				
				String strOne = inputOne.getText().toString();
				String strTwo = inputTwo.getText().toString();
				
				if (TextUtils.isEmpty(strOne)) {
					strOne = "0";
				} 
				if (TextUtils.isEmpty(strTwo)) {
					strTwo = "0";
				}
				
				int one = Integer.parseInt(strOne);
				int two = Integer.parseInt(strTwo);
				
				MyObject obj = new MyObject(one, two);
				
				try {
					mService.showResult(obj);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		unbindService(mConnection);
	}
}

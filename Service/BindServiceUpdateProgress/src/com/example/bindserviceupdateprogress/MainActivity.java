package com.example.bindserviceupdateprogress;
import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;


public class MainActivity extends Activity {
	
	private ProgressBar mProgressBar;
	
	private EditText mMaxInput;
	
	private IUpdateService mService;
	
	private RemoteCallback mCallback = new RemoteCallback() {

		@Override
		public IBinder asBinder() {
			return null;
		}

		@Override
		public void updateProgress(int progress) throws RemoteException {
			mProgressBar.setProgress(progress);
		}
		
	};

	private ServiceConnection mConnection = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName arg0) {
			
		}
		
		@Override
		public void onServiceConnected(ComponentName arg0, IBinder arg1) {
			mService = IUpdateService.Stub.asInterface(arg1);
			try {
				mService.registerCallback(mCallback);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main_layout);
		
		Intent intent = new Intent("com.example.serviceupdate.EXECUTE");
		bindService(intent, mConnection , Service.BIND_AUTO_CREATE);
		
		mProgressBar = (ProgressBar) findViewById(R.id.progressBar1);
		
		mMaxInput = (EditText) findViewById(R.id.editText1);
		
		Button execute = (Button) findViewById(R.id.button1);
		execute.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (mService == null) {
					return;
				}
				
				String strMax = mMaxInput.getText().toString();
				
				int max = Integer.parseInt(strMax);
				mProgressBar.setProgress(0);
				mProgressBar.setMax(max);
				try {
					mService.startExecute(max);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				
			}
		});
		
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		unbindService(mConnection);
	}
	
}

package com.example.startservicebasic;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

public class ShowResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		NotificationManager mgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		mgr.cancel(100);
		
		String notificationText = getIntent().getStringExtra("text");
		
		Toast.makeText(this, notificationText, Toast.LENGTH_LONG).show();
	}

}

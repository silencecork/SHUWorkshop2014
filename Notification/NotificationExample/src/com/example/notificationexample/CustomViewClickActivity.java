package com.example.notificationexample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class CustomViewClickActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Toast.makeText(this, "«ö¶s«ö¤U¥h¤F", Toast.LENGTH_LONG).show();
		
		finish();
	}

}

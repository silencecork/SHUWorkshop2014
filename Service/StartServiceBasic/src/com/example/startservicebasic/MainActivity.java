package com.example.startservicebasic;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText input = (EditText) findViewById(R.id.editText1);
				String message = input.getText().toString();
				
				Intent intent = new Intent("com.example.intent.START_SERVICE");
				intent.putExtra("text", message);
				startService(intent);
			}
		});
	}

	

}

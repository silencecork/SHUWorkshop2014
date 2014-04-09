package com.example.servicepassobject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
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
				
				Intent intent = new Intent(MainActivity.this, CalculateService.class);
				intent.putExtra("object", obj);
				
				startService(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

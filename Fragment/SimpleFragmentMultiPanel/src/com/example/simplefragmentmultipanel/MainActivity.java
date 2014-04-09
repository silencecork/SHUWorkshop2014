package com.example.simplefragmentmultipanel;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends FragmentActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
			getSupportFragmentManager().beginTransaction().replace(R.id.fragment1, new Fragment1()).commit();
			getSupportFragmentManager().beginTransaction().replace(R.id.fragment2, new Fragment2()).commit();
		} else {
			getSupportFragmentManager().beginTransaction().replace(R.id.fragment1, new Fragment1()).commit();
			Button button = (Button) findViewById(R.id.btn_next);
			button.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(MainActivity.this, SecondActivity.class);
					startActivity(intent);
				}
			});
		}
	}


}

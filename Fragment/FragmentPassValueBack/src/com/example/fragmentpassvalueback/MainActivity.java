package com.example.fragmentpassvalueback;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new FragmentOne(), "One").commit();
	}

}

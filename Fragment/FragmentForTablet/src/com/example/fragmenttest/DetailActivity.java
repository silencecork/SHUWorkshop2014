package com.example.fragmenttest;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class DetailActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
			finish();
			return;
		}
		
		setContentView(R.layout.activity_detail);
		
		Detail detail = new Detail();
		
		Bundle bundle = new Bundle();
		
		int index = getIntent().getExtras().getInt("index");
		
		bundle.putInt("index", index);
		
		detail.setArguments(bundle);
		
		getSupportFragmentManager().beginTransaction().replace(R.id.right, detail, "Detail").commit();
	}
	

}

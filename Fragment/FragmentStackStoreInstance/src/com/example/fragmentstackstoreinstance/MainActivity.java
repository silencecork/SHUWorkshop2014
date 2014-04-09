package com.example.fragmentstackstoreinstance;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends FragmentActivity {
	
	private int mInstanceCount;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if (savedInstanceState == null) {
			createInstance(false);
		}
		
		Button button = (Button) findViewById(R.id.btn_add);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				createInstance(true);
			}
		});
	}

	private void createInstance(boolean addToStack) {
		mInstanceCount++;
		StackFragment fragment = new StackFragment();
		Bundle data = new Bundle();
		data.putInt("count", mInstanceCount);
		fragment.setArguments(data);
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction().add(R.id.content, fragment);
		if (addToStack) {
			transaction.addToBackStack(null);
		}
		transaction.commit();
	}

}

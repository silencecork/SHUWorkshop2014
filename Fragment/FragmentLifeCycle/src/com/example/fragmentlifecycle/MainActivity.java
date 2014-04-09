package com.example.fragmentlifecycle;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends FragmentActivity {
	
	private static final String TAG = "LifeCycleFragment";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, "Activity: onCreate");
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
		
		getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new LifeCycleFragment()).commit();
	}
	
	@Override
	protected void onStart() {
		Log.i(TAG, "Activity: onStart");
		super.onStart();
	}
	
	@Override
	protected void onResume() {
		Log.i(TAG, "Activity: onResume");
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		Log.i(TAG, "Activity: onPause");
		super.onPause();
	}
	
	@Override
	protected void onStop() {
		Log.i(TAG, "Activity: onStop");
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		Log.i(TAG, "Activity: onDestroy");
		super.onDestroy();
	}


	public static class LifeCycleFragment extends Fragment {

		@Override
		public void onAttach(Activity activity) {
			Log.i(TAG, "Fragment LifeCycle: onAttach");
			super.onAttach(activity);
		}

		@Override
		public void onCreate(Bundle savedInstanceState) {
			Log.i(TAG, "Fragment LifeCycle: onCreate");
			super.onCreate(savedInstanceState);
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			Log.i(TAG, "Fragment LifeCycle: onCreateView");
			return inflater.inflate(R.layout.activity_main, null);
		}
		
		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			Log.i(TAG, "Fragment LifeCycle: onActivityCreated");
			super.onActivityCreated(savedInstanceState);
		}
		
		@Override
		public void onStart() {
			Log.i(TAG, "Fragment LifeCycle: onStart");
			super.onStart();
		}
		
		@Override
		public void onResume() {
			Log.i(TAG, "Fragment LifeCycle: onResume");
			super.onResume();
		}
		
		@Override
		public void onPause() {
			Log.i(TAG, "Fragment LifeCycle: onPause");
			super.onPause();
		}
		
		@Override
		public void onStop() {
			Log.i(TAG, "Fragment LifeCycle: onStop");
			super.onStop();
		}
		
		@Override
		public void onDestroyView() {
			Log.i(TAG, "Fragment LifeCycle: onDestroyView");
			super.onDestroyView();
		}

		@Override
		public void onDestroy() {
			Log.i(TAG, "Fragment LifeCycle: onDestroy");
			super.onDestroy();
		}

		@Override
		public void onDetach() {
			Log.i(TAG, "Fragment LifeCycle: onDetach");
			super.onDetach();
		}
		
	}

}

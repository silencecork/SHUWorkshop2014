package com.example.fragmentaddinlayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SimpleFragment extends Fragment {

	private static final String TAG = "LifeCycleFragment";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, "Fragment LifeCycle: onCreate");
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i(TAG, "Fragment LifeCycle: onCreateView");
		return inflater.inflate(R.layout.fragment_layout, null);
	}

}
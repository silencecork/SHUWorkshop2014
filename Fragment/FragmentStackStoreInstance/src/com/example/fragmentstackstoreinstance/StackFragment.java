package com.example.fragmentstackstoreinstance;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class StackFragment extends Fragment {
	
	private int mCount;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_layout, null);
		if (savedInstanceState == null) {
			Bundle bundle = getArguments();
			mCount = bundle.getInt("count");
		} else {
			mCount = savedInstanceState.getInt("fragment_text");
		}
		
		TextView countView = (TextView) v.findViewById(R.id.count);
		countView.setText(String.valueOf(mCount));
		
		return v;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		
		outState.putInt("fragment_text", mCount);
	}
	
	

}

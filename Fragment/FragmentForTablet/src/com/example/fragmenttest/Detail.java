package com.example.fragmenttest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Detail extends Fragment {
	
	private TextView text;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		text = new TextView(getActivity());
		text.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
		text.setTextSize(30);
		return text;
	}

	@Override
	public void onResume() {
		super.onResume();
		
		Bundle bundle = getArguments();
		int index = bundle.getInt("index");
		text.setText(Shakespeare.DIALOGUE[index]);
	}
	
	

}

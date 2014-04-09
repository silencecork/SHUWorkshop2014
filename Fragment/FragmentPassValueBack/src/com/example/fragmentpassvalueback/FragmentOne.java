package com.example.fragmentpassvalueback;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentOne extends Fragment {
	
	private TextView mResult;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_one, null);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		mResult = (TextView) getActivity().findViewById(R.id.result);
		Button changeToNext = (Button) getActivity().findViewById(R.id.btn_next);
		changeToNext.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				getFragmentManager().beginTransaction().add(android.R.id.content, new FragmentTwo()).addToBackStack(null).commit();
			}
		});
	}

	public void setResult(String value) {
		mResult.setText(value);
	}
	
}

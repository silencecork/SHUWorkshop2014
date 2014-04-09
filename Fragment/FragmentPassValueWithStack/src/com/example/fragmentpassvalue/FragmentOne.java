package com.example.fragmentpassvalue;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentOne extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_one, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		Button changeToNextButton = (Button) getActivity().findViewById(R.id.btn_change);
		changeToNextButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText input = (EditText) getActivity().findViewById(R.id.input);
				FragmentTwo two = new FragmentTwo();
				String value = input.getText().toString();
				Bundle data = new Bundle();
				data.putString("value", value);
				two.setArguments(data);
				getFragmentManager().beginTransaction().replace(android.R.id.content, two).addToBackStack(null).commit();
			}
		});
	}
	
	
	
}

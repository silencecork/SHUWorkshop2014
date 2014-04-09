package com.example.fragmentpassvalueback;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentTwo extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_two, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Button changeBackToPrev = (Button) getActivity().findViewById(R.id.btn_back);
		changeBackToPrev.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText input = (EditText) getActivity().findViewById(R.id.input);
				String strContent = input.getText().toString();
				FragmentOne oneFragment = (FragmentOne) getFragmentManager().findFragmentByTag("One");
				oneFragment.setResult(strContent);
				getFragmentManager().popBackStack();
			}
		});
	}
	
}

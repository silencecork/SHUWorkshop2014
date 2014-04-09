package com.example.fragmenttest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListOptionFragment extends ListFragment {

	private int mPosition = -1;

	public ListOptionFragment() {
		super();
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		setListAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1,
				Shakespeare.TITLES));
		if (savedInstanceState != null) {
			mPosition = savedInstanceState.getInt("current_pos");
			showDetail();
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

		outState.putInt("current_pos", mPosition);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		mPosition = position;
		showDetail();
	}

	private void showDetail() {
		if (mPosition < 0) {
			return;
		}
		Bundle bundle = new Bundle();
		bundle.putInt("index", mPosition);
		if (getActivity().findViewById(R.id.right) != null) {
			Detail detail = new Detail();
			detail.setArguments(bundle);
			getActivity().findViewById(R.id.right).setVisibility(View.VISIBLE);
			getFragmentManager().beginTransaction()
					.replace(R.id.right, detail, "Detail")
					.commit();
		} else {
			Intent intent = new Intent(getActivity(), DetailActivity.class);
			intent.putExtras(bundle);
			getActivity().startActivity(intent);
		}
	}

}
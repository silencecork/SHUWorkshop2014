package com.example.twosidenavigationdrawer;

import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	
	private DrawerLayout mDrawerLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		
		getSupportFragmentManager().beginTransaction().replace(R.id.left_menu_root, new Menu()).commit();
		getSupportFragmentManager().beginTransaction().replace(R.id.right_menu_root, new RightMenu()).commit();
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, 0, 0) {

			@Override
			public void onDrawerClosed(View drawerView) {
				Toast.makeText(MainActivity.this, "Drawer closed", Toast.LENGTH_SHORT).show();
			}
			@Override
			public void onDrawerOpened(View drawerView) {
				Toast.makeText(MainActivity.this, "Drawer open", Toast.LENGTH_SHORT).show();
			}
		};
		mDrawerLayout.setDrawerListener(drawerToggle);
		drawerToggle.syncState();
	}
	
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
	    getMenuInflater().inflate(R.menu.main, menu);
	    
	    return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			mDrawerLayout.closeDrawer(Gravity.RIGHT);
			if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
				mDrawerLayout.closeDrawer(Gravity.LEFT);
			} else {
				mDrawerLayout.openDrawer(Gravity.LEFT);
			}
			return true;
		} else if (item.getItemId() == R.id.action_settings) {
			mDrawerLayout.closeDrawer(Gravity.LEFT);
			if (mDrawerLayout.isDrawerOpen(Gravity.RIGHT)) {
				mDrawerLayout.closeDrawer(Gravity.RIGHT);
			} else {
				mDrawerLayout.openDrawer(Gravity.RIGHT);
			}
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public static class Menu extends Fragment implements OnItemClickListener {
		
		private static final String[] MENU = {"earth", "jupiter", "mars", "mercury", "neptune", "saturn", "uranus", "venus"};
		private static final int[] MENU_ICON = {R.drawable.earth, R.drawable.jupiter, R.drawable.mars, R.drawable.mercury, R.drawable.neptune, R.drawable.saturn, R.drawable.uranus, R.drawable.venus};
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			ListView list = (ListView) inflater.inflate(R.layout.menu_layout, null);
			
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, MENU);
			list.setAdapter(adapter);
			list.setOnItemClickListener(this);
			
			return list;
		}

		@Override
		public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {
			changeContent(pos);
		}
		
		private void changeContent(int position) {
			int menuIconResId = MENU_ICON[position];
			Content content = new Content();
			Bundle data = new Bundle();
			data.putInt("res", menuIconResId);
			content.setArguments(data);
			
			getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content, content).commit();
			
			DrawerLayout drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
			
			drawer.closeDrawer(Gravity.LEFT);
		}
	}
	
	public static class Content extends Fragment {

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			Bundle data = getArguments();
			int iconResId = data.getInt("res");
			View v = inflater.inflate(R.layout.content_layout, null);
			
			ImageView image = (ImageView) v.findViewById(R.id.content_image);
			image.setImageResource(iconResId);
			
			return v;
		}
		
	}
	
	public static class RightMenu extends Fragment implements OnItemClickListener {
		
		private static final String[] MENU = {"sun", "galaxy", "comet"};
		private static final int[] MENU_ICON = {R.drawable.sun, R.drawable.galaxy, R.drawable.comet};
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			ListView list = (ListView) inflater.inflate(R.layout.menu_layout, null);
			
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, MENU);
			list.setAdapter(adapter);
			list.setOnItemClickListener(this);
			
			return list;
		}

		@Override
		public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {
			changeContent(pos);
		}
		
		private void changeContent(int position) {
			int menuIconResId = MENU_ICON[position];
			Content content = new Content();
			Bundle data = new Bundle();
			data.putInt("res", menuIconResId);
			content.setArguments(data);
			
			getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content, content).commit();
			
			DrawerLayout drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
			
			drawer.closeDrawer(Gravity.RIGHT);
		}
	}
}

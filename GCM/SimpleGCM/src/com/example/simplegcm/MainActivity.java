package com.example.simplegcm;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;

public class MainActivity extends Activity {
	
	private GoogleCloudMessaging mGcm;
	private static final String SENDER_ID = "YOUR-SENDER-ID";
	private static final String PREF_REGISTRATION = "registration_prefs";
	private static final String PREF_KEY_REGISTRATION_ID = "registration_id";
	private ProgressDialog mProgress;
	private static final String REGISTER_URL = "YOUR-REGISTER-URL";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
	    if (resultCode != ConnectionResult.SUCCESS) {
	    	Toast.makeText(this, "你的裝置不支援GCM", Toast.LENGTH_LONG).show();
	    	return;
	    }
		mProgress = new ProgressDialog(this);
		mProgress.setMessage("註冊中，請稍等...");
		mGcm = GoogleCloudMessaging.getInstance(this);
		String registrationId = getRegistrationId();
		if (TextUtils.isEmpty(registrationId)) {
			registrationInBackground();
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
		
		NotificationManager mgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		mgr.cancelAll();
	}
	
	private void registrationInBackground() {
		AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
			@Override
			protected void onPreExecute() {
				mProgress.show();
			}
			@Override
			protected Void doInBackground(Void... params) {
				try {
					String registrationId = mGcm.register(SENDER_ID);
					sendRegistrationToBackend(registrationId);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
			}
			@Override
			protected void onPostExecute(Void result) {
				mProgress.dismiss();
			}
		};
		task.execute();
	}
	
	private String getRegistrationId() {
		SharedPreferences prefs = getSharedPreferences(PREF_REGISTRATION, Context.MODE_PRIVATE);
		return prefs.getString(PREF_KEY_REGISTRATION_ID, null);
	}
	
	private void saveRegistrationId(String id) {
		SharedPreferences prefs = getSharedPreferences(PREF_REGISTRATION, Context.MODE_PRIVATE);
		prefs.edit().putString(PREF_KEY_REGISTRATION_ID, id).commit();
	}
	
	private void sendRegistrationToBackend(String id) {
		Log.d("GCM", "registration id " + id);
		HttpURLConnection conn = null;
		InputStream in = null;
		try {
			URL url = new URL(REGISTER_URL + id);
			conn = (HttpURLConnection) url.openConnection();
			in = conn.getInputStream();
			String result = streamToString(in);
			JSONObject json = new JSONObject(result);
			String resultCode = json.getString("result");
			if ("00".equals(resultCode)) {
				saveRegistrationId(id);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} finally {
			if (conn != null){
				conn.disconnect();
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private String streamToString(InputStream in) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    byte[] buffer = new byte[1024];
	    int length = 0;
	    while ((length = in.read(buffer)) != -1) {
	        baos.write(buffer, 0, length);
	    }
	    return new String(baos.toByteArray(), "UTF-8");
	}
}

package com.example.broadcastbyprogramming;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context c, Intent intent) {
		String action = intent.getAction();
		Log.i("Receiver", action);
		if ("com.example.broadcast.MAIN".equals(action)) {
			String text = intent.getStringExtra("text");
			Toast.makeText(c, text, Toast.LENGTH_LONG).show();
		} else {
			showNotification(c, action);
		}
	}
	
	private void showNotification(Context context, String action) {
		NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
		.setSmallIcon(android.R.drawable.stat_notify_voicemail)
		.setTicker(action)
		.setContentTitle(action);
		
		NotificationManager mgr = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		mgr.notify(action.hashCode(), builder.build());
	}

}

package com.example.broadcaststartactivity;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class Receiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context c, Intent intent) {
		String action = intent.getAction();
		showNotification(c, action);
		Intent startActivityIntent = new Intent(c, MainActivity.class);
		startActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		c.startActivity(startActivityIntent);
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

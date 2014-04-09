package com.example.simplegcm;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

public class GcmIntentService extends IntentService {

	public GcmIntentService() {
		super("GcmIntentService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);
		String messageType = gcm.getMessageType(intent);
		if (messageType.equals(GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR)) {
			showNotification("receive error");
		} else if (messageType.equals(GoogleCloudMessaging.MESSAGE_TYPE_DELETED)) {
			showNotification("message deleted");
		} else if (messageType.equals(GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE)) {
			Bundle extras = intent.getExtras();
			String message = extras.getString("message");
			showNotification(message);
		}
	}
	
	private void showNotification(String message) {
		NotificationManager mgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		
		Intent intent = new Intent(this, MainActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
		
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		builder.setTicker("收到一則新訊息")
		.setSmallIcon(android.R.drawable.stat_notify_chat)
		.setContentIntent(pendingIntent)
		.setContentText("訊息內容")
		.setContentText(message);
		mgr.notify(100, builder.build());
	}
	
}

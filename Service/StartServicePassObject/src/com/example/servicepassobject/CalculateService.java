package com.example.servicepassobject;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class CalculateService extends IntentService {

	public CalculateService() {
		super("CalculateService");
	}
	
	@Override
	public void onCreate() {
		Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
		super.onCreate();
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		MyObject obj = intent.getParcelableExtra("object");
		int result = obj.getResult();
		
		showNotification("result is " + result);
	}
	
	private void showNotification(CharSequence text) {
		Intent intent = new Intent(this, ClearNotificationBroadcast.class);
		intent.putExtra("text", text);
		
        PendingIntent contentIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
		
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		builder.setSmallIcon(android.R.drawable.stat_notify_chat)
		.setTicker("你有一則新訊息")
		.setContentTitle("New Message")
		.setContentText(text)
		.setContentIntent(contentIntent);
		
        NotificationManager mgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mgr.cancel(100);
        mgr.notify(100, builder.build());
    }

	@Override
	public void onDestroy() {
		Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show();
		super.onDestroy();
	}
}

package com.example.startservicebasic;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class SimpleService extends IntentService {
	
	public SimpleService() {
		super("SimpleService");
	}

	@Override
	public void onCreate() {
		Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
		super.onCreate();
	}
	
	private void showNotification(CharSequence text) {
		Intent intent = new Intent(this, ShowResultActivity.class);
		intent.putExtra("text", text);
		
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
		
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		builder.setSmallIcon(R.drawable.stat_neutral)
		.setTicker("你有一則新訊息")
		.setContentTitle("New Message")
		.setContentText(text)
		.setContentIntent(contentIntent);
		
        NotificationManager mgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mgr.cancel(100);
        mgr.notify(100, builder.build());
    }

	@Override
	protected void onHandleIntent(Intent intent) {
		String strMsgToShow = intent.getStringExtra("text");
		
		strMsgToShow = "Service負責顯示" + strMsgToShow;
		
		for (int i = 0; i < 10; i++) {
			showNotification(strMsgToShow);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void onDestroy() {
		Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show();
		super.onDestroy();
	}

}

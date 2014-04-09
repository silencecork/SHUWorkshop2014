package com.example.serviceupdate;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;
import android.widget.Toast;

public class UpdateService extends IntentService {
	
	private NotificationCompat.Builder builder;

	public UpdateService() {
		super("UpdateService");
	}
	
	@Override
	public void onCreate() {
		Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
		super.onCreate();
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		
		int currentProgress = 0;
		while (currentProgress < 100) {
			currentProgress++;
			Intent updateIntent = new Intent("com.example.serviceupdate.UPDATE");
			updateIntent.putExtra("progress", currentProgress);
			sendBroadcast(updateIntent);
			
			showNotification(currentProgress);
			
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private void showNotification(int progress) {
		Intent intent = new Intent(this, MainActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification;
        
        if (builder == null) {
        	builder = new NotificationCompat.Builder(this);
        }
        
		builder.setContentIntent(contentIntent);
		
		if (progress < 100) {
			if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
				RemoteViews views = new RemoteViews(getPackageName(), R.layout.update_progress);
				views.setProgressBar(R.id.progress_bar, 100, progress, false);
				views.setTextViewText(R.id.progress, "已經執行了" + progress + "%");
				notification = builder.build();
				notification.contentView = views;
			} else {
				builder.setContentTitle("已經執行了" + progress + "%")
				.setProgress(100, progress, false)
				.setSmallIcon(android.R.drawable.stat_sys_upload).setOngoing(true);
				notification = builder.build();
			}
		} else {
			builder
			.setSmallIcon(android.R.drawable.stat_sys_upload_done)
			.setOngoing(false)
			.setContentTitle("執行完成");
			notification = builder.build();
		}
        NotificationManager mgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mgr.notify(100, notification);
    }

	@Override
	public void onDestroy() {
		Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show();
		super.onDestroy();
	}
}

package com.example.bindservicebasic;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class SimpleService extends Service {
	
	@Override
	public void onCreate() {
		Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
		super.onCreate();
	}
	
	@Override
	public IBinder onBind(Intent arg0) {
		return new IRemoteService.Stub() {
			
			@Override
			public void passValue(String val) throws RemoteException {
				showNotification(val);
			}
		};
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
	public boolean onUnbind(Intent intent) {
		Toast.makeText(this, "onUnbind", Toast.LENGTH_LONG).show();
		return super.onUnbind(intent);
	}

	@Override
	public void onDestroy() {
		Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show();
		super.onDestroy();
	}
}

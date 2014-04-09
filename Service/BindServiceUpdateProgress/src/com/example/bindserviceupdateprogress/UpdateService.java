package com.example.bindserviceupdateprogress;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class UpdateService extends Service {
	
	private RemoteCallback mCallback;
	private boolean mIsStop;
	
	public UpdateService() {
		super();
	}
	
	@Override
	public void onCreate() {
		Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
		super.onCreate();
	}

	private void showNotification(CharSequence progress) {
		Intent intent = new Intent(this, MainActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
		
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		builder.setSmallIcon(android.R.drawable.stat_notify_more)
		.setTicker("你有一則新訊息")
		.setContentTitle("執行狀況")
		.setContentText("已經執行了" + progress)
		.setContentIntent(contentIntent);
		
		Notification notification = builder.build();
        notification.flags = Notification.FLAG_AUTO_CANCEL;
        NotificationManager mgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mgr.notify(100, notification);
    }

	@Override
	public IBinder onBind(Intent arg0) {
		return new IUpdateService.Stub() {
			
			@Override
			public void startExecute(int max) throws RemoteException {
				AsyncTask<Integer, Integer, Void> task = new AsyncTask<Integer, Integer, Void>() {

					@Override
					protected Void doInBackground(Integer... params) {
						int max = params[0];
						int currentProgress = 0;
						while (currentProgress < max && !mIsStop) {
							currentProgress++;
							publishProgress(currentProgress);
							
							if (currentProgress % 10 == 0) {
								showNotification("" + currentProgress);
							}
							
							try {
								Thread.sleep(500);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						return null;
					}

					@Override
					protected void onProgressUpdate(Integer... values) {
						int progress = values[0];
						try {
							mCallback.updateProgress(progress);
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
					
					
				};
				task.execute(max);
			}
			
			@Override
			public void registerCallback(RemoteCallback callback)
					throws RemoteException {
				mCallback = callback;
			}
		};
	}

	@Override
	public boolean onUnbind(Intent intent) {
		Toast.makeText(this, "onUnBind", Toast.LENGTH_LONG).show();
		mIsStop = true;
		NotificationManager mgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		mgr.cancelAll();
		return super.onUnbind(intent);
	}

	@Override
	public void onDestroy() {
		Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show();
		super.onDestroy();
	}

}

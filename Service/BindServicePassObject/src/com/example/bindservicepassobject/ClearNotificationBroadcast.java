package com.example.bindservicepassobject;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ClearNotificationBroadcast extends BroadcastReceiver {

	@Override
	public void onReceive(Context c, Intent arg1) {
		NotificationManager mgr = (NotificationManager) c.getSystemService(Context.NOTIFICATION_SERVICE);
        mgr.cancel(100);
	}

}

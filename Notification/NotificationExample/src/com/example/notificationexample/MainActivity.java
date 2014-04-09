package com.example.notificationexample;

import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
	}

	public void showNormalNotification(View v) {
		showNormalNotification();
	}
	
	public void showBigPictureNotification(View v) {
		showBigPictureStyleNotification();
	}
	
	public void showBigTextNotification(View v) {
		showBigTextStyleNotification();
	}
	
	public void showInBoxNotification(View v) {
		showInBoxStyleNotification();
	}
	
	public void showCustomViewNotification(View v) {
		showCustomViewNotification();
	}
	
	public void showActionNotification(View v){
		showActionNotification();
	}
	
	private void showNormalNotification() {
		Intent intent = new Intent(this, ResultActivity.class);
		PendingIntent peddingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
		
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		builder.setSmallIcon(R.drawable.ic_notification)
		.setTicker("收到一則訊息")
		.setContentTitle("這是一般類型的訊息通知")
		.setContentText("Hello World")
		.setDefaults(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND | Notification.FLAG_SHOW_LIGHTS)
		.setLargeIcon(((BitmapDrawable)getResources().getDrawable(R.drawable.ic_large)).getBitmap())
		.setContentIntent(peddingIntent);
		
		Notification notification = builder.build();
		
		NotificationManager mgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		mgr.notify(0, notification);
	}
	
	public void showBigPictureStyleNotification() {
		Intent intent = new Intent(this, ResultActivity.class);
		PendingIntent peddingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		builder.setTicker("收到一則訊息")
		.setContentTitle("這是大圖片的訊息通知")
		.setContentText("在手機上可以用雙指下拉看內容")
		.setSmallIcon(R.drawable.ic_notification)
		.setContentIntent(peddingIntent)
		.setLargeIcon(((BitmapDrawable)getResources().getDrawable(R.drawable.ic_large)).getBitmap());;
		
		NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
		bigPictureStyle.bigPicture(((BitmapDrawable)getResources().getDrawable(R.drawable.large_image)).getBitmap())
		.setBigContentTitle("大圖片展開了")
		.setSummaryText("可用兩指上拉關閉大圖");
		
		builder.setStyle(bigPictureStyle);
		Notification notification = builder.build();
		
		NotificationManager mgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		mgr.notify(0, notification);
	}
	
	public void showBigTextStyleNotification() {
		Intent intent = new Intent(this, ResultActivity.class);
		PendingIntent peddingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		builder.setTicker("收到一則訊息")
		.setContentTitle("這是大文字的訊息通知")
		.setContentText("在手機上可以用雙指下拉看內容")
		.setSmallIcon(R.drawable.ic_notification)
		.setContentIntent(peddingIntent)
		.setLargeIcon(((BitmapDrawable)getResources().getDrawable(R.drawable.ic_large)).getBitmap());
		
		NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
		bigTextStyle
		.setBigContentTitle("大文字展開了")
		.setSummaryText("可用兩指上拉關閉大文字")
		.bigText("這是大文字大文字大文字大文字\n大文字大文字大文字大文字\n大文字大文字大文字大文字大文字大文字大文字大文字大文字大文字大文字大文字大文字大文字大文字大文字大文字大文字大文字大文字大文字大文字大文字大文字大文字大文字");
		
		builder.setStyle(bigTextStyle);
		Notification notification = builder.build();
		
		NotificationManager mgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		mgr.notify(0, notification);
	}
	
	public void showInBoxStyleNotification() {
		Intent intent = new Intent(this, ResultActivity.class);
		PendingIntent peddingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		builder.setTicker("收到一則訊息")
		.setContentTitle("這是收件夾的訊息通知")
		.setContentText("在手機上可以用雙指下拉看內容")
		.setSmallIcon(R.drawable.ic_notification)
		.setContentIntent(peddingIntent)
		.setLargeIcon(((BitmapDrawable)getResources().getDrawable(R.drawable.ic_large)).getBitmap());
		
		NotificationCompat.InboxStyle inBoxStyle = new NotificationCompat.InboxStyle();
		inBoxStyle
		.setBigContentTitle("以下是條列訊息內容")
		.addLine("這是內文1")
		.addLine("這是內文2")
		.addLine("這是內文3")
		.addLine("這是內文4")
		.addLine("這是內文5")
		.setSummaryText("可用兩指上拉關閉收件夾");
		
		builder.setStyle(inBoxStyle);
		Notification notification = builder.build();
		
		NotificationManager mgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		mgr.notify(0, notification);
	}
	
	public void showCustomViewNotification() {
		Intent intent = new Intent(this, ResultActivity.class);
		PendingIntent peddingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
		
		Intent remoteClickIntent = new Intent(this, CustomViewClickActivity.class);
		PendingIntent clickPendingIntent = PendingIntent.getActivity(this, 0, remoteClickIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		
		RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.custom_view);
		remoteViews.setImageViewResource(R.id.icon, R.drawable.ic_large);
		remoteViews.setTextViewText(R.id.title, "這是客製化的訊息通知");
		remoteViews.setOnClickPendingIntent(R.id.btn_toast, clickPendingIntent);
		
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		builder
		.setTicker("收到一則訊息")
		.setSmallIcon(R.drawable.ic_notification)
		.setContentTitle("這是客製化的訊息通知")
		.setContentIntent(peddingIntent)
		.setContent(remoteViews);
		
		Notification notification = builder.build();
		
		if (android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.JELLY_BEAN) {
			RemoteViews remoteBigViews = new RemoteViews(getPackageName(), R.layout.custom_big_view);
			remoteBigViews.setTextViewText(R.id.title, "雙指上拉關閉");
			remoteBigViews.setImageViewResource(R.id.icon, R.drawable.large_image);
			notification.bigContentView = remoteBigViews;
		}
		
		NotificationManager mgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		mgr.notify(0, notification);
	}
	
	public void showActionNotification() {
		Intent intent = new Intent(this, ResultActivity.class);
		PendingIntent peddingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
		
		Intent searchIntent = new Intent(Intent.ACTION_WEB_SEARCH);
		searchIntent.putExtra(SearchManager.QUERY, "Shih Hsin");
		PendingIntent actionIntent = PendingIntent.getActivity(this, 0, searchIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		builder
		.setSmallIcon(R.drawable.ic_notification)
		.setTicker("收到一則訊息")
		.setContentTitle("這是一般類型的訊息通知")
		.setContentText("Hello World")
		.setLargeIcon(((BitmapDrawable)getResources().getDrawable(R.drawable.ic_large)).getBitmap())
		.setContentIntent(peddingIntent)
		.addAction(R.drawable.ic_search, "Search", actionIntent);
		
		Notification notification = builder.build();
		
		NotificationManager mgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		mgr.notify(0, notification);
	}

}

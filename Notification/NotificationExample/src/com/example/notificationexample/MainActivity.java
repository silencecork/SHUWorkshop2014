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
		.setTicker("����@�h�T��")
		.setContentTitle("�o�O�@���������T���q��")
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
		builder.setTicker("����@�h�T��")
		.setContentTitle("�o�O�j�Ϥ����T���q��")
		.setContentText("�b����W�i�H�������U�Ԭݤ��e")
		.setSmallIcon(R.drawable.ic_notification)
		.setContentIntent(peddingIntent)
		.setLargeIcon(((BitmapDrawable)getResources().getDrawable(R.drawable.ic_large)).getBitmap());;
		
		NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
		bigPictureStyle.bigPicture(((BitmapDrawable)getResources().getDrawable(R.drawable.large_image)).getBitmap())
		.setBigContentTitle("�j�Ϥ��i�}�F")
		.setSummaryText("�i�Ψ���W�������j��");
		
		builder.setStyle(bigPictureStyle);
		Notification notification = builder.build();
		
		NotificationManager mgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		mgr.notify(0, notification);
	}
	
	public void showBigTextStyleNotification() {
		Intent intent = new Intent(this, ResultActivity.class);
		PendingIntent peddingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		builder.setTicker("����@�h�T��")
		.setContentTitle("�o�O�j��r���T���q��")
		.setContentText("�b����W�i�H�������U�Ԭݤ��e")
		.setSmallIcon(R.drawable.ic_notification)
		.setContentIntent(peddingIntent)
		.setLargeIcon(((BitmapDrawable)getResources().getDrawable(R.drawable.ic_large)).getBitmap());
		
		NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
		bigTextStyle
		.setBigContentTitle("�j��r�i�}�F")
		.setSummaryText("�i�Ψ���W�������j��r")
		.bigText("�o�O�j��r�j��r�j��r�j��r\n�j��r�j��r�j��r�j��r\n�j��r�j��r�j��r�j��r�j��r�j��r�j��r�j��r�j��r�j��r�j��r�j��r�j��r�j��r�j��r�j��r�j��r�j��r�j��r�j��r�j��r�j��r�j��r�j��r�j��r�j��r");
		
		builder.setStyle(bigTextStyle);
		Notification notification = builder.build();
		
		NotificationManager mgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		mgr.notify(0, notification);
	}
	
	public void showInBoxStyleNotification() {
		Intent intent = new Intent(this, ResultActivity.class);
		PendingIntent peddingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		builder.setTicker("����@�h�T��")
		.setContentTitle("�o�O���󧨪��T���q��")
		.setContentText("�b����W�i�H�������U�Ԭݤ��e")
		.setSmallIcon(R.drawable.ic_notification)
		.setContentIntent(peddingIntent)
		.setLargeIcon(((BitmapDrawable)getResources().getDrawable(R.drawable.ic_large)).getBitmap());
		
		NotificationCompat.InboxStyle inBoxStyle = new NotificationCompat.InboxStyle();
		inBoxStyle
		.setBigContentTitle("�H�U�O���C�T�����e")
		.addLine("�o�O����1")
		.addLine("�o�O����2")
		.addLine("�o�O����3")
		.addLine("�o�O����4")
		.addLine("�o�O����5")
		.setSummaryText("�i�Ψ���W����������");
		
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
		remoteViews.setTextViewText(R.id.title, "�o�O�Ȼs�ƪ��T���q��");
		remoteViews.setOnClickPendingIntent(R.id.btn_toast, clickPendingIntent);
		
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		builder
		.setTicker("����@�h�T��")
		.setSmallIcon(R.drawable.ic_notification)
		.setContentTitle("�o�O�Ȼs�ƪ��T���q��")
		.setContentIntent(peddingIntent)
		.setContent(remoteViews);
		
		Notification notification = builder.build();
		
		if (android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.JELLY_BEAN) {
			RemoteViews remoteBigViews = new RemoteViews(getPackageName(), R.layout.custom_big_view);
			remoteBigViews.setTextViewText(R.id.title, "�����W������");
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
		.setTicker("����@�h�T��")
		.setContentTitle("�o�O�@���������T���q��")
		.setContentText("Hello World")
		.setLargeIcon(((BitmapDrawable)getResources().getDrawable(R.drawable.ic_large)).getBitmap())
		.setContentIntent(peddingIntent)
		.addAction(R.drawable.ic_search, "Search", actionIntent);
		
		Notification notification = builder.build();
		
		NotificationManager mgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		mgr.notify(0, notification);
	}

}

package com.zmy.study.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.zmy.study.MainActivity;
import com.zmy.study.R;
import com.zmy.study.util.LogUtils;

public class ForegroundService extends Service {
    private MyBinder mBinder = new MyBinder();

    @Override
    public void onCreate() {
        LogUtils.d("ForegroundService  onCreate");
        super.onCreate();

        // 普通意图
        Intent notificationIntent = new Intent(this, MainActivity.class);
        // 加强意图
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        // 通知的创建
        Notification notification = new Notification.Builder(this)
                .setContentTitle("有通知到来")
                .setContentText("这是通知的内容")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pendingIntent)
                .build(); // level 16才支持的

        notification.flags = Notification.FLAG_AUTO_CANCEL;
        // 让ForegroundService变成一个前台Service（ForegroundService）
        startForeground(1, notification);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtils.d("ForegroundService  onStartCommand");
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 开始执行后台任务
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        LogUtils.d("ForegroundService  onDestroy");
        super.onDestroy();
    }

    // 这个方法其实就是用于和Activity建立关联的
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        LogUtils.d("ForegroundService  onBind");
        return null; // mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        LogUtils.d("ForegroundService  onUnbind");
        return super.onUnbind(intent);
    }

    class MyBinder extends Binder {

        public void startDownload() {
            LogUtils.d("startDownload() executed");
            // 执行具体的下载任务
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 开始执行后台任务
                }
            }).start();
        }

    }
}
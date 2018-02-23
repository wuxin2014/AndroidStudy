package com.zmy.study.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import com.zmy.study.util.LogUtils;


public class MyService extends Service {

    private MyBinder mBinder = new MyBinder();

    @Override
    public void onCreate() {
        LogUtils.d("MyService  onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtils.d("MyService  onStartCommand");
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
        LogUtils.d("MyService  onDestroy");
        super.onDestroy();
    }

    // 这个方法其实就是用于和Activity建立关联的
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        LogUtils.d("MyService  onBind");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        LogUtils.d("MyService  onUnbind");
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

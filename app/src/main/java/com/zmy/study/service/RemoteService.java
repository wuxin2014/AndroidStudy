package com.zmy.study.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.zmy.study.util.LogUtils;

// http://blog.csdn.net/guolin_blog/article/details/9797169

public class RemoteService extends Service {
    private MyBinder mBinder = new MyBinder();

    @Override
    public void onCreate() {
        LogUtils.d("RemoteService  onCreate");
        super.onCreate();

        /*
        * 在onCreate中睡眠60秒，会报ANR的错
        * 解决方案： 只需要在注册Service的时候将它的android:process属性指定成:remote就可以了
        * <service
        *   android:name="com.zmy.study.service.RemoteService"
        *   android:process=":remote" >
        * </service>
        *
        * 如何才能让Activity与一个远程Service建立关联呢？这就要使用AIDL来进行跨进程通信了（IPC）
        * AIDL（Android Interface Definition Language）是Android接口定义语言的意思，
        * 它可以用于让某个Service与多个应用程序组件之间进行跨进程通信，从而可以实现多个应用程序共享同一个Service的功能。
        */

        /*try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtils.d("RemoteService  onStartCommand");
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
        LogUtils.d("RemoteService  onDestroy");
        super.onDestroy();
    }

    // 这个方法其实就是用于和Activity建立关联的
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        LogUtils.d("RemoteService  onBind");
        return null; // mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        LogUtils.d("RemoteService  onUnbind");
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

package com.zmy.study.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;

import com.zmy.study.util.LogUtils;

/**
 * IntentService，可以看做是Service和HandlerThread的结合体，在完成了使命之后会自动停止，适合需要在工作线程处理UI无关任务的场景
 */
public class MyIntentService extends IntentService {
    private boolean isRunning;
    private int count;
    private LocalBroadcastManager mLocalBroadcastManager;

    public MyIntentService() {
        super("MyIntentService");
        LogUtils.e("MyIntentService 无参构造方法");
    }
    public MyIntentService(String name) {
        super(name);
        LogUtils.e("MyIntentService 构造方法");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.e("MyIntentService onCreate");
        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        LogUtils.e("MyIntentService onHandleIntent");
        try {
            Thread.sleep(1000);
            isRunning = true;
            count = 0;
            while (isRunning) {
                count++;
                if (count >= 100) {
                    isRunning = false;
                }
                Thread.sleep(50);
                sendThreadStatus("线程运行中...", count);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送进度消息
     */
    private void sendThreadStatus(String status, int progress) {
        Intent intent = new Intent(IntentServiceActivity.ACTION_TYPE_THREAD);
        intent.putExtra("status", status);
        intent.putExtra("progress", progress);
        mLocalBroadcastManager.sendBroadcast(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.e("MyIntentService onDestroy");
    }
}

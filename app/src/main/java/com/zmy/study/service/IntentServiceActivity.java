package com.zmy.study.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zmy.study.R;

// 参考文章 http://blog.csdn.net/iromkoear/article/details/63252665

public class IntentServiceActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startBtn;
    private ProgressBar progressBar;
    private TextView statusText, progressText;

    private LocalBroadcastManager mLocalBroadcastManager;
    private MyBroadcastReceiver mBroadcastReceiver;
    public final static String ACTION_TYPE_THREAD = "action.type.thread";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);

        startBtn = findViewById(R.id.btn_start);
        progressBar = findViewById(R.id.progressBar);
        statusText = findViewById(R.id.tv_status);
        progressText = findViewById(R.id.tv_progress);
        startBtn.setOnClickListener(this);

        //注册广播
        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
        mBroadcastReceiver = new MyBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_TYPE_THREAD);
        mLocalBroadcastManager.registerReceiver(mBroadcastReceiver, intentFilter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start:
                Intent intent = new Intent(this, MyIntentService.class);
                startService(intent);
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注销广播
        mLocalBroadcastManager.unregisterReceiver(mBroadcastReceiver);
    }

    public class MyBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {
                case ACTION_TYPE_THREAD:
                    //更改UI
                    int progress = intent.getIntExtra("progress", 0);
                    statusText.setText("线程状态：" + intent.getStringExtra("status"));
                    progressBar.setProgress(progress);
                    progressText.setText(progress + "%");
                    if (progress >= 100) {
                        statusText.setText("线程结束");
                    }
                    break;
            }
        }
    }
}

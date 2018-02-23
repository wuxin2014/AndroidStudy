package com.zmy.study.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zmy.study.R;

// 参考文章http://blog.csdn.net/xuefu_78/article/details/64127844
public class ServiceActivity extends AppCompatActivity implements View.OnClickListener{
    private Button startBtn, stopBtn, bindBtn, unbindBtn;

    // 内部类
    private MyService.MyBinder myBinder;
    private ServiceConnection connection = new ServiceConnection(){

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (MyService.MyBinder) service;
            myBinder.startDownload();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        startBtn = findViewById(R.id.btn_start_service);
        stopBtn = findViewById(R.id.btn_stop_service);
        bindBtn = findViewById(R.id.btn_bind_service);
        unbindBtn = findViewById(R.id.btn_unbind_service);

        startBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
        bindBtn.setOnClickListener(this);
        unbindBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.btn_start_service:
                intent = new Intent(this, MyService.class);
                startService(intent);
                break;
            case R.id.btn_stop_service:
                intent = new Intent(this, MyService.class);
                stopService(intent);
                break;
            case R.id.btn_bind_service:
                // 标志位BIND_AUTO_CREATE表示在Activity和Service建立关联后自动创建Service，这会使得MyService中的onCreate()方法得到执行，但onStartCommand()方法不会执行
                intent = new Intent(this, MyService.class);
                bindService(intent, connection, BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbind_service:
                // 一个Service必须要在既没有和任何Activity关联又处理停止状态的时候才会被销毁。
                unbindService(connection);
                break;
            default:
                break;
        }
    }
}

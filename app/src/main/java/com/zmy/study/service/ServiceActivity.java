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

/**
 *  执行startService时，Service会经历onCreate->onStartCommand。当执行stopService时，直接调用onDestroy方法。
 *  调用者如果没有stopService，Service会一直在后台运行，下次调用者再起来仍然可以stopService。
 *
 *  执行bindService时，Service会经历onCreate->onBind。这个时候调用者和Service绑定在一起。
 *  调用者调用unbindService方法或者调用者Context不存在了（如Activity被finish了），Service就会调用onUnbind->onDestroy。
 *  这里所谓的绑定在一起就是说两者共存亡了。
 *
 *  什么情况下既使用startService，又使用bindService呢？
 *
 *  如果你只是想要启动一个后台服务长期进行某项任务，那么使用startService便可以了。
 *  如果你还想要与正在运行的Service取得联系，那么有两种方法：一种是使用broadcast，另一种是使用bindService。
 *  前者的缺点是如果交流较为频繁，容易造成性能上的问题，而后者则没有这些问题。因此，这种情况就需要startService和bindService一起使用了。
 */
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

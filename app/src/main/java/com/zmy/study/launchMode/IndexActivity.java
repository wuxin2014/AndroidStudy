package com.zmy.study.launchMode;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zmy.study.R;
import com.zmy.study.util.LogUtils;

/**
 * 当我们多次启动同一个Activity，系统也会创建多个实例放入任务栈中，这样岂不是很耗费内存资源？为了解决这一问题，Android为Activity提供了启动模式
 * 为什么要研究启动模式
 * 1.有时候我们的App需要生成给其他App调用的Activity，例如浏览器应用，照相机应用
 * 2.解决生成重复页面等等Bug
 * 3.任务栈过深的时候，避免一直按返回键也退不回想要的页面
 */

public class IndexActivity extends AppCompatActivity implements View.OnClickListener {

    private Button standardBtn, singleTopBtn, singleTaskBtn, singleInstanceBtn;
    private boolean firstFlag = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        standardBtn = this.findViewById(R.id.btn_standard);
        singleTopBtn = this.findViewById(R.id.btn_single_top);
        singleTaskBtn = this.findViewById(R.id.btn_single_task);
        singleInstanceBtn = this.findViewById(R.id.btn_single_instance);

        standardBtn.setOnClickListener(this);
        singleTopBtn.setOnClickListener(this);
        singleTaskBtn.setOnClickListener(this);
        singleInstanceBtn.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.d("IndexActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.d("IndexActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.d("IndexActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.d("IndexActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.d("IndexActivity onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.d("IndexActivity onRestart");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogUtils.d("IndexActivity onNewIntent");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        LogUtils.d("IndexActivity onSaveInstanceState");
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.btn_standard:
                intent = new Intent(IndexActivity.this, StandardActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_single_top:
                intent = new Intent(IndexActivity.this, SingleTopActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_single_task:
                LogUtils.d("btn_single_task");
                intent = new Intent(IndexActivity.this, SingleTaskActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_single_instance:
                intent = new Intent(IndexActivity.this, SingleInstanceActivity.class);
                startActivity(intent);
                break;
        }
    }
}

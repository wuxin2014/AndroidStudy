package com.zmy.study.launchMode;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.zmy.study.R;
import com.zmy.study.util.LogUtils;

public class SingleTaskActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        LogUtils.d("SingleTaskActivity OnCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task);
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.d("SingleTaskActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.d("SingleTaskActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.d("SingleTaskActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.d("SingleTaskActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.d("SingleTaskActivity onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.d("SingleTaskActivity onRestart");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogUtils.d("SingleTaskActivity onNewIntent");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        LogUtils.d("SingleTaskActivity onSaveInstanceState");
    }
}

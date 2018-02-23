package com.zmy.study.launchMode;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zmy.study.R;
import com.zmy.study.util.LogUtils;

/**
 * Created by lings on 2018/2/23.
 */

public class SingleTopActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.d("SingleTopActivity OnCreate");
        setContentView(R.layout.activity_single_top);
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.d("SingleTopActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.d("SingleTopActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.d("SingleTopActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.d("SingleTopActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.d("SingleTopActivity onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.d("SingleTopActivity onRestart");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogUtils.d("SingleTopActivity onNewIntent");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        LogUtils.d("SingleTopActivity onSaveInstanceState");
    }
}

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

public class StandardActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.d("StandardActivity OnCreate");
        setContentView(R.layout.activity_standard);
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.d("StandardActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.d("StandardActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.d("StandardActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.d("StandardActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.d("StandardActivity onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.d("StandardActivity onRestart");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogUtils.d("StandardActivity onNewIntent");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        LogUtils.d("StandardActivity onSaveInstanceState");
    }
}

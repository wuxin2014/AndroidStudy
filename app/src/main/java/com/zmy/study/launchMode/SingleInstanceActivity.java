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

public class SingleInstanceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.d("SingleInstanceActivity OnCreate");
        setContentView(R.layout.activity_single_instance);
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.d("SingleInstanceActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.d("SingleInstanceActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.d("SingleInstanceActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.d("SingleInstanceActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.d("SingleInstanceActivity onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.d("SingleInstanceActivity onRestart");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogUtils.d("SingleInstanceActivity onNewIntent");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        LogUtils.d("SingleInstanceActivity onSaveInstanceState");
    }
}

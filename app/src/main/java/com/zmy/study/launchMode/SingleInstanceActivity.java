package com.zmy.study.launchMode;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zmy.study.R;
import com.zmy.study.util.LogUtils;

/**
 * singleInstance适合需要与程序分离开的页面
 *
 * 这种模式下的Activity会单独占用一个Task栈，具有全局唯一性，即整个系统中就这么一个实例，由于栈内复用的特性，
 * 后续的请求均不会创建新的Activity实例，除非这个特殊的任务栈被销毁了
 *
 * 例如电话拨号盘页面，通过自己的应用或者其他应用打开拨打电话页面 ，只要系统的栈中存在该实例，那么就会直接调用
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

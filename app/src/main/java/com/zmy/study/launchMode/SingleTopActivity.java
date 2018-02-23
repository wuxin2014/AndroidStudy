package com.zmy.study.launchMode;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zmy.study.R;
import com.zmy.study.util.LogUtils;

/**
 * singleTop适合接收通知启动的内容显示页面
 *
 * 这种模式应用场景的话，假如一个新闻客户端，在通知栏收到了3条推送，点击每一条推送会打开新闻的详情页，如果为默认的启动模式的话，
 * 点击一次打开一个页面，会打开三个详情页，这肯定是不合理的。如果启动模式设置为singleTop，当点击第一条推送后，新闻详情页已经处于栈顶，
 * 当我们第二条和第三条推送的时候，只需要通过Intent传入相应的内容即可，并不会重新打开新的页面，这样就可以避免重复打开页面了。
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

    public static void open(Context context) {
        context.startActivity(new Intent(context, SingleTopActivity.class));
    }
}

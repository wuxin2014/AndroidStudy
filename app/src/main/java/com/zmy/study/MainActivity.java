package com.zmy.study;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zmy.study.launchMode.IndexActivity;
import com.zmy.study.service.ServiceActivity;
import com.zmy.study.viewScroll.ViewScollActivity;
import com.zmy.study.webJs.WebViewActivity;
import com.zmy.study.webJs.WebViewActivity2;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button launchModeBtn, serviceBtn, webViewBtn, webViewBtn2, viewScrollBtn, dragViewBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        launchModeBtn = findViewById(R.id.launch_demo);
        serviceBtn = findViewById(R.id.service_demo);
        webViewBtn = findViewById(R.id.webView);
        webViewBtn2 = findViewById(R.id.webView2);
        viewScrollBtn = findViewById(R.id.viewScroll);
        dragViewBtn = findViewById(R.id.dragView);
        launchModeBtn.setOnClickListener(this);
        serviceBtn.setOnClickListener(this);
        webViewBtn.setOnClickListener(this);
        webViewBtn2.setOnClickListener(this);
        viewScrollBtn.setOnClickListener(this);
        dragViewBtn.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.launch_demo:
                intent = new Intent(MainActivity.this, IndexActivity.class);
                startActivity(intent);
                break;

            case R.id.service_demo:
                intent = new Intent(this, ServiceActivity.class);
                startActivity(intent);
                break;

            case R.id.webView:
                intent = new Intent(this, WebViewActivity.class);
                startActivity(intent);
                break;

            case R.id.webView2:
                intent = new Intent(this, WebViewActivity2.class);
                startActivity(intent);
                break;
            case R.id.viewScroll:
                intent = new Intent(this, ViewScollActivity.class);
                startActivity(intent);
                break;

            case R.id.dragView:
                intent = new Intent(this, DragActivity.class);
                startActivity(intent);
                break;
        }
    }
}

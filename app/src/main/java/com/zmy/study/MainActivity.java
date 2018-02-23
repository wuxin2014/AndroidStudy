package com.zmy.study;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zmy.study.launchMode.IndexActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button launchModeBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        launchModeBtn = findViewById(R.id.launch_demo);
        launchModeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.launch_demo:
                Intent intent = new Intent(MainActivity.this, IndexActivity.class);
                startActivity(intent);
                break;
        }
    }
}

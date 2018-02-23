package com.zmy.study.launchMode;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zmy.study.R;
import com.zmy.study.util.LogUtils;

public class OtherActivity extends AppCompatActivity {
    private static final String TAG = OtherActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        findViewById(R.id.btn_single_top).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SingleTopActivity.open(OtherActivity.this);
            }
        });
        // 因为它们的taskId值都相同，所以它们同属于一个任务栈
        LogUtils.i("OtherActivity onCreate(): TaskId: " + getTaskId() +",  hashCode: " + hashCode());
    }

    public static void open(Context context) {
        context.startActivity(new Intent(context, OtherActivity.class));
    }
}

package com.zmy.study;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.zmy.study.R;
import com.zmy.study.view.OriginDragView;

public class OriginDragViewActivity extends AppCompatActivity {
    private OriginDragView originDragView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_origin_drag_view);
        originDragView = findViewById(R.id.originDragView);

        //使用属性动画使view滑动
        // ObjectAnimator.ofFloat(originDragView,"translationX",0,300).setDuration(1000).start();
        //使用View动画使view滑动
        //mCustomView.setAnimation(AnimationUtils.loadAnimation(this, R.anim.translate));
        //使用Scroll来进行平滑移动
        // originDragViews.smoothScrollTo(-400,0);
    }
}

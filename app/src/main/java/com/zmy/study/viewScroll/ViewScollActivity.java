package com.zmy.study.viewScroll;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.zmy.study.R;

public class ViewScollActivity extends AppCompatActivity {
    private ViewScrollDemo viewScrollDemo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_scroll_view);
        viewScrollDemo = findViewById(R.id.scrollView);

        //使用属性动画使view滑动
        // ObjectAnimator.ofFloat(mCustomView,"translationX",0,300).setDuration(1000).start();
        //使用View动画使view滑动
        //mCustomView.setAnimation(AnimationUtils.loadAnimation(this, R.anim.translate));
        //使用Scroll来进行平滑移动
        viewScrollDemo.smoothScrollTo(-400,0);
    }
}

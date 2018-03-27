package com.zmy.study.view;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DragView extends LinearLayout {
    private ViewDragHelper mViewDragHelper;
    private Point initPointPosition = new Point();
    private TextView mDragView;
    private TextView mDragView2;
    private TextView mDragView3;

    public DragView(Context context) {
        this(context, null);
    }

    public DragView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DragView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initDragHelper();
    }

    @Override
    protected void onFinishInflate() {
        mDragView = (TextView) getChildAt(0);
        mDragView2 = (TextView) getChildAt(1);
        mDragView3 = (TextView) getChildAt(2);
        super.onFinishInflate();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        //布局完成的时候就记录一下位置
        initPointPosition.x = mDragView.getLeft();
        initPointPosition.y = mDragView.getTop();
    }


    private void initDragHelper() {
        mViewDragHelper = ViewDragHelper.create(this, mDragCallBack);
    }

    private ViewDragHelper.Callback mDragCallBack = new ViewDragHelper.Callback() {
        @Override
        public boolean tryCaptureView(View child, int pointerId) {
           //可以用来指定哪一个childView可以拖动
           return child == mDragView || child == mDragView3;
        }

        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            final int leftBound = getPaddingLeft();
            final int rightBound = getWidth() - mDragView.getWidth();
            final int newLeft = Math.min(Math.max(left, leftBound), rightBound);
            return newLeft;
        }

        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            // 控制child的移动范围在父view中
            final int topBound = getPaddingTop();
            final int bottomBound = getHeight() - mDragView.getHeight();
            final int newTop = Math.min(Math.max(top, topBound), bottomBound);
            return newTop;
        }

        // 释放的时候, 会回调下面的方法
        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            if (releasedChild == mDragView) {
                mViewDragHelper.settleCapturedViewAt(initPointPosition.x, initPointPosition.y);
                postInvalidate();
            }

        }

        // 响应点击事件需要的两个事件
        @Override
        public int getViewHorizontalDragRange(View child) {
            return getMeasuredWidth() - child.getMeasuredWidth();
        }

        @Override
        public int getViewVerticalDragRange(View child) {
            return getMeasuredHeight()-child.getMeasuredHeight();
        }

        //在边界拖动时回调
        @Override
        public void onEdgeDragStarted(int edgeFlags, int pointerId) {
            mViewDragHelper.captureChildView(mDragView3, pointerId);
        }
    };

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        //固定写法
        int action = event.getAction();
        if (action == MotionEvent.ACTION_CANCEL || action == MotionEvent.ACTION_UP) {
            mViewDragHelper.cancel();
            return false;
        }
        return mViewDragHelper.shouldInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //将触摸事件传递给`ViewDragHelper`，必不可少
        mViewDragHelper.processTouchEvent(event);
        return true;
    }

    @Override
    public void computeScroll() {
        //固定写法
        if (mViewDragHelper.continueSettling(true)) {
            postInvalidate();//注意此处.
        }
    }
}

package com.zmy.study.viewScroll;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

public class ViewScrollDemo extends View {

    private int lastX;
    private int lastY;
    private Scroller mScroller;

    public ViewScrollDemo(Context context) {
        super(context);
    }

    public ViewScrollDemo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context);
    }

    public ViewScrollDemo(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x-lastX;
                int offsetY = y-lastY;

                // layout(getLeft()+offsetX, getTop()+offsetY,getRight()+offsetX , getBottom()+offsetY);

                //对left和right进行偏移
                //offsetLeftAndRight(offsetX);

                //对top和bottom进行偏移
                //offsetTopAndBottom(offsetY);

                //使用LayoutParams
                /* LinearLayout.LayoutParams layoutParams= (LinearLayout.LayoutParams) getLayoutParams();
                layoutParams.leftMargin = getLeft() + offsetX;
                layoutParams.topMargin = getTop() + offsetY;
                setLayoutParams(layoutParams);*/

                //使用MarginLayoutParams
                /*ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
                layoutParams.leftMargin = getLeft() + offsetX;
                layoutParams.topMargin = getTop() + offsetY;
                setLayoutParams(layoutParams);*/

                // 使用scrollBy
                ((View)getParent()).scrollBy(-offsetX,-offsetY);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

    public void smoothScrollTo(int destX,int destY){
        int scrollX=getScrollX();
        int delta=destX-scrollX;
        //1000秒内滑向destX
        mScroller.startScroll(scrollX,0,delta,0,2000);
        invalidate();
    }
    @Override
    public void computeScroll() {
        super.computeScroll();
        if(mScroller.computeScrollOffset()){
            ((View) getParent()).scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            //通过不断的重绘不断的调用computeScroll方法
            invalidate();
        }

    }
}
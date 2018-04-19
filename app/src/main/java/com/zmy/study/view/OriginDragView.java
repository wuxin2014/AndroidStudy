package com.zmy.study.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

import com.zmy.study.util.LogUtils;

public class OriginDragView extends View {
    private final String TAG = "OriginDragView";

    private int mLastX;
    private int mLastY;
    private Scroller mScroller;

    public OriginDragView(Context context) {
        super(context);
    }

    public OriginDragView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context);
    }

    public OriginDragView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastX = x;
                mLastY = y;
                break;

            case MotionEvent.ACTION_MOVE:
                LogUtils.i( "ACTION_MOVE-X:"+ x);
                LogUtils.i("ACTION_MOVE-Y:"+ y);
                int offsetX = x - mLastX;
                int offsetY = y - mLastY;

                // layout(getLeft()+ offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);

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



                //边界检测判断，防止滑块越界
                /*if (offsetX + getScrollX() > 0) {
                    scrollTo(0, 0);
                    return true;
                } else if (offsetX + getScrollX() + getMeasuredWidth() / 2 < 0) {
                    scrollTo(-getMeasuredWidth() / 2, 0);
                    return true;
                }*/
                // scrollBy()方法则是让View相对于当前的位置滚动某段距离
                ((View)getParent()).scrollBy(-offsetX, -offsetY);
                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        return true;
    }

    public void smoothScrollTo(int destX,int destY){
        int scrollX = getScrollX();
        int delta = destX - scrollX;
        //1000秒内滑向destX
        mScroller.startScroll(scrollX,0,delta,0,2000);
        invalidate();
    }

    @Override
    public void computeScroll() {
        LogUtils.i( "computeScroll:"+ mScroller.computeScrollOffset());
        super.computeScroll();
        // scrollTo()方法 让View相对于初始的位置滚动某段距离
        if(mScroller.computeScrollOffset()){
            ((View) getParent()).scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            //通过不断的重绘不断的调用computeScroll方法
            invalidate();
        }
    }
}

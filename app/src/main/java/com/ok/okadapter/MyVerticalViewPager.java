package com.ok.okadapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import me.kaelaela.verticalviewpager.VerticalViewPager;

/**
 * Created by chen.huarong on 2018/4/20.
 */
public class MyVerticalViewPager extends VerticalViewPager {

    private boolean needInterceptTouch = false;
    private float downY;
    private GestureListener mGestureListener;

    public MyVerticalViewPager(Context context) {
        super(context);
    }

    public MyVerticalViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return needInterceptTouch;
    }

    public boolean isNeedInterceptTouch() {
        return needInterceptTouch;
    }

    public void setNeedInterceptTouch(boolean needInterceptTouch) {
        this.needInterceptTouch = needInterceptTouch;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downY = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                if (mGestureListener != null) {
                    if (downY - ev.getY() > 0) {
                        mGestureListener.onUpMove();
                    } else {
                        mGestureListener.onDownMove();
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                downY = 0;
                break;

        }
        return super.onTouchEvent(ev);
    }

    public GestureListener getGestureListener() {
        return mGestureListener;
    }

    public void setGestureListener(GestureListener gestureListener) {
        mGestureListener = gestureListener;
    }

    public interface GestureListener {
        void onDownMove();

        void onUpMove();
    }
}

package com.example.niu.myapplication.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by wanglei on 18-5-23.
 */

public class SlideLiearLayout extends LinearLayout {
    public SlideLiearLayout(Context context) {
        super(context);
    }

    public SlideLiearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SlideLiearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("wanglei", "dispatchTouchEvent: ");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        Log.d("wanglei", "onInterceptTouchEvent: ");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("wanglei", "onTouchEvent: ");
        return super.onTouchEvent(event);
    }
}

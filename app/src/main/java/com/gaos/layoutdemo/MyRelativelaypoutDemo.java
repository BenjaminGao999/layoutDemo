package com.gaos.layoutdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Author:　Created by benjamin
 * DATE :  2017/10/10 13:44
 * versionCode:　v2.2
 */

public class MyRelativelaypoutDemo extends RelativeLayout {
    private static final String TAG = "MyRelativelaypoutDemo";
    private Context mContext;

    public MyRelativelaypoutDemo(Context context) {
        this(context, null);
    }

    public MyRelativelaypoutDemo(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public MyRelativelaypoutDemo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        inflate(context, R.layout.layout_child1, this);
        inflate(context, R.layout.layout_child2, this);
        initChildVisiable();

    }

    private void initChildVisiable() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                childAt.setVisibility(VISIBLE);
//                Log.e(TAG, "MyRelativelaypoutDemo: " );
                if (i == 0) {
                    childAt.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
//                            Toast.makeText(mContext, "1", Toast.LENGTH_SHORT).show();
                            show2();
                        }
                    });
                }
                if (i == 1) {
                    View tv2 = ((LinearLayout) childAt).getChildAt(0);
                    tv2.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
//                            Toast.makeText(mContext, "2", Toast.LENGTH_SHORT).show();
                            show1();
                        }
                    });

                }
            }
        }
        show1();
    }


    /**
     * xml call;
     * java not call.
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.e(TAG, "onFinishInflate: ");
    }

    /**
     * call at inflate method
     * 每调用一次inflate方法，就调用一次onViewAdded方法
     *
     * @param child
     */
    @Override
    public void onViewAdded(View child) {
        super.onViewAdded(child);
        Log.e(TAG, "onViewAdded: ");
    }

    @Override
    public void onViewRemoved(View child) {
        super.onViewRemoved(child);
        Log.e(TAG, "onViewRemoved: ");
    }


    /**
     * 获取child view 参数
     *
     * @param changed
     * @param l
     * @param t
     * @param r
     * @param b
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        for (int i = 0; i < getChildCount(); i++) {
//            Log.e(TAG, "onLayout: child count = " + getChildCount());
            View childAt = getChildAt(i);
            if (childAt != null) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                Log.e(TAG, "onLayout: measuredWidth = " + measuredWidth + " ; measuredHeight = " + measuredHeight);
            }
        }
    }

    public void show1() {
        for (int i = 0; i < getChildCount(); i++) {
//            Log.e(TAG, "onLayout: child count = " + getChildCount());
            View childAt = getChildAt(i);
            if (i == 0) {
                childAt.setVisibility(VISIBLE);
            } else {
                childAt.setVisibility(GONE);
            }
        }
    }

    public void show2() {
        for (int i = 0; i < getChildCount(); i++) {
//            Log.e(TAG, "onLayout: child count = " + getChildCount());
            View childAt = getChildAt(i);
            if (i == 1) {
                childAt.setVisibility(VISIBLE);
            } else {
                childAt.setVisibility(GONE);
            }
        }
    }


}

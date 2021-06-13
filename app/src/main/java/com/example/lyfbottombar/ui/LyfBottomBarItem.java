package com.example.lyfbottombar.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * *******************
 * 项目名称 LyfBottomBar
 *
 * @Author lyf
 * email:869824341@qq.com
 * 创建时间 2021/6/13 2:24
 * 用途
 *
 * *******************
 */
public class LyfBottomBarItem extends FrameLayout {
    private int currentPosition;
    private int icon;
    private String msg;

    public LyfBottomBarItem(@NonNull Context context) {
        this(context,null);
    }

    public LyfBottomBarItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LyfBottomBarItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LyfBottomBarItem(Context context,int icon,String msg){
        super(context,null,0);
        initView(context,icon,msg);
    }

    private void initView(Context context,int icon,String msg) {
        FrameLayout.LayoutParams params=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 300);
        params.gravity= Gravity.CENTER;
        TextView tv=new TextView(context);
        tv.setText(msg);
        tv.setTextSize(26);
        tv.setGravity(Gravity.CENTER);
        addView(tv,params);
    }

    public int getPosition(){
        return currentPosition;
    }
    public void setPosition(int position){
        this.currentPosition = position;
    }
}

package com.example.lyfbottombar.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lyfbottombar.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

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
    private Context mContext;
    private int currentPosition;
    private int icon;
    private String msg;
    private ImageView img_icon;
    private TextView tv_msg;
    private TextView tv_unread;
    private LinearLayout llContainer;
    private int unreadNum;

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
        this.mContext=context;
        //添加触摸阴影反馈
        TypedArray typedArray = context.obtainStyledAttributes(new int[]{R.attr.selectableItemBackgroundBorderless});
        Drawable drawable = typedArray.getDrawable(0);
        setBackground(drawable);
        typedArray.recycle();

        //添加LinearLayout
        llContainer=new LinearLayout(context);
        llContainer.setOrientation(LinearLayout.VERTICAL);
        llContainer.setGravity(Gravity.CENTER);
        LayoutParams layoutParams=new LayoutParams(100, 100);
        layoutParams.gravity=Gravity.CENTER;
        llContainer.setLayoutParams(layoutParams);

        //设置icon imageview
        img_icon= new ImageView(context);
        LinearLayout.LayoutParams layoutParam1=new LinearLayout.LayoutParams(50, 50);
        img_icon.setImageResource(icon);
        img_icon.setColorFilter(ContextCompat.getColor(context, R.color.tab_unselect));
        llContainer.addView(img_icon,layoutParam1);
        //设置msg textview
        tv_msg=new TextView(context);
        LinearLayout.LayoutParams layoutParam2=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        tv_msg.setTextSize(15);
        tv_msg.setText(msg);
        llContainer.addView(tv_msg,layoutParam2);

        //添加llContainer
        addView(llContainer);
        //添加unread textView
        tv_unread=new TextView(context);
        tv_unread.setText("10");
        tv_unread.setTextSize(10);
        tv_unread.setTextColor(Color.WHITE);
        tv_unread.setPadding(5,0,5,0);
        tv_unread.setBackgroundResource(R.drawable.bg_unread);
        tv_unread.setGravity(Gravity.CENTER);
        FrameLayout.LayoutParams layoutParam3=new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        layoutParam3.gravity=Gravity.CENTER;
        layoutParam3.leftMargin=30;
        layoutParam3.bottomMargin=30;
        tv_unread.setVisibility(View.GONE);
        addView(tv_unread,layoutParam3);
    }

    public int getPosition(){
        return currentPosition;
    }
    public void setPosition(int position){
        this.currentPosition = position;
    }

    public void setUnreadNum(int unreadNum){
        if(unreadNum>0){
            tv_unread.setVisibility(View.VISIBLE);
        }
    }

    public void setSelected(boolean isSelect){
        if(isSelect){
            img_icon.setColorFilter(ContextCompat.getColor(mContext, R.color.colorPrimary));
            tv_msg.setTextColor(ContextCompat.getColor(mContext, R.color.colorPrimary));
        }else{
            img_icon.setColorFilter(ContextCompat.getColor(mContext, R.color.tab_unselect));
            tv_msg.setTextColor(ContextCompat.getColor(mContext, R.color.tab_unselect));
        }
    }
}

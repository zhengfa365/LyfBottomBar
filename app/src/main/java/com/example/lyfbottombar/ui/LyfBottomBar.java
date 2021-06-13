package com.example.lyfbottombar.ui;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.lyfbottombar.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

/**
 * *******************
 * 项目名称 LyfBottomBar
 *
 * @Author lyf
 * email:869824341@qq.com
 * 创建时间 2021/6/13 2:23
 * 用途
 * *******************
 */
public class LyfBottomBar extends LinearLayout {
    private List<LyfBottomBarItem> bottomBarItems;
    private LinearLayout.LayoutParams itemParams;
    private BottomBarSelectListener listener;
    private int selectPosition=-1;

    public LyfBottomBar(Context context) {
        this(context,null);
    }

    public LyfBottomBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LyfBottomBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        setOrientation(HORIZONTAL);
        setBackgroundColor(Color.GRAY);
        //item属性
        itemParams=new LinearLayout.LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT);
        itemParams.weight=1;
        if(selectPosition==-1) selectPosition=0;
        bottomBarItems =new ArrayList<LyfBottomBarItem>();
    }

    public void addItem(LyfBottomBarItem item){
        if(item!=null){
            bottomBarItems.add(item);
            item.setPosition(bottomBarItems.size());
            item.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.selectItem(selectPosition,item.getPosition());
                    selectPosition=item.getPosition();
                }
            });
            addView(item,itemParams);
        }
    }
    public void setListener(BottomBarSelectListener listener){
        this.listener=listener;
    }

   public interface BottomBarSelectListener{
        void selectItem(int prePosition,int showPosition);
    }


}

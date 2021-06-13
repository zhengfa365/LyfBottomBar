package com.example.lyfbottombar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.lyfbottombar.ui.LyfBottomBar;
import com.example.lyfbottombar.ui.LyfBottomBarItem;

public class MainActivity extends AppCompatActivity {
    private LyfBottomBar lyf_bottomobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lyf_bottomobar=findViewById(R.id.lyf_bottomobar);
        lyf_bottomobar.addItem(new LyfBottomBarItem(this,R.drawable.ic_launcher_foreground,"home"));
        lyf_bottomobar.addItem(new LyfBottomBarItem(this,R.drawable.ic_launcher_foreground,"msg"));
        lyf_bottomobar.addItem(new LyfBottomBarItem(this,R.drawable.ic_launcher_foreground,"knowledge"));
        lyf_bottomobar.setListener(new LyfBottomBar.BottomBarSelectListener() {
            @Override
            public void selectItem(int prePosition, int showPosition) {
                Toast.makeText(MainActivity.this,"click:"+showPosition,Toast.LENGTH_LONG).show();
            }
        });
        lyf_bottomobar.setSelectItem(3);
    }
}
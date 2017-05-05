package com.warmfire.firsttest.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.warmfire.firsttest.R;
import com.warmfire.firsttest.utils.MyToast;

import java.util.Calendar;

/**
 * Created by warmfire on 2017/5/3.
 */

public class DoubleClickActivity extends BaseActivity {

    Button double_btn;
    long lastTime = 0;
    // 设置标题
    ImageView img_back;
    TextView txt_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doubleclick);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setStateBarColor(this, Color.parseColor("#FF3F51B5"));
        init();
        setListener();
    }

    public void init(){
        double_btn = (Button) findViewById(R.id.double_btn);
        // 设置标题
        img_back = (ImageView) findViewById(R.id.title_back);
        txt_title = (TextView) findViewById(R.id.title_title);
    }

    public void setListener(){
        txt_title.setText("双击检测");
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        double_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long newTime = Calendar.getInstance().getTimeInMillis();
                if(newTime - lastTime < 800){
                    MyToast.ShortToast(DoubleClickActivity.this, "双击了按钮");
                } else{
                    lastTime = Calendar.getInstance().getTimeInMillis();
                    //MyToast.ShortToast(DoubleClickActivity.this, "超时");
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

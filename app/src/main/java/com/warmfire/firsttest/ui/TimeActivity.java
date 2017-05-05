package com.warmfire.firsttest.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.warmfire.firsttest.R;
import com.xenione.digit.TabDigit;

/**
 * Created by warmfire on 2017/5/4.
 */

public class TimeActivity extends BaseActivity implements Runnable {

    // 设置标题
    ImageView img_back;
    TextView txt_title;
    TabDigit tabDigit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        setStateBarColor(this, Color.parseColor("#FF3F51B5"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        init();
        setListener();
    }

    public void init(){
        // 设置标题
        img_back = (ImageView) findViewById(R.id.title_back);
        txt_title = (TextView) findViewById(R.id.title_title);
        tabDigit = (TabDigit) findViewById(R.id.tabDigit1);
    }

    public void setListener(){
        txt_title.setText("倒计时");
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        ViewCompat.postOnAnimationDelayed(tabDigit, TimeActivity.this, 1000);
    }

    @Override
    public void run() {
        tabDigit.start();
        ViewCompat.postOnAnimationDelayed(tabDigit, TimeActivity.this, 1000);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

package com.warmfire.firsttest.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.warmfire.firsttest.R;
import com.warmfire.firsttest.utils.BackGestureListener;

/**
 * Created by warmfire on 2017/5/3.
 */

public class BackActivity extends BaseActivity {

    BackGestureListener backGestureListener;
    GestureDetector gestureDetector;
    // 设置标题
    ImageView img_back;
    TextView txt_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setStateBarColor(this, Color.parseColor("#FF3F51B5"));
        init();
        setListener();
    }

    public void init(){
        backGestureListener = new BackGestureListener(this);
        gestureDetector = new GestureDetector(backGestureListener);
        // 设置标题
        img_back = (ImageView) findViewById(R.id.title_back);
        txt_title = (TextView) findViewById(R.id.title_title);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    public void setListener(){
        txt_title.setText("滑动返回");
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

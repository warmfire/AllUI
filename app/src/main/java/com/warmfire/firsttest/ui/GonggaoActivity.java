package com.warmfire.firsttest.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.warmfire.firsttest.R;
import com.warmfire.firsttest.utils.MyToast;

import java.util.Arrays;

import ezy.ui.view.NoticeView;

/**
 * Created by warmfire on 2017/5/3.
 */

public class GonggaoActivity extends BaseActivity {

    // 设置标题
    ImageView img_back;
    TextView txt_title;
    NoticeView vNotice;
    String[] notices = {"1111111", "2222222", "3333333"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gonggao);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setStateBarColor(this, Color.parseColor("#FF3F51B5"));
        init();
        setListener();
    }

    public void init(){
        // 设置标题
        img_back = (ImageView) findViewById(R.id.title_back);
        txt_title = (TextView) findViewById(R.id.title_title);
    }

    public void setListener(){
        txt_title.setText("公告");
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        vNotice = (NoticeView) findViewById(R.id.notice);
        vNotice.start(Arrays.asList(notices));
        vNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyToast.ShortToast(GonggaoActivity.this, notices[vNotice.getIndex()]);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

package com.warmfire.firsttest.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.warmfire.firsttest.R;
import com.warmfire.firsttest.utils.MyToast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class ButterKnifeActivity extends BaseActivity {

    @BindView(R.id.butter_btn1)  public Button button1 ;
    // 设置标题
    @BindView(R.id.title_back)  ImageView img_back;
    @BindView(R.id.title_title)  TextView txt_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterknife);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setStateBarColor(this, Color.parseColor("#FF3F51B5"));
        setListener();
    }

    public void setListener(){
        txt_title.setText("ButterKnife");
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyToast.ShortToast(ButterKnifeActivity.this, "测试");
            }
        });
        button1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                MyToast.ShortToast(ButterKnifeActivity.this, "测试长按");
                return true;
            }
        });
    }

    @OnClick(R.id.butter_btn2)  void submit() {
        MyToast.ShortToast(ButterKnifeActivity.this, "测试2");
    }

    @OnLongClick(R.id.butter_btn2)  public boolean showToast2(){
        MyToast.ShortToast(ButterKnifeActivity.this, "测试2长按");
        return true  ;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}

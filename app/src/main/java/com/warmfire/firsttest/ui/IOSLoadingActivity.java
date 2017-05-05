package com.warmfire.firsttest.ui;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiang.android.pbutton.CProgressButton;
import com.suke.widget.SwitchButton;
import com.warmfire.firsttest.R;
import com.warmfire.firsttest.utils.MyToast;
import com.warmfire.firsttest.utils.SetStateBarColor;

public class IOSLoadingActivity extends Activity {

    ValueAnimator valueAnimator = ValueAnimator.ofInt(0,100); // 设置动画的初始值和结束值
    TextView tv;
    CProgressButton progressButton;
    int state = 0;
    // 设置标题
    ImageView img_back;
    TextView txt_title;
    SwitchButton switchButton;
    int lock = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iosloading);
        //最终方案
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //5.0 全透明实现
            //getWindow.setStatusBarColor(Color.TRANSPARENT)
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //4.4 全透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        SetStateBarColor.setStateBarColor(this, Color.parseColor("#FF3F51B5"));
        init();
        setListener();
        start();
    }

    public void init(){
        tv = (TextView) findViewById(R.id.state); // 绑定文本控件
        progressButton = (CProgressButton)findViewById(R.id.iosbtn); // 绑定按钮控件
        // 设置标题
        img_back = (ImageView) findViewById(R.id.title_back);
        txt_title = (TextView) findViewById(R.id.title_title);
        switchButton = (SwitchButton) findViewById(R.id.switch_button);
    }

    public void setListener(){
        txt_title.setText("仿iOS进度条");
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        switchButton.setChecked(false);
        switchButton.isChecked();
//        switchButton.toggle();     //switch state
//        switchButton.toggle(false);//switch without animation
//        switchButton.setShadowEffect(true);//disable shadow effect
//        switchButton.setEnabled(false);//disable button
//        switchButton.setEnableEffect(false);//disable the switch animation
        switchButton.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if(lock == 0){
                    MyToast.ShortToast(IOSLoadingActivity.this, "开");
                    switchButton.setChecked(true);
                    lock = 1;
                } else if(lock == 1){
                    MyToast.ShortToast(IOSLoadingActivity.this, "关");
                    switchButton.setChecked(false);
                    lock = 0;
                }
            }
        });
    }

    public void start(){
        CProgressButton.initStatusString(new String[]{"下载","暂停","完成","出错","删除"}); // 设置五个按钮状态
        progressButton.normal(0); // 设置按钮为初始状态
        progressButton.setOnClickListener(new View.OnClickListener() { // 设置按钮监听器
            @Override
            public void onClick(View v) { // 设置按钮点击方法
                valueAnimator.setDuration(5000); // 设置动画时间为5秒
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // 动画进行时的监听
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) { // 动画进行时的执行代码
                        int value = (int) animation.getAnimatedValue(); // 设置当前的动画进行进度
                        tv.setText("已下载:"+value); // 设置文本控件文本
                        progressButton.download(value); // 设置按钮进行进度
                        if(value == 100){ // 当动画结束时
                            progressButton.normal(2); // 设置按钮为完成状态
                            tv.setText("下载完成"); // 设置文本控件文本
                            state = 0;
                        }
                    }
                });
                if(progressButton.getState() == CProgressButton.STATE.NORMAL){ // 判断按钮为停止时的执行代码
                    if(state == 0){
                        valueAnimator.start(); //否则就是从头开始播放
                    } else if(state == 1){
                        valueAnimator.resume(); // 继续下载
                    }
                    progressButton.startDownLoad(); // 开始下载
                }else if(progressButton.getState() == CProgressButton.STATE.PROGRESS){ // 判断按钮为进行时的执行代码
                    progressButton.normal(1); // 设置按钮为暂停状态
                    valueAnimator.pause();
                    state = 1;
                }else { // 判断按钮在其他状态的执行代码
                    valueAnimator.end(); // 设置动画取消
                    progressButton.normal(3); // 设置按钮为出错状态
                    tv.setText("已下载"); // 设置文本控件文本
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


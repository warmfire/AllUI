package com.warmfire.firsttest.ui;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.warmfire.firsttest.R;
import com.warmfire.firsttest.utils.TimeCount;

public class MyDialogActivity extends BaseActivity {

    Button btn, btn_2;
    // 设置标题
    ImageView img_back;
    TextView txt_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydialog);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setStateBarColor(this, Color.parseColor("#FF3F51B5"));
        init();
        setListener();
    }

    public void init(){
        btn = (Button)findViewById(R.id.btn);
        btn_2 = (Button)findViewById(R.id.btn_2);
        // 设置标题
        img_back = (ImageView) findViewById(R.id.title_back);
        txt_title = (TextView) findViewById(R.id.title_title);
    }

    public void setListener(){
        txt_title.setText("自定义dialog");
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = LayoutInflater.from(MyDialogActivity.this);
                View v = inflater.inflate(R.layout.dialog_test, null);
                LinearLayout layout = (LinearLayout) v.findViewById(R.id.ll);
                TextView tipTextView = (TextView) v.findViewById(R.id.txt);
                Button btn_cancle = (Button) v.findViewById(R.id.btn1);
                Button btn_ok = (Button) v.findViewById(R.id.btn2);
                tipTextView.setText("123456");
                tipTextView.setTextColor(Color.parseColor("#555555"));
                final Dialog loadingDialog = new Dialog(MyDialogActivity.this, R.style.CustomDialog);
                loadingDialog.setCancelable(false);
                loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.FILL_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                Window window = loadingDialog.getWindow();
                WindowManager.LayoutParams lp = window.getAttributes();
                window.setGravity(Gravity.CENTER_HORIZONTAL);
                lp.alpha = 1f;
                window.setAttributes(lp);
                loadingDialog.show();
                btn_cancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        loadingDialog.dismiss();
                    }
                });
                btn_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        loadingDialog.dismiss();
                    }
                });
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = LayoutInflater.from(MyDialogActivity.this);
                View v = inflater.inflate(R.layout.dialog_test, null);
                LinearLayout layout = (LinearLayout) v.findViewById(R.id.ll);
                TextView tipTextView = (TextView) v.findViewById(R.id.txt);
                tipTextView.setText("123456");
                tipTextView.setTextColor(Color.parseColor("#555555"));
                final Dialog loadingDialog = new Dialog(MyDialogActivity.this, R.style.CustomDialog);
                loadingDialog.setCancelable(false);
                loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.FILL_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                Window window = loadingDialog.getWindow();
                WindowManager.LayoutParams lp = window.getAttributes();
                window.setGravity(Gravity.CENTER_HORIZONTAL);
                lp.alpha = 1f;
                window.setAttributes(lp);
                loadingDialog.show();
                TimeCount timer = new TimeCount(2000, 1000);
                timer.setDialog(loadingDialog);
                timer.start();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}

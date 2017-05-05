package com.warmfire.firsttest.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.warmfire.firsttest.R;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by warmfire on 2017/5/3.
 */

public class SweetAlertDialogActivity extends BackActivity {

    // 设置标题
    ImageView img_back;
    TextView txt_title;
    Button dialog_error, dialog_success, dialog_warning, dialog_image, dialog_progress, dialog_normal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sweetalertdialog);
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
        dialog_error = (Button) findViewById(R.id.dialog_error);
        dialog_success = (Button) findViewById(R.id.dialog_success);
        dialog_warning = (Button) findViewById(R.id.dialog_warning);
        dialog_image = (Button) findViewById(R.id.dialog_image);
        dialog_progress = (Button) findViewById(R.id.dialog_progress);
        dialog_normal = (Button) findViewById(R.id.dialog_normal);
    }

    public void setListener(){
        txt_title.setText("漂亮的dialog");
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        dialog_error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(SweetAlertDialogActivity.this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Error")
                        .setConfirmText("确定")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismiss();
                            }
                        })
                        .show();
            }
        });
        dialog_success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(SweetAlertDialogActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Success")
                        .setConfirmText("确定")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismiss();
                            }
                        })
                        .show();
            }
        });
        dialog_warning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(SweetAlertDialogActivity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Warning")
                        .setConfirmText("确定")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismiss();
                            }
                        })
                        .show();
            }
        });
        dialog_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(SweetAlertDialogActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                        .setTitleText("Image")
                        .setConfirmText("确定")
                        .setCustomImage(R.drawable.touxiang)
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismiss();
                            }
                        })
                        .show();
            }
        });
        dialog_progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(SweetAlertDialogActivity.this, SweetAlertDialog.PROGRESS_TYPE)
                        .setTitleText("Progress")
                        .setConfirmText("确定")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismiss();
                            }
                        })
                        .show();
            }
        });
        dialog_normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(SweetAlertDialogActivity.this, SweetAlertDialog.NORMAL_TYPE)
                        .setTitleText("Normal")
                        .setConfirmText("确定")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismiss();
                            }
                        })
                        .show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

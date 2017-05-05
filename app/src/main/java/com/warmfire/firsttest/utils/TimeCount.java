package com.warmfire.firsttest.utils;

import android.app.Dialog;
import android.os.CountDownTimer;

public  class TimeCount extends CountDownTimer{

    Dialog loadingDialog;

    @Override
    public void onTick(long l) {

    }

    public TimeCount(long millisInFuture, long countDownInterval)
    {
        super(millisInFuture, countDownInterval);
    }

    public void setDialog(Dialog loadingDialog){
        this.loadingDialog = loadingDialog;
    }

    @Override
    public void onFinish() {
        loadingDialog.dismiss();
    }

}

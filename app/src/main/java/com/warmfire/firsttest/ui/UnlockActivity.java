package com.warmfire.firsttest.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;
import com.andrognito.patternlockview.utils.ResourceUtils;
import com.andrognito.rxpatternlockview.RxPatternLockView;
import com.andrognito.rxpatternlockview.events.PatternLockCompoundEvent;
import com.warmfire.firsttest.R;
import com.warmfire.firsttest.utils.MyToast;

import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * Created by warmfire on 2017/5/4.
 */

public class UnlockActivity extends BaseActivity {

    // 设置标题
    ImageView img_back;
    TextView txt_title;
    PatternLockView patternLockView;
    String password = "";
    List<PatternLockView.Dot> pattern;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unlock);
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
        patternLockView = (PatternLockView) findViewById(R.id.pattern_lock_view);
    }

    public void setListener(){
        txt_title.setText("手势密码");
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        patternLockView.setDotAnimationDuration(150);
        patternLockView.setPathEndAnimationDuration(100);
        patternLockView.setNormalStateColor(ResourceUtils.getColor(this, R.color.white));
        patternLockView.setCorrectStateColor(ResourceUtils.getColor(UnlockActivity.this, R.color.green));
        patternLockView.setWrongStateColor(ResourceUtils.getColor(UnlockActivity.this, R.color.red));
        RxPatternLockView.patternChanges(patternLockView)
                .subscribe(new Consumer<PatternLockCompoundEvent>() {
                    @Override
                    public void accept(PatternLockCompoundEvent event) throws Exception {
                        if (event.getEventType() == PatternLockCompoundEvent.EventType.PATTERN_STARTED) {
                            Log.d(getClass().getName(), "Pattern drawing started");
                        } else if (event.getEventType() == PatternLockCompoundEvent.EventType.PATTERN_PROGRESS) {
//                            Log.d(getClass().getName(), "Pattern progress: " +
//                                    PatternLockUtils.patternToString(patternLockView, event.getPattern()));
                        } else if (event.getEventType() == PatternLockCompoundEvent.EventType.PATTERN_COMPLETE) {
                            Log.d(getClass().getName(), "Pattern complete: " +
                                    PatternLockUtils.patternToString(patternLockView, event.getPattern()));
                            String nowpassword = PatternLockUtils.patternToString(patternLockView, event.getPattern());
                            Log.d("Unlock", "old --> " + password);
                            Log.d("Unlock", "new --> " + nowpassword);
                            if(password.equals("") || password == null){
                                password = nowpassword;
                                MyToast.ShortToast(UnlockActivity.this, "密码设置成功");
                                patternLockView.clearPattern();
                            } else{
                                if(nowpassword.equals(password)){
                                    patternLockView.setViewMode(PatternLockView.PatternViewMode.CORRECT);
                                    MyToast.ShortToast(UnlockActivity.this, "密码正确");
                                } else {
                                    MyToast.ShortToast(UnlockActivity.this, "密码错误");
                                    patternLockView.setViewMode(PatternLockView.PatternViewMode.WRONG);
                                }
                            }
                            //MyToast.ShortToast(UnlockActivity.this, PatternLockUtils.patternToString(patternLockView, event.getPattern()));
                        } else if (event.getEventType() == PatternLockCompoundEvent.EventType.PATTERN_CLEARED) {
                            Log.d(getClass().getName(), "Pattern has been cleared");
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

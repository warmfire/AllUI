package com.warmfire.firsttest.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.warmfire.firsttest.R;
import com.warmfire.firsttest.utils.Titanic.Titanic;
import com.warmfire.firsttest.utils.Titanic.TitanicTextView;

/**
 * Created by warmfire on 2017/5/4.
 */

public class WaterActivity extends BaseActivity {

    // 设置标题
    ImageView img_back;
    TextView txt_title;
    Button btn_start, btn_end;
    TitanicTextView titanicTextView;
    Titanic titanic = new Titanic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);
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
        btn_start = (Button) findViewById(R.id.water_start);
        btn_end = (Button) findViewById(R.id.water_end);
        titanicTextView = (TitanicTextView) findViewById(R.id.titanic_tv);
    }

    public void setListener(){
        txt_title.setText("滑动返回");
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titanic.start(titanicTextView);
            }
        });
        btn_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titanic.cancel();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

package com.warmfire.firsttest.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.warmfire.firsttest.R;
import com.warmfire.firsttest.utils.MyToast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RetrofitActivity extends BaseActivity {

    private static String TAG = "RetrofitActivity";
    private static Button btn;
    private static TextView txt;
    // 设置标题
    ImageView img_back;
    TextView txt_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setStateBarColor(this, Color.parseColor("#FF3F51B5"));
        try {
            init();
            setListenner();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void init(){
        btn = (Button) findViewById(R.id.retrofit_btn);
        txt = (TextView) findViewById(R.id.retrofit_txt);
        // 设置标题
        img_back = (ImageView) findViewById(R.id.title_back);
        txt_title = (TextView) findViewById(R.id.title_title);
    }

    public void setListenner(){
        txt_title.setText("Retrofit");
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testRetrofitHttpGet();
            }
        });
    }

    public interface DemoService {
        @GET("http://192.168.16.247/RetrofitServer/Servlet") //正常
        Call<ResponseInfo> testHttpGet(@Query("method") String method, @Query("name") String name);
    }

    // GSON - BEAN
    class ResponseInfo {
        String describe;
        String method;
        String name;
    }

    private void testRetrofitHttpGet() {
        // step1
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.16.247/RetrofitServer/Servlet/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // step2
        DemoService service = retrofit.create(DemoService.class);
        // step3
        Call<ResponseInfo> call = service.testHttpGet("0", "123");

        // step4
        call.enqueue(new Callback<ResponseInfo>() {
            @Override
            public void onResponse(Call<ResponseInfo> call, Response<ResponseInfo> response) {
                try {
                    txt.setText("Suc --> " + response.body().describe + "\nmethod --> " + response.body().method + "\nname --> " + response.body().name);
                    Log.d(TAG, "Suc --> " + response.body().describe + " - " + response.body().method + response.body().name);
                } catch (Exception e){
                    e.printStackTrace();
                    MyToast.ShortToast(RetrofitActivity.this, "请确认服务器返回数据");
                }
            }

            @Override
            public void onFailure(Call<ResponseInfo> call, Throwable t) {
                Log.d(TAG, t.getMessage());
                MyToast.ShortToast(RetrofitActivity.this, "请打开服务器");
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

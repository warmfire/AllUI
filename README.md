# 好用的UI框架
好用的UI框架

## 1、自定义dialog
本人自己编写，并不美观，以实现功能为主
```Java
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
```

2、retrofit 
-----
参考网址：http://blog.csdn.net/ghost_Programmer/article/details/52372065?locationNum=2&fps=1
```Java
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
```

3、butterknife 
-----
参考网址：https://github.com/JakeWharton/butterknife    

```java
class ExampleActivity extends Activity {
  @BindView(R.id.user) EditText username;
  @BindView(R.id.pass) EditText password;

  @BindString(R.string.login_error) String loginErrorMessage;

  @OnClick(R.id.submit) void submit() {
    // TODO call server...
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.simple_activity);
    ButterKnife.bind(this);
    // TODO Use fields...
  }
}
```

4、仿iOS进度条
-----
参考网址：https://github.com/jiang111/CProgressButton      

![](https://raw.githubusercontent.com/jiang111/CProgressButton/master/art/art2.gif)

5、BannerView
-----
参考网址：https://github.com/czy1121/bannerview      

![](https://github.com/czy1121/bannerview/raw/master/screenshot.png)

6、双击按钮
-----
本人自己编写，并不美观，以实现功能为主      

```Java
long newTime = Calendar.getInstance().getTimeInMillis();
if(newTime - lastTime < 800){
  MyToast.ShortToast(DoubleClickActivity.this, "双击了按钮");
} else{
  lastTime = Calendar.getInstance().getTimeInMillis();
}
```

7、滑动返回
-----
参考网址：https://github.com/ikew0ng/SwipeBackLayout      

![](https://github.com/Issacw0ng/SwipeBackLayout/raw/master/art/screenshot.png?raw=true)

8、漂亮的dialog
-----
参考网址：https://github.com/pedant/sweet-alert-dialog      

![](https://github.com/pedant/sweet-alert-dialog/raw/master/change_type.gif)

9、公告
-----
参考网址：https://github.com/czy1121/noticeview      

![](https://github.com/czy1121/noticeview/raw/master/screenshot.png)

10、下拉刷新
-----
参考网址：https://github.com/Yalantis/Phoenix      

![](https://camo.githubusercontent.com/d406ac5a03a2b1fa5cf41fadc8d2408cb8709bdc/68747470733a2f2f6431337961637572716a676172612e636c6f756466726f6e742e6e65742f75736572732f3132353035362f73637265656e73686f74732f313635303331372f7265616c6573746174652d70756c6c5f312d322d332e676966)

11、水波文字
-----
参考网址：https://github.com/RomainPiel/Titanic      

![](https://github.com/RomainPiel/Titanic/raw/master/titanic.gif)

12、手势密码
-----
参考网址：https://github.com/aritraroy/PatternLockView      

![](https://github.com/aritraroy/PatternLockView/raw/master/screenshots/pattern_lock_view_small.gif?raw=true)
![](https://github.com/aritraroy/PatternLockView/raw/master/screenshots/pattern_lock_view_2_small.gif?raw=true)

13、搜索
-----
参考网址：https://github.com/KieronQuinn/PersistentSearch      

![](https://raw.githubusercontent.com/Quinny898/PersistentSearch/master/resources/search.gif)

14、仿ios开关
-----
参考网址：https://github.com/zcweng/ToggleButton      

![](https://github.com/zcweng/ToggleButton/raw/master/ToggleButtonSample/21879.gif)

15、仿QQ气泡拖拽消失
-----
参考网址：https://github.com/chenupt/BezierDemo      

![](https://raw.githubusercontent.com/chenupt/BezierDemo/master/pic/bezier.gif)

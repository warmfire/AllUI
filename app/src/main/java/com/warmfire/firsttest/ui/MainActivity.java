package com.warmfire.firsttest.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.warmfire.firsttest.R;
import com.warmfire.firsttest.utils.SetStateBarColor;
import com.warmfire.firsttest.utils.StartActivity;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SetStateBarColor.setStateBarColor(this, Color.parseColor("#FF3F51B5"));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            new SweetAlertDialog(this)
                    .setTitleText("关于")
                    .setContentText("Copyright © 2017  范正威 版权所有  |  联系方式：15158715552")
                    .show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_mydialog) {
            StartActivity.EasyStartActicity(MainActivity.this, MyDialogActivity.class);
        } else if (id == R.id.nav_retrofit) {
            StartActivity.EasyStartActicity(MainActivity.this, RetrofitActivity.class);
        } else if (id == R.id.nav_butterknife) {
            StartActivity.EasyStartActicity(MainActivity.this, ButterKnifeActivity.class);
        } else if (id == R.id.nav_iosloading) {
            StartActivity.EasyStartActicity(MainActivity.this, IOSLoadingActivity.class);
        } else if (id == R.id.nav_bannerview) {
            StartActivity.EasyStartActicity(MainActivity.this, BannerViewActivity.class);
        } else if (id == R.id.nav_doubleclick) {
            StartActivity.EasyStartActicity(MainActivity.this, DoubleClickActivity.class);
        } else if (id == R.id.nav_back) {
            StartActivity.EasyStartActicity(MainActivity.this, BackActivity.class);
        } else if (id == R.id.nav_sweet) {
            StartActivity.EasyStartActicity(MainActivity.this, SweetAlertDialogActivity.class);
        } else if (id == R.id.nav_gonggao) {
            StartActivity.EasyStartActicity(MainActivity.this, GonggaoActivity.class);
        } else if (id == R.id.nav_refresh) {
            StartActivity.EasyStartActicity(MainActivity.this, RefreshActivity.class);
        } else if (id == R.id.nav_water) {
            StartActivity.EasyStartActicity(MainActivity.this, WaterActivity.class);
        } else if (id == R.id.nav_unlock) {
            StartActivity.EasyStartActicity(MainActivity.this, UnlockActivity.class);
        } else if (id == R.id.nav_search) {
            StartActivity.EasyStartActicity(MainActivity.this, SearchActivity.class);
        } else if (id == R.id.nav_time) {
            StartActivity.EasyStartActicity(MainActivity.this, TimeActivity.class);
        } else if (id == R.id.nav_share) {
            new SweetAlertDialog(MainActivity.this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("当前缓存 0MB , 清空吗？")
                    .setConfirmText("清空")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismissWithAnimation();
                        }
                    })
                    .setCancelText("取消")
                    .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismissWithAnimation();
                        }
                    })
                    .show();
        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

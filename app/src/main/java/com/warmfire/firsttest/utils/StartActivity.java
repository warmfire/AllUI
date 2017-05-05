package com.warmfire.firsttest.utils;

import android.content.Context;
import android.content.Intent;

public class StartActivity {

    public static void EasyStartActicity(Context context, Class<?> cls){
        Intent intent = new Intent();
        intent.setClass(context, cls);
        context.startActivity(intent);
    }

    public static void EndStartActicity(Context context, Class<?> cls){
        Intent intent = new Intent();
        intent.setClass(context, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }
}

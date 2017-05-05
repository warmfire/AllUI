package com.warmfire.firsttest.utils;

import android.content.Context;
import android.widget.Toast;

public class MyToast {

    public static void ShortToast(Context context, String str){
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
    }

    public static void LongToast(Context context, String str){
        Toast.makeText(context, str, Toast.LENGTH_LONG).show();
    }
}

package com.warmfire.firsttest.utils;

import android.os.StrictMode;

/**
 * Created by warm_fire on 2016/10/27.
 */
public class NetworkOK {

    public static void setNetworkOnMainThread(){
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()
                .penaltyLog()
                .build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .detectLeakedClosableObjects()
                .penaltyLog()
                .penaltyDeath()
                .build());
    }
}

package com.linglingyi.siinax.sample;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2019/1/29.
 */

public class SampleApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}

package com.deli.commonpush;

import android.app.Application;

import com.deli.commonpush.util.PushUtil;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        PushUtil.initPush(this);
    }
}

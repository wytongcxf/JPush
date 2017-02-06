package com.cxf.jpush;

import android.app.Application;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by cxf on 2017/2/6.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initJPush();
    }

    private void initJPush(){
        //在开发时候使用debug,发布的时候关掉
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }
}

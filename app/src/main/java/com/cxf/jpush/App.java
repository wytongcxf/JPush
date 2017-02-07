package com.cxf.jpush;

import android.app.Application;

import com.google.gson.Gson;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by cxf on 2017/2/6.
 */
public class App extends Application {

    public static Gson sGson;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
        initJPush();
    }

    private void init(){
        sGson=new Gson();
    }

    private void initJPush(){
        //在开发时候使用debug,发布的时候关掉
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }
}

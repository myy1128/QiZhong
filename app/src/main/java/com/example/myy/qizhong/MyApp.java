package com.example.myy.qizhong;

import android.app.Application;

public class MyApp extends Application {
    public static MyApp app;

    public static MyApp getApp() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}

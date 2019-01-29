package com.kotlin.lifan.androidkotlin.base;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    public static App instance;
    public static int killTestIndex = 0;

    public static Context getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }
}

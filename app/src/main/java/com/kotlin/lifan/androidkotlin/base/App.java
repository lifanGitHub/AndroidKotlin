package com.kotlin.lifan.androidkotlin.base;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.util.Log;

import com.tencent.tinker.entry.ApplicationLike;
import com.tinkerpatch.sdk.TinkerPatch;
import com.tinkerpatch.sdk.loader.TinkerPatchApplicationLike;

public class App extends Application {
    private static final String TAG = "Tinker";
    private ApplicationLike tinkerApplicationLike;
    public static App instance;
    public static int killTestIndex = 0;

    public App() {
    }

    public static Context getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }

    @Override
    public void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //you must install multiDex whatever tinker is installed!
        //MultiDex.install(base);
        initTinkerPatch();
    }

    private void initTinkerPatch() {
        // 我们可以从这里获得Tinker加载过程的信息
        if (true) {
            Log.e("lftest",""+Process.myPid());
            Log.e("lftest",""+Thread.currentThread().getName());
            tinkerApplicationLike = TinkerPatchApplicationLike.getTinkerPatchApplicationLike();
            // 初始化TinkerPatch SDK
            TinkerPatch.init(
                    tinkerApplicationLike
//                new TinkerPatch.Builder(tinkerApplicationLike)
//                    .requestLoader(new OkHttp3Loader())
//                    .build()
            )
                    .reflectPatchLibrary()
                    .setPatchRollbackOnScreenOff(true)
                    .setPatchRestartOnSrceenOff(true)
                    .setFetchPatchIntervalByHours(3)
            ;
            // 获取当前的补丁版本
            Log.d(TAG, "Current patch version is " + TinkerPatch.with().getPatchVersion());

            // fetchPatchUpdateAndPollWithInterval 与 fetchPatchUpdate(false)
            // 不同的是，会通过handler的方式去轮询
            TinkerPatch.with().fetchPatchUpdateAndPollWithInterval();
        }
    }

}

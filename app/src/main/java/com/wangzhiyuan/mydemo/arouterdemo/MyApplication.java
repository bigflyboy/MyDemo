package com.wangzhiyuan.mydemo.arouterdemo;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ARouterInit();
    }

    private void ARouterInit(){
        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this);
    }
}

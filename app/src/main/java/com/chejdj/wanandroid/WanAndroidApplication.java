package com.chejdj.wanandroid;

import android.app.Application;

import com.chejdj.wanandroid.db.ObjectBox;
import com.chejdj.wanandroid.db.account.AccountManager;
import com.didichuxing.doraemonkit.DoraemonKit;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.crashreport.CrashReport;

public class WanAndroidApplication extends Application {
    private static WanAndroidApplication mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(this);
        mApplication = this;
        ObjectBox.init(this);
        AccountManager.getInstance().init();
        if (!LeakCanary.isInAnalyzerProcess(this)) {
            LeakCanary.install(this);
        }
        //安装性能监控程序
        DoraemonKit.install(this);
    }

    public static WanAndroidApplication getMyApplication() {
        return mApplication;
    }
}

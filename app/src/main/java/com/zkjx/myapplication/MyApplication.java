package com.zkjx.myapplication;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;


public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

    }
}
class BaseSettings{
    /**  是否禁止旋转屏幕 */
    public boolean isAllowScreenRoate=false;
    /** 是否允许全屏*/
    public boolean mAllowFullScreen= true;
}
// 共用方法
class CommonFunction{
    /**
     * startActivity
     */
    public static void readyGo(Context context, Class<?> clazz) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
    }
}

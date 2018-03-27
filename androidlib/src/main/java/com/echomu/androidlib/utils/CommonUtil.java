package com.echomu.androidlib.utils;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.google.gson.Gson;

import java.util.List;
import java.util.UUID;

/**
 * 一般工具类
 */
public class CommonUtil {


    /*****************************     获取手机状态操作        ***********************************/

    /**
     * 取得版本名称
     *
     * @param context
     * @return
     */
    public static PackageInfo getPackageInfo(Context context) {
//		try {
        PackageInfo manager = null;
        try {
            manager = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return manager;
//		} catch (NameNotFoundException e) {
//			return "Unknown";
//		}
    }


    /**
     * 获取UUID
     *
     * @return 32UUID小写字符串
     */
    public static String gainUUID() {
        String strUUID = UUID.randomUUID().toString();
        strUUID = strUUID.replaceAll("-", "").toLowerCase();
        return strUUID;
    }

    /**
     * 判断当前应用程序处于前台还是后台
     */
    public static boolean isApplicationBroughtToBackground(final Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(1);
        if (!tasks.isEmpty()) {
            ComponentName topActivity = tasks.get(0).topActivity;
            if (!topActivity.getPackageName().equals(context.getPackageName())) {
                return true;
            }
        }
        return false;

    }

    /**
     * 判断当前应用程序处于前台还是后台
     */
    public static boolean isApplicationRunning(final Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> list = am.getRunningTasks(100);
        boolean isAppRunning = false;
        String MY_PKG_NAME = context.getPackageName();
        for (ActivityManager.RunningTaskInfo info : list) {
            if (info.topActivity.getPackageName().equals(MY_PKG_NAME) || info.baseActivity.getPackageName().equals(MY_PKG_NAME)) {
                isAppRunning = true;
                CommonLog.d(CommonLog.class, info.topActivity.getPackageName() + " info.baseActivity.getPackageName()=" + info.baseActivity.getPackageName());
                break;
            }
        }

        return isAppRunning;
    }

    /**
     * 解析json数据
     *
     * @param json
     * @param class1
     * @return 返回JSON数据对象bean
     */
    public static <T> Object processJson(String json, Class<T> class1) {
        // 解析json
        Gson gson = new Gson();
        T bean = gson.fromJson(json, class1);

        return bean;
    }

}

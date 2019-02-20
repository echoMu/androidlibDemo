package com.echomu.androidlib.utils.exit;

import android.app.Activity;
import android.content.Context;

/**
 * 双击退出Activity的类。
 *
 * @author Geek_Soledad (66704238@51uc.com)
 */
public class ExitDoubleClick extends DoubleClick {

    private static ExitDoubleClick exit;

    private ExitDoubleClick(Context context) {
        super(context);
    }

    /**
     * 返回一个双击退出的实例。
     *
     * @param context
     * @return ExitDoubleClick
     */
    public static synchronized ExitDoubleClick getInstance(Context context) {
        if (exit == null) {
            exit = new ExitDoubleClick(context);
        }
        return exit;
    }
    /**
     * 返回一个双击退出的实例。
     *
     * @param context
     * @return ExitDoubleClick
     */
    public static synchronized ExitDoubleClick getInstance(Context context, exitApplication eApplication) {
        if (exit == null) {
            exit = new ExitDoubleClick(context);
        }
        exit.eApplication = eApplication;
        return exit;
    }

    /**
     * 双击之后退出。
     */
    @Override
    protected void afterDoubleClick() {
        if(exit.eApplication!=null){
            exit.eApplication.exit();
        }else{
            if (mContext instanceof Activity){
                ((Activity) mContext).finish();
            }
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
            destroy();
        }

    }

    /**
     * 双击退出Activity，如果msg为null，而默认显示的提示语为"再按一次退出"。
     */
    @Override
    public void doDoubleClick(int delayTime, String msg) {
        if (msg == null ||"".equals(msg)) {
            msg = "再按一次退出";
        }
        super.doDoubleClick(delayTime, msg);
    }

    private static void destroy() {
        exit = null;
    }

    /**
     * 退出回调
     * @author hejinix
     *
     */
    public interface exitApplication{
        void exit();
    }

    private exitApplication eApplication;

    public exitApplication geteApplication() {
        return eApplication;
    }

    public void seteApplication(exitApplication eApplication) {
        this.eApplication = eApplication;
    }



}

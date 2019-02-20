package com.echomu.androidlib.widget;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.echomu.androidlib.R;

public class BasePopupWindow extends PopupWindow {
    protected Activity mContext;

    public View getView() {
        return view;
    }

    protected View view;

    public boolean isSetAlpha() {
        return setAlpha;
    }

    public void setSetAlpha(boolean setAlpha) {
        this.setAlpha = setAlpha;
    }

    protected boolean setAlpha = true;

//    @Override
//    public void onClick(View v) {
//
//        switch (v.getId()) {
//            case R.id.pop_close:
//
//                dismiss();
//
//                break;
//        }
//
//    }

    public BasePopupWindow(Activity context) {
        super(context);
        mContext = context;
        setAnimationStyle(R.style.AnimationBottom);
        setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        setFocusable(true);
        ColorDrawable cd = new ColorDrawable();
        setBackgroundDrawable(cd);
        // 解决5.0Lollipop上被NavigationBar遮挡的问题
        setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
    }


    @Override
    public void showAsDropDown(View anchor) {
        //解决7.0锚点位置错乱现象
        this.view = anchor;
        if (Build.VERSION.SDK_INT >= 24) {
            Rect visibleFrame = new Rect();
            anchor.getGlobalVisibleRect(visibleFrame);
            int height = anchor.getResources().getDisplayMetrics().heightPixels - visibleFrame.bottom;
            setHeight(height);
        }
        super.showAsDropDown(anchor);
    }

    public void showShareBottomWindow(View anchor) {
        showShareBottomWindow(anchor, Gravity.BOTTOM);
    }

    public void showShareBottomWindow(View anchor, int gravity) {
        if (setAlpha) {
            backgroundAlpha(mContext, 0.4f);
        }
        this.view = anchor;

        this.showAtLocation(anchor, gravity, 0, 0);
    }
    @Override
    public void dismiss() {
        super.dismiss();
        if (setAlpha) {
            backgroundAlpha(mContext, 1);
        }

    }

    // 设置屏幕透明度
    public void backgroundAlpha(Activity activity, float bgAlpha) {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = bgAlpha; // 0.0~1.0
        activity.getWindow().setAttributes(lp); //act 是上下文context

    }
}

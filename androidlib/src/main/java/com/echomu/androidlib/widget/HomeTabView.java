package com.echomu.androidlib.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.echomu.androidlib.R;

/**
 * HomeBottomView
 *
 * @date 2018/4/11.
 */

public class HomeTabView extends FrameLayout {

    /**
     * tab名字
     */
    private TextView mTvBottomTab;

    /**
     * 当前下标
     */
    private int mIndex;


    /**
     * 选中的颜色
     */
    private int mCheckedColor;

    /**
     * 未选中的颜色
     */
    private int mUnCheckedColor;

    /**
     * 图标资源
     */
    private int mDrawableRes;

    /**
     * tab点击监听
     */
    private OnTabClickListener onTabClickListener;
    private ImageView mIvBottomTab;


    public HomeTabView(Context context) {
        super(context, null);
        initView(context);

    }

    /**
     * 初始化View
     *
     * @param context
     */
    private void initView(Context context) {

        View viewBottomTab = View.inflate(context, R.layout.layout_home_tab, (ViewGroup) getParent());
        mTvBottomTab = (TextView) viewBottomTab.findViewById(R.id.tv_bottom_tab);
        mIvBottomTab = (ImageView) viewBottomTab.findViewById(R.id.iv_bottom_tab);
        addView(viewBottomTab);
        viewBottomTab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onTabClickListener != null) {
                    onTabClickListener.onClick(mIndex);
                }
            }
        });
        invalidate();

    }

    /**
     * 设置tab名称
     *
     * @param tabName
     */
    public void setTabName(int index, String tabName) {
        mIndex = index;
        mTvBottomTab.setText(tabName);
        postInvalidate();
    }

    /**
     * 设置一个DrawableRes图标
     *
     * @param drawableRes
     */
    public void setTabImageResource(@DrawableRes int drawableRes) {
        mDrawableRes = drawableRes;
        mIvBottomTab.setImageDrawable(ContextCompat.getDrawable(getContext(), drawableRes));
    }

    /**
     * 设置drawable图标
     *
     * @param drawable drawable
     */
    public void setTabDrawable(Drawable drawable) {
        mIvBottomTab.setImageDrawable(drawable);
    }

    /**
     * 是否选中状态
     *
     * @param checked 是否选中
     */
    public void checked(boolean checked) {
        if (checked) {
            mTvBottomTab.setTextColor(mCheckedColor);
            if (mDrawableRes != 0) {
                changeVectorDrawable(mDrawableRes, mCheckedColor, mIvBottomTab);
            }
        } else {
            mTvBottomTab.setTextColor(mUnCheckedColor);
            if (mDrawableRes != 0) {

                changeVectorDrawable(mDrawableRes, mUnCheckedColor, mIvBottomTab);
            }
        }
        invalidate();
    }

    /**
     * 修改drawable颜色
     *
     * @param drawableIcon 需要改变颜色的图标
     * @param color        需要改变的颜色
     * @param iv           应用的ImageView
     */
    private void changeVectorDrawable(int drawableIcon, @ColorInt int color, ImageView iv) {

        Drawable drawable = ContextCompat.getDrawable(getContext(), drawableIcon);
        if (drawable == null) {
            throw new Resources.NotFoundException("没有找到图标");
        }
        //使用包装类为drawable添加颜色
        Drawable drawableCompat = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(drawableCompat, color);
        iv.setImageDrawable(drawableCompat);

    }

    public void setOnTabClickListener(OnTabClickListener onTabClickListener) {
        this.onTabClickListener = onTabClickListener;
    }

    /**
     * 设置颜色
     *
     * @param mCheckedColor 选中的颜色
     */
    public void setCheckedColor(int mCheckedColor) {
        this.mCheckedColor = mCheckedColor;
    }

    public void setUnCheckedColor(int mUnCheckedColor) {
        this.mUnCheckedColor = mUnCheckedColor;
    }


    /**
     * 底部view的点击监听
     */
    public interface OnTabClickListener {
        void onClick(int position);
    }
}

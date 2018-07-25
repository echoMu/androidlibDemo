package com.echomu.androidlib.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.echomu.androidlib.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义底部布局
 *
 * @date 2018/4/11.
 */
public class HomeTabLayout extends LinearLayout {

    private static final String TAG = HomeTabLayout.class.getSimpleName();


    /**
     * tab集合
     */
    private List<HomeTabView> mTabViewList = new ArrayList<>();

    /**
     * tab的点击监听
     */
    private OnTabClickListener mOnTabClickListener;
    private int mDefaultCheckedPosition;
    private int mCheckedColor;
    private int mUnCheckedColor;


    public HomeTabLayout(Context context) {
        this(context, null);
    }

    public HomeTabLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttr(context, attrs);
        setOrientation(HORIZONTAL);
    }

    /**
     * 获取自定义属性
     *
     * @param context
     * @param attrs
     */
    private void initAttr(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.HomeTabLayout);
        mDefaultCheckedPosition = array.getInteger(R.styleable.HomeTabLayout_checkedPosition, 0);
        mCheckedColor = array.getColor(R.styleable.HomeTabLayout_checkedColor, ContextCompat.getColor(getContext(), R.color.colorPrimary));
        mUnCheckedColor = array.getColor(R.styleable.HomeTabLayout_unCheckedColor, Color.parseColor("#9B9B9B"));
        array.recycle();
    }

    /**
     * 设置数据
     *
     * @param tabNameList tab名字列表
     */
    public void setBottomLabel(List<String> tabNameList) {
        //充满布局
        LinearLayout.LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 1.0f);
        for (int i = 0; i < tabNameList.size(); i++) {
            //创建一个底部tab
            HomeTabView homeTabView = new HomeTabView(getContext());
            homeTabView.setTabName(i, tabNameList.get(i));
            homeTabView.setCheckedColor(mCheckedColor);
            homeTabView.setUnCheckedColor(mUnCheckedColor);
            homeTabView.setOnTabClickListener(new HomeTabView.OnTabClickListener() {
                @Override
                public void onClick(int position) {
                    setChecked(position);
                    if (mOnTabClickListener != null) {
                        mOnTabClickListener.onClick(position);
                    }
                }
            });
            mTabViewList.add(homeTabView);
            addView(homeTabView, layoutParams);
        }

        invalidate();
    }

    /**
     * 设置某个tab选中
     *
     * @param position
     */
    public void setChecked(int position) {
        if (position <= 0) {
            position = 0;
        } else if (position > mTabViewList.size()) {
            position = mTabViewList.size() - 1;
        }
        for (int i = 0; i < mTabViewList.size(); i++) {
            mTabViewList.get(i).checked(false);
        }
        mTabViewList.get(position).checked(true);
    }

    public void setOnTabClickListener(OnTabClickListener onTabClickListener) {
        this.mOnTabClickListener = onTabClickListener;
    }

    /**
     * 设置tabIcon
     *
     * @param drawables 图片数组
     */
    public void setBottomLabelImg(List<Drawable> drawables) {

        for (int i = 0; i < drawables.size(); i++) {
            mTabViewList.get(i).setTabDrawable(drawables.get(i));
        }
        //设置默认的选中tab
        setChecked(mDefaultCheckedPosition);
        invalidate();
    }

    public void setBottomLabelImg(int[] drawables) {
        for (int i = 0; i < drawables.length; i++) {
            mTabViewList.get(i).setTabImageResource(drawables[i]);
        }
        //设置默认的选中tab
        setChecked(mDefaultCheckedPosition);
        invalidate();

    }


    /**
     * 让最外层的layout监听点击事件
     */
    public interface OnTabClickListener {
        void onClick(int position);
    }

}

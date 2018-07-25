package com.echomu.androidlib.utils;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.ArrayList;

/**
 * @date 2018/4/19.
 */

public class FragmentUtil {


    /**
     * LinkedList
     */
    private static ArrayList<Fragment> fragmentList = new ArrayList<>();


    /**
     * 向布局添加Fragment
     *
     * @param savedInstance   保存Fragment状态
     * @param fragmentManager FragmentManager
     * @param containerId     容器布局id
     * @param fragments       Fragment
     */
    public static void addFragmentToContainer(Bundle savedInstance, FragmentManager fragmentManager, @IdRes int containerId, Fragment... fragments) {
        if (savedInstance == null) {
            fragmentList.clear();
            //遍历添加Fragment
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            for (Fragment fragment : fragments) {
                fragmentTransaction.add(containerId, fragment, fragment.getClass().getSimpleName());
                fragmentList.add(fragment);
            }
            fragmentTransaction.commit();
            //显示第一个Fragment
            showFragment(fragmentManager, 0);
        } else {
            //按顺序获取Fragment
            for (int i = 0; i < fragmentList.size(); i++) {
                fragments[i] = fragmentManager.findFragmentByTag(fragmentList.get(i).getClass().getSimpleName());
            }
            showFragment(fragmentManager, 0);

        }
    }


    /**
     * 显示单个Fragment
     *
     * @param fragmentManager support.v4包的FragmentManager
     * @param position        显示的位置
     */
    public static void showFragment(FragmentManager fragmentManager, int position) {
        checkPosition(position);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.show(fragmentList.get(position));
        fragmentList.get(position).setUserVisibleHint(true);
        for (int i = 0; i < fragmentList.size(); i++) {
            if (i != position) {
                fragmentTransaction.hide(fragmentList.get(i));
                fragmentList.get(i).setUserVisibleHint(false);
            }
        }
        fragmentTransaction.commit();
    }

    /**
     * 检验position的合法性
     * @param position position
     */
    private static void checkPosition(int position) {
        if (position >= fragmentList.size()) {
            throw new IllegalArgumentException("position长度大于Fragment列表长度");
        } else if (position < 0) {
            position = 0;
        }
    }
}

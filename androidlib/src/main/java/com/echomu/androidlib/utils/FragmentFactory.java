package com.echomu.androidlib.utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <pre>
 *  反射创建Fragment对象
 *  Fragment必须有newInstance方法
 * </pre>
 *
 * @date 2018/4/11.
 */

public class FragmentFactory {


    /**
     * 反射调用创建Fragment
     *
     * @param fragmentClass Fragment实例,Fragment必须有newInstance()方法.
     * @param bundle        传递给Fragment 的参数
     * @param <T>           Fragment泛型
     * @return
     */
    public static <T> Fragment createFragment(Class<T> fragmentClass, @Nullable Bundle bundle) {
        try {
            Method method = fragmentClass.getMethod("newInstance", Bundle.class);
            return (Fragment) method.invoke(fragmentClass, bundle);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();


        }

        return null;
    }

    /**
     * 没有Bundle构建的Fragment
     *
     * @param fragmentClass Fragment实例,Fragment必须有newInstance()方法.
     * @return Fragment实例
     */
    public static <T> Fragment createFragment(Class<T> fragmentClass) {
        return createFragment(fragmentClass, null);
    }


}

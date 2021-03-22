package com.example.mvpdemo.utils;

import android.text.TextUtils;

/**
 * @author SpreadWater
 * @Date 2021-03-22
 * @Time 11:26
 * @description TODO(字符串操作公用类)
 */

public class StringUtils {

    /**
     * @return true 有一个为empty就为true ， false 都不为empty就为false
     * @Description TODO(判断字符串是否为empty)
     * @author SpreadWater
     * @parame 接收一个字符串数组
     */
    public static boolean isEmpty(String... values) {

        boolean isEmpty = false;

        for (int i = 0; i < values.length; i++) {
            if (TextUtils.isEmpty(values[i])) {
                isEmpty = true;
                break;
            }
        }

        return isEmpty;
    }
}


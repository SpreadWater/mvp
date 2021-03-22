package com.example.mvpdemo.utils;

/**
 * @author SpreadWater
 * @Date 2021-03-22
 * @Time 11:26
 * @description TODO(提示公用类)
 */

import android.content.Context;
import android.widget.Toast;

public class T {

    public static void show(Context context, String hint) {
        Toast.makeText(context, hint, Toast.LENGTH_SHORT).show();
    }
}


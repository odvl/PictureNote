package com.example.administrator.picturenote.utils;

import android.util.Log;

/**
 * Created by Administrator on 2016/1/19.
 */
public class LogUtil {
    private static final String TAG = "PNT";

    public static void i(String message) {
        Log.i(TAG, "i: " + message);
    }

    public static void d(String message) {
        Log.d(TAG, "d: " + message);
    }

    public static void e(String message) {
        Log.e(TAG, "e: " + message);
    }

    public static void w(String message) {
        Log.w(TAG, "w: " + message);
    }
}

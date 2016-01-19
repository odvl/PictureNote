package com.example.administrator.picturenote.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.administrator.picturenote.common.Constant;

/**
 * Created by Administrator on 2016/1/19.
 */
public class SharedPreferencesUtil {

    private static SharedPreferencesUtil Instance;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    private SharedPreferencesUtil(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(Constant.SharedPreferencesField.NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static SharedPreferencesUtil getInstance(Context context) {
        if (null == Instance) {
            synchronized (SharedPreferencesUtil.class) {
                if (null == Instance) {
                    Instance = new SharedPreferencesUtil(context);
                }
            }
        }
        return Instance;
    }

    public void setInt(String name, int value) {
        editor.putInt(name, value).apply();
    }

    public int getInt(String name, int defValue) {
        return sharedPreferences.getInt(name, defValue);
    }

    public void setString(String name, String value) {
        editor.putString(name, value).apply();
    }

    public String getString(String name, String defValue) {
        return sharedPreferences.getString(name, defValue);
    }

    public void setBoolean(String name, boolean value) {
        editor.putBoolean(name, value).apply();
    }

    public boolean getBoolean(String name, boolean defValue) {
        return sharedPreferences.getBoolean(name, defValue);
    }

}

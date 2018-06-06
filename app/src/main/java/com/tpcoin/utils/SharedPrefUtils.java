package com.tpcoin.utils;
/*
 * Created by HoangDong on 30/11/2017.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.tpcoin.others.constant.AppConstant;


public class SharedPrefUtils {

    public static String getString(Context context, String key) {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        return preferences.getString(key, "");
    }

    public static void setString(Context context, String key, String content) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context)
                .edit();
        edit.putString(key, content);
        edit.apply();
    }

    public static int getInt(Context context, String key) {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        return preferences.getInt(key, 0);
    }

    public static void setInt(Context context, String key, int content) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context)
                .edit();
        edit.putInt(key, content);
        edit.apply();
    }

    public static boolean getBoolean(Context context, String key) {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(context);
        return preferences.getBoolean(key, false);
    }

    public static void setBoolean(Context context, String key, boolean content) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context)
                .edit();
        edit.putBoolean(key, content);
        edit.apply();
    }


    public static void resetUser(Context context) {
        setString(context, AppConstant.KEY_USER, "");
    }

}

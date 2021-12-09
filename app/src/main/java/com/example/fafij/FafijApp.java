package com.example.fafij;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

public class FafijApp extends Application {
    public static Context context;
    public static String getToken() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        Log.e("1", sp.getString("jwtToken", ""));
        if (sp.contains("jwtToken")) return "Bearer " + sp.getString("jwtToken", "");
        else return "";
    }
}

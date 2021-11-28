package com.example.fafij;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class FafijApp extends Application {
    public static Context context;
    public String getToken() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        if (sp.contains("jwtToken")) return sp.getString("jwtToken", "");
        else return "";
    }
}

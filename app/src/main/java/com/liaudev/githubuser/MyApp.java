package com.liaudev.githubuser;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;

import androidx.appcompat.app.AppCompatDelegate;

import dagger.hilt.android.HiltAndroidApp;

/**
 * Created by Budiliauw87 on 2022-08-21.
 * budiliauw87.github.io
 * Budiliauw87@gmail.com
 */
@HiltAndroidApp
public class MyApp extends Application {
    private static MyApp mInstance;
    private SharedPreferences sharedPref;
    private String langApp;
    private String themeMode;

    public static synchronized MyApp getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        sharedPref = this.getSharedPreferences(getString(R.string.title_settings), Context.MODE_PRIVATE);
        readMyPref();
        applyTheme();

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    public void readMyPref() {
        this.setLangApp(sharedPref.getString("language_app", "en"));
        this.setThemeMode(sharedPref.getString("theme_mode", "default"));
    }

    public void applyTheme() {
        String themeMode = this.getThemeMode();
        switch (themeMode) {
            case "light":
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
            case "dark":
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            default:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY);
                }
                break;
        }
    }

    public String getLangApp() {
        return langApp;
    }

    public void setLangApp(String langApp) {
        this.langApp = langApp;
    }

    public String getThemeMode() {
        return themeMode;
    }

    public void setThemeMode(String themeMode) {
        this.themeMode = themeMode;
    }

    public void saveThemeMode(String mode) {
        this.setThemeMode(mode);
        sharedPref.edit().putString("theme_mode", mode).apply();
    }

    public void saveLanguage(String language) {
        this.setLangApp(language);
        sharedPref.edit().putString("language_app", language).apply();
    }
}

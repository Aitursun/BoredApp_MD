package com.example.boredapp_md;

import android.content.Context;
import android.content.SharedPreferences;

import java.nio.file.attribute.FileAttribute;

public class Prefs {
    private SharedPreferences preferences;
    //-----------------------------------------------------------------------------------
    public Prefs(Context context){
        preferences = context.getSharedPreferences(
                "settings", Context.MODE_PRIVATE);
    }

    public void saveBoardState(){ preferences.edit().putBoolean("isShow", true).apply();}

    public boolean isShow(){ return preferences.getBoolean("isShow", false);}

    public void saveString(String textProfile) {
        preferences.edit().putString("text", textProfile).apply();}

    public String getStringData() {return preferences.getString("text", "");}

    public void clear(){preferences.edit().clear().apply();}

    public void saveImage(String result) {preferences.edit().putString("avatar", result).apply();}

    public String getAvatar(){return preferences.getString("avatar", null);}
}

//-----------------------------------------------------------------------------------


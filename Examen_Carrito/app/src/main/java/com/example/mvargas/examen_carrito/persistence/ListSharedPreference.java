package com.example.mvargas.examen_carrito.persistence;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


import com.example.mvargas.examen_carrito.common.Constants;
import com.example.mvargas.examen_carrito.session.Session;

/**
 * Created by MVARGAS on 02/07/2015.
 */
public class ListSharedPreference {

    private SharedPreferences sharedPreferences=null;
    private static ListSharedPreference instance=null;
    private ListSharedPreference(){
        sharedPreferences= Session.contex.getSharedPreferences(Constants.APP_TAG, Context.MODE_PRIVATE);
    }

    private synchronized static void createInstance(){
        if(instance==null){
            instance=new ListSharedPreference();
        }
    }

    public static ListSharedPreference getInstance(){
        if(instance==null){
            createInstance();
        }
        return instance;
    }

    public void setStringData(String value, String data){
        Editor editor=sharedPreferences.edit();
        editor.putString(value,data);
        editor.commit();
    }
    public void setBooleanData(String value, Boolean data){
        Editor editor=sharedPreferences.edit();
        editor.putBoolean(value, data);
        editor.commit();
    }

    public void setIntData(String value, int data){
        Editor editor=sharedPreferences.edit();
        editor.putInt(value, data);
        editor.commit();
    }

    public void setFloatData(String value, float data){
        Editor editor=sharedPreferences.edit();
        editor.putFloat(value, data);
        editor.commit();
    }

    public float getFloatData(String key){
        float resp=0;
        try {
            resp=sharedPreferences.getFloat(key,0);
        }
        catch (Exception e){

        }
        return resp;
    }
    public String getData(String key){
        String resp="";
        try {
            resp=sharedPreferences.getString(key,"");
        }
        catch (Exception e){

        }
        return resp;
    }

    public int getDataInt(String key){
        int resp=0;
        try {
            resp=sharedPreferences.getInt(key, -1);

        }
        catch (Exception e){

        }
        return resp;
    }
    public Boolean getDataBoolean(String key){
        Boolean resp=false;
        try {
            resp=sharedPreferences.getBoolean(key, false);
        }
        catch (Exception e){

        }
        return resp;
    }
}

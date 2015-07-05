package com.example.mvargas.examen_carrito.common;

import java.io.IOException;
import java.io.InputStream;


import com.example.mvargas.examen_carrito.persistence.ListSharedPreference;
import com.example.mvargas.examen_carrito.session.Session;

/**
 * Created by MVARGAS on 02/07/2015.
 */


public class Utils {


    public static boolean isEmpty(String value) {
        if (value.equals("") || value == null)
            return true;
        else
            return false;
    }


    public static boolean isFirstRun() {
        int value = ListSharedPreference.getInstance().getDataInt("firstRun");
        if (value == -1) {
            registerApp();
            return true;
        }
        else
            return false;
    }

    public static void registerApp() {

        ListSharedPreference.getInstance().setIntData("firstRun", 1);
    }

    public String loadJSONFromAsset() {
        String json;
        try {

            InputStream is = Session.contex.getAssets().open("productos.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }

}

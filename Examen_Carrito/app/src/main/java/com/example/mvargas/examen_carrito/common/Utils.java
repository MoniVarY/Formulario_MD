package com.example.mvargas.examen_carrito.common;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

import com.example.mvargas.examen_carrito.models.Persona;
import com.example.mvargas.examen_carrito.persistence.ListSharedPreference;
import com.example.mvargas.examen_carrito.session.Session;

import java.util.ArrayList;

/**
 * Created by MVARGAS on 02/07/2015.
 */


public class Utils {

    //private Context context; //<-- declare a Context reference

    /*public static ArrayList<Persona> getData() {
        ArrayList<Persona>personas = new ArrayList<Persona>();
        //int total=personas.size();
        int total=Contacts.NOMBRES.length;

        for (int i=0;i<total;i++) {
            Persona persona=new Persona();
            persona.setNombre(Contacts.NOMBRES[i]);
            personas.add(persona);

        }
        return personas;
    }*/

    public static boolean isEmpty(String value) {
        if (value.equals("") || value == null)
            return true;
        else
            return false;
    }

    public static void showMessage(String message) {
        Toast messageToast = Toast.makeText(Session.contex, message, Toast.LENGTH_SHORT);
        messageToast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
        messageToast.show();
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

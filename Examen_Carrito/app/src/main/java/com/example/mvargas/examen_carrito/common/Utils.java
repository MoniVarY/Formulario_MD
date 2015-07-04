package com.example.mvargas.examen_carrito.common;


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

}

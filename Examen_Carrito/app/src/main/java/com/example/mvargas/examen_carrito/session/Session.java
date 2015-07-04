package com.example.mvargas.examen_carrito.session;

import android.app.Application;
import android.content.Context;

/**
 * Created by MVARGAS on 02/07/2015.
 */
public class Session extends Application {

    public static Context contex;


    @Override
    public void onCreate(){
        super.onCreate();
        contex=this;
    }
}

package com.example.mvargas.examen_carrito.db;

import com.example.mvargas.examen_carrito.common.Constants;

/**
 * Created by MVARGAS on 03/07/2015.
 */
public class DatabaseManager {







    public static final String CREATE_TABLE_PERSONAS = "CREATE TABLE IF NOT EXISTS " + Constants.CREA_USUARIO_TABLA + "(" + Constants.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + Constants.NAME+ " TEXT, "
            + Constants.TELEFONO+ " TEXT, "
            + Constants.USUARIO+ " TEXT, "
            + Constants.PASSWORD+ " TEXT, "
            + Constants.CORREO+ " TEXT )";
//IF NOT EXISTS

}


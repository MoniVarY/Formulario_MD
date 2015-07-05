package com.example.mvargas.examen_carrito.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mvargas.examen_carrito.common.Constants;
import com.example.mvargas.examen_carrito.models.Customer;
import com.example.mvargas.examen_carrito.models.Persona;

import java.util.ArrayList;

/**
 * Created by MVARGAS  on 03/07/2015.
 */
public class CarritoReaderDBHelper extends SQLiteOpenHelper{

    public CarritoReaderDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        //db.execSQL(DatabaseManager.CREATE_TABLE_PERSONAS);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS "+Persona.TABLE);

        /*String CREATE_TABLE_PERSONAS = "CREATE TABLE IF NOT EXISTS " + Persona.TABLE + "(" + Persona.KEY_ID + " INTEGER PRIMARY KEY AUTOONCREMENT ,"
                + Persona.KEY_name+ " TEXT, "
                + Persona.KEY_firstap+ " TEXT, "
                + Persona.KEY_secondap+ " TEXT, "
                + Persona.KEY_telefono+ " TEXT, "
                + Persona.KEY_edad+ " TEXT, "
                + Persona.KEY_estado+ " TEXT )";
        db.execSQL(CREATE_TABLE_PERSONAS);
        onCreate(db);*/
    }
   /* public void insertarDatos(SQLiteDatabase db,String nombre, String ap1, String ap2, String tel, String estado, String edad) {
        String sqlInsert = "insert into " + Constants.TABLA_USUARIO +
                " values("+"null"+","
                + "'"+nombre +"'"+","
                + "'"+ap1 +"'"+","
                + "'"+ap2 +"'"+","
                + "'"+tel +"'"+","
                + "'"+estado +"'"+","
                + "'"+edad +"'"+")";
        db.execSQL(sqlInsert);
    }
    public ArrayList<Customer> recuperarDatos(SQLiteDatabase db) {
        ArrayList<Customer> arraycliente=new ArrayList<Customer>();

        String sqlConsultar = "select * from " + Constants.TABLA_USUARIO;

        //db.execSQL(sqlInsert);
        Cursor c=db.rawQuery(sqlConsultar,null);
        if(c.moveToFirst()){
            do {
                Customer cliente=new Customer();
                cliente.setId(c.getInt(0));
                cliente.setNombre(c.getString(1));
                cliente.setTelefono(c.getString(2));
                cliente.setUsuario(c.getString(3));
                cliente.setTelefono(c.getString(4));
                cliente.setPassword(c.getString(5));
                cliente.setCorreo(c.getString(6));
                arraycliente.add(cliente);
            } while(c.moveToNext());


        }
        return arraycliente;
    }*/
}

package com.example.mvargas.examen_carrito.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mvargas.examen_carrito.common.Constants;
import com.example.mvargas.examen_carrito.common.Utils;
import com.example.mvargas.examen_carrito.models.Customer;
import com.example.mvargas.examen_carrito.session.Session;

/**
 * Created by monyvargas on 7/3/15.
 */
public class DBOperaciones {

    public CarritoReaderDBHelper carritoSQLiteHelper;

    public SQLiteDatabase db;

    public DBOperaciones() {
        carritoSQLiteHelper = new CarritoReaderDBHelper(Session.contex, "dbexamencarrito", null, 1);
        if (Utils.isFirstRun());
        createTables();
    }

    public void createTables() {
        db = carritoSQLiteHelper.getWritableDatabase();
        db.execSQL(Constants.CREA_PRODUCTOS_TABLA);
        db.execSQL(Constants.CREA_USUARIO_TABLA);
    }

    public boolean registerCliente(Customer customer) {
        boolean success = false;
        db = carritoSQLiteHelper.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put("nombre", customer.getNombre());
            values.put("usuario", customer.getUsuario());
            values.put("telefono", customer.getTelefono());
            values.put("email", customer.getCorreo());
            values.put("password", customer.getPassword());

            db.insert(Constants.TABLA_USUARIO, null, values);
            success = true;
            db.close();

        }
        catch (Exception e) {
            success = false;
            db.close();
        }

        return success;
    }

    public Customer getCustomer(Customer customer) {
        Customer savedCustomer = null;

        String name;
        String username;
        String phone;
        String email;
        String password;
        int algo;

        db = carritoSQLiteHelper.getWritableDatabase();

        try {
            Cursor cursor = db.rawQuery(Constants.OBTIENE_USUARIO_QUERY + customer.getUsuario(), null);
            if (cursor.moveToFirst()) {
                name = cursor.getString(0);
                username = cursor.getString(1);
                email = cursor.getString(2);
                phone = cursor.getString(3);
                password = cursor.getString(4);


                savedCustomer = new Customer(name, phone, email, username, password);
                db.close();
            }
            else {
                customer = null;
            }
        }
        catch (Exception e) {
            customer = null;
            db.close();
        }

        return savedCustomer;
    }
}

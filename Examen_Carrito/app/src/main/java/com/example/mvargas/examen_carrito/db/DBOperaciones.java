package com.example.mvargas.examen_carrito.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mvargas.examen_carrito.common.Constants;
import com.example.mvargas.examen_carrito.common.ReadJsonFile;
import com.example.mvargas.examen_carrito.common.Utils;
import com.example.mvargas.examen_carrito.models.Customer;
import com.example.mvargas.examen_carrito.models.Producto;
import com.example.mvargas.examen_carrito.session.Session;

import java.util.ArrayList;

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

    public boolean creaCliente(Customer customer) {
        boolean success = false;
        db = carritoSQLiteHelper.getWritableDatabase();
        try {
            ContentValues usuario = new ContentValues();
            usuario.put("id", (byte[]) null);
            usuario.put("name", customer.getNombre());
            usuario.put("username", customer.getUsuario());
            usuario.put("email", customer.getTelefono());
            usuario.put("phone", customer.getCorreo());
            usuario.put("password", customer.getPassword());

            db.insert(Constants.TABLA_USUARIO, null, usuario);
            success = true;
            db.close();

        }
        catch (Exception e) {
            success = false;
            db.close();
        }

        return success;
    }

    /*public Boolean creaCatalogo(ArrayList<Producto> arrayList){
        boolean creado=false;
        ArrayList<Producto> producto=arrayList;
        producto= ReadJsonFile.convierteJson();
        db=carritoSQLiteHelper.getWritableDatabase();
        try{
            ContentValues catalogo=new ContentValues();
            int totalProductos=producto.size();
            for(int i=0;i<totalProductos;i++){
                catalogo.put("id", String.valueOf(producto.get(0)));
                catalogo.put("code",String.valueOf(producto.get(1)));
                catalogo.put("name",String.valueOf(producto.get(2)));
                catalogo.put("minDesc",String.valueOf(producto.get(3)));
                catalogo.put("maxDesc",String.valueOf(producto.get(4)));
                catalogo.put("image",String.valueOf(producto.get(5)));
                catalogo.put("units",Integer.parseInt(String.valueOf(producto.get(6))));
                catalogo.put("price", Double.parseDouble(String.valueOf(producto.get(7))));
                db.insert(Constants.TABLA_PRODUCTOS,null,catalogo);


            }

            creado=true;
        }
        catch (Exception e){
            creado = false;
            db.close();
        }
        return creado;
    }*/

    public Customer getCustomer(Customer customer) {
        Customer savedCustomer = null;

        String name;
        String username;
        String phone;
        String email;
        String password;
        int id;

        db = carritoSQLiteHelper.getWritableDatabase();

        try {
            Cursor cursor = db.rawQuery(Constants.OBTIENE_USUARIO_QUERY + "'"+customer.getUsuario()+"'", null);
            //Cursor cursor = db.rawQuery(Constants.OBTIENE_USUARIO_QUERY , null);
            if (cursor.moveToFirst()) {
                id=cursor.getInt(0);
                name = cursor.getString(1);
                username = cursor.getString(2);
                email = cursor.getString(3);
                phone = cursor.getString(4);
                password = cursor.getString(5);


                savedCustomer = new Customer(id,name, phone, email, username, password);
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

    public ArrayList<Producto> recuperarDatos() {
        ArrayList<Producto> recuperaCatalogo=new ArrayList<Producto>();
        db = carritoSQLiteHelper.getReadableDatabase();

        Cursor c=db.rawQuery(Constants.OBTIENE_PRODUCTOS_QUERY,null);
        if(c.moveToFirst()){
            do {
                Producto producto=new Producto();
                producto.setId_producto(""+c.getInt(0));
                producto.setCodigo(c.getString(1));
                producto.setNombre(c.getString(2));
                producto.setMinDesc(c.getString(3));
                producto.setMaxDesc(c.getString(4));
                producto.setImagen(c.getString(5));
                producto.setUnidades(c.getInt(6));
                producto.setPrecio(c.getDouble(7));
                recuperaCatalogo.add(producto);
            } while(c.moveToNext());


        }
        return recuperaCatalogo;
    }
}

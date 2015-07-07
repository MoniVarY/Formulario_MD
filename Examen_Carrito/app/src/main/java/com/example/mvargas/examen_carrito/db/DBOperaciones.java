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
   public ArrayList<Producto> recuperaCatalogo=new ArrayList<Producto>();
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
        db.execSQL(Constants.CREA_CARRITO_TABLA);
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
        String code="";
        String name="";
        String mindesc="";
        String maxdesc="";
        String image="";
        String id_back="";
        Double price = null;
        int units=0;

        db = carritoSQLiteHelper.getReadableDatabase();

        Cursor c=db.rawQuery(Constants.OBTIENE_PRODUCTOS_QUERY,null);
        if(c.moveToFirst()){
            do {
                Producto producto=new Producto(id_back,code, name, mindesc, maxdesc, image,units,price);
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


    public ArrayList<Producto> recuperarTicket() {
        String code="";
        String name="";
        String mindesc="";
        String maxdesc="";
        String image="";
        String id_back="";
        Double price = null;
        int units=0;

        db = carritoSQLiteHelper.getReadableDatabase();

        Cursor c=db.rawQuery(Constants.OBTIENE_TICKET_QUERY,null);
        if(c.moveToFirst()){
            do {
                Producto producto=new Producto(id_back,code, name, mindesc, maxdesc, image,units,price);
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

    public Producto recuperaDetalle(String id){
        Producto productBack=null;
        String code;
        String name;
        String mindesc;
        String maxdesc;
        String image;
        String id_back;
        Double price;
        int units;

        db = carritoSQLiteHelper.getWritableDatabase();

        try {
            Cursor cursor = db.rawQuery(Constants.OBTIENE_DETALLE_QUERY + "'"+id+"'", null);
            if (cursor.moveToFirst()) {
                id_back=""+cursor.getInt(0);
                code = cursor.getString(1);
                name = cursor.getString(2);
                mindesc = cursor.getString(3);
                maxdesc = cursor.getString(4);
                image = cursor.getString(5);
                units=cursor.getInt(6);
                price=cursor.getDouble(7);


                productBack = new Producto(id_back,code, name, mindesc, maxdesc, image,units,price);
                db.close();
            }
            else {
                productBack = null;
            }
        }
        catch (Exception e) {
            productBack = null;
            db.close();
        }

        return productBack;
    }

    public boolean insertaTicket(Producto producto) {
        boolean success = false;
        db = carritoSQLiteHelper.getWritableDatabase();
        try {
            ContentValues productTicket = new ContentValues();
            productTicket.put("id", (byte[]) null);
            productTicket.put("code", producto.getCodigo());
            productTicket.put("name", producto.getNombre());
            productTicket.put("mindesc", producto.getMinDesc());
            productTicket.put("maxdesc", producto.getMaxDesc());
            productTicket.put("image", producto.getImagen());
            productTicket.put("units", producto.getUnidades());
            productTicket.put("price", producto.getPrecio());

            db.insert(Constants.TABLA_CARRITO, null, productTicket);
            success = true;
            db.close();

        }
        catch (Exception e) {
            success = false;
            db.close();
        }

        return success;
    }

    public void restarPieza(String cod, int unid){
        db = carritoSQLiteHelper.getWritableDatabase();
        int unidadesRes =unid-1;
        String sqlActualizaCantidad="UPDATE "+Constants.TABLA_CARRITO+" set units= "+unidadesRes+ " where code ="+"'"+cod+"'";
        db.execSQL(sqlActualizaCantidad);
    }
}

package com.example.mvargas.examen_carrito.common;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.mvargas.examen_carrito.db.DBOperaciones;
import com.example.mvargas.examen_carrito.models.Customer;
import com.example.mvargas.examen_carrito.models.Producto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by monyvargas on 7/5/15.
 */
public class ReadJsonFile {


    /*public static ArrayList<Producto>  convierteJson(){
        ArrayList<Producto> inventario = new ArrayList<Producto>();
        try{

        JSONObject obj = new JSONObject(Utils.loadJSONFromAsset());
        JSONArray json_array = obj.getJSONArray("productos");


        for (int i = 0; i < json_array.length(); i++)
        {
            Producto producto=new Producto();
            JSONObject catalogo = json_array.getJSONObject(i);
            producto.setId_producto(null);
            producto.setCodigo(catalogo.getString("codigo"));
            producto.setUnidades(catalogo.getInt("unidades"));
            producto.setNombre(catalogo.getString("nombre"));
            producto.setMinDesc(catalogo.getString("minDesc"));
            producto.setMaxDesc(catalogo.getString("maxDesc"));
            producto.setPrecio(catalogo.getDouble("precio"));
            producto.setImagen(catalogo.getString("imagen"));
            inventario.add(producto);

        }
        }
        catch (JSONException je){

        }
        return inventario;

    }*/

    DBOperaciones dbOperation= new DBOperaciones();
    SQLiteDatabase db;

    public Boolean insertaCatalogo(){
        Boolean catalogoCreado=false;
        try {

            JSONObject obj = new JSONObject(Utils.loadJSONFromAsset());
            JSONArray json_array = obj.getJSONArray("productos");
            dbOperation.db=db;
            db=dbOperation.carritoSQLiteHelper.getWritableDatabase();
            ContentValues catalogo=new ContentValues();
            for (int i = 0; i < json_array.length(); i++)
            {
                JSONObject archivojson = json_array.getJSONObject(i);
                catalogo.put("id", (byte[]) null);
                catalogo.put("code", archivojson.getString("codigo"));
                catalogo.put("name",archivojson.getString("nombre"));
                catalogo.put("mindesc",archivojson.getString("minDesc"));
                catalogo.put("maxDesc",archivojson.getString("maxDesc"));
                catalogo.put("image",archivojson.getString("imagen"));
                catalogo.put("units",archivojson.getInt("unidades"));
                catalogo.put("price",archivojson.getDouble("precio"));
                db.insert(Constants.TABLA_PRODUCTOS,null,catalogo);

                catalogoCreado=true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            catalogoCreado=false;
            db.close();
        }
        return catalogoCreado;

    }
}

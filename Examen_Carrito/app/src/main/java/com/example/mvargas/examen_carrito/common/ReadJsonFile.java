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

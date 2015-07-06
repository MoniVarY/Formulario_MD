package com.example.mvargas.examen_carrito.common;

import android.util.Log;

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

    public static ArrayList<Producto>  convierteJson(){
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

    }
}

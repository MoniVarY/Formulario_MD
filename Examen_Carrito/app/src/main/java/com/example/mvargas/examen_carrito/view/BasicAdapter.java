package com.example.mvargas.examen_carrito.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.mvargas.examen_carrito.CatalogoActivity;
import com.example.mvargas.examen_carrito.DetalleActivity;
import com.example.mvargas.examen_carrito.R;
import com.example.mvargas.examen_carrito.RegistraActivity;
import com.example.mvargas.examen_carrito.db.DBOperaciones;
import com.example.mvargas.examen_carrito.models.Producto;
import com.example.mvargas.examen_carrito.session.Session;


import java.util.ArrayList;

/**
 * Created by MVARGAS on 02/07/2015.
 */
public class BasicAdapter extends BaseAdapter{

    private TextView nameTxt;
    private String code;
    private TextView minDesctxt,tvCodigo;
    private Context context;
    private ArrayList<Producto> productos;
    private Activity activity;
    Button btnVerDetalle;
    Button btnElimina;
    boolean catalog;

    public BasicAdapter(Context context, ArrayList<Producto> data, Activity activity, boolean carrito){
        this.context = context;
        this.productos = data;
        this.activity = activity;
        this.catalog= carrito;
    }

    @Override
    public int getCount() {
        return productos.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        View lienzo=convertView;

        if(convertView == null){
            LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            lienzo=layoutInflater.inflate(R.layout.item_layout,parent,false);

        }
        relationUI(lienzo);

        nameTxt.setText(productos.get(pos).getNombre());
        minDesctxt.setText(productos.get(pos).getMinDesc());


        btnVerDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code=productos.get(pos).getCodigo();
                irDetalle(code);

            }
        });


        return lienzo;
    }

    private void relationUI(View v){
        nameTxt=(TextView) v.findViewById(R.id.tvNombreCatalogo);
        minDesctxt=(TextView) v.findViewById(R.id.tvMinDesc);
        btnElimina=(Button) v.findViewById(R.id.btnEliminar);
        btnVerDetalle=(Button) v.findViewById(R.id.btnDetalle);

        if(catalog==false){
            btnElimina.setVisibility(v.VISIBLE);
        }
        else {
            btnElimina.setVisibility(v.INVISIBLE);
        }
    }

    public void irDetalle(String codeSelected){

        Intent intent1=new Intent(context,DetalleActivity.class);
        intent1.putExtra("item",codeSelected);
        activity.startActivity(intent1);
    }

}

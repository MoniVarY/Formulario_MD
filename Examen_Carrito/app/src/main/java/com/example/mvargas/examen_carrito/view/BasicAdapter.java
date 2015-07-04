package com.example.mvargas.examen_carrito.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mvargas.examen_carrito.R;
import com.example.mvargas.examen_carrito.models.Persona;

import java.util.ArrayList;

/**
 * Created by MVARGAS on 02/07/2015.
 */
public class BasicAdapter extends BaseAdapter{
    private TextView nameTxt;
    private TextView countTxt;


    private Context activityContext;
    private ArrayList<Persona> personas;

    public BasicAdapter(Context context, ArrayList<Persona> data){
        activityContext=context;
        personas=data;
    }

    @Override
    public int getCount() {
        return personas.size();
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
        View lienzo=convertView;
        LayoutInflater layoutInflater=(LayoutInflater) activityContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        lienzo=layoutInflater.inflate(R.layout.item_layout,parent,false);
        relationUI(lienzo);

        Persona persona=personas.get(position);
        nameTxt.setText(persona.getNombre());
        countTxt.setText(""+position);
        //countTxt.setText();

        return lienzo;
    }

    private void relationUI(View v){
        nameTxt=(TextView) v.findViewById(R.id.nameTxt);
        countTxt=(TextView) v.findViewById(R.id.countTxt);
    }
}

package com.example.mvargas.examen_carrito;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mvargas.examen_carrito.db.DBOperaciones;
import com.example.mvargas.examen_carrito.models.Producto;
import com.example.mvargas.examen_carrito.session.Session;
import com.example.mvargas.examen_carrito.view.BasicAdapter;

import java.util.ArrayList;


public class CarritoActivity extends ActionBarActivity  implements View.OnClickListener{

    private ListView productos;
    private Button btnPagar;
    private ArrayList<Producto> catalogo;
    private TextView tvTotal;

    private boolean iscatalog=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        linkUI();
        llenarLista();
    }


    public void linkUI(){
        productos=(ListView) findViewById(R.id.listCarrito);
        btnPagar=(Button) findViewById(R.id.btnPagarCarrito);
        btnPagar.setOnClickListener(this);
        tvTotal=(TextView) findViewById(R.id.tvTotal);

    }

    public void llenarLista(){

        Bundle values=getIntent().getExtras();
        iscatalog= values.getBoolean("catalog");
        DBOperaciones help=new DBOperaciones();
        catalogo = help.recuperarTicket();

        BasicAdapter adaptador = new BasicAdapter(Session.contex, catalogo, this,iscatalog);
        productos.setAdapter(adaptador);
    }

    @Override
    public void onClick(View v) {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_carrito, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}

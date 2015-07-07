package com.example.mvargas.examen_carrito;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mvargas.examen_carrito.common.Constants;
import com.example.mvargas.examen_carrito.db.CarritoReaderDBHelper;
import com.example.mvargas.examen_carrito.db.DBOperaciones;
import com.example.mvargas.examen_carrito.models.Producto;
import com.example.mvargas.examen_carrito.session.Session;
import com.example.mvargas.examen_carrito.view.BasicAdapter;

import java.util.ArrayList;


public class CatalogoActivity extends Activity implements View.OnClickListener{
    private ListView productos;
    private Button btnPagar,btnVerCarrito;
    private ArrayList<Producto> catalogo;

    private boolean iscatalog=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);
        linkUI();
        llenarLista();

    }



    public void linkUI(){
        productos=(ListView) findViewById(R.id.listCatalogo);
        btnPagar=(Button) findViewById(R.id.btnPagar);
        btnVerCarrito=(Button) findViewById(R.id.btnVerCarrito);
        btnPagar.setOnClickListener(this);
        btnVerCarrito.setOnClickListener(this);

    }




    @Override
    public void onClick(View v) {
        if(v == btnVerCarrito){
            Intent intent1=new Intent(this,CarritoActivity.class);
            intent1.putExtra("catalog",false);
            startActivity(intent1);
        }


    }


    public void llenarLista(){

        Bundle values=getIntent().getExtras();
        iscatalog= values.getBoolean("catalog");
        DBOperaciones help=new DBOperaciones();
        catalogo = help.recuperarDatos();

        BasicAdapter adaptador = new BasicAdapter(Session.contex, catalogo, this,iscatalog);
        productos.setAdapter(adaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_catalogo, menu);
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

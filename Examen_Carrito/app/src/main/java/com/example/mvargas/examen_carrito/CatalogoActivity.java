package com.example.mvargas.examen_carrito;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.mvargas.examen_carrito.db.CarritoReaderDBHelper;
import com.example.mvargas.examen_carrito.db.DBOperaciones;
import com.example.mvargas.examen_carrito.models.Producto;
import com.example.mvargas.examen_carrito.session.Session;
import com.example.mvargas.examen_carrito.view.BasicAdapter;

import java.util.ArrayList;


public class CatalogoActivity extends Activity {
    private ListView productos;
    private BasicAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);
        linkUI();
    }

    public void linkUI(){
        productos=(ListView) findViewById(R.id.listCatalogo);
    }
    public void llenarLista(){
        DBOperaciones help=new DBOperaciones();//getApplicationContext()

        ArrayList<Producto> catalogo=help.recuperarDatos();
        adaptador=new BasicAdapter(Session.contex, catalogo);
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

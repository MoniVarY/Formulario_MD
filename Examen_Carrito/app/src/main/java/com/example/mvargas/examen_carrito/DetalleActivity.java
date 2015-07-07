package com.example.mvargas.examen_carrito;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvargas.examen_carrito.common.Constants;
import com.example.mvargas.examen_carrito.db.DBOperaciones;
import com.example.mvargas.examen_carrito.models.Producto;


public class DetalleActivity extends ActionBarActivity implements View.OnClickListener{
    private TextView tvNombre,tvDescripcion,tvPrecio,tvUnidades,tvTitulo;
    private ImageView ivImagen;
    private Button btnAgrega;
    private String selec="";

    private  String code="";
    private String name="";
    private String mindesc="";
    private String maxdesc="";
    private String image="";
    private String id_db="";
    private Double price = null;
    private int units=0;

    DBOperaciones dbop= new DBOperaciones();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        linkUI();
        cargaInformacion();
    }


    public void linkUI(){
        tvNombre=(TextView) findViewById(R.id.tv_nombre_producto);
        tvDescripcion=(TextView) findViewById(R.id.tv_descripcion);
        tvPrecio=(TextView) findViewById(R.id.tv_precio);
        tvUnidades=(TextView) findViewById(R.id.tv_unidades);
        ivImagen=(ImageView) findViewById(R.id.ivImagen);
        btnAgrega=(Button) findViewById(R.id.btnAgrega);
        btnAgrega.setOnClickListener(this);


    }

    public void cargaInformacion(){

        Bundle values=getIntent().getExtras();
        code=values.getString("item");

        Producto productoDetalle=new Producto(id_db,code, name, mindesc, maxdesc, image,units,price);

        productoDetalle=dbop.recuperaDetalle(code);
        tvNombre.setText(productoDetalle.getNombre());
        tvDescripcion.setText(productoDetalle.getMaxDesc());
        tvPrecio.setText(""+productoDetalle.getPrecio());
        tvUnidades.setText(""+productoDetalle.getUnidades());

        selec=productoDetalle.getImagen();
        int posicion=selec.indexOf('.');
        String select2=selec.substring(0,posicion);
        int id = getResources().getIdentifier(select2, "drawable", getPackageName());
        ivImagen.setImageDrawable(getResources().getDrawable(id));
        code=productoDetalle.getCodigo();
        name=productoDetalle.getNombre();
        mindesc=productoDetalle.getMinDesc();
        maxdesc=productoDetalle.getMaxDesc();
        image=productoDetalle.getImagen();
        id_db=null;
        price = productoDetalle.getPrecio();
        units=productoDetalle.getUnidades();

    }
    @Override
    public void onClick(View v) {

        if (v == btnAgrega){
            if (units>0) {
                Producto comprado = new Producto(id_db, code, name, mindesc, maxdesc, image, 1, price);
                boolean insertaticket = dbop.insertaTicket(comprado);
                dbop.restarPieza(code, units);
                Toast.makeText(this, "Se agrego el producto " + name, Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(this, CatalogoActivity.class);
                intent1.putExtra("catalog", true);
                startActivity(intent1);
            }else {
                Toast.makeText(this, "Ya no hay productos en el inventario " + name, Toast.LENGTH_LONG).show();
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalle, menu);
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

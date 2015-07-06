package com.example.mvargas.examen_carrito;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvargas.examen_carrito.common.Constants;
import com.example.mvargas.examen_carrito.common.ReadJsonFile;
import com.example.mvargas.examen_carrito.common.Utils;
import com.example.mvargas.examen_carrito.db.DBOperaciones;
import com.example.mvargas.examen_carrito.models.Customer;
import com.example.mvargas.examen_carrito.models.Producto;

import java.util.ArrayList;


public class MainActivity extends Activity implements View.OnClickListener {

    private EditText et_usuario,et_password;
    private Button btn_registrar,btn_ingresar;
    private Boolean inventario;
    DBOperaciones dbop= new DBOperaciones();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkUI();
    }

    private void inventarioCreado(){
        String archivoJson=Utils.loadJSONFromAsset();
        ReadJsonFile lectura=new ReadJsonFile();
        ArrayList<Producto> catalogo=lectura.convierteJson();
        inventario=dbop.creaCatalogo(catalogo);
        if(inventario==true){
            btn_registrar.setEnabled(true);
            btn_ingresar.setEnabled(true);
        }
    }

    private void linkUI(){
        et_usuario=(EditText) findViewById(R.id.et_usuario);
        et_password=(EditText) findViewById(R.id.et_password);
        btn_registrar=(Button) findViewById(R.id.btn_registar);
        btn_ingresar=(Button) findViewById(R.id.btn_ingresar);
        btn_ingresar.setOnClickListener(this);
        btn_registrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String usuario="";
        String contrasena="";
        String nombre="";
        String correo="";
        String telefono="";
        int id=0;
        usuario=et_usuario.getText().toString();
        contrasena=et_password.getText().toString();

            if (v == btn_ingresar) {
                if (!usuario.equals("")&&!contrasena.equals("")) {



                    Customer cliente = new Customer(id,nombre,telefono,correo,usuario,contrasena);
                    Customer clienteRetornado=dbop.getCustomer(cliente);
                    if(!(clienteRetornado == null)){
                        if(usuario.equals(clienteRetornado.getUsuario())){
                            if (contrasena.equals(clienteRetornado.getPassword())){
                                Intent intent1=new Intent(this,CatalogoActivity.class);
                                intent1.putExtra("value",1);
                                startActivity(intent1);
                            }
                            else {
                                Toast.makeText(this, Constants.ERROR_PASSWORD_INCORRECTA, Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                    else {
                        Toast.makeText(this, Constants.ERROR_USUARIO, Toast.LENGTH_LONG).show();
                    }

                }else {
                    Toast.makeText(this, Constants.MENSAJE, Toast.LENGTH_LONG).show();
                }
            } else if (v == btn_registrar) {

                    Intent intent1=new Intent(this,RegistraActivity.class);
                    intent1.putExtra("value",1);
                    startActivity(intent1);
            }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

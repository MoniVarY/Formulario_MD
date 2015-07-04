package com.example.mvargas.examen_carrito;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvargas.examen_carrito.common.Constants;


public class RegistraActivity extends ActionBarActivity  implements View.OnClickListener{

    private EditText et_nombre,et_telefono,et_user,et_password,et_confima_password,et_email;
    private Button btn_registra;
    private String nombre,telefono,usuario,password,confirm_password,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registra);
        linkUI();

    }

    private void linkUI(){
        et_nombre=(EditText) findViewById(R.id.et_nombre);
        et_telefono=(EditText) findViewById(R.id.et_telefono);
        et_email=(EditText) findViewById(R.id.et_email);
        et_password=(EditText) findViewById(R.id.et_password);
        et_confima_password=(EditText) findViewById(R.id.et_confirma);
        et_user=(EditText)findViewById(R.id.et_usuario);
        btn_registra=(Button)findViewById(R.id.btn_enviar);
        btn_registra.setOnClickListener(this);
    }

    private void obtenerDatos(){
        nombre=et_nombre.getText().toString();
        telefono=et_telefono.getText().toString();
        email=et_email.getText().toString();
        password=et_password.getText().toString();
        confirm_password=et_confima_password.getText().toString();
        usuario=et_user.getText().toString();
    }

    @Override
    public void onClick(View v) {
        if (v == btn_registra){
            obtenerDatos();
            if (!nombre.trim().equals("")&&!telefono.trim().equals("")&&!email.trim().equals("")&&!password.trim().equals("")&&!confirm_password.trim().equals("")&&!usuario.trim().equals("")) {
                //if(!nombre.equals("")&&!nombre.equals(" ")&&!telefono.equals("")&&!telefono.equals(" ")&&!email.equals("")&&!email.equals(" ")&&!usuario.equals("")&&!usuario.equals(" "))
                if (password.equals(confirm_password)) {

                    Intent intent1=new Intent(this,MainActivity.class);
                    intent1.putExtra("value",1);
                    startActivity(intent1);
                }
                else {
                    Toast.makeText(this, Constants.ERROR_PASSWORD, Toast.LENGTH_LONG).show();
                }
            }
            else {
                Toast.makeText(this, Constants.MENSAJE, Toast.LENGTH_LONG).show();
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registra, menu);
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

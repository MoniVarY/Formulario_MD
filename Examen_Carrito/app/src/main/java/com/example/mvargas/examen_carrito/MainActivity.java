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


public class MainActivity extends Activity implements View.OnClickListener {

    private EditText et_usuario,et_password;
    private Button btn_registrar,btn_ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkUI();
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

            if (v == btn_ingresar) {
                if (!et_usuario.getText().toString().equals("")&&!et_password.getText().toString().equals("")) {

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

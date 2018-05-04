package com.example.usuario.project.projectasistencia;


import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.usuario.project.R;
import com.example.usuario.project.dao.UsuarioDao;


public class MainActivity extends AppCompatActivity {


    TextView msg;
    UsuarioDao usu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText txtUsuario =(EditText) findViewById(R.id.id_usuario);
        final EditText txtClave =(EditText) findViewById(R.id.id_password);
        //final Button btnCancelar =(Button)findViewById(R.id.idCancelar);
        final Button btnIngresar=(Button)findViewById(R.id.button_ingresar);
        msg=(TextView)findViewById(R.id.idMsg);
        usu=new UsuarioDao(this);

        btnIngresar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(usu.validarUsuario(txtUsuario.getText().toString(), txtClave.getText().toString())){
                    ingresar();
                }else{
                    msg.setText("Intente Nuevamente...!");
                }

            }
        });

    }

    public void ingresar(){
        final EditText txtUsuario =(EditText) findViewById(R.id.id_usuario);
        usu=new UsuarioDao(this);
        Cursor curx=usu.listarUsuario(txtUsuario.getText().toString());
        String nombre="";
        int idUsuario=0;
        if(curx.moveToNext()){
            nombre=curx.getString(3)+" "+curx.getString(4);
            idUsuario=curx.getInt(0);
        }
        Intent intent=new Intent();
        intent.putExtra("txtUsuarioNombre", nombre);
        intent.putExtra("idUsuario", idUsuario);
        intent.setClass(this,DravNav.class);
        startActivity(intent);
    }



}



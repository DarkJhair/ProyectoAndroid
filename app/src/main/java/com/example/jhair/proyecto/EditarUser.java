package com.example.jhair.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jhair.proyecto.Usuarios.Usuario;
import com.example.jhair.proyecto.Usuarios.UsuarioLimitado;
import com.example.jhair.proyecto.Usuarios.UsuarioNormal;
import com.example.jhair.proyecto.Usuarios.Validaciones;

public class EditarUser extends AppCompatActivity {
    EditText edtnom;
    EditText edtNombre;
    EditText edtEdad;
    EditText edtpassw;
    TextView spinner;
    Button btnEditar;
    String userName;
    Usuario usu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_user);
        initComponents();
    }
    private void initComponents(){
        userName = getIntent().getExtras().getString("user");
        edtnom = (EditText)findViewById(R.id.edtnom);
        edtNombre = (EditText)findViewById(R.id.edtNombre);
        edtEdad = (EditText)findViewById(R.id.edtedad);
        edtpassw = (EditText)findViewById(R.id.edtpassw);
        spinner = (TextView) findViewById(R.id.spinner);
        btnEditar = (Button)findViewById(R.id.btnEditar);
        usu = Validaciones.buscarUsuario(userName);
        edtnom.setText(usu.getUsuario());
        edtNombre.setText(usu.getNomcompleto());
        edtEdad.setText(String.valueOf(usu.getEdad()));
        edtpassw.setText(usu.getContra());
        if(usu instanceof UsuarioNormal){
            spinner.setText("Usuario Normal");
        }else if( usu instanceof UsuarioLimitado){
            spinner.setText("Usuario Limitado");
        }else{
            spinner.setText("Usuario Administrador");
        }

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usu.setUsuario(edtnom.getText().toString());
                usu.setNomcompleto(edtNombre.getText().toString());
                usu.setContra(edtpassw.getText().toString());
                usu.setEdad(Integer.parseInt(edtEdad.getText().toString()));
                Toast.makeText(EditarUser.this,"Se ha actualizado exitosamente",Toast.LENGTH_LONG).show();

            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(EditarUser.this, PedirUserEditar.class);
        startActivity(intent);
        finish();
    }
}

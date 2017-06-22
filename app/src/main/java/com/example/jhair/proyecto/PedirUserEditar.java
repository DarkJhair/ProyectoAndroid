package com.example.jhair.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jhair.proyecto.Usuarios.Validaciones;

public class PedirUserEditar extends AppCompatActivity {
    EditText edt_userName;
    Button btn_EditarEvento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedir_user_editar);
        edt_userName = (EditText)findViewById(R.id.edt_userName);
        btn_EditarEvento = (Button)findViewById(R.id.btn_EditarEvento);
        btn_EditarEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_userName.getText().toString().length() > 0){
                    String s = edt_userName.getText().toString();
                    if(Validaciones.buscarUsuario(s) != null){
                        Intent intent = new Intent(PedirUserEditar.this,EditarUser.class);
                        intent.putExtra("user",s);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(PedirUserEditar.this,"Porfavor escriba un usuario existente",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(PedirUserEditar.this,"Porfavor llene el dato",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(PedirUserEditar.this,administrarusuarios.class);
        startActivity(intent);
        finish();
    }
}

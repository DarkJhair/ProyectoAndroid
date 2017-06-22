package com.example.jhair.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class administrarusuarios extends AppCompatActivity {
Button btn_crear;
    Button btn_editar;
    Button btn_eliminar;
    Button btn_regresar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrarusuarios);
        Initcomponents();
    }


    public void Initcomponents(){
        btn_eliminar=(Button)findViewById(R.id.bteliminarusuario);

        btn_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(administrarusuarios.this,EliminarUsuario.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(administrarusuarios.this,MenuMainActivity.class);
        startActivity(intent);
        finish();
    }
}

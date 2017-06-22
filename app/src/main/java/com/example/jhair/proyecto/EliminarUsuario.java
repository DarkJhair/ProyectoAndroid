package com.example.jhair.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jhair.proyecto.Usuarios.Usuario;
import com.example.jhair.proyecto.Usuarios.Validaciones;

public class EliminarUsuario extends AppCompatActivity {
    Button btn_eliminar;
    Button btn_regresar;
    EditText usuario_eliminar;
    String usuarioeli;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_usuario);
        Initcomponets();

    }

    public void Initcomponets(){
            btn_eliminar=(Button)findViewById(R.id.bteliminarusuario);
            btn_regresar=(Button)findViewById(R.id.btregresar);
            usuario_eliminar=(EditText)findViewById(R.id.etxtusu);

            usuarioeli=usuario_eliminar.getText().toString();


            btn_eliminar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (usuario_eliminar.getText().toString().equals("")){
                        Toast.makeText(EliminarUsuario.this,"Campo Vacio",Toast.LENGTH_LONG).show();

                    }else if(usuario_eliminar.getText().toString().equals("admin")){
                        Toast.makeText(EliminarUsuario.this,"No se puede eliminar el administrador",Toast.LENGTH_LONG).show();
                    }

                    else{
                        if(Validaciones.comprobarUsuario(usuario_eliminar.getText().toString())){

                            Validaciones.borrarUsuario(usuario_eliminar.getText().toString());

                            Toast.makeText(EliminarUsuario.this,"Usuario eliminado",Toast.LENGTH_LONG).show();
                            Intent inte = new Intent(EliminarUsuario.this,administrarusuarios.class);
                            startActivity(inte);
                            finish();
                        }else{
                            Toast.makeText(EliminarUsuario.this,"Usuario no existe",Toast.LENGTH_LONG).show();
                        }
                    }




                }
            });

        btn_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EliminarUsuario.this,administrarusuarios.class);
                startActivity(intent);
                finish();
            }
        });


    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(EliminarUsuario.this,administrarusuarios.class);
        startActivity(intent);
        finish();
    }
}

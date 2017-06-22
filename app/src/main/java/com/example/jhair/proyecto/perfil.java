package com.example.jhair.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jhair.proyecto.Usuarios.UsuarioLimitado;

public class perfil extends AppCompatActivity {
    ViewGroup perfilLinear;
    Button btn_Event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        initcomponents();
    }
    public void initcomponents(){
        perfilLinear = (ViewGroup)findViewById(R.id.perfilLinear);
        for(int i = 0; i < perfilLinear.getChildCount();i++){
            if(perfilLinear.getChildAt(i) instanceof TextView){
                TextView tx =(TextView) perfilLinear.getChildAt(i);
                tx.setText(MainActivity.usuarioActivo.getUsuario());
            }
            else if(perfilLinear.getChildAt(i) instanceof LinearLayout){
                LinearLayout ly = (LinearLayout)perfilLinear.getChildAt(i);
                for(int m = 0; m < ly.getChildCount();m++) {
                    if (ly.getChildAt(m) instanceof TextView) {
                        TextView v = (TextView) ly.getChildAt(m);
                        String id = "";
                        try {
                            id = v.getResources().getResourceName(v.getId());
                            String[] ide = id.split(":id/");
                            id = ide[1];
                        } catch (Exception e) {
                            continue;
                        }
                        switch (id) {
                            case "txtName":
                                v.setText(MainActivity.usuarioActivo.getNomcompleto());
                                break;
                            case "txtContra":
                                v.setText(MainActivity.usuarioActivo.getContra());
                                break;
                            case "txtEdad":
                                v.setText(String.valueOf(MainActivity.usuarioActivo.getEdad()));
                                break;
                        }
                    }
                }
            }
        }
        btn_Event = (Button)findViewById(R.id.btn_Event);
        btn_Event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.usuarioActivo instanceof UsuarioLimitado){
                    Toast.makeText(perfil.this,"No tiene ningun evento, ya que es usuario Limitado",Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(perfil.this, EventosUsers.class);
                    startActivity(intent);
                    finish();
                }
            }
        });



    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(perfil.this,MenuReportes.class);
        startActivity(intent);
        finish();
    }
}

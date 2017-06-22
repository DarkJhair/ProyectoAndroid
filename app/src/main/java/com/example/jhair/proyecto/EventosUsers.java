package com.example.jhair.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jhair.proyecto.Usuarios.UsuarioAdmin;
import com.example.jhair.proyecto.Usuarios.UsuarioNormal;
import com.example.jhair.proyecto.clases.Evento;

import java.util.ArrayList;

public class EventosUsers extends AppCompatActivity {
    ArrayList<Evento> eventosUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos_users);
        eventosUser = new ArrayList<>();
        if(MainActivity.usuarioActivo instanceof UsuarioAdmin){
            UsuarioAdmin usu = (UsuarioAdmin) MainActivity.usuarioActivo;
            eventosUser = usu.getEventosadmin();
        }else if(MainActivity.usuarioActivo instanceof UsuarioNormal){
            UsuarioNormal usu = (UsuarioNormal) MainActivity.usuarioActivo;
            eventosUser = usu.getEventosnormales();
        }
        ListAdapter pambisitoAdapter = new CustomAdapter(getApplicationContext(), eventosUser);
        ListView ListEventosUsers = (ListView) findViewById(R.id.List_eventosUser);
        ListEventosUsers.setAdapter(pambisitoAdapter);
        if(eventosUser.size() == 0){
            Toast.makeText(EventosUsers.this,"No hay eventos creados por usted, vuelva hacia atras",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(EventosUsers.this,perfil.class);
        startActivity(intent);
        finish();
    }
}

package com.example.jhair.proyecto.Usuarios;

import com.example.jhair.proyecto.clases.Evento;

import java.util.ArrayList;

/**
 * Created by Jhair on 28/05/2017.
 */

public class UsuarioAdmin extends Usuario {

    public ArrayList<Evento> eventosadmin;


    public UsuarioAdmin(String usuario, String contra, String nomcompleto, int edad) {
        super(usuario, contra, nomcompleto, edad);
        eventosadmin = new ArrayList<>();

    }

    public  void agregarEventoAdmin(Evento e){
        eventosadmin.add(e);
    }

    public  ArrayList<Evento> getEventosadmin() {
        return eventosadmin;
    }
}

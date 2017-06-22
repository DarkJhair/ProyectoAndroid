package com.example.jhair.proyecto.Usuarios;

import com.example.jhair.proyecto.clases.Evento;

import java.util.ArrayList;

/**
 * Created by Jhair on 28/05/2017.
 */

public class UsuarioNormal extends Usuario {

    public ArrayList<Evento> eventosnormales;


    public UsuarioNormal(String usuario, String contra, String nomcompleto, int edad) {
        super(usuario, contra, nomcompleto, edad);
        eventosnormales = new ArrayList<>();

    }

    public  void agregarEventoNormal(Evento e){
        eventosnormales.add(e);
    }

    public  ArrayList<Evento> getEventosnormales() {
        return eventosnormales;
    }
}

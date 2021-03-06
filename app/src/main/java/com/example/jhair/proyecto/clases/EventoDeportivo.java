package com.example.jhair.proyecto.clases;

import java.util.ArrayList;
import java.util.Calendar;

public class EventoDeportivo extends Evento {
    public enum Deportes{
        TENIS,FUTBOL,RUGBY,BASEBALL;
    }
    private Deportes tipoDeporte;
    private String equipo1;
    private ArrayList<String> listadoEquipo1;
    private ArrayList<String> listadoEquipo2;
    private String equipo2;
    public static final int CANTIDADMAXIMA = 20000;
    public EventoDeportivo(int codigo, String titulo, Calendar fecha, double montoPagar,String descripcion,String deporte,String eq1, String eq2) {
        super(codigo, titulo, fecha, montoPagar,descripcion);
        tipoDeporte = Deportes.valueOf(deporte);
        equipo1 = eq1;
        equipo2 = eq2;
        listadoEquipo1 = new ArrayList<>();
        listadoEquipo2 = new ArrayList<>();

    }

    public ArrayList<String> getListadoEquipo1() {
        return listadoEquipo1;
    }


    public ArrayList<String> getListadoEquipo2() {
        return listadoEquipo2;
    }
    public void addJugador(int equipo,String name){
        if(equipo == 1){
            listadoEquipo1.add(name);
        }else{
            listadoEquipo2.add(name);
        }
    }

    public Deportes getTipoDeporte() {
        return tipoDeporte;
    }

    public void setTipoDeporte(String tipoDeporte) {
        this.tipoDeporte = Deportes.valueOf(tipoDeporte);
    }

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }
}

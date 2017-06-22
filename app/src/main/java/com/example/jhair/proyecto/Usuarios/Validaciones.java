package com.example.jhair.proyecto.Usuarios;

import com.example.jhair.proyecto.clases.Evento;

import java.util.ArrayList;

/**
 * Created by Jhair on 28/05/2017.
 */

public class Validaciones {
    public static ArrayList<Usuario> usuarioss =new ArrayList<>();

    public static UsuarioNormal usunormal[];
    private static int contador;
    public static void inicializarusuariosnomales(){
        usunormal = new UsuarioNormal[100];

        contador=0;
    }
    public static boolean comprobarRegistro(String u,String c){
        for (int i=0;i<usuarioss.size();i++){
            Usuario us=usuarioss.get(i);
            if(us.getUsuario().equals(u)&&us.getContra().equals(c)){
                return true;
            }
        }
        return false;

    }

    public static boolean comprobarUsuario(String u){
        for (int i=0;i<usuarioss.size();i++){
            Usuario us=usuarioss.get(i);
            if(us.getUsuario().equals(u)){
                return true;
            }
        }
        return false;

    }

    public static void addUsuario(Usuario u){
        usuarioss.add(u);
    }

    public static Usuario buscarUsuario(String u){
        for (int i=0;i<usuarioss.size();i++){
            Usuario us=usuarioss.get(i);
            if(us.getUsuario().equals(u)){
                return us;
            }
        }return null;
    }


    public static  void crearusuarionormal(String usuario,String contra){
        usunormal[contador].setUsuario(usuario);
        usunormal[contador].setContra(contra);

        contador++;

    }


    public static int comprobarpocicionusuarioinicio(String usuario){


        for (int x=0;x<100;x++) {
            String a= usunormal[x].getUsuario();
            if (a.equals(usuario)){
                return x;
            }
        }
        return -1;
    }

    public static boolean comprobarEventoUser(Evento eve, Usuario usu){
        if(usu instanceof UsuarioNormal){
            UsuarioNormal usun = (UsuarioNormal) usu;
            for(int  i =0; i <usun.eventosnormales.size();i++){
                if(usun.eventosnormales.get(i).equals(eve.getCodigo())){
                    return true;
                }
            }
        }else if(usu instanceof  UsuarioAdmin){
            UsuarioAdmin usua = (UsuarioAdmin) usu;
            for(int  i =0; i <usua.eventosadmin.size();i++){
                if(usua.eventosadmin.get(i).equals(eve.getCodigo())){
                    return true;
                }
            }
        }
        return false;
    }



}

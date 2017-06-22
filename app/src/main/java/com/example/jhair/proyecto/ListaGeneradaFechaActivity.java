package com.example.jhair.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jhair.proyecto.clases.Evento;
import com.example.jhair.proyecto.clases.EventoDeportivo;
import com.example.jhair.proyecto.clases.EventoMusical;
import com.example.jhair.proyecto.clases.EventoReligioso;

import java.util.ArrayList;
import java.util.Calendar;

public class ListaGeneradaFechaActivity extends AppCompatActivity {

    TextView DeportivosFil;
    TextView ReligiososFil;
    TextView MusicalesFil;
    TextView MontoTotalFil;
    double montoTotal = 0;
    int contadorDeportivos = 0;
    int contadorMusicales = 0;
    int contadorReligiosos = 0;
    ArrayList<Evento> EventosFiltrados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_generada_fecha);
        DeportivosFil = (TextView) findViewById(R.id.textViewDeportivosFil);
        ReligiososFil = (TextView) findViewById(R.id.textViewReligiososFil);
        MusicalesFil = (TextView) findViewById(R.id.textViewMusicalesFil);
        MontoTotalFil = (TextView) findViewById(R.id.textViewMontoTotalFil);


        /*/lo que voy a hacer es que voy a crear otro arrayList que contenga los eventos ya
        realizados, extrayendo la info del arrayList que esta en el MainClass, para asi no alterar
        la info que hay en el arraylist original
        */
        EventosFiltrados = new ArrayList<>();
        for(Evento e : MainClass.eventos) {
            if(e.getFecha().after(GenerarFechaActivity.FInicial) &&
                    e.getFecha().before(GenerarFechaActivity.FFinal)) {
                EventosFiltrados.add(e);
                montoTotal += e.getMontoPagar();
                if(e instanceof EventoDeportivo) {
                    contadorDeportivos++;
                }
                else if (e instanceof EventoMusical) {
                    contadorMusicales++;
                }
                else if(e instanceof EventoReligioso) {
                    contadorReligiosos++;
                }
            }
        }
        ListAdapter pambisitoAdapter = new CustomAdapter(getApplicationContext(), EventosFiltrados);
        ListView ListEventosFuturos = (ListView) findViewById(R.id.List_eventos_filtrados);
        ListEventosFuturos.setAdapter(pambisitoAdapter);

        //ahora a poner los contadores en los textViews
        DeportivosFil.setText("Eventos deportivos: "+String.valueOf(contadorDeportivos));
        ReligiososFil.setText("Eventos religiosos: "+String.valueOf(contadorReligiosos));
        MusicalesFil.setText("Eventos musicales: "+String.valueOf(contadorMusicales));
        MontoTotalFil.setText("Monto total: "+String.valueOf(montoTotal));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ListaGeneradaFechaActivity.this, MenuReportes.class);
        startActivity(intent);
        finish();
    }
}

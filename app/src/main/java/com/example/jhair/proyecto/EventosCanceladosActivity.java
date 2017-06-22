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

public class EventosCanceladosActivity extends AppCompatActivity {

    TextView DeportivosC;
    TextView ReligiososC;
    TextView MusicalesC;
    TextView MontoTotalC;
    ArrayList<Evento> EventosCanceled;
    int contadorDeportivos = 0;
    int contadorMusicales = 0;
    int contadorReligiosos = 0;
    double montoTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos_cancelados);
        DeportivosC = (TextView) findViewById(R.id.textViewDeportivosC);
        ReligiososC = (TextView) findViewById(R.id.textViewReligiososC);
        MusicalesC = (TextView) findViewById(R.id.textViewMusicalesC);
        MontoTotalC = (TextView) findViewById(R.id.textViewMontoTotalC);

        /*/lo que voy a hacer es que voy a crear otro arrayList que contenga los eventos ya
        realizados, extrayendo la info del arrayList que esta en el MainClass, para asi no alterar
        la info que hay en el arraylist original
        */
        EventosCanceled = new ArrayList<>();
        for(Evento e : MainClass.eventos) {
            if(Calendar.getInstance().before(e.getFecha())) {
                EventosCanceled.add(e);
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

        ListAdapter pambisitoAdapter = new CustomAdapter(getApplicationContext(), EventosCanceled);
        ListView ListEventosCancelados = (ListView) findViewById(R.id.List_eventos_cancelados);
        ListEventosCancelados.setAdapter(pambisitoAdapter);

        //ahora a poner los contadores en los textViews
        DeportivosC.setText("Eventos deportivos: "+String.valueOf(contadorDeportivos));
        ReligiososC.setText("Eventos religiosos: "+String.valueOf(contadorReligiosos));
        MusicalesC.setText("Eventos musicales: "+String.valueOf(contadorMusicales));
        MontoTotalC.setText("Monto total: "+String.valueOf(montoTotal));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(EventosCanceladosActivity.this, MenuReportes.class);
        startActivity(intent);
        finish();
    }
}

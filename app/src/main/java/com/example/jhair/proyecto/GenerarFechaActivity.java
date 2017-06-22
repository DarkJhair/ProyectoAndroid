package com.example.jhair.proyecto;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class GenerarFechaActivity extends AppCompatActivity {

    EditText FechaInicial;
    EditText FechaFinal;
    public static Calendar FInicial;
    public static Calendar FFinal;
    Button Generar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generar_fecha);
        FechaInicial = (EditText) findViewById(R.id.editTextFechaInicio);
        FechaFinal = (EditText) findViewById(R.id.editTextFechaFinal);
        Generar = (Button) findViewById(R.id.buttonGenerar);

        FechaInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDatePicker1();
            }
        });

        FechaFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDatePicker2();
            }
        });

        Generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FInicial = ((DatePickerFragment) newFragment1).getSc();
                    FFinal = ((DatePickerFragment)newFragment2).getSc();
                    if(FFinal.before(FFinal)) {
                        Intent intent = new Intent(GenerarFechaActivity.this, ListaGeneradaFechaActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Has elegido las fehcas al reves",Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Elige las fechas",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public DialogFragment newFragment1;
    public DialogFragment newFragment2;
    private void mostrarDatePicker1(){
        newFragment1 = new DatePickerFragment();
        newFragment1.show(getSupportFragmentManager(), "datePicker");
    }

    private void mostrarDatePicker2(){
        newFragment2 = new DatePickerFragment();
        newFragment2.show(getSupportFragmentManager(), "datePicker2");
    }
}

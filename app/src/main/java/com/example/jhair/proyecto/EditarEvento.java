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

import com.example.jhair.proyecto.clases.Evento;
import com.example.jhair.proyecto.clases.EventoDeportivo;
import com.example.jhair.proyecto.clases.EventoMusical;
import com.example.jhair.proyecto.clases.EventoReligioso;

import java.util.Calendar;

public class EditarEvento extends AppCompatActivity {
    TextView tipoEdtEvento;
    EditText editarCode;
    EditText editarTitulo;
    EditText editarDescripcion;
    TextView editarDate;
    EditText editarMonto;
    Button editarEvent;
    TextView txtDato1;
    EditText editarDato1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_evento);
        initComponents();
    }
    Evento eve;
    private void initComponents(){
        tipoEdtEvento = (TextView)findViewById(R.id.tipoEdtEvento);
        editarDate = (TextView)findViewById(R.id.editarDate);
        editarCode = (EditText)findViewById(R.id.editarCode);
        editarTitulo = (EditText)findViewById(R.id.editarTitulo);
        editarDescripcion = (EditText)findViewById(R.id.editarDescripcion);
        editarMonto = (EditText)findViewById(R.id.editarMonto);
        editarEvent = (Button)findViewById(R.id.editarEvent);
        txtDato1 = (TextView)findViewById(R.id.txtDato1);
        editarDato1 = (EditText) findViewById(R.id.editarDato1);
        final int codigo = (Integer) getIntent().getExtras().get("codEvent");
        eve = MainClass.buscarEvento(codigo);
        setDatos(eve);
        editarDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDatePicker();
            }
        });
        editarEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarDatos(eve);
                Toast.makeText(EditarEvento.this,"Datos Actualizados",Toast.LENGTH_LONG).show();
                setDatos(eve);

            }
        });


    }
    private void actualizarDatos(Evento e){
        int codigoEvent = (Integer) getIntent().getExtras().get("codEvent");
        int cod = Integer.valueOf(editarCode.getText().toString());
        String title = editarTitulo.getText().toString();
        String descripcion = editarDescripcion.getText().toString();
        Calendar date;
        if(e.getFechaString().equals(editarDate.getText().toString())){}
        else{
            date = ((DatePickerFragment) nwFragment).getSc();
            e.setFecha(date);
        }
        double monto = Double.parseDouble(editarMonto.getText().toString());
        e.setCodigo(cod);
        e.setTitulo(title);
        e.setDescripcion(descripcion);
        e.setMontoPagar(monto);
        if(e instanceof EventoReligioso && e.getFecha().before(Calendar.getInstance())){
            try {
                int personasConver = Integer.valueOf(editarDato1.getText().toString());
                ((EventoReligioso) e).setPersonasConvertidas(personasConver);
            }catch (Exception ex){
                ((EventoReligioso) e).setPersonasConvertidas(0);
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(EditarEvento.this,Eliminar_EventoActivity.class);
        intent.putExtra("FUENTE",1);
        startActivity(intent);
        finish();
    }
    private void setDatos(Evento e){
        editarCode.setText(String.valueOf(e.getCodigo()));
        editarTitulo.setText(e.getTitulo());
        editarDescripcion.setText(e.getDescripcion());
        editarDate.setText(e.getFechaString());
        editarMonto.setText(String.valueOf(e.getMontoPagar()));
        txtDato1.setText(" ");
        editarDato1.setText(" ");
        editarDato1.setEnabled(false);
        if(e instanceof EventoDeportivo){
            tipoEdtEvento.setText("DEPORTIVO");
        }
        else if(e instanceof EventoMusical){
            tipoEdtEvento.setText("MUSICAL");
            editarMonto.setText(String.valueOf(e.getMontoPagar()-((EventoMusical) e).getSeguroGrama()));
        }
        else{
            tipoEdtEvento.setText("RELIGIOSO");
            editarMonto.setText(String.valueOf(e.getMontoPagar()-2000));
            if(e.getFecha().before(Calendar.getInstance())) {
                editarDato1.setEnabled(true);
                txtDato1.setText("Convertidos: ");
                editarDato1.setText(String.valueOf(((EventoReligioso)e).getPersonasConvertidas()));
            }
        }
    }
    public DialogFragment nwFragment;
    private void mostrarDatePicker(){
        nwFragment = new DatePickerFragment();
        nwFragment.show(getSupportFragmentManager(), "datePicker");
    }
}
package com.example.jhair.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jhair.proyecto.clases.Evento;
import com.example.jhair.proyecto.clases.EventoMusical;

import java.util.ArrayList;

public class ViewStaff extends AppCompatActivity {
    EditText edt_Staff1;
    EditText edt_Staff2;
    EditText edt_Staff3;
    EditText edt_Staff4;
    EditText edt_Staff5;
    EditText edt_Staff6;
    EditText edt_Staff7;
    EditText edt_Staff8;
    EditText edt_Staff9;
    EditText edt_Staff10;
    EditText edt_Staff11;
    ViewGroup gridStaff;
    ViewGroup rl_Staff;
    Button btn_Guardar;
    int cod ;
    int fuente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_staff);
        initComponents();
    }

    private void initComponents(){
        cod = (Integer) getIntent().getExtras().get("codigoEvento");
        fuente = (Integer) getIntent().getExtras().get("FUENTE");
        btn_Guardar = (Button)findViewById(R.id.btn_Guardar);
        rl_Staff = (ViewGroup)findViewById(R.id.rl_Staff);
        gridStaff = (ViewGroup)findViewById(R.id.gridStaff);
        edt_Staff1 = (EditText)findViewById(R.id.edt_Staff1);
        edt_Staff2 = (EditText)findViewById(R.id.edt_Staff2);
        edt_Staff3 = (EditText)findViewById(R.id.edt_Staff3);
        edt_Staff4 = (EditText)findViewById(R.id.edt_Staff4);
        edt_Staff5 = (EditText)findViewById(R.id.edt_Staff5);
        edt_Staff6 = (EditText)findViewById(R.id.edt_Staff6);
        edt_Staff7 = (EditText)findViewById(R.id.edt_Staff7);
        edt_Staff8 = (EditText)findViewById(R.id.edt_Staff8);
        edt_Staff9 = (EditText)findViewById(R.id.edt_Staff9);
        setDatos(fuente,cod);

        btn_Guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setStaff(cod);
                Toast.makeText(ViewStaff.this,"Staff actualizado Exitosamente",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ViewStaff.this,EditarEvento.class);
                intent.putExtra("codEvent",cod);
                startActivity(intent);
                finish();
            }
        });
    }


    @Override
    public void onBackPressed() {
        if(fuente == 1) {
            Intent intent = new Intent(ViewStaff.this, EditarEvento.class);
            intent.putExtra("codEvent", cod);
            startActivity(intent);
            finish();
        }else if(fuente == 2){
            Intent intent = new Intent(ViewStaff.this, DatosEventoActivity.class);
            intent.putExtra("codigo", cod);
            startActivity(intent);
            finish();
        }
    }

    public void setStaff(int codi){
        Evento e = MainClass.buscarEvento(codi);
        ArrayList<String> arr = ((EventoMusical) e).getStaff();
        if(arr.size() == 0) {
            for (int i = 0; i < gridStaff.getChildCount(); i++) {
                EditText edt = (EditText) gridStaff.getChildAt(i);
                String txt = edt.getText().toString();
                int x = 10;
                ((EventoMusical) e).addStaff(txt);
            }
        }else{
            for (int i = 0; i < gridStaff.getChildCount(); i++) {
                EditText edt = (EditText) gridStaff.getChildAt(i);
                String txt = edt.getText().toString();
                arr.add(i,txt);
            }
        }
    }
    private void setDatos(int fuente, int codigo){
            if(fuente == 2){
                for (int i = 0; i < gridStaff.getChildCount(); i++) {
                    EditText edt = (EditText) gridStaff.getChildAt(i);
                    edt.setEnabled(false);
                    rl_Staff.removeView(btn_Guardar);

                }
            }
            Evento e = MainClass.buscarEvento(codigo);
            ArrayList<String> arr = ((EventoMusical) e).getStaff();
            if(arr.size() == 0){
            }else {
                for (int i = 0; i < gridStaff.getChildCount(); i++) {
                    EditText edt = (EditText) gridStaff.getChildAt(i);
                    edt.setText(arr.get(i).startsWith("android.support") ? String.valueOf(i + 1) + ". Agregue Nombre" : arr.get(i));
                }
            }
    }
}

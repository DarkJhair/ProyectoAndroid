package com.example.jhair.proyecto;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class menu_reportes_activity extends AppCompatActivity {
    Button ButtonList, ButtonListFuture, ButtonCancelEvent, ButtonDateInput, ButtonProfile,
            ButtonreturnMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_reportes_activity);
        initComponents();
    }

    public void initComponents() {
        ButtonList = (Button) findViewById(R.id.button_list_events);
        ButtonListFuture = (Button) findViewById(R.id.button_list_future_events);
        ButtonCancelEvent = (Button) findViewById(R.id.button_canceled_events);
        ButtonDateInput = (Button) findViewById(R.id.button_date_input);
        ButtonProfile = (Button) findViewById(R.id.button_profile);
        ButtonreturnMenu = (Button) findViewById(R.id.button_return_menu);

        //ahora lo que haran los botones al tocarlos (uff que rikho) :V
    }


}

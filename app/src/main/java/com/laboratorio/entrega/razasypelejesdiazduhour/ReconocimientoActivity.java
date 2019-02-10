package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ReconocimientoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences preferences = getSharedPreferences("preferences", MODE_PRIVATE);
        Boolean b = preferences.getBoolean("lista", true);
        if (b) {
            setContentView(R.layout.activity_reconocimiento);
        } else {
            setContentView(R.layout.activity_reconocimiento_grid);
        }
    }
    /*

        Propósito: Evento del boton volver que regresa a la pantalla de Principal (MainActivity)
    */
    public void volver(View view) {
        Intent i = new Intent(ReconocimientoActivity.this, MainActivity.class);
        startActivity(i);
    }
}

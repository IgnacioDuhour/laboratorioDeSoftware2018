package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MiniJuegoGanado extends AppCompatActivity {

    private TextView mTextMessage;
    private MediaPlayer videoConfeti;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_juego_ganado);
    }

    public void reiniciarUltimoJuego(View view) {
        Intent i = new Intent(MiniJuegoGanado.this, RazaYPelajeActivity.class);
        startActivity(i);
    }

    public void miniJuego(View view) {
        Intent i = new Intent(MiniJuegoGanado.this, RazayPelajeJuntasActivity.class);
        startActivity(i);
    }

}

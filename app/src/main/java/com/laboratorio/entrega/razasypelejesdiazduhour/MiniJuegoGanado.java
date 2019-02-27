package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

public class MiniJuegoGanado extends AppCompatActivity {

    private VideoView videoConfetiBg;
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_juego_ganado);
        cargarVideoConfeti();

    }

    public void irAInicio(View view) {
        Intent i = new Intent(MiniJuegoGanado.this, SettingsActivity.class);
        startActivity(i);
    }

    private void cargarVideoConfeti(){
        videoConfetiBg = (VideoView) findViewById(R.id.confetiBg);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.confeti);
        videoConfetiBg.setVideoURI(uri);
        videoConfetiBg.start();
    }
}

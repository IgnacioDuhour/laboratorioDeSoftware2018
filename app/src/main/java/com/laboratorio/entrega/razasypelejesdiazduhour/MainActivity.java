package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Activity act = this;

        Button recButton = act.findViewById(R.id.button);
        recButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(act, ReconocimientoActivity.class);
                startActivity(i);
            }
        });

        ImageButton aboutButton = act.findViewById(R.id.imageButton2);
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder about = new AlertDialog.Builder(act);
                about.setMessage(R.string.about_message)
                        .setCancelable(false)
                        .setPositiveButton(R.string.about_dialog_btn, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                AlertDialog alert = about.create();
                alert.setTitle(R.string.about_title);
                alert.show();
            }
        });
    }
    public void settings(View view){
        Intent i = new Intent(this, SettingsActivity.class);
        startActivity(i);
    }

    public void minigame(View view) {
        Intent i = new Intent(this, ReconocimientoActivity.class);
        startActivity(i);
    }
}

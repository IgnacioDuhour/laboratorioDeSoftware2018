package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * carga la lista del modo reconocimiento
 */
public class ListActivity extends ReconocimientoActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reconocimiento);
        cargarReconocimiento();
    }

    @Override
    public void cargarReconocimiento() {
        LinearLayout lista = findViewById(R.id.listaRec);
        for (Pelaje p : Pelaje.values()) {
            LinearLayout l = new LinearLayout(getApplicationContext());
            l.setOrientation(LinearLayout.HORIZONTAL);
            l.setGravity(Gravity.CENTER);
            l.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f));
            l.setWeightSum(3);
            l.setPadding(5, 5, 5, 5);

            //image
            ImageView iv = new ImageView(getApplicationContext());
            iv.setImageResource(ubicacionDeImagenDeCaballoPorNombre(p.name()));
            iv.setLayoutParams(new LinearLayout.LayoutParams(200,200,1.0f));
            iv.setMaxHeight(200);
            iv.setMaxWidth(200);

            l.addView(iv);

            //nombre y boton audio
            LinearLayout l2 = new LinearLayout(getApplicationContext());
            l2.setOrientation(LinearLayout.VERTICAL);
            l2.setLayoutParams(new LinearLayout.LayoutParams(20,LinearLayout.LayoutParams.WRAP_CONTENT,1.0f));
            TextView tv = new TextView(getApplicationContext());
            tv.setText(p.name());
            tv.setGravity(Gravity.CENTER);
            tv.setTextColor(Color.BLACK);
            l2.addView(tv);

            ImageButton iB = new ImageButton(getApplicationContext());
            iB.setImageResource(R.drawable.audio_regular);
            iB.setBackgroundColor(Color.TRANSPARENT);
            iB.setMaxWidth(101);
            iB.setMaxHeight(79);
            l2.addView(iB);
            l.addView(l2);

            //descripcion
            TextView tv2 = new TextView(getApplicationContext());
            tv2.setText(R.string.lorem);
            tv2.setLayoutParams(new LinearLayout.LayoutParams(57,94,1.0f));
            tv2.setGravity(Gravity.CENTER);
            tv2.setTextColor(Color.BLACK);
            tv2.setMaxWidth(57);
            tv2.setMaxHeight(94);
            l.addView(tv2);

            //agrego a la lista
            lista.addView(l);
        }
    }
}

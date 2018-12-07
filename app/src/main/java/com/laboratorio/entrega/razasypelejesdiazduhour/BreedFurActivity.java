package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class BreedFurActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        TextView itemTextView = (TextView) findViewById(R.id.breedOrFurItemTextView);
        itemTextView.setText("Raza");

        ImageView img1 = (ImageView) findViewById(R.id.breedfurImageView1);
        //img1.setImageDrawable();
        //img1.setImageResource();

        setContentView(R.layout.activity_breed_fur);
    }
}

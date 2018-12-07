package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

public class BreedFurActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_fur);

        TableLayout tableLayout = (TableLayout) findViewById(R.id.breedfurTablelayout);


        TextView itemTextView = (TextView) findViewById(R.id.breedOrFurItemTextView);
        itemTextView.setText("Raza");


        ImageView img1 = (ImageView) findViewById(R.id.breedfurImageView1);
        img1.setImageResource(R.drawable.caballo2);

        ImageView img2 = (ImageView) findViewById(R.id.breedfurImageView2);
        img2.setImageResource(R.drawable.caballo2);

        ImageView img3 = (ImageView) findViewById(R.id.breedfurImageView3);
        img3.setImageResource(R.drawable.caballo2);

        ImageView img4 = (ImageView) findViewById(R.id.breedfurImageView4);
        img4.setImageResource(R.drawable.caballo2);


    }
}

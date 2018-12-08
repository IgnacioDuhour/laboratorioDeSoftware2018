package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

public class BreedFurActivity extends AppCompatActivity {

    private String[] playSequences; //secuencia de jugadas random intercambiadas entre razas y pelajes
    private int lastPlayWon; //última jugada ganada

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_breed_fur);

        loadFirstPlay();
    }

    private void loadFirstPlay() {
        this.lastPlayWon = 0;
        generateSequenceOfRandomGame();
        loadActivityWithBInteraction();
    }

    private void generateSequenceOfRandomGame(){
        this.playSequences = new String[HorseFur.values().length];
        int i=0;
        for(HorseFur h: HorseFur.values()) {
            this.playSequences[i] = h.toString();
            i++;
        }
    }

    private void loadActivityWithBInteraction() {
        loadTextView();
        loadFourImagesView();
    }

    //ver de elegir un nombre que no tenga que ver con ImageView
    private void loadTextView(){
        TextView itemTextView = (TextView) findViewById(R.id.breedOrFurItemTextView);
        itemTextView.setText("Pelaje");
    }

    //ver de elegir un nombre que no tenga que ver con ImageView
    private void loadFourImagesView(){
        loadTheCorrectImage();
        loadTheOtherThreeImages();
    }

    private void loadTheCorrectImage() {
        ImageView img1 = (ImageView) findViewById(R.id.breedfurImageView1);
        img1.setImageResource(getDrawableValueByImage(playSequences[lastPlayWon]));
    }

    @SuppressLint("ResourceType")
    private void loadTheOtherThreeImages() {
        ImageView img2 = (ImageView) findViewById(R.id.breedfurImageView2);
        img2.setImageResource(getDrawableValueByImage(playSequences[lastPlayWon+1]));

        ImageView img3 = (ImageView) findViewById(R.id.breedfurImageView3);
        img3.setImageResource(getDrawableValueByImage(playSequences[lastPlayWon+2]));

        ImageView img4 = (ImageView) findViewById(R.id.breedfurImageView4);
        img4.setImageResource(getDrawableValueByImage(playSequences[lastPlayWon+3]));

    }

    private int getDrawableValueByImage(String nameImg) {
        switch (nameImg) {
            case "ALBO": return R.drawable.albo;
            case "ATIGRADO": return R.drawable.atigrado;
            case "BAYO": return R.drawable.bayo;
            case "BRAGADO": return R.drawable.bragado;
            case "COLORADO": return R.drawable.colorado;
            case "MELADO": return R.drawable.melado;
            case "PANGARE": return R.drawable.pangare;
            case "ZAINO": return R.drawable.zaino;
            default: return R.drawable.defaultfur;
        }
    }

    public void backButton(View view) {
        Intent i = new Intent(BreedFurActivity.this, MainActivity.class);
        startActivity(i);
    }
}

package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class BreedFurActivity extends AppCompatActivity {

    private String[] playSequences; //secuencia de jugadas random intercambiadas entre razas y pelajes
    private int lastPlayWon; //última jugada ganada

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_fur);
        loadFirstPlay();


        ImageView imageButton = (ImageView) findViewById(R.id.breedfurImageView1);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView1OnClick();
            }
        });
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
        img1.setTag(typeHorseTextView());
    }

    @SuppressLint("ResourceType")
    private void loadTheOtherThreeImages() {
        ImageView img2 = (ImageView) findViewById(R.id.breedfurImageView2); //get imageView
        img2.setImageResource(getDrawableValueByImage(playSequences[lastPlayWon+1]));//set resource to imageView
        img2.setTag(playSequences[lastPlayWon+1]); // set name to imageView to distinguish

        ImageView img3 = (ImageView) findViewById(R.id.breedfurImageView3);
        img3.setImageResource(getDrawableValueByImage(playSequences[lastPlayWon+2]));
        img3.setTag(playSequences[lastPlayWon+2]);

        ImageView img4 = (ImageView) findViewById(R.id.breedfurImageView4);
        img4.setImageResource(getDrawableValueByImage(playSequences[lastPlayWon+3]));
        img4.setTag(playSequences[lastPlayWon+3]);

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

    public void imageView1OnClick() {
        //breedfurImageView1
        ImageView img1 = (ImageView)findViewById(R.id.breedfurImageView1);
        if (img1.getTag()==typeHorseTextView()) {
            dialogWithTheOptionToNextPlay();
        } else {
            //emitir sonodio y volver a la misma actividad con las misma jugada
            Intent i = new Intent(BreedFurActivity.this, SettingsActivity.class);
            startActivity(i);
        }

    }

    //mensaje con dos opciones: volver a jugar|siguiente jugada
    private void dialogWithTheOptionToNextPlay() {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Jugada Ganada");
        //builder.setMessage("This is my message.");

        // add a button
        builder.setPositiveButton("Siguiente jugada", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                loadNextPlay();
            }
        });
        builder.setNeutralButton("Volver a jugar", null);
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void imageView2OnClick(View view) {

    }

    public void imageView3OnClick(View view) {

    }

    public void imageView4OnClick(View view) {

    }

    //pensar en un nombre que no sea textview
    //devuelve el typo (pelaje o raza) del caballo que aparece en el texto (textView)
    private String typeHorseTextView() {
        return playSequences[lastPlayWon];
    }

    //devuelve el nombre del caballo para la primera imagen
    private String typeHorseImage1() {
        return playSequences[lastPlayWon];
    }

    //devuelve el nombre del caballo para la primera imagen
    private String typeHorseImage2() {
        return playSequences[lastPlayWon+1];
    }

    private void loadNextPlay() {
        this.lastPlayWon ++;
        loadTextView();
        loadFourImagesView();
    }
}

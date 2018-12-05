package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        SharedPreferences preferences = getSharedPreferences("preferences", MODE_PRIVATE);

        recognitionSettings(preferences);

        RadioButton rb2 = SettingsActivity.this.findViewById(R.id.radioButton3);
        RadioButton rb3 = SettingsActivity.this.findViewById(R.id.radioButton4);
        RadioButton rb4 = SettingsActivity.this.findViewById(R.id.radioButton5);

        radioGroup(preferences, rb2, rb3, rb4, "razaypelaje", "razaspelajejuntas", "juego_cruzas");

        RadioButton rb5 = SettingsActivity.this.findViewById(R.id.radioButton6);
        RadioButton rb6 = SettingsActivity.this.findViewById(R.id.radioButton7);
        RadioButton rb7 = SettingsActivity.this.findViewById(R.id.radioButton8);

        radioGroup(preferences, rb5, rb6, rb7, "interact_a", "interact_b", "interact_c");

        configs(preferences);
    }

    private void recognitionSettings(SharedPreferences preferences) {
        Boolean b = preferences.getBoolean("lista", true);
        RadioButton rb;
        if (b) {
            rb = SettingsActivity.this.findViewById(R.id.radioButton);
            rb.setChecked(true);
        } else {
            rb = SettingsActivity.this.findViewById(R.id.radioButton2);
            rb.setChecked(true);
        }

        CheckBox cb1 = SettingsActivity.this.findViewById(R.id.checkBox);
        CheckBox cb2 = SettingsActivity.this.findViewById(R.id.checkBox2);
        CheckBox cb3 = SettingsActivity.this.findViewById(R.id.checkBox3);
        cb1.setChecked(preferences.getBoolean("razas", true));
        cb2.setChecked(preferences.getBoolean("pelajes", false));
        cb3.setChecked(preferences.getBoolean("cruzas", false));
    }

    private void radioGroup(SharedPreferences preferences, RadioButton r1, RadioButton r2, RadioButton r3, String key, String key2, String key3) {
        if (preferences.getBoolean(key, true)) {
            r1.setChecked(true);
        } else if (preferences.getBoolean(key2, false)) {
            r2.setChecked(true);
        } else if (preferences.getBoolean(key3, false)) {
            r3.setChecked(true);
        }
    }

    private void configs(SharedPreferences preferences) {
        Switch sw = SettingsActivity.this.findViewById(R.id.switch1);
        String text = preferences.getString("level", "Nivel 1");
        if (text.equals("Nivel 1")) {
            sw.setChecked(false);
        } else {
            sw.setChecked(true);
        }
        sw = SettingsActivity.this.findViewById(R.id.switch2);
        text = preferences.getString("audio", "Femenina");
        if (text.equals("Femenina")) {
            sw.setChecked(true);
        } else {
            sw.setChecked(false);
        }
    }

    public void saveSettings(View view) {
        SharedPreferences preferences = getSharedPreferences("preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        RadioGroup rg = SettingsActivity.this.findViewById(R.id.radioGroup7);
        int radioId = rg.getCheckedRadioButtonId();
        RadioButton rb = SettingsActivity.this.findViewById(radioId);
        if ((rb.getText()).toString().compareTo("Lista") == 0) {
            editor.putBoolean("lista", true);
            editor.putBoolean("grilla", false);
        } else {
            editor.putBoolean("grilla", true);
            editor.putBoolean("lista", false);
        }
        CheckBox cb1 = SettingsActivity.this.findViewById(R.id.checkBox);
        CheckBox cb2 = SettingsActivity.this.findViewById(R.id.checkBox2);
        CheckBox cb3 = SettingsActivity.this.findViewById(R.id.checkBox3);
        editor.putBoolean("razas", cb1.isChecked());
        editor.putBoolean("pelajes", cb2.isChecked());
        editor.putBoolean("cruzas", cb3.isChecked());

        rg = SettingsActivity.this.findViewById(R.id.radioGroup8);
        radioId = rg.getCheckedRadioButtonId();
        rb = SettingsActivity.this.findViewById(radioId);
        String text = (String) rb.getText();
        switch (text) {
            case "Razas y Pelajes":
                editor.putBoolean("razaypelaje", true);
                editor.putBoolean("razaspelajejuntas", false);
                editor.putBoolean("juego_cruzas", false);
                break;
            case "Razas y Pelajes Juntas":
                editor.putBoolean("razaspelajejuntas", true);
                editor.putBoolean("razaypelaje", false);
                editor.putBoolean("juego_cruzas", false);
                break;
            case "Cruzas":
                editor.putBoolean("juego_cruzas", true);
                editor.putBoolean("razaspelajejuntas", false);
                editor.putBoolean("razaypelaje", false);
                break;
            default:
                break;
        }


        rg = SettingsActivity.this.findViewById(R.id.radioGroup9);
        radioId = rg.getCheckedRadioButtonId();
        rb = SettingsActivity.this.findViewById(radioId);
        text = (String) rb.getText();
        switch (text) {
            case "Interacción A":
                editor.putBoolean("interact_a", true);
                editor.putBoolean("interact_b", false);
                editor.putBoolean("interact_c", false);
                break;
            case "Interacción B":
                editor.putBoolean("interact_a", false);
                editor.putBoolean("interact_b", true);
                editor.putBoolean("interact_c", false);
                break;
            case "Interacción C":
                editor.putBoolean("interact_a", false);
                editor.putBoolean("interact_b", false);
                editor.putBoolean("interact_c", true);
                break;
            default:
                break;
        }

        Switch sw = SettingsActivity.this.findViewById(R.id.switch1);
        if (sw.isChecked()) {
            editor.putString("level", (String) sw.getTextOn());
        } else {
            editor.putString("level", (String) sw.getTextOff());
        }
        sw = SettingsActivity.this.findViewById(R.id.switch2);
        if (sw.isChecked()) {
            editor.putString("audio", (String) sw.getTextOn());
        } else {
            editor.putString("audio", (String) sw.getTextOff());
        }

        editor.apply();
        finish();
    }
}

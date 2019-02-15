package com.laboratorio.entrega.razasypelejesdiazduhour;

import android.os.Bundle;

public class GridActivity extends ReconocimientoActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reconocimiento_grid);
        cargarReconocimiento();
    }

    @Override
    public void cargarReconocimiento() {

    }
}

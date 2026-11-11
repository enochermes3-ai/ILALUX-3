package com.ilalux.observatorio;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

abstract class ListaBase extends AppCompatActivity {
    abstract String titulo();
    abstract String subtitulo();
    abstract Contenido.Item[] items();
    abstract int tipo(); // 0 = temario, 1 = boletin

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        findViewById(R.id.btnVolver).setOnClickListener(v -> finish());
        ((TextView) findViewById(R.id.titulo)).setText(titulo());
        ((TextView) findViewById(R.id.subtitulo)).setText(subtitulo());

        LinearLayout cont = findViewById(R.id.contenedor);
        float d = getResources().getDisplayMetrics().density;
        Contenido.Item[] lista = items();
        for (int i = 0; i < lista.length; i++) {
            final int indice = i;
            Contenido.Item it = lista[i];
            View v = LayoutInflater.from(this).inflate(R.layout.item_tarjeta, cont, false);
            ((TextView) v.findViewById(R.id.etiqueta)).setText(it.etiqueta);
            ((TextView) v.findViewById(R.id.nombre)).setText(it.titulo);
            ((TextView) v.findViewById(R.id.detalle)).setText(it.resumen);
            v.setOnClickListener(x -> {
                Intent in = new Intent(this, DetalleActivity.class);
                in.putExtra("tipo", tipo());
                in.putExtra("indice", indice);
                startActivity(in);
            });
            v.setAlpha(0f);
            v.setTranslationY(30 * d);
            v.animate().alpha(1f).translationY(0f).setStartDelay(120L + i * 90L)
                .setDuration(450).setInterpolator(new DecelerateInterpolator()).start();
            cont.addView(v);
        }
    }
}

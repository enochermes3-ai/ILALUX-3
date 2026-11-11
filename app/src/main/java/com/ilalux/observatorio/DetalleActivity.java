package com.ilalux.observatorio;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetalleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        findViewById(R.id.btnVolver).setOnClickListener(v -> finish());

        int tipo = getIntent().getIntExtra("tipo", 0);
        int indice = getIntent().getIntExtra("indice", 0);
        Contenido.Item[] fuente = tipo == 0 ? Contenido.TEMARIO : Contenido.BOLETIN;
        if (indice < 0 || indice >= fuente.length) { finish(); return; }
        Contenido.Item it = fuente[indice];

        ((TextView) findViewById(R.id.etiqueta)).setText(it.etiqueta);
        ((TextView) findViewById(R.id.titulo)).setText(it.titulo);

        LinearLayout cont = findViewById(R.id.contenedor);
        int n = 0;
        for (String linea : it.cuerpo) {
            TextView t = new TextView(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            if (linea.startsWith("## ")) {
                t.setText(linea.substring(3));
                t.setTextColor(getColor(R.color.dorado));
                t.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17);
                t.setTypeface(t.getTypeface(), android.graphics.Typeface.BOLD);
                lp.topMargin = dp(24);
            } else if (linea.startsWith("• ")) {
                t.setText("•  " + linea.substring(2));
                t.setTextColor(Color.WHITE);
                t.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15.5f);
                t.setLineSpacing(0, 1.25f);
                t.setPadding(dp(6), 0, 0, 0);
                lp.topMargin = dp(10);
            } else {
                t.setText(linea);
                t.setTextColor(getColor(R.color.texto_suave));
                t.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15.5f);
                t.setLineSpacing(0, 1.3f);
                lp.topMargin = dp(14);
            }
            t.setLayoutParams(lp);
            t.setAlpha(0f);
            t.setTranslationY(dp(16));
            t.animate().alpha(1f).translationY(0f).setStartDelay(100L + n * 60L)
                .setDuration(400).setInterpolator(new DecelerateInterpolator()).start();
            n++;
            cont.addView(t);
        }
    }

    private int dp(int v) {
        return Math.round(v * getResources().getDisplayMetrics().density);
    }
}

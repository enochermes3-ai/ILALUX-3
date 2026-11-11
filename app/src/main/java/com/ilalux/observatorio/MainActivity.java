package com.ilalux.observatorio;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {

    // ====== DATOS EDITABLES ======
    // Importante: el sitio en wuaze.com funciona SIN "www." delante.
    private static final String URL_SITIO = "https://observatorioilalux.wuaze.com/";
    private static final String TELEFONO = "+524428807888";
    private static final String URL_WHATSAPP = "https://wa.me/524428807888?text="
        + Uri.encode("Hola, tengo una pregunta para el director del Observatorio Ilalux.");
    // Si tienes el enlace fijo de tus clases en Meet, ponlo aqui (ej. https://meet.google.com/abc-defg-hij)
    private static final String URL_CLASES = "https://meet.google.com/";
    private static final String URL_MAPA = "https://www.google.com/maps/dir/?api=1&destination="
        + Uri.encode("Observatorio Ilalux, La Mesita, Huimilpan, Querétaro, México")
        + "&travelmode=driving";

    private static final int[] FOTOS = {
        R.drawable.slide_1, R.drawable.slide_2, R.drawable.slide_3,
        R.drawable.slide_4, R.drawable.slide_5
    };
    private static final long INTERVALO_SLIDER_MS = 3500;

    private final Handler handler = new Handler(Looper.getMainLooper());
    private ViewPager2 pager;
    private final Runnable avanzar = new Runnable() {
        @Override public void run() {
            int n = FOTOS.length;
            pager.setCurrentItem((pager.getCurrentItem() + 1) % n, true);
            handler.postDelayed(this, INTERVALO_SLIDER_MS);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.cardWeb).setOnClickListener(v -> abrirUrl(URL_SITIO));
        findViewById(R.id.cardBoletin).setOnClickListener(v ->
            startActivity(new Intent(this, BoletinActivity.class)));
        findViewById(R.id.cardTemario).setOnClickListener(v ->
            startActivity(new Intent(this, TemarioActivity.class)));
        findViewById(R.id.cardDirector).setOnClickListener(v -> abrirUrl(URL_WHATSAPP));
        findViewById(R.id.cardClases).setOnClickListener(v -> abrirUrl(URL_CLASES));
        findViewById(R.id.rowTel).setOnClickListener(v -> abrir(new Intent(Intent.ACTION_DIAL,
            Uri.parse("tel:" + TELEFONO))));
        findViewById(R.id.cardMapa).setOnClickListener(v -> abrirUrl(URL_MAPA));

        configurarSlider();

        int[] ids = {R.id.tvTitulo, R.id.tvSub, R.id.cardWeb, R.id.cardBoletin,
                     R.id.cardTemario, R.id.cardDirector, R.id.cardClases};
        for (int i = 0; i < ids.length; i++) aparecer(findViewById(ids[i]), 100 + i * 90L);
    }

    private void configurarSlider() {
        pager = findViewById(R.id.pager);
        pager.setAdapter(new SlideAdapter(FOTOS));
        pager.setOffscreenPageLimit(1);

        final LinearLayout puntos = findViewById(R.id.puntos);
        final float d = getResources().getDisplayMetrics().density;
        for (int i = 0; i < FOTOS.length; i++) {
            View p = new View(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                Math.round(8 * d), Math.round(8 * d));
            lp.setMargins(Math.round(3 * d), 0, Math.round(3 * d), 0);
            p.setLayoutParams(lp);
            puntos.addView(p);
        }
        marcarPunto(puntos, 0);
        pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override public void onPageSelected(int position) {
                marcarPunto(puntos, position);
            }
        });
    }

    private void marcarPunto(LinearLayout puntos, int activo) {
        for (int i = 0; i < puntos.getChildCount(); i++) {
            puntos.getChildAt(i).setBackgroundResource(i == activo ? R.drawable.dot_on : R.drawable.dot_off);
        }
    }

    private void abrirUrl(String url) {
        abrir(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }

    private void abrir(Intent intent) {
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "No se encontró una aplicación para abrir este enlace",
                Toast.LENGTH_LONG).show();
        }
    }

    private void aparecer(View v, long retraso) {
        float d = getResources().getDisplayMetrics().density;
        v.setAlpha(0f);
        v.setTranslationY(36 * d);
        v.animate().alpha(1f).translationY(0f).setStartDelay(retraso)
            .setDuration(550).setInterpolator(new DecelerateInterpolator()).start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(avanzar, INTERVALO_SLIDER_MS);
    }

    @Override
    protected void onPause() {
        handler.removeCallbacks(avanzar);
        super.onPause();
    }
}

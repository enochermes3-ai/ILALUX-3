package com.ilalux.observatorio;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

/** Pantalla de bienvenida: logo animado sobre fondo claro y paso al menu principal. */
public class SplashActivity extends AppCompatActivity {
    private static final long DURACION_MS = 2800;
    private final List<Animator> bucles = new ArrayList<>();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final Runnable irAlMenu = () -> {
        startActivity(new Intent(this, MainActivity.class));
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        animarLogo();
        handler.postDelayed(irAlMenu, DURACION_MS);
    }

    /** Entrada del logo (zoom + rebote), luego flotacion suave; las estrellas titilan. */
    private void animarLogo() {
        final float d = getResources().getDisplayMetrics().density;
        final View caja = findViewById(R.id.logoBox);
        final View estrellas = findViewById(R.id.logoStars);

        caja.setAlpha(0f);
        caja.setScaleX(0.8f);
        caja.setScaleY(0.8f);
        caja.setTranslationY(26 * d);
        caja.animate().alpha(1f).scaleX(1f).scaleY(1f).translationY(0f)
            .setDuration(950).setInterpolator(new OvershootInterpolator(1.1f))
            .withEndAction(() -> {
                ObjectAnimator flota = ObjectAnimator.ofFloat(caja, View.TRANSLATION_Y, 0f, -6 * d);
                bucle(flota, 2800);
            }).start();

        estrellas.setAlpha(0f);
        estrellas.animate().alpha(1f).setStartDelay(650).setDuration(900)
            .withEndAction(() -> {
                ObjectAnimator titila = ObjectAnimator.ofFloat(estrellas, View.ALPHA, 1f, 0.25f);
                bucle(titila, 1300);
            }).start();
    }

    private void bucle(ObjectAnimator a, long duracion) {
        a.setDuration(duracion);
        a.setRepeatCount(ValueAnimator.INFINITE);
        a.setRepeatMode(ValueAnimator.REVERSE);
        a.setInterpolator(new AccelerateDecelerateInterpolator());
        bucles.add(a);
        a.start();
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacks(irAlMenu);
        for (Animator a : bucles) a.cancel();
        bucles.clear();
        super.onDestroy();
    }
}

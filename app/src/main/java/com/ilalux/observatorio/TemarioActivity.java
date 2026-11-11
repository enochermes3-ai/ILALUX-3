package com.ilalux.observatorio;

public class TemarioActivity extends ListaBase {
    String titulo() { return "Temario"; }
    String subtitulo() { return "Curso de astronomía básica · 5 módulos"; }
    Contenido.Item[] items() { return Contenido.TEMARIO; }
    int tipo() { return 0; }
}

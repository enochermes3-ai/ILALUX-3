package com.ilalux.observatorio;

public class BoletinActivity extends ListaBase {
    String titulo() { return "Boletín astronómico"; }
    String subtitulo() { return "Edición noviembre – diciembre 2026"; }
    Contenido.Item[] items() { return Contenido.BOLETIN; }
    int tipo() { return 1; }
}

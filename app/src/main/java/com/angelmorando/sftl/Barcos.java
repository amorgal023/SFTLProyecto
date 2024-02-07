package com.angelmorando.sftl;

public enum Barcos {
    FACINAS_JET(Zonas.CAMPO_GIBRALTAR, "Facinas Jet"),
    TAHIVILLA_JET(Zonas.CAMPO_GIBRALTAR, "Tahivilla Jet"),
    HUELOTERRA_EXPRESS(Zonas.EXTERIOR, "Hueloterra Express"),
    NORTE_EXPRESS(Zonas.EXTERIOR, "Norte Express");



    private final Zonas zonaBarco;
    private final String nombreBarco;

    Barcos(Zonas zonaBarco, String nombreBarco) {
        this.zonaBarco = zonaBarco;
        this.nombreBarco = nombreBarco;
    }

    public int getZonaBarco() {
        return zonaBarco.getValorZona();
    }
    public String getNombreBarco() {
        return nombreBarco;
    }
}

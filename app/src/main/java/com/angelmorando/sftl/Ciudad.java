package com.angelmorando.sftl;

public enum Ciudad {
    TARIFA(Zonas.CAMPO_GIBRALTAR, "Tarifa"),
    ALGECIRAS(Zonas.CAMPO_GIBRALTAR, "Algeciras"),
    CEUTA(Zonas.EXTERIOR, "Ceuta"),
    TANGER(Zonas.EXTERIOR, "Tanger"),
    NO_VALIDO(Zonas.NO_VALIDO, "No valido");

    private final Zonas zonaCiudad;
    private final String nombreCiudad;

    Ciudad(Zonas zonaCiudad, String nombreCiudad) {
        this.zonaCiudad = zonaCiudad;
        this.nombreCiudad = nombreCiudad;
    }

    public int getZonaCiudad() {
        return zonaCiudad.getValorZona();
    }
    public String getNombreCiudad() {
        return nombreCiudad;
    }
}

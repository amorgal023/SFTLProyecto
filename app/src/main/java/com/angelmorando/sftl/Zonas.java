package com.angelmorando.sftl;

public enum Zonas {
    CAMPO_GIBRALTAR(0), EXTERIOR(1), NO_VALIDO(-1);

    private final int valorZona;

    Zonas(int valorZona) {
        this.valorZona = valorZona;
    }

    public int getValorZona() {
        return valorZona;
    }
}

package com.angelmorando.sftl

class Constantes {
    //El companion object se usa para poder acceder a las constantes como en Java, por ejemplo Constantes.MAXIMO_PERSONAS
    companion object {
        val MINIMO_PERSONAS = 1
        val MAXIMO_PERSONAS = 20
        // Strings de los mensaje de error generados por el alert.
        val TITULO_ERROR = "Error";
        val ACEPTAR_ERROR = "Aceptar";
        val MENSAJE_ERROR_ORIGENDEST = "El origen o destino no son correctos. Compruebe y pruebe de nuevo.";
        val MENSAJE_ERROR_FECHA = "La fecha no puede ser anterior a la actual.";
        val MENSAJE_ERROR_CORREO = "El correo electronico no puede estar en blanco.";
        val MENSAJE_ERROR_PASSWORD = "La contraseña no puede estar en blanco.\"";

    }
}
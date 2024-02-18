package com.angelmorando.sftl

class Constantes {
    //El companion object se usa para poder acceder a las constantes como en Java, por ejemplo Constantes.MAXIMO_PERSONAS
    companion object {
        val MINIMO_PERSONAS = 1
        val MAXIMO_PERSONAS = 20

        //PRECIOS
        val PRECIO_POR_PERSONA = 18.20
        val SUPLEMENTO_COCHES = 54.00
        val SUPLEMENTO_NENES = 5.00
        val SUPLEMENTO_ANIMALES = 4.00
        //SERVICIOS PREMIUM
        val PRECIO_CAFE = 1.50
        val PRECIO_COMIDA = 2.00
        val PRECIO_PISCINA = 4.00
        val PRECIO_ASIENTO = 3.50
        val PRECIO_TAQUILLA = 2



        // Strings de los mensaje de error generados por el alert.
        //ERRORES
        val TITULO_ERROR = "Error";
        val ACEPTAR_ERROR = "Aceptar";
        val MENSAJE_ERROR_ORIGENDEST = "El origen o destino no son correctos. Compruebe y pruebe de nuevo.";
        val MENSAJE_ERROR_FECHA = "La fecha no puede ser anterior a la actual.";
        val MENSAJE_ERROR_CORREO = "El correo electronico no puede estar en blanco.";
        val MENSAJE_ERROR_PASSWORD = "La contraseña no puede estar en blanco.";
        val MENSAJE_ERROR_AMBOS = "El correo electronico y la contraseña no puede estar en blanco.";



    }
}
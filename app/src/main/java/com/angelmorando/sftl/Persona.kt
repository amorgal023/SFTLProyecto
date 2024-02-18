package com.angelmorando.sftl

import java.io.Serializable

class Persona(
    private var nombre : String,
    private var DNI : String,
    private var correo : String) : Serializable
{
    fun getNombre() : String {
        return this.nombre
    }

    fun getDNI() : String {
        return this.DNI
    }

    fun getCorreo() : String {
        return this.correo
    }


}
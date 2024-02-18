package com.angelmorando.sftl

import java.io.Serializable
import java.time.LocalDate

class PrimerPartePedido(
    private var origenEnum : Ciudad,
    private var destinoEnum : Ciudad,
    private var numPersonas : Int,
    private var llevaCoche : Boolean,
    private var llevaNenes : Boolean,
    private var llevaAnimales : Boolean,
    private var fechaSeleccionada: LocalDate) : Serializable{
    fun getOrigenEnum() : Ciudad {
        return this.origenEnum
    }

    fun getDestinoEnum() : Ciudad {
        return this.destinoEnum
    }

    fun getNumPersonas() : Int {
        return this.numPersonas
    }

    fun getLlevaCoche() : Boolean {
        return this.llevaCoche
    }

    fun getLlevaNenes() : Boolean {
        return this.llevaNenes
    }

    fun getLlevaAnimales() : Boolean {
        return this.llevaAnimales
    }

    fun getFechaSeleccionada() : LocalDate {
        return this.fechaSeleccionada
    }
}
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



}
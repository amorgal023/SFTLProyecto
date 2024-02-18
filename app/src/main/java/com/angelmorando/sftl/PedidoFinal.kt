package com.angelmorando.sftl

import java.io.Serializable

class PedidoFinal(
    private var primerPartePedido: PrimerPartePedido,
    private var precioTotal : Double,
    private var listaPersona : List<Persona>) : Serializable
{
    fun getPrimerPartePedido() : PrimerPartePedido {
        return this.primerPartePedido
    }

    fun getPrecioTotal() : Double {
        return this.precioTotal
    }

    fun getListaPersona() : List<Persona> {
        return this.listaPersona
    }


}
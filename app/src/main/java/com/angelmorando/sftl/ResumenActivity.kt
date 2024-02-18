package com.angelmorando.sftl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton

class ResumenActivity : AppCompatActivity() {

    private lateinit var butIbBack: ImageButton

    private lateinit var butFinalizar : AppCompatButton

    private lateinit var tvNombre: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvFecha: TextView
    private lateinit var tvNumPersonas: TextView
    private lateinit var tvPrecio: TextView

    private lateinit var pedidoFinal: PedidoFinal



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)
        initButtons()
        initFunctions()
        initVariables()
    }
    private fun initButtons() {
        butIbBack = findViewById<ImageButton>(R.id.butIbBack)
        butFinalizar = findViewById<AppCompatButton>(R.id.butFinalizar)
        tvNombre = findViewById<TextView>(R.id.tvNombre)
        tvEmail = findViewById<TextView>(R.id.tvEmail)
        tvFecha = findViewById<TextView>(R.id.tvFecha)
        tvNumPersonas = findViewById<TextView>(R.id.tvNumPersonas)
        tvPrecio = findViewById<TextView>(R.id.tvPrecio)
    }


    private fun initFunctions() {
        butIbBack.setOnClickListener {
            finish()
        }

        butFinalizar.setOnClickListener {
            enviarInformacion()
        }


    }

    private fun enviarInformacion() {
        val intent = Intent(this, PasarelaActivity::class.java)
        intent.putExtra("PEDIDO_FINAL",pedidoFinal)
        startActivity(intent)
    }

    private fun initVariables() {
        pedidoFinal = intent.getSerializableExtra("PEDIDO_FINAL") as PedidoFinal
        tvNombre.text = pedidoFinal.getListaPersona()[0].getNombre()
        tvEmail.text = pedidoFinal.getListaPersona()[0].getCorreo()
        tvFecha.text = pedidoFinal.getPrimerPartePedido().getFechaSeleccionada().toString()
        tvNumPersonas.text = pedidoFinal.getPrimerPartePedido().getNumPersonas().toString()
        tvPrecio.text = pedidoFinal.getPrecioTotal().toString()+" €"
    }

}



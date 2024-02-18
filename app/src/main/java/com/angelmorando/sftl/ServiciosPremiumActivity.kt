package com.angelmorando.sftl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.ImageButton
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class ServiciosPremiumActivity : AppCompatActivity() {
    private lateinit var butIbBack: ImageButton
    private lateinit var butContinuar: AppCompatButton

    private lateinit var cgServicios : ChipGroup
    private lateinit var cpAsiento: Chip
    private lateinit var cpComida: Chip
    private lateinit var cpPiscina: Chip
    private lateinit var cpTaquilla: Chip
    private lateinit var cpCafe: Chip
    private lateinit var cbCondiciones : CheckBox

    private var cpAsientoCheckedOnce: Boolean = false
    private var cpComidaCheckedOnce: Boolean = false
    private var cpPiscinaCheckedOnce: Boolean = false
    private var cpTaquillaCheckedOnce: Boolean = false
    private var cpCafeCheckedOnce: Boolean = false


    private var termsAndConditions: Boolean = false



    private lateinit var primeraPartePedido : PrimerPartePedido

    private var precioTotal = 0.00


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servicios_premium)
        initButtons()
        initFunctions()
        initVariables()
    }

    private fun initButtons(){
        butIbBack = findViewById<ImageButton>(R.id.butIbBack)

        butContinuar = findViewById<AppCompatButton>(R.id.butContinuar)

        cgServicios = findViewById<ChipGroup>(R.id.cgServicios)
        cpAsiento = findViewById<Chip>(R.id.cpAsiento)
        cpComida = findViewById<Chip>(R.id.cpComida)
        cpPiscina = findViewById<Chip>(R.id.cpPiscina)
        cpTaquilla = findViewById<Chip>(R.id.cpTaquilla)
        cpCafe = findViewById<Chip>(R.id.cpCafe)

        cbCondiciones = findViewById<CheckBox>(R.id.cbCondiciones)

    }


    private fun initFunctions(){
        butIbBack.setOnClickListener {
            finish()
        }
        cpAsiento.setOnCheckedChangeListener { chip, isChecked ->
            if (isChecked) {
                precioTotal += Constantes.PRECIO_ASIENTO
                cpAsientoCheckedOnce = true
            } else if (!isChecked && cpAsientoCheckedOnce) {
                // Si el chip no está seleccionado y ha sido seleccionado al menos una vez antes, resta el suplemento del precio total
                precioTotal -= Constantes.PRECIO_ASIENTO
            }
        }
        cpComida.setOnCheckedChangeListener { chip, isChecked ->
            if (isChecked) {
                precioTotal += Constantes.PRECIO_COMIDA
                cpComidaCheckedOnce = true
            } else if (!isChecked && cpComidaCheckedOnce) {
                // Si el chip no está seleccionado y ha sido seleccionado al menos una vez antes, resta el suplemento del precio total
                precioTotal -= Constantes.PRECIO_COMIDA
            }
        }
        cpPiscina.setOnCheckedChangeListener { chip, isChecked ->
            if (isChecked) {
                precioTotal += Constantes.PRECIO_PISCINA
                cpPiscinaCheckedOnce = true
            } else if (!isChecked && cpPiscinaCheckedOnce) {
                // Si el chip no está seleccionado y ha sido seleccionado al menos una vez antes, resta el suplemento del precio total
                precioTotal -= Constantes.PRECIO_PISCINA
            }
        }
        cpTaquilla.setOnCheckedChangeListener { chip, isChecked ->
            if (isChecked) {
                precioTotal += Constantes.PRECIO_TAQUILLA
                cpTaquillaCheckedOnce = true
            } else if (!isChecked && cpTaquillaCheckedOnce) {
                // Si el chip no está seleccionado y ha sido seleccionado al menos una vez antes, resta el suplemento del precio total
                precioTotal -= Constantes.PRECIO_TAQUILLA
            }
        }
        cpCafe.setOnCheckedChangeListener { chip, isChecked ->
            if (isChecked) {
                precioTotal += Constantes.PRECIO_CAFE
                cpCafeCheckedOnce = true
            } else if (!isChecked && cpCafeCheckedOnce) {
                // Si el chip no está seleccionado y ha sido seleccionado al menos una vez antes, resta el suplemento del precio total
                precioTotal -= Constantes.PRECIO_CAFE
            }
        }
    }

    private fun initVariables() {
        primeraPartePedido = intent.getSerializableExtra("PRIMERA_PARTE_PEDIDO") as PrimerPartePedido
        precioTotal = Constantes.PRECIO_POR_PERSONA * primeraPartePedido.getNumPersonas()

        if (primeraPartePedido.getLlevaNenes()){
            precioTotal += Constantes.SUPLEMENTO_NENES
        }
        if (primeraPartePedido.getLlevaAnimales()){
            precioTotal += Constantes.SUPLEMENTO_ANIMALES
        }

        if (primeraPartePedido.getLlevaCoche()){
            precioTotal += Constantes.SUPLEMENTO_COCHES
        }
    }
}
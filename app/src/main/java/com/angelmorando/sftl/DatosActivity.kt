package com.angelmorando.sftl

import android.content.Intent
import android.os.Bundle
import android.widget.CalendarView
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.appcompat.widget.SwitchCompat
import java.time.LocalDate

class DatosActivity : AppCompatActivity() {
    private lateinit var butSeguirCompra:AppCompatButton

    private lateinit var butIbBack:ImageButton
    private lateinit var ibutMenos:ImageButton
    private lateinit var ibutPlus:ImageButton

    private lateinit var tvNumPersonas: TextView

    private lateinit var calendarView:CalendarView

    private lateinit var swCoche: SwitchCompat

    private lateinit var rgAcompanantes: RadioGroup
    private lateinit var rbNenes : AppCompatRadioButton
    private lateinit var rbAnimales : AppCompatRadioButton


    private var botonDisponible : Boolean = false
    private var llevaCoche : Boolean = false
    private var llevaNenes : Boolean = false
    private var llevaAnimales : Boolean = false

    private var numPersonas = Constantes.MINIMO_PERSONAS

    private lateinit var fechaSeleccionada: LocalDate

    private lateinit var origenEnum : Ciudad;
    private lateinit var destinoEnum : Ciudad;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos)
        initButtons()
        initFunctions()
        initVariables()

    }

    private fun initButtons(){
        butSeguirCompra = findViewById<AppCompatButton>(R.id.butSeguirCompra)

        butIbBack = findViewById<ImageButton>(R.id.butIbBack)
        ibutMenos = findViewById<ImageButton>(R.id.ibutMenos)
        ibutPlus = findViewById<ImageButton>(R.id.ibutPlus)

        tvNumPersonas = findViewById<TextView>(R.id.tvNumPersonas)

        calendarView = findViewById<CalendarView>(R.id.calendarView)

        swCoche = findViewById<SwitchCompat>(R.id.swCoche)

        rgAcompanantes = findViewById<RadioGroup>(R.id.rgAcompanantes)
        rbNenes = findViewById<AppCompatRadioButton>(R.id.rbNenes)
        rbAnimales = findViewById<AppCompatRadioButton>(R.id.rbAnimales)
    }

    private fun initVariables(){
        fechaSeleccionada = LocalDate.now();
        tvNumPersonas.text = numPersonas.toString()

        origenEnum = intent.getSerializableExtra("ORIGEN") as Ciudad
        destinoEnum = intent.getSerializableExtra("DESTINO") as Ciudad


    }

    private fun initFunctions(){
        ibutMenos.setOnClickListener {
            if (numPersonas > Constantes.MINIMO_PERSONAS) {
                --numPersonas
                tvNumPersonas.text = (numPersonas.toString())
            }
        }

        ibutPlus.setOnClickListener {
            if (numPersonas < Constantes.MAXIMO_PERSONAS) {
                ++numPersonas
                tvNumPersonas.text = (numPersonas.toString())
            }
        }

        butIbBack.setOnClickListener {
            finish()
        }

        swCoche.setOnCheckedChangeListener { _, isChecked ->
            llevaCoche = isChecked
        }

        controladorRadioGroup()
        controladorCalendar()

        butSeguirCompra.setOnClickListener {
            if (botonDisponible){
                enviarInformacion()
            } else {
                mostrarError(Constantes.TITULO_ERROR, Constantes.MENSAJE_ERROR_FECHA, Constantes.ACEPTAR_ERROR)
            }
        }
    }

    private fun enviarInformacion() {
        var primeraPartePedido = PrimerPartePedido(origenEnum, destinoEnum, numPersonas, llevaCoche, llevaNenes, llevaAnimales, fechaSeleccionada)
        val intent = Intent(this, DatosActivity::class.java)
        intent.putExtra("PRIMERA_PARTE_PEDIDO",primeraPartePedido)
        startActivity(intent)
    }

    private fun controladorCalendar() {

        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            // Los meses en CalendarView comienzan desde 0, hay que sumarle 1.
            val fechaPropuesta = LocalDate.of(year, month + 1, dayOfMonth)

            if (fechaPropuesta.isBefore(LocalDate.now())){
                mostrarError(Constantes.TITULO_ERROR, Constantes.MENSAJE_ERROR_FECHA, Constantes.ACEPTAR_ERROR)
                butSeguirCompra.setBackgroundColor(getColor(R.color.Black))
                botonDisponible = false
            } else {
                fechaSeleccionada = fechaPropuesta
                butSeguirCompra.setBackgroundColor(getColor(R.color.Orange))
                botonDisponible = true

            }
        }
    }


    private fun mostrarError(titulo:String, mensaje:String, positiveButton:String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle(titulo)
        builder.setMessage(mensaje)
        builder.setPositiveButton(positiveButton){ dialog, id ->
        }
        val dialog = builder.create()
        dialog.show()
    }

    private fun controladorRadioGroup() {
        rgAcompanantes.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId) {
                R.id.rbNenes -> {
                    llevaNenes = true
                }
                R.id.rbAnimales -> {
                    llevaAnimales = true
                }
                }
            }
        }



}
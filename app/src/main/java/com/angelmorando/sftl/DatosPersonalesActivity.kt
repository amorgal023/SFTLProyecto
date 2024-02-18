package com.angelmorando.sftl

import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DatosPersonalesActivity : AppCompatActivity() {
    private lateinit var butIbBack: ImageButton

    private lateinit var primerPartePedido: PrimerPartePedido
    private lateinit var listaPersona : MutableList<Persona>


    private var precioTotal : Double = 0.0
    private var numPersonas = 0
    private var contadorPersonas = 1

    private lateinit var etNombre : EditText
    private lateinit var etDNI : EditText
    private lateinit var etCorreo : EditText
    private lateinit var fabAgregar : FloatingActionButton
    private lateinit var tvPersona : TextView
    private lateinit var butFinalizar : AppCompatButton

    private var finalizar = false;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_personales)
        initButtons()
        initVariables()
        initFunctions()
    }

    private fun initButtons(){
        etNombre = findViewById<EditText>(R.id.etNombre)
        etDNI = findViewById<EditText>(R.id.etDNI)
        etCorreo = findViewById<EditText>(R.id.etCorreo)
        butIbBack = findViewById<ImageButton>(R.id.butIbBack)
        tvPersona = findViewById<TextView>(R.id.tvPersona)
        fabAgregar = findViewById<FloatingActionButton>(R.id.fabAgregar)
        butFinalizar = findViewById<AppCompatButton>(R.id.butFinalizar)
    }

    private fun initFunctions(){
        butIbBack.setOnClickListener {
            finish()
        }

        butFinalizar.setOnClickListener {
            if (finalizar){
                enviarInformacion()
            } else {
                mostrarError(Constantes.TITULO_ERROR, Constantes.MENSAJE_ERROR_TERMINAR, Constantes.ACEPTAR_ERROR)
            }
        }

        fabAgregar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val dni = etDNI.text.toString()
            val correo = etCorreo.text.toString()

            if (nombre.isNotEmpty() && dni.isNotEmpty() && correo.isNotEmpty()){
                if (contadorPersonas <= numPersonas){
                    listaPersona.add(Persona(nombre, dni, correo))
                    ++contadorPersonas

                    if (contadorPersonas > numPersonas){

                        finalizar = true
                        fabAgregar.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.Black)));
                        butFinalizar.setBackgroundColor(getColor(R.color.Orange))
                    } else {
                        etNombre.text.clear()
                        etDNI.text.clear()
                        etCorreo.text.clear()
                        tvPersona.text = getString(R.string.str_persona)+" "+contadorPersonas+" de "+numPersonas+"."
                    }

                } else {
                    mostrarError(Constantes.TITULO_ERROR, Constantes.MENSAJE_ERROR_NUMPERSONAS, Constantes.ACEPTAR_ERROR)
                }
            } else {
                mostrarError(Constantes.TITULO_ERROR, Constantes.MENSAJE_ERROR_CAMPOS, Constantes.ACEPTAR_ERROR)
            }
        }
    }

    private fun enviarInformacion() {
        val intent = Intent(this, ResumenActivity::class.java)
        val pedidoFinal = PedidoFinal(primerPartePedido, precioTotal, listaPersona)
        intent.putExtra("PEDIDO_FINAL",pedidoFinal)
        startActivity(intent)
    }

    private fun initVariables(){
        primerPartePedido = intent.getSerializableExtra("PRIMERA_PARTE_PEDIDO") as PrimerPartePedido
        precioTotal = intent.getStringExtra("PRECIO_TOTAL")?.toDouble() ?: 0.00
        numPersonas = primerPartePedido.getNumPersonas()
        listaPersona = mutableListOf()
        tvPersona.text = getString(R.string.str_persona)+" "+contadorPersonas+" de "+numPersonas+"."
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
}
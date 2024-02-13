package com.angelmorando.sftl

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class DatosActivity : AppCompatActivity() {
    private lateinit var butSeguirCompra:AppCompatButton
    private lateinit var butIbBack:ImageButton


    private var botonDisponible : Boolean = false

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
    }

    private fun initVariables(){

    }

    private fun initFunctions(){
        butSeguirCompra.setOnClickListener {
            if (botonDisponible){

            } else {
                mostrarError()
            }
        }

        butIbBack.setOnClickListener {
            finish()
        }
    }

    private fun mostrarError(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Faltan datos. Compruebe y pruebe de nuevo.")
        builder.setPositiveButton("Aceptar"){ dialog, id ->
        }
        val dialog = builder.create()
        dialog.show()
    }



}
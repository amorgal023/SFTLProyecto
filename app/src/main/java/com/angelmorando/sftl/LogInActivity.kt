package com.angelmorando.sftl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.core.widget.addTextChangedListener

class LogInActivity : AppCompatActivity() {

    private lateinit var butIbBack:ImageButton
    private lateinit var etCorreo:EditText
    private lateinit var etPassword:EditText
    private lateinit var butIniciarSesion:AppCompatButton

    private var iniciarSesion = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        initButtons()
        initFunctions()
    }

    private fun initButtons(){
        butIbBack = findViewById<ImageButton>(R.id.butIbBack)
        etCorreo = findViewById<EditText>(R.id.etCorreo)
        etPassword = findViewById<EditText>(R.id.etPassword)
        butIniciarSesion = findViewById(R.id.butIniciarSesion)
    }

    private fun initFunctions(){

        butIbBack.setOnClickListener {
            finish()
        }

        butIniciarSesion.setOnClickListener {
            if (iniciarSesion){
                startActivity(Intent(this, LoadingLoginActivity::class.java))
            } else {
                if (etCorreo.text.toString().isBlank() && etPassword.text.toString().isBlank()) {
                    mostrarError(Constantes.TITULO_ERROR, Constantes.MENSAJE_ERROR_AMBOS, Constantes.ACEPTAR_ERROR)
                } else {
                    if (etPassword.text.toString().isBlank()){
                        mostrarError(Constantes.TITULO_ERROR, Constantes.MENSAJE_ERROR_PASSWORD, Constantes.ACEPTAR_ERROR)}
                    else {
                        mostrarError(Constantes.TITULO_ERROR, Constantes.MENSAJE_ERROR_CORREO, Constantes.ACEPTAR_ERROR) }
                }
            }
        }

        etCorreo.addTextChangedListener {
            if (etCorreo.text.toString().isEmpty() || etPassword.text.toString().isEmpty()){
                butIniciarSesion.setBackgroundColor(getColor(R.color.Black))
                iniciarSesion = false
            } else {
                butIniciarSesion.setBackgroundColor(getColor(R.color.Orange))
                iniciarSesion = true
            }
        }
        etPassword.addTextChangedListener {
            if (etCorreo.text.toString().isEmpty() || etPassword.text.toString().isEmpty()){
                butIniciarSesion.setBackgroundColor(getColor(R.color.Black))
                iniciarSesion = false
            } else {
                butIniciarSesion.setBackgroundColor(getColor(R.color.Orange))
                iniciarSesion = true
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
}
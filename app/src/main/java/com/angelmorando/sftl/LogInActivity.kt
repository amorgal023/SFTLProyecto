package com.angelmorando.sftl

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AccelerateInterpolator
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener

class LogInActivity : AppCompatActivity() {

    private lateinit var butIbBack:ImageButton
    private lateinit var etCorreo:EditText
    private lateinit var etPassword:EditText
    private lateinit var butIniciarSesion:AppCompatButton
    private lateinit var actvBaseDeDatos:AutoCompleteTextView

    private lateinit var animator: ObjectAnimator


    private var iniciarSesion = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        initButtons()
        initVariables()
        initFunctions()
    }

    private fun initVariables() {
        animarBoton()
    }

    private fun initButtons(){
        butIbBack = findViewById<ImageButton>(R.id.butIbBack)
        etCorreo = findViewById<EditText>(R.id.etCorreo)
        etPassword = findViewById<EditText>(R.id.etPassword)
        butIniciarSesion = findViewById<AppCompatButton>(R.id.butIniciarSesion)
        actvBaseDeDatos= findViewById<AutoCompleteTextView>(R.id.actvBaseDeDatos)
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
            if (etCorreo.text.toString().isEmpty() || etPassword.text.toString().isEmpty() ){
                butIniciarSesion.setBackgroundColor(getColor(R.color.Black))
                iniciarSesion = false
            } else {
                iniciarSesion = true
            }
            controlarAnimacion()
        }
        etPassword.addTextChangedListener {
            if (etCorreo.text.toString().isEmpty() || etPassword.text.toString().isEmpty()){
                butIniciarSesion.setBackgroundColor(getColor(R.color.Black))
                iniciarSesion = false
            } else {
                iniciarSesion = true
            }
            controlarAnimacion()
        }
    }
    private fun controlarAnimacion(){
        if (iniciarSesion){
            animator.start() // Iniciar la animación
        } else {
            if (animator.isRunning){
                animator.cancel()
            }
        }
    }

    private fun animarBoton(){
        animator = ObjectAnimator.ofArgb(
            butIniciarSesion,
            "backgroundColor",
            ContextCompat.getColor(this, R.color.Orange),
            ContextCompat.getColor(this, R.color.DarkOrange)
        )

        animator.duration = 1000
        animator.repeatCount = ValueAnimator.INFINITE // Repetir infinitamente las veces del repeatcount
        animator.repeatMode = ValueAnimator.REVERSE // Invierte la animación en cada repetición.

        // Esto mete un efecto como ease in, que empieza mas lento y luego acelera.
        animator.interpolator = AccelerateInterpolator()

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
package com.angelmorando.sftl

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener

class SFTLMainActivity : AppCompatActivity() {
    private lateinit var ciudades_array:Array<String>
    private lateinit var adaptadorPaises:ArrayAdapter<String>

    private lateinit var butContinuar:AppCompatButton

    private lateinit var actvOrigen:AutoCompleteTextView
    private lateinit var actvDestino:AutoCompleteTextView

    private lateinit var llMascotas:LinearLayoutCompat
    private lateinit var llEcosostenible:LinearLayoutCompat
    private lateinit var llBarquito:LinearLayoutCompat

    private lateinit var ibIniciarSesion:ImageButton


    private var botonDisponible : Boolean = false
    private lateinit var origenEnum : Ciudad;
    private lateinit var destinoEnum : Ciudad;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sftlmain)
        initButtons()
        initFunctions()
        initVariables()

    }

    private fun initButtons(){
        butContinuar = findViewById<AppCompatButton>(R.id.butContinuar)
        actvOrigen = findViewById<AutoCompleteTextView>(R.id.actvOrigen)
        actvDestino = findViewById<AutoCompleteTextView>(R.id.actvDestino)
        llMascotas = findViewById<LinearLayoutCompat>(R.id.llMascotas)
        llEcosostenible = findViewById<LinearLayoutCompat>(R.id.llEcosostenible)
        llBarquito = findViewById<LinearLayoutCompat>(R.id.llBarquito)
        ibIniciarSesion = findViewById<ImageButton>(R.id.ibIniciarSesion)

    }

    private fun initVariables(){
        ciudades_array = resources.getStringArray(R.array.valores_zonas)
        adaptadorPaises = ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, ciudades_array)
        actvOrigen.setAdapter(adaptadorPaises)
        actvDestino.setAdapter(adaptadorPaises)
    }

    private fun initFunctions(){
        actvOrigen.addTextChangedListener  {
             comprobarDisponibilidadBoton()
         }
        actvDestino.addTextChangedListener {
            comprobarDisponibilidadBoton()
        }
        butContinuar.setOnClickListener {
            if (botonDisponible){
                val intent = Intent(this, DatosActivity::class.java)
                intent.putExtra("ORIGEN",origenEnum)
                intent.putExtra("DESTINO",destinoEnum)
                startActivity(intent)
            } else {
                mostrarError(Constantes.TITULO_ERROR, Constantes.MENSAJE_ERROR_ORIGENDEST, Constantes.ACEPTAR_ERROR)
            }
        }

        llMascotas.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }

        llEcosostenible.setOnClickListener {
            val intent = Intent(this, VideoWebActivity::class.java)
            startActivity(intent)
        }
        llBarquito.setOnClickListener {
            val intent = Intent(this, ExtrasActivity::class.java)
            startActivity(intent)
        }

        ibIniciarSesion.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }
    }

    private fun animarBoton(){
        var colorOrange = ContextCompat.getColor(this, R.color.Orange)
        var colorDarkOrange = ContextCompat.getColor(this, R.color.DarkOrange)

        var animator = ObjectAnimator.ofArgb(
            butContinuar,
            "backgroundColor",
            colorOrange,
            colorDarkOrange
        )

        animator.duration = 1000
        animator.repeatCount = ValueAnimator.INFINITE // Repetir infinitamente las veces del repeatcount
        animator.repeatMode = ValueAnimator.REVERSE // Invierte la animación en cada repetición.

        // No se que hace pero tiene un nombre gracioso.
        animator.interpolator = AccelerateDecelerateInterpolator()

        animator.start() // Iniciar la animación
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

    private fun comprobarDisponibilidadBoton(){
        botonDisponible = comprobacionOrigenDestino();
        if (botonDisponible){
            animarBoton()
        } else {
            butContinuar.setBackgroundColor(getColor(R.color.Black))
        }
    }

    private fun comprobacionOrigenDestino(): Boolean {
        var textoOrigen = actvOrigen.text.toString()
        var textoDestino = actvDestino.text.toString()
        var origenValido = false;
        var destinoValido = false;

        for (ciudad in Ciudad.values()){
            if (ciudad.nombreCiudad.equals(textoOrigen)) {
                origenValido = true;
                origenEnum = ciudad;
                break
            }
        }

        for (ciudad in Ciudad.values()){
            if (ciudad.nombreCiudad.equals(textoDestino)) {
                destinoValido = true;
                destinoEnum = ciudad;
                break
            }
        }

        return origenValido && destinoValido && (origenEnum.zonaCiudad != destinoEnum.zonaCiudad);

    }

}
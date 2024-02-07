package com.angelmorando.sftl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.widget.addTextChangedListener

class SFTLMainActivity : AppCompatActivity() {
    private lateinit var ciudades_array:Array<String>
    private lateinit var adaptadorPaises:ArrayAdapter<String>
    private lateinit var butContinuar:AppCompatButton
    private lateinit var actvOrigen:AutoCompleteTextView
    private lateinit var actvDestino:AutoCompleteTextView

    private var botonDisponible : Boolean = false

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

            } else {
                
            }
        }
    }

    private fun comprobarDisponibilidadBoton(){
        botonDisponible = comprobacionOrigenDestino();
        if (botonDisponible){
            butContinuar.setBackgroundColor(getColor(R.color.Orange))
        } else {
            butContinuar.setBackgroundColor(getColor(R.color.Black))
        }
    }

    private fun comprobacionOrigenDestino(): Boolean {
        var textoOrigen = actvOrigen.text.toString()
        var textoDestino = actvDestino.text.toString()
        var origenEnum = Ciudad.NO_VALIDO
        var destinoEnum = Ciudad.NO_VALIDO
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
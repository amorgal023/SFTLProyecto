package com.angelmorando.sftl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView

class ExtrasActivity : AppCompatActivity() {

    private lateinit var butIbBack: ImageButton
    private lateinit var skDiscreto: SeekBar
    private lateinit var skNormal: SeekBar

    private lateinit var tvSeekbarDis : TextView
    private lateinit var tvSeekbarNor : TextView

    var valorNormal = 0
    var valorDiscreto = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extras)
        initButtons()
        initVariables()
        initFunctions()
            }

    private fun initButtons() {
        butIbBack = findViewById<ImageButton>(R.id.butIbBack)
        skNormal= findViewById<SeekBar>(R.id.skNormal)
        skDiscreto= findViewById<SeekBar>(R.id.skDiscreto)
        tvSeekbarNor = findViewById<TextView>(R.id.tvSeekbarNor)
        tvSeekbarDis = findViewById<TextView>(R.id.tvSeekbarDis)
    }

    private fun initFunctions() {
        butIbBack.setOnClickListener {
            finish()
        }
        skNormal.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                valorNormal = i
                tvSeekbarNor.text = valorNormal.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })

        skDiscreto.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                valorDiscreto = i
                tvSeekbarDis.text = valorDiscreto.toString()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }

        })

    }

    private fun initVariables() {
        tvSeekbarNor.text = valorNormal.toString()
        tvSeekbarDis.text = valorDiscreto.toString()
    }
}
package com.angelmorando.sftl

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.LinearInterpolator
import android.widget.ImageButton
import android.widget.ProgressBar

class LoadingLoginActivity : AppCompatActivity() {
    private lateinit var butIbBack: ImageButton
    private lateinit var pbBarrita: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading_login)
        initButtons()
        initFunctions()
    }
    private fun initButtons(){
        butIbBack = findViewById<ImageButton>(R.id.butIbBack)
        pbBarrita = findViewById<ProgressBar>(R.id.pbBarrita)

    }
    private fun initFunctions(){
        butIbBack.setOnClickListener {
            finish()
            }

        animacionBarra()

    }

    private fun animacionBarra(){
        // Animación de carga del 0 al 100%
        val progressAnimator = ObjectAnimator.ofInt(pbBarrita, "progress", 0, 100)
        progressAnimator.duration = 1000
        progressAnimator.interpolator = LinearInterpolator() // Interpolador lineal para una transición suave

        // Animación de cambio brusco del 100 al 0%
        val resetAnimator = ObjectAnimator.ofInt(pbBarrita, "progress", 0)
        resetAnimator.duration = 0

        progressAnimator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                resetAnimator.start()
            }
        })

        resetAnimator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                progressAnimator.start()
            }
        })

        progressAnimator.start()
    }



}



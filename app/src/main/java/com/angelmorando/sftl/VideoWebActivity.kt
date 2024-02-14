package com.angelmorando.sftl

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.MediaController
import android.widget.VideoView

class VideoWebActivity : AppCompatActivity() {
    private lateinit var butIbBack: ImageButton
    private lateinit var vwVideo: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videoweb)
        initButtons()
        initFunctions()

    }

    private fun initButtons(){
        butIbBack = findViewById<ImageButton>(R.id.butIbBack)
        vwVideo = findViewById<VideoView>(R.id.vwVideo)
    }

    private fun initFunctions(){

        controladorVideoWeb()

        butIbBack.setOnClickListener {
            finish()
        }
    }

    private fun controladorVideoWeb(){
        // Establece la ruta del video. Puede ser una URL o una ruta local.
        val videoPath = "android.resource://" + packageName + "/" + R.raw.video
        val uri = Uri.parse(videoPath)

        vwVideo.setVideoURI(uri)

        // Configura el MediaController y lo asocia con el VideoView.
        val mediaController = MediaController(this)
        mediaController.setAnchorView(vwVideo)
        vwVideo.setMediaController(mediaController)

        // Inicia el video
        vwVideo.start()
    }


}
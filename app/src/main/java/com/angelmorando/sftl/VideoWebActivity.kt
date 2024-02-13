package com.angelmorando.sftl

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.CookieManager
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageButton

class VideoWebActivity : AppCompatActivity() {
    private lateinit var butIbBack: ImageButton
    private lateinit var wvPagina: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videoweb)
        initButtons()
        initFunctions()

    }

    private fun initButtons(){
        butIbBack = findViewById<ImageButton>(R.id.butIbBack)
        wvPagina = findViewById<WebView>(R.id.wvPagina)
    }

    private fun initFunctions(){

        controladorWebView()

        butIbBack.setOnClickListener {
            finish()
        }
    }

    private fun controladorWebView(){
        //Para que el navegador se abra dentro de la aplicacion
        wvPagina.webViewClient = WebViewClient()
        //Para que funcione de manera correcta https y javascript en el WebView
        wvPagina.settings.javaScriptEnabled = true
        wvPagina.settings.domStorageEnabled = true
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            wvPagina.settings.mediaPlaybackRequiresUserGesture = false
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            wvPagina.settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
            CookieManager.getInstance().setAcceptThirdPartyCookies(wvPagina, true)
        }


        wvPagina.loadUrl("https://www.perreradelosbarrios.com/")
    }


}
package com.example.taller1

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.annotation.RequiresApi

class pais_info : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pais_info)

        val extras = intent.extras
        val capital = extras?.getString("capital")
        val nombre_pais = extras?.getString("nombre_pais")
        val nombre_pais_int = extras?.getString("nombre_pais_int")
        val sigla = extras?.getString("sigla")

        var tcapital = findViewById<TextView>(R.id.capital).apply {
            text = "Capital: " + capital
        }
        var tnombre_pais= findViewById<TextView>(R.id.nombre_pais).apply {
            text = "Nombre del pais: " + nombre_pais
        }
        var tnombre_pais_int= findViewById<TextView>(R.id.nombre_pais_int).apply {
            text = "Nombre internacional del pais: " + nombre_pais_int
        }
        var tsigla= findViewById<TextView>(R.id.sigla).apply {
            text = "Sigla: " + sigla
        }

        val webView = findViewById<WebView>(R.id.webView)


        //crear el url

        val url="https://www.countryflags.com/flag-of-"+nombre_pais_int+"/"
        webView.webViewClient= WebViewClient()
        webView.apply {
            loadUrl(url)

            settings.javaScriptEnabled=true
            settings.safeBrowsingEnabled =true
            settings.textZoom = -200
        }
        webView.scrollTo(0, 400)
        webView.isClickable = false
        webView.isLongClickable = false
        webView.isFocusable = false
        webView.isFocusableInTouchMode = false
        webView.isScrollContainer= false

    }
}
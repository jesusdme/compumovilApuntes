package com.example.taller1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class random_greet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_greet)

        var auxSp =intent.getStringExtra("language")
        var saludos = findViewById<TextView>(R.id.saludo).apply {
            text = auxSp
        }
        if (auxSp=="Español")
        {
            var saludos = findViewById<TextView>(R.id.saludo).apply {
                text = resources.getString(R.string.hola)
            }
        }
        if (auxSp=="English")
        {
            var saludos = findViewById<TextView>(R.id.saludo).apply {
                text =resources.getString(R.string.holaE)
            }
        }
        if (auxSp=="Italiano")
        {
            var saludos = findViewById<TextView>(R.id.saludo).apply {
                text =resources.getString(R.string.holaI)
            }
        }
            if (auxSp=="Français")
        {
            var saludos = findViewById<TextView>(R.id.saludo).apply {
                text =resources.getString(R.string.holaF)
            }
        }

    }




}
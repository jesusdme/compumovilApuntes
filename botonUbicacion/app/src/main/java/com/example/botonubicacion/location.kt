package com.example.botonubicacion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.botonubicacion.databinding.ActivityLocationBinding

class location : AppCompatActivity() {
    private lateinit var binding: ActivityLocationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val extras = intent.extras
        val lon = extras?.getString("longitude")
        val lat = extras?.getString("latitude")
        val alt = extras?.getString("altitude")
        binding = ActivityLocationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.latitude.text = lat
        binding.elevation.text = alt
        binding.longitude.text = lon
    }
}
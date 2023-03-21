package com.example.ejercicoclase3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextDirectionHeuristic
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity3 : AppCompatActivity() {
    var jugadas=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val num =intent.getStringExtra("act3")
        var cota = num.toString().toInt()
        val randomNumber= Random.nextInt(0,cota)

        val boton = findViewById<Button>(R.id.play)
        boton.setOnClickListener(){
            jugadas++
            val editTextCota=findViewById<EditText>(R.id.cota)

        

            if (cota > 0 && cota <= 100) {
                val textViewCota = findViewById<TextView>(R.id.textViewJuego)
                textViewCota.setText("Numero entre 0 y " + cota)

                val editTextNumero = findViewById<EditText>(R.id.numeroJugar)
                val numero = editTextNumero.text.toString().toInt()

                if (numero == randomNumber) {
                    Toast.makeText(
                        applicationContext,
                        "Felicidades el numero ganador era " + randomNumber,
                        Toast.LENGTH_LONG
                    ).show()
                    val intent = Intent(this, MainActivity::class.java)
                    Thread.sleep(1_000)
                    startActivity(intent)
                } else if (numero >= 0 && numero < randomNumber) {
                    Toast.makeText(applicationContext, "El numero es mayor", Toast.LENGTH_LONG)
                        .show()
                } else if (numero >= 0 && numero > randomNumber) {
                    Toast.makeText(applicationContext, "El numero es menor", Toast.LENGTH_LONG)
                        .show()
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Elija un número entre 0 y " + cota,
                        Toast.LENGTH_LONG
                    ).show()
                    jugadas--
                }
            } else {
                Toast.makeText(
                    applicationContext,
                    "Elija un número entre 0 y " + cota,
                    Toast.LENGTH_LONG
                ).show()
                jugadas--
            }

            val textViewJugadas = findViewById<TextView>(R.id.jugadas)
            textViewJugadas.setText("Cantidad de jugadas: " + jugadas)
        }
    }



/*
    fun play (view: View){
        jugadas++
        val editTextCota=findViewById<EditText>(R.id.cota)
        val cota = editTextCota.text.toString().toInt()
        //numero aleatorio
        val randomNumber= Random.nextInt(0,cota)

            if (cota > 0 && cota <= 100) {
                val textViewCota = findViewById<TextView>(R.id.textViewJuego)
                textViewCota.setText("Numero entre 0 y " + cota)

                val editTextNumero = findViewById<EditText>(R.id.numeroJugar)
                val numero = editTextNumero.text.toString().toInt()

                if (numero == randomNumber) {
                    Toast.makeText(
                        applicationContext,
                        "Felicidades el numero ganador era " + randomNumber,
                        Toast.LENGTH_LONG
                    ).show()
                    val intent = Intent(this, MainActivity::class.java)
                    Thread.sleep(1_000)
                    startActivity(intent)
                } else if (numero >= 0 && numero < randomNumber) {
                    Toast.makeText(applicationContext, "El numero es mayor", Toast.LENGTH_LONG)
                        .show()
                } else if (numero >= 0 && numero > randomNumber) {
                    Toast.makeText(applicationContext, "El numero es menor", Toast.LENGTH_LONG)
                        .show()
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Elija un número entre 0 y " + cota,
                        Toast.LENGTH_LONG
                    ).show()
                    jugadas--
                }
            } else {
                Toast.makeText(
                    applicationContext,
                    "Elija un número entre 0 y " + cota,
                    Toast.LENGTH_LONG
                ).show()
                jugadas--
            }

            val textViewJugadas = findViewById<TextView>(R.id.jugadas)
            textViewJugadas.setText("Cantidad de jugadas: " + jugadas)

    }*/
}
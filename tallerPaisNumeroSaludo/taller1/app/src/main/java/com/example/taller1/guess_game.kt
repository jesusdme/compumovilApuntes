package com.example.taller1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class guess_game : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess_game)



        val pNum =intent.getStringExtra("numero")

        val Rango = findViewById<TextView>(R.id.rango).apply {
            text ="Guess a number between 0 and "+pNum
        }


        val max= pNum.toString().toInt()//num

        val numAl = (0..max).random()
        var contador =0
        val adivinar = findViewById<Button>(R.id.jugar)
        adivinar.setOnClickListener {
            verNum(max,numAl)
            contador++
            var textoCounter
                    = findViewById<TextView>(R.id.textoCounter).apply {
                text ="counter: "+contador.toString()
                }
            }

    }

    private fun verNum(max: Int,numAl: Int) {
        val num =findViewById<EditText>(R.id.numAd)
        val aux = num.text.toString()

        if ((aux.toIntOrNull() != null) && (aux.toIntOrNull()!! >= 0) && (aux.toIntOrNull()!! <= max))//numero entre 0 y el numero escogido
        {

            if (aux.toInt()>numAl)
            {
                var message
                        = findViewById<TextView>(R.id.message).apply {
                    text ="message: "+aux+" is bigger"
                }
            }
            if (aux.toInt()<numAl)
            {
                var message
                        = findViewById<TextView>(R.id.message).apply {
                    text ="message: "+aux+" is smaller"
                }

            }
            if (aux.toInt()==numAl)
            {
                var message
                        = findViewById<TextView>(R.id.message).apply {
                    text ="message: "+aux+" is the number"
                }
                Toast.makeText(this@guess_game,"ha ganado, saliendo...",Toast.LENGTH_LONG)

                val Intent = Intent(this,MainActivity::class.java)
                Thread.sleep(1_000)
                startActivity(Intent)

            }


        }
        else {
            var aviso2 = findViewById<TextView>(R.id.aviso2).apply {
                text = "ingrese un numero entre 0 y "+max.toString()
            }
        }
    }
}
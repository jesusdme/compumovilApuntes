package com.example.taller1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    var auxSp=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val ggame = findViewById<Button>(R.id.gg)
        ggame.setOnClickListener {
            jugar()
        }

        val rGreet = findViewById<Button>(R.id.rg)

        val mySpinner = findViewById<Spinner>(R.id.spinner)
        mySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val auxSp = parent.getItemAtPosition(position).toString()
                rGreet.setOnClickListener {
                    greet(auxSp)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }


        val pais= findViewById<Button>(R.id.coun)
        pais.setOnClickListener {
            paises()
        }

    }

    private fun paises() {

        val Intent = Intent(this, lista_paises::class.java)
        startActivity(Intent)
    }

    private fun jugar() {

        val num = findViewById<EditText>(R.id.editTextNumber)
        val pNum = num.text.toString()

        if (pNum.toIntOrNull() != null && pNum.toIntOrNull()!! > 0 && pNum.toIntOrNull()!! <= 1000) //numero entre 0 y 1000
        {

            val Intent = Intent(this, guess_game::class.java).also {
                it.putExtra("numero", pNum)
                startActivity(it)
            }
        } else {
            val aviso = findViewById<TextView>(R.id.aviso).apply {
                text = "ingrese un numero entre 0 y 1000"
            }
        }


    }

    private fun greet(auxSp: String) {
        val intent = Intent(this, random_greet::class.java)
        intent.putExtra("language", auxSp)
        startActivity(intent)

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }


}
package com.example.ejercicoclase3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //Se obtienen las referencias del textview
        val porcentaje2 = findViewById<TextView>(R.id.porcentajeAct2)
        val numero2 = findViewById<TextView>(R.id.numeroAct2)

        //Se obtienen los datos del bundle provenientes de la actividad 1
        val bundle=intent.extras
        if(bundle!=null){
            val porcentaje1= bundle.getString("porcentaje")
            porcentaje2.setText(porcentaje1)
            val numero1 = bundle.getString("numero")
            numero2.setText(numero1)
        }


    }
}


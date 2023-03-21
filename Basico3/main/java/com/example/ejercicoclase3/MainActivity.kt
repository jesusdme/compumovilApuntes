package com.example.ejercicoclase3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("activity_main","Se inicio correctamente")
        //Toast.makeText(applicationContext,"Hola (in)mundo",Toast.LENGTH_LONG).show()
       /*
       opcion 2 para programar un boton

        val boton = findViewById<Button>(R.id.showToast3)
        boton.setOnClickListener(){
            Toast.makeText(applicationContext,"Mostrando toast2",Toast.LENGTH_LONG).show()
        }*/
    }

    fun toastNombre(view: View){
        val nombre = findViewById<EditText>(R.id.nombre)
        val texto = nombre.text.toString()
        Toast.makeText(applicationContext,"Bienvenido "+texto,Toast.LENGTH_LONG).show()
    }

    fun toastPorcentaje(view: View){
        //leer cada editText
        val editTextPorcentaje = findViewById<EditText>(R.id.porcentaje)
        var texto = editTextPorcentaje.text.toString()
        texto=texto.replace("%"," ") //quitar el simbolo del porcentaje
        val porcentaje = texto.toDouble()
        val editTextNumero = findViewById<EditText>(R.id.numero)
        val numero = editTextNumero.text.toString().toDouble()
        val resultado = (porcentaje/100)*numero


        Toast.makeText(applicationContext,resultado.toString(),Toast.LENGTH_LONG).show()
    }
    var clickCount=0
    fun cantidadClicks(view: View){
        clickCount++
        Log.i("MainActivity","Se ha hecho $clickCount clicks")
        Toast.makeText(applicationContext,"Ha dado $clickCount clicks".toString(),Toast.LENGTH_LONG).show()
    }

    fun actividad2(view: View){
        val intent = Intent(this,MainActivity2::class.java)
        val editTextPorcentaje = findViewById<EditText>(R.id.porcentaje)
        val editTextNumero = findViewById<EditText>(R.id.numero)
        //Objeto que permite almacenar valores y envairlos a fragmetos/actividades
        val bundle = Bundle()
        bundle.putString("porcentaje",editTextPorcentaje.text.toString())
        bundle.putString("numero",editTextNumero.text.toString())
        intent.putExtras(bundle)
        startActivity(intent)
    }

    fun actividad3(view: View){
        val intent = Intent(this,MainActivity3::class.java)
        val editTextPorcentaje = findViewById<EditText>(R.id.porcentaje)
       val num=editTextPorcentaje.text.toString()
       intent.putExtra("act3",num)
        startActivity(intent)
    }
    /*
    Opcion 1 para programar un boton
    fun showToast2(view: View){
        Toast.makeText(applicationContext,"Mostrando toast3",Toast.LENGTH_LONG).show()
    }*/


}
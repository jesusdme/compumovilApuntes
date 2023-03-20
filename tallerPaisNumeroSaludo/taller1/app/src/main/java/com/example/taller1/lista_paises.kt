package com.example.taller1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.text.FieldPosition

class lista_paises : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_paises)
        var languages = resources.getStringArray(R.array.Languages)
        var arrAux=""
        val json=JSONObject(LoadJSONFromAsset())
        val paisesJSONArray=json.getJSONArray("paises")
        for (i in 0 until paisesJSONArray.length())
        {

            val jsonObject =paisesJSONArray.getJSONObject(i)
            val capital =jsonObject.getString("capital")
            val nombre_pais =jsonObject.getString("nombre_pais")
            val nombre_pais_int =jsonObject.getString("nombre_pais_int")
            val sigla =jsonObject.getString("sigla")

            var pais = Pais(capital,nombre_pais,nombre_pais_int,sigla)
            arrAux=arrAux+nombre_pais
            arrAux = arrAux + "," //separador

            paisesJSONArray.put(pais)
        }
        val arrAux2 = arrAux.substring(0, arrAux.length - 1)//quitar ultimo caracter
        val nombresPaises = arrAux2.split(",") //usar separador

        println(arrAux2)


        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1, nombresPaises)
        val ListView: ListView = findViewById(R.id.listView)
        ListView.adapter =adapter


        ListView.setOnItemClickListener { parent, view, position, id ->
            val paisEsc = paisesJSONArray.getJSONObject(position)   //buscar objeto con la posicion del nombre

            inforPais(paisEsc)
        }


    }

    private fun inforPais(paisEsc: JSONObject) {
        val intent = Intent(this, pais_info::class.java)

        // Add the strings to the intent's extras
        intent.putExtra("capital",paisEsc.get("capital").toString() )
        intent.putExtra("nombre_pais", paisEsc.get("nombre_pais").toString())
        intent.putExtra("nombre_pais_int", paisEsc.get("nombre_pais_int").toString())
        intent.putExtra("sigla", paisEsc.get("sigla").toString())

        // Start the new activity
        startActivity(intent)
    }

    fun LoadJSONFromAsset(): String? {
        var json: String? = null
        try {
            val istream: InputStream = assets.open("paises.json")
            val size: Int = istream.available()
            val buffer = ByteArray(size)
            istream.read(buffer)
            istream.close()
            json = String(buffer, Charsets.UTF_8)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }

        return json
    }
}
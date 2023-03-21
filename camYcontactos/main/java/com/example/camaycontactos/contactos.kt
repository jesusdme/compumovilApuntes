package com.example.camaycontactos

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat
import android.Manifest
import android.content.Intent
import android.widget.Toast

class contactos : AppCompatActivity() {
    private val PERMISSIONS_REQUEST_READ_CONTACTS = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactos)
        val contac=findViewById<Button>(R.id.contact)

        contac.setOnClickListener{
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
                // aun no hay permiso preguntar
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_CONTACTS),
                    PERMISSIONS_REQUEST_READ_CONTACTS
                )
            }
            else
            {
                val Intent = Intent(this, listaContactos::class.java)
                startActivity(Intent)

            }
        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSIONS_REQUEST_READ_CONTACTS -> {
                // If the request is cancelled, the grantResults array will be empty.
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(this, "Permiso concedido", Toast.LENGTH_SHORT).show()

                } else {
                    // Permission denied. Handle the denied state.
                    Toast.makeText(this, "Permiso denegado. La aplicación no puede acceder a los contactos sin el permiso correspondiente.", Toast.LENGTH_LONG).show()

                }
                return
            }
        }
    }
}
package com.example.camaycontactos

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream

/*--------------------------------------------------------------------------
------- MIRAR ABAJO PARA EL MANIFEST Y LA CREACION DEL file_paths.xml ------
----------------------------------------------------------------------------
*/
class MainActivity : AppCompatActivity() {

    private val PERMISSION_REQUEST_CAMERA = 1 // Identificador para la solicitud de permiso de la cámara
    private val REQUEST_IMAGE_CAPTURE = 2 // Identificador para la solicitud de captura de imagen
    private val REQUEST_WRITE_EXTERNAL_STORAGE =3 // Identificador para guardar la imagen
    private lateinit var photoImageView: ImageView // Referencia al ImageView donde se mostrará la foto capturada

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtener una referencia al ImageView para mostrar la foto capturada
        photoImageView = findViewById(R.id.imageView)

        // Obtener una referencia al botón para tomar una foto
        val foto = findViewById<Button>(R.id.foto)
        val sig = findViewById<Button>(R.id.sig)

        sig.setOnClickListener {
            val Intent = Intent(this, contactos::class.java)
            startActivity(Intent)
        }

        // Configurar el botón para tomar una foto
        foto.setOnClickListener {
            // Solicitar permiso para usar la cámara si aún no se ha concedido
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.CAMERA), PERMISSION_REQUEST_CAMERA)
            } else {
                // El permiso ya ha sido concedido, así que se puede iniciar la captura de imagen
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this,
                        arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                        REQUEST_WRITE_EXTERNAL_STORAGE)
                } else {
                    // El permiso ya ha sido concedido, así que se puede escribir en el almacenamiento externo
                    // ...
                    dispatchTakePictureIntent()

                }
            }
        }

    }

    // Método que se llama cuando se solicita un permiso
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        // Verifica si el permiso se ha concedido y muestra un mensaje de tostada correspondiente
        if (requestCode == REQUEST_WRITE_EXTERNAL_STORAGE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permiso concedido", Toast.LENGTH_SHORT).show()
                // El permiso ha sido concedido, así que se puede escribir en el almacenamiento externo
                // ...
            } else {
                Toast.makeText(this, "Permiso denegado", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Método que inicia la actividad de la cámara para capturar una imagen
    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            // Asegurarse de que hay una cámara disponible
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            // Verificar que la imagen capturada no sea nula
            val imageBitmap = data?.extras?.get("data") as? Bitmap
            if (imageBitmap != null) {
                // Guardar la imagen en el almacenamiento externo
                val filename = "photo_${System.currentTimeMillis()}.PNG"
                val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
                val imageFile = File(storageDir, filename)
                val outputStream = FileOutputStream(imageFile)
                imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
                outputStream.flush()
                outputStream.close()

                // Cargar la imagen en el ImageView
                val imageView = findViewById<ImageView>(R.id.imageView)
                val imageUri = FileProvider.getUriForFile(this, "com.example.camaycontactos.fileprovider", imageFile)
                imageView.setImageURI(imageUri)
            }
        }
    }



}
/*file_paths
Haz clic derecho en la carpeta res, selecciona "New" y luego "Android Resource File".
En el diálogo que aparece, selecciona "XML" como tipo de recurso y asigna el nombre "file_paths" como nombre del archivo.
Haz clic en "OK" para crear el archivo.
archivo:
<paths xmlns:android="http://schemas.android.com/apk/res/android">
    <root-path name="external_files" path="/" />
    <files-path name="my_images" path="Pictures/" />
</paths>

 */

/*manifest permisos y provider

    <uses-permission android:name="android.permission.CAMERA"/>
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />



<application>
    ...
    <provider
        android:name="androidx.core.content.FileProvider"
        android:authorities="com.example.camaycontactos.fileprovider"
        android:grantUriPermissions="true"
        android:exported="false">
        <meta-data
            android:name="android.support.FILE_PROVIDER_PATHS"
            android:resource="@xml/file_paths" />
    </provider>
    ...
</application>
 */
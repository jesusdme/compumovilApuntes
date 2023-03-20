package com.example.botonubicacion
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.botonubicacion.databinding.ActivityMainBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices


class MainActivity : AppCompatActivity() {
    private lateinit var mFusedLocationClient: FusedLocationProviderClient
    private lateinit var binding: ActivityMainBinding
    private val PERMISSIONS_REQUEST_ACCESS_LOCATION = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)



        binding.imageButton.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(
                        android.Manifest.permission.ACCESS_FINE_LOCATION,
                        android.Manifest.permission.ACCESS_COARSE_LOCATION
                    ),
                    PERMISSIONS_REQUEST_ACCESS_LOCATION
                )

            } else {

                mFusedLocationClient.lastLocation.addOnSuccessListener(this) { location ->
                    Log.i("LOCATION",
                        "onSuccess location")
                    if (location != null) {

                        val intent = Intent(this, com.example.botonubicacion.location::class.java)
                        intent.putExtra("altitude",location.altitude.toString() )
                        intent.putExtra("latitude",location.latitude.toString() )
                        intent.putExtra("longitude", location.longitude.toString() )
                        startActivity(intent)
                    }
                }


            }

        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            PERMISSIONS_REQUEST_ACCESS_LOCATION -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    binding.imageButton.callOnClick()
                } else {
                    Log.i("PERMISSIONS", "Location permission has been denied")
                }
                return
            }
        }
    }
}

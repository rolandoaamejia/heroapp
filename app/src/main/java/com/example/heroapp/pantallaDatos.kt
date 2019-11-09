package com.example.heroapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pantalla_datos.*

class pantallaDatos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_datos)

       btnRegresar.setOnClickListener()
       {
           val Intent = Intent(this, MainActivity::class.java)
           startActivity(Intent)
       }
    }
}

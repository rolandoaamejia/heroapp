package com.example.heroapp

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_pantalla_datos1.*

class pantallaDatos1 : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_datos1)

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btnRegresar.setOnClickListener(){
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }


        val objetoIntent = intent
        val name = objetoIntent.getStringExtra("name")
        val intelligence = objetoIntent.getStringExtra("intelligence")
        val strenght = objetoIntent.getStringExtra("strenght")
        val speed = objetoIntent.getStringExtra("speed")
        val durability = objetoIntent.getStringExtra("durability")
        val power = objetoIntent.getStringExtra("power")
        val combat = objetoIntent.getStringExtra("combat")
        val urlImage = objetoIntent.getStringExtra("urlImage")

        txtNombre.text="Name: $name"
        txtInteligencia.text="Intelligence: $intelligence"
        txtFuerza.text="Force: $strenght"
        txtVelocidad.text="Speed: $speed"
        txtDurabilidad.text="Durability: $durability"
        txtPoder.text="Power: $power"
        txtCombate.text="Combat: $combat"
        //Toast.makeText(this,"$urlImage", Toast.LENGTH_SHORT).show()
        Picasso.get()
            .load(urlImage)
            .resize(320, 320)
            .centerCrop()
            .into(imageView2)
    }
}


package com.example.heroapp

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.heroapp.Response.ApiResponse
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btnBuscar.setOnClickListener(){
            //val Intent = Intent(this, pantallaDatos1::class.java)
            //startActivity(Intent)
            verifyAndConnect(editText_Buscar.text.toString())
        }

    }


    /***
     * Verifica la conexión del dispositivo a Internet y obtiene
     * la respuesta JSON desde la API.
     */
    private fun verifyAndConnect(hero: String = "") {
        if (Network.verifyConnection(this)) {
            httpVolley(getUrlApi(hero))
        } else {
            Toast.makeText(this,"¡No tienes conexión a Internet!",Toast.LENGTH_SHORT)
        }
    }

    /***
     * https://developer.android.com/training/volley/simple
     * Realiza una petición http implementando Volley
     */
    private fun httpVolley(url: String) {
        // Instanciar la cola de peticiones
        val queue = Volley.newRequestQueue(this)

        // Obtener un string de respuesta desde la URL enviada
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                Log.d("HTTPVolley",  response)
                jsonToObject(response)
            },
            Response.ErrorListener {
                Log.d("HTTPVolley", "Error en la URL $url")
                Toast.makeText(this,"¡No tienes conexión a Internet!",Toast.LENGTH_SHORT)
            })

        // Agregar la peticion a la cola de peticiones
        queue.add(stringRequest)
    }

    private fun getUrlApi(hero: String): String {

        return "https://www.superheroapi.com/api.php/1153860768144457/search/$hero"
    }


    /***
     * Pasa un objeto de tipo JSON a objetos de Kotlin.
     * params: response el objeto de tipo JSON
     */
    private fun jsonToObject(response: String) {
        // Inicializar los valores de tipo Gson
        val gson = Gson()
        val apiResponse = gson.fromJson(response, ApiResponse::class.java)
        //Toast.makeText(this,"OK",Toast.LENGTH_SHORT)
        var selec:Int=0

              Toast.makeText(this,"ok",Toast.LENGTH_SHORT)

              if(apiResponse.results.isNotEmpty())
              {

                  var tamArray:Int=apiResponse.results.size

                  /*
                  var i=0

                  for (num in i..tamArray){

                      if(apiResponse.results.get(i).name==editText_Buscar.text.toString()){
                          selec=i
                          break
                      }
                      i=i+1


                  }


                   */
                  //apiResponse.results.get(i).image

                 /* val intent:Intent = Intent(this,pantallaDatos1::class.java)
                  intent.putExtra("name",apiResponse.results.get(i).name)
                  intent.putExtra("intelligence",apiResponse.results.get(i).powerstats.intelligence)
                  intent.putExtra("strenght",apiResponse.results.get(i).powerstats.strength)
                  intent.putExtra("speed",apiResponse.results.get(i).powerstats.speed)
                  intent.putExtra("durability",apiResponse.results.get(i).powerstats.durability)
                  intent.putExtra("power",apiResponse.results.get(i).powerstats.power)
                  intent.putExtra("combat",apiResponse.results.get(i).powerstats.combat)

                  startActivity(intent)

                  */
              }


    }

}

package com.example.heroapp

/*
    Verifica si existe conectividad de red y acceso a Internet
 */
class Network {
    companion object {
        fun verifyConnection(activity: AppCompatActivity): Boolean {
            val connectivityManager = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo

            return networkInfo != null && networkInfo.isConnected
        }
    }
}
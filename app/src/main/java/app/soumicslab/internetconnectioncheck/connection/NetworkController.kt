package app.soumicslab.internetconnectioncheck.connection

import android.content.Context
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.Network
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat

/**
 * @Brief: Keep it inside your fragment / activity
 * The code runs if you directly write it inside your fragment / activity. but if you use this class,
 * the code doesn't work :/
 *
 * */
class NetworkController(private var context: Context, private val connectivityManager: ConnectivityManager) {
    private val _tag: String = "NetworkUtil"

    private var isInternetAvailableForApiGte21: Boolean = false

    private lateinit var networkCallback: ConnectivityManager.NetworkCallback

    private val permissionsForApiLt21 = arrayOf(
        android.Manifest.permission.ACCESS_NETWORK_STATE
    )

    fun registerOnResume() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            registerNetworkCallBackForApiGte21()
        }
    }

    fun unregisterOnPause() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            unregisterNetworkCallBackForApiGte21()
        }
    }

    // Private methods
    private fun allPermissionsGrantedForApiLt21() = permissionsForApiLt21.all {
        ContextCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun registerNetworkCallBackForApiGte21() {
        if(!this::networkCallback.isInitialized) {
            this.networkCallback = object: ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    super.onAvailable(network)
                    isInternetAvailableForApiGte21 = true
                    Log.e(_tag, "networkCallBack onAvailable")
                }

                override fun onLost(network: Network) {
                    super.onLost(network)
                    isInternetAvailableForApiGte21 = false
                    Log.e(_tag, "networkCallBack onLost")
                }
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val looper: Looper = Looper.getMainLooper()
            val handler = Handler(looper)
            this.connectivityManager.registerDefaultNetworkCallback(this.networkCallback, handler)
        }else{
            this.connectivityManager.registerDefaultNetworkCallback(this.networkCallback)
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun unregisterNetworkCallBackForApiGte21() {
        if(this::networkCallback.isInitialized)
            this.connectivityManager.unregisterNetworkCallback(this.networkCallback) // registerDefaultNetworkCallback(this.networkCallback!!)
    }


    @Suppress("DEPRECATION")
    private fun isInternetAvailableForApiLt21(): Boolean {
        if(allPermissionsGrantedForApiLt21()) {
            val activeNetwork: android.net.NetworkInfo? = this.connectivityManager.activeNetworkInfo
            val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
            Log.e(_tag, "isInternetAvailableForApiLt21() isConnected = $isConnected")
            return isConnected
        }else{
            Log.e(_tag, "isInternetAvailableForApiLt21() isConnected = false")
            return false
        }
    }

    // public method
    fun isInternetAvailable(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Log.e(_tag, "isInternetAvailable() -> $isInternetAvailableForApiGte21")
            isInternetAvailableForApiGte21
        }else{
            val isInternetAvailableForApiLt21 = isInternetAvailableForApiLt21()
            Log.e(_tag, "isInternetAvailable() -> $isInternetAvailableForApiLt21")
            isInternetAvailableForApiLt21
        }
    }
}
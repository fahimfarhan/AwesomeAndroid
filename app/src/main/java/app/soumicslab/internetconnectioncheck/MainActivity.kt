package app.soumicslab.internetconnectioncheck

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import app.soumicslab.internetconnectioncheck.connection.NetworkController
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var networkController: NetworkController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val check: TextView = findViewById(R.id.check)

        check.setOnClickListener {
            val isConnected = networkController.isInternetAvailable()
            Snackbar.make(check, "internet is connected = $isConnected", Snackbar.LENGTH_LONG).show()
        }
    }


    override fun onResume() {
        super.onResume()

        if(!this::networkController.isInitialized) {
            val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            this.networkController = NetworkController(this, connectivityManager)
        }

        this.networkController.registerOnResume()

    }

    override fun onPause() {
        if(this::networkController.isInitialized) {
            this.networkController.unregisterOnPause()
        }
        super.onPause()
    }


}
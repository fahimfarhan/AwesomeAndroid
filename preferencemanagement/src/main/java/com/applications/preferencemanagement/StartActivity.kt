package com.applications.preferencemanagement

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.preference.PreferenceManager

class StartActivity : AppCompatActivity() {
    private var pref: SharedPreferences? = null
    private val TAG = "StartActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val tag = "settings"

        val btn1 = findViewById<TextView>(R.id.button1)
        val btn2 = findViewById<TextView>(R.id.button2)

        btn1.setOnClickListener {
            val val1 = pref?.getBoolean("key1", false)
            val val2 = pref?.getString("key2", "")
            val val3 = pref?.getBoolean("key3", false)
            Log.i(TAG, "$val1, $val2, $val3")
        }

        this.pref = PreferenceManager.getDefaultSharedPreferences(this)
        btn2.setOnClickListener {
            supportFragmentManager.beginTransaction().add(R.id.base, SettingsFragment(), tag)
                .addToBackStack(tag).commit()
        }
    }
}
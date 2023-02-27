package com.ynov.projectfragment.views

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.ynov.projectfragment.R

class SplashActivity : AppCompatActivity() {

    private val splashTimeOut: Long = 3000 // temps d'affichage du splash screen en millisecondes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        supportActionBar?.hide()

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, splashTimeOut)
    }
}

package com.magicapp.examtest5modul.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.magicapp.examtest5modul.R
import com.magicapp.examtest5modul.SharedPref

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler()
        handler.postDelayed({
            if (SharedPref(this).isSaved){
                Intent(this, MainActivity::class.java).also{
                    startActivity(it)
                    finish()
                }
            }else{
                Intent(this,IntroActivty::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        },2000)
    }
}
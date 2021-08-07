package com.istekno.features.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.istekno.features.onboarding.OnboardingActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_SplashScreen)
        super.onCreate(savedInstanceState)

        showSplash()
    }

    private fun showSplash() {
        Handler(mainLooper).postDelayed(
            {
                startActivity(Intent(this, OnboardingActivity::class.java))
                finish()
            }, 1500
        )
    }
}
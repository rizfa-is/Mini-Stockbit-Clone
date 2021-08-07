package com.istekno.mini_stockbit_clone.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.istekno.mini_stockbit_clone.R
import com.istekno.mini_stockbit_clone.base.BaseActivity
import com.istekno.mini_stockbit_clone.databinding.ActivitySplashScreenBinding
import com.istekno.mini_stockbit_clone.ui.onboarding.OnboardingActivity

class SplashScreenActivity : BaseActivity<ActivitySplashScreenBinding>() {

    override val layout: Int
        get() = R.layout.activity_splash_screen

    override fun setupLifeCycleOwner() {
        dataBinding.apply {
            lifecycleOwner = this@SplashScreenActivity
        }
    }

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
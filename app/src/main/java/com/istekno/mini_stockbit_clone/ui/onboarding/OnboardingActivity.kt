package com.istekno.mini_stockbit_clone.ui.onboarding

import android.os.Bundle
import android.widget.Toast
import com.istekno.mini_stockbit_clone.R
import com.istekno.mini_stockbit_clone.base.BaseActivity
import com.istekno.mini_stockbit_clone.databinding.ActivityOnboardingBinding
import com.istekno.mini_stockbit_clone.utils.DarkModeState

class OnboardingActivity : BaseActivity<ActivityOnboardingBinding>(), DarkModeState {

    override val layout: Int
        get() = R.layout.activity_onboarding

    override fun setupLifeCycleOwner() {
        dataBinding.apply {
            lifecycleOwner = this@OnboardingActivity
        }
    }

    override val darkModeState: DarkModeState?
        get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupView()
    }

    private fun setupView() {
        dataBinding.tvMyText.text = "This is Stockbit"
    }

    override fun onLightMode() {
        Toast.makeText(this, "This is Light Mode", Toast.LENGTH_LONG).show()
    }

    override fun onDarkMode() {
        Toast.makeText(this, "This is Dark Mode", Toast.LENGTH_LONG).show()
    }
}
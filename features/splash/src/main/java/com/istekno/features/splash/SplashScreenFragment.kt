package com.istekno.features.splash

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.istekno.core.base.BaseFragment
import com.istekno.features.splash.databinding.FragmentSplashBinding
import com.istekno.libraries.utils.extensions.Alert.LogD
import com.istekno.libraries.utils.interfaces.DarkModeState
import com.istekno.libraries.utils.extensions.Delay.delay
import com.istekno.libraries.utils.navigator.NavUtils.navigateUriWithDefaultOptions

class SplashScreenFragment : BaseFragment<FragmentSplashBinding>(), DarkModeState {

    override val layout: Int
        get() = R.layout.fragment_splash

    override val darkModeState: DarkModeState?
        get() = this

    override fun setupLifeCycleOwner() {
        dataBinding.apply { lifecycleOwner = this@SplashScreenFragment }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        endSplash()
    }

    private fun endSplash() {
        if (activity == null) return

        activity?.apply {
            delay(1500L, action = {
                findNavController().navigateUriWithDefaultOptions(
                    Uri.parse("stockbit://onboarding")
                )
            })
        }
    }

    override fun onLightMode() {
        activity?.apply {
            LogD("Splash : ", "Light Mode On")
        }
    }

    override fun onDarkMode() {
        dataBinding.ivSplash.setImageResource(R.drawable.ic_new_dark)
    }
}
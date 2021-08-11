package com.istekno.features.splash

import android.net.Uri
import androidx.navigation.fragment.findNavController
import com.istekno.core.base.BaseFragment
import com.istekno.features.splash.databinding.FragmentSplashBinding
import com.istekno.libraries.utils.Constant.BASE_DEEPLINK
import com.istekno.libraries.utils.extensions.Alert.LogD
import com.istekno.libraries.utils.extensions.Delay.delay
import com.istekno.libraries.utils.interfaces.DarkModeState
import com.istekno.libraries.utils.navigator.NavUtils.navigateUriWithDefaultOptions

class SplashScreenFragment : BaseFragment<FragmentSplashBinding>(), DarkModeState {

    override val layout: Int
        get() = R.layout.fragment_splash

    override val darkModeState: DarkModeState
        get() = this

    override fun setupLifeCycleOwner() {
        dataBinding.lifecycleOwner = this
    }

    override fun onResume() {
        endSplash()
        super.onResume()
    }

    private fun endSplash() {
        activity?.apply {
            delay(1500L, action = {
                findNavController().navigateUriWithDefaultOptions(
                    Uri.parse("${BASE_DEEPLINK}/onboarding")
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
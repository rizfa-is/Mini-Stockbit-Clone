package com.istekno.features.onboarding.page

import com.istekno.core.base.BaseFragment
import com.istekno.features.onboarding.R
import com.istekno.features.onboarding.databinding.FragmentSecondOnboardBinding
import com.istekno.libraries.utils.Alert.LogD
import com.istekno.libraries.utils.DarkModeState

class SecondOnboardFragment : BaseFragment<FragmentSecondOnboardBinding>(), DarkModeState {

    override val layout: Int
        get() = R.layout.fragment_second_onboard

    override fun setupLifeCycleOwner() {
        dataBinding.apply {
            lifecycleOwner = this@SecondOnboardFragment
        }
    }

    override val darkModeState: DarkModeState
        get() = this

    override fun onLightMode() {
        if (activity == null) return

        activity?.apply {
            LogD("note: ", "Light Mode")
        }
    }

    override fun onDarkMode() {
        dataBinding.apply {
            ivOnboard2.setImageResource(R.drawable.img_onboard2_dark)
        }
    }
}
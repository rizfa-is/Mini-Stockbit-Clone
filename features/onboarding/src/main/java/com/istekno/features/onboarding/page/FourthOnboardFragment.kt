package com.istekno.features.onboarding.page

import com.istekno.core.base.BaseFragment
import com.istekno.features.onboarding.R
import com.istekno.features.onboarding.databinding.FragmentFourthOnboardBinding
import com.istekno.libraries.utils.extensions.Alert.LogD
import com.istekno.libraries.utils.interfaces.DarkModeState

class FourthOnboardFragment : BaseFragment<FragmentFourthOnboardBinding>(), DarkModeState {

    override val layout: Int
        get() = R.layout.fragment_fourth_onboard

    override fun setupLifeCycleOwner() {
        dataBinding.apply {
            lifecycleOwner = this@FourthOnboardFragment
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
            ivOnboard4.setImageResource(R.drawable.img_onboard4_dark)
        }
    }
}
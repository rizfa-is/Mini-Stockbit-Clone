package com.istekno.features.onboarding.page

import com.istekno.core.base.BaseFragment
import com.istekno.features.onboarding.R
import com.istekno.features.onboarding.databinding.FragmentFirstOnboardBinding
import com.istekno.libraries.utils.Alert.LogD
import com.istekno.libraries.utils.DarkModeState

class FirstOnboardFragment : BaseFragment<FragmentFirstOnboardBinding>(), DarkModeState {

    override val layout: Int
        get() = R.layout.fragment_first_onboard

    override fun setupLifeCycleOwner() {
        dataBinding.apply {
            lifecycleOwner = this@FirstOnboardFragment
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
            ivOnboard1.setImageResource(R.drawable.img_onboard1_dark)
        }
    }
}
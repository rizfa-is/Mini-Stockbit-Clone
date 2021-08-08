package com.istekno.features.onboarding.page

import com.istekno.core.base.BaseFragment
import com.istekno.features.onboarding.R
import com.istekno.features.onboarding.databinding.FragmentFirstOnboardBinding
import com.istekno.libraries.utils.extensions.Alert.LogD
import com.istekno.libraries.utils.interfaces.DarkModeState

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
        setupView(R.drawable.img_onboard1)
    }

    override fun onDarkMode() {
        setupView(R.drawable.img_onboard1_dark)
    }

    private fun setupView(view: Int = 0) {
        dataBinding.apply {
            ivOnboard1.setImageResource(view)
        }
    }
}
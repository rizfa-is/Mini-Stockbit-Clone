package com.istekno.mini_stockbit_clone.ui.onboarding.page

import com.istekno.mini_stockbit_clone.R
import com.istekno.mini_stockbit_clone.base.BaseFragment
import com.istekno.mini_stockbit_clone.databinding.FragmentSecondOnboardBinding
import com.istekno.mini_stockbit_clone.utils.Alert.LogD
import com.istekno.mini_stockbit_clone.utils.DarkModeState

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
            ivOnboard2.setImageResource(R.drawable.ic_new_dark)
        }
    }
}
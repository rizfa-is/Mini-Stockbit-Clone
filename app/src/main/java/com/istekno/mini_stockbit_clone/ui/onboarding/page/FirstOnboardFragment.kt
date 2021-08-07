package com.istekno.mini_stockbit_clone.ui.onboarding.page

import com.istekno.mini_stockbit_clone.R
import com.istekno.mini_stockbit_clone.base.BaseFragment
import com.istekno.mini_stockbit_clone.databinding.FragmentFirstOnboardBinding
import com.istekno.mini_stockbit_clone.utils.Alert.LogD
import com.istekno.mini_stockbit_clone.utils.DarkModeState

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
            ivOnboard1.setImageResource(R.drawable.ic_new_dark)
        }
    }
}
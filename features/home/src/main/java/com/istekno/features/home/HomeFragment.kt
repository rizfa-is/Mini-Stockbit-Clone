package com.istekno.features.home

import com.istekno.core.base.BaseFragment
import com.istekno.features.home.databinding.FragmentHomeBinding
import com.istekno.libraries.utils.interfaces.DarkModeState
import com.istekno.libraries.utils.interfaces.OnFragmentBackPressed

class HomeFragment : BaseFragment<FragmentHomeBinding>(), DarkModeState, OnFragmentBackPressed {

    override val layout: Int
        get() = R.layout.fragment_home

    override fun setupLifeCycleOwner() {
        dataBinding.lifecycleOwner = this
    }

    override val darkModeState: DarkModeState?
        get() = this

    override val onFragmentBackPressed: OnFragmentBackPressed
        get() = this

    override fun onBackPressed() {
        activity?.finishAffinity()
    }

    override fun onLightMode() {
        setupView(R.drawable.ic_new_light)
    }

    override fun onDarkMode() {
        setupView(R.drawable.ic_new_dark)
    }

    private fun setupView(view: Int = 0) {
        dataBinding.apply {
            imgIcHeader.setImageResource(view)
        }
    }
}
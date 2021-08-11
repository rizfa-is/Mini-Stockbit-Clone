package com.istekno.features.login

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.istekno.core.base.BaseFragment
import com.istekno.features.login.databinding.FragmentLoginBinding
import com.istekno.libraries.utils.extensions.Alert.LogD
import com.istekno.libraries.utils.interfaces.DarkModeState
import com.istekno.libraries.utils.interfaces.OnFragmentBackPressed

class LoginFragment : BaseFragment<FragmentLoginBinding>(), DarkModeState, OnFragmentBackPressed {

    override val layout: Int
        get() = R.layout.fragment_login

    override fun setupLifeCycleOwner() {
        dataBinding.lifecycleOwner = this
    }

    override val darkModeState: DarkModeState
        get() = this

    override val onFragmentBackPressed: OnFragmentBackPressed
        get() = this

    override fun onLightMode() {
        activity?.apply {
            LogD("Login : ", "Light Mode On")
        }
    }

    override fun onDarkMode() {
        setTheme()
    }

    override fun onBackPressed() {
        activity.apply {
            findNavController().popBackStack()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewClick()
    }

    private fun setupViewClick() {
        dataBinding.apply {

        }
    }

    private fun setTheme() {

    }
}
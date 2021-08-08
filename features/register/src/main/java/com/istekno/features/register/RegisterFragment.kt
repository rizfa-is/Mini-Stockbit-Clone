package com.istekno.features.register

import android.net.Uri
import androidx.navigation.fragment.findNavController
import com.istekno.core.base.BaseFragment
import com.istekno.features.register.databinding.FragmentRegisterBinding
import com.istekno.libraries.utils.interfaces.OnFragmentBackPressed
import com.istekno.libraries.utils.navigator.NavUtils.navigateUriWithDefaultOptions

class RegisterFragment : BaseFragment<FragmentRegisterBinding>(), OnFragmentBackPressed {

    override val layout: Int
        get() = R.layout.fragment_register

    override fun setupLifeCycleOwner() {
        dataBinding.apply {
            lifecycleOwner = this@RegisterFragment
        }
    }

    override val onFragmentBackPressed: OnFragmentBackPressed?
        get() = this

    override fun onBackPressed() {
        activity?.apply {
            findNavController().popBackStack()
        }
    }

}
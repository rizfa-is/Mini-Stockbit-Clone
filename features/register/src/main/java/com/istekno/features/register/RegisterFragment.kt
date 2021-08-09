package com.istekno.features.register

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.istekno.core.base.BaseFragment
import com.istekno.features.register.databinding.FragmentRegisterBinding
import com.istekno.libraries.utils.interfaces.OnFragmentBackPressed

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewClick()
    }

    private fun setupViewClick() {
        dataBinding.apply {
            btnBack.setOnClickListener { findNavController().popBackStack() }
            btnGoogle.setOnClickListener {  }
            btnFacebook.setOnClickListener {  }
            btnRegisterEmail.setOnClickListener {  }
            btnConsultation.setOnClickListener {  }
            tvMasuk.setOnClickListener {  }
        }
    }
}
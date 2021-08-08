package com.istekno.core.base

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.istekno.libraries.utils.interfaces.DarkModeState
import com.istekno.libraries.utils.interfaces.OnFragmentBackPressed

abstract class BaseFragment<binding: ViewDataBinding>: Fragment() {

    abstract val layout: Int
    abstract fun setupLifeCycleOwner()
    open val darkModeState: DarkModeState? = null
    open val onFragmentBackPressed: OnFragmentBackPressed? = null

    lateinit var dataBinding: binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (activity != null) {
            activity?.onBackPressedDispatcher?.addCallback(object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() { onFragmentBackPressed?.onBackPressed() }
            })
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, layout, container, false)
        setupLifeCycleOwner()

        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupDarkModeState()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setupDarkModeState() {
        if (darkModeState != null) {
            val detectMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
            when(detectMode) {
                Configuration.UI_MODE_NIGHT_YES -> darkModeState?.onDarkMode()
                Configuration.UI_MODE_NIGHT_NO -> darkModeState?.onLightMode()
                Configuration.UI_MODE_NIGHT_UNDEFINED -> darkModeState?.onLightMode()
            }
        }
    }
}
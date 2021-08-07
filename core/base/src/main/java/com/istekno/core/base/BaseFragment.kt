package com.istekno.core.base

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<binding: ViewDataBinding>: Fragment() {

    abstract val layout: Int
    open val darkModeState: com.istekno.libraries.utils.DarkModeState? = null
    lateinit var dataBinding: binding

    abstract fun setupLifeCycleOwner()

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
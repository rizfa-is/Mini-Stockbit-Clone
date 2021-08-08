package com.istekno.core.base

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.istekno.libraries.utils.interfaces.DarkModeState

abstract class BaseActivity<binding: ViewDataBinding>: AppCompatActivity() {

    abstract val layout: Int
    open val darkModeState: DarkModeState? = null
    lateinit var dataBinding: binding

    abstract fun setupLifeCycleOwner()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding= DataBindingUtil.setContentView(this, layout)
        setupLifeCycleOwner()
        setupDarkModeState()
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
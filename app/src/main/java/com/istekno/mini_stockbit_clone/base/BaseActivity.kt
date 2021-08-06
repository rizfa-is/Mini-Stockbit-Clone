package com.istekno.mini_stockbit_clone.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<binding: ViewDataBinding>: AppCompatActivity() {

    abstract val layout: Int
    lateinit var dataBinding: binding

    abstract fun setupLifeCycleOwner()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding= DataBindingUtil.setContentView(this, layout)
        setupLifeCycleOwner()
    }
}
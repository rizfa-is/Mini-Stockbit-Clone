package com.istekno.mini_stockbit_clone.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<binding: ViewDataBinding>: Fragment() {

    abstract val layout: Int
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

}
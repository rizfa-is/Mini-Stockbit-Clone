package com.istekno.features.navigator

import com.istekno.core.base.BaseActivity
import com.istekno.features.navigator.databinding.ActivityInitialBinding

class InitialActivity : BaseActivity<ActivityInitialBinding>() {

    override val layout: Int
        get() = R.layout.activity_initial

    override fun setupLifeCycleOwner() {
        dataBinding.apply { lifecycleOwner = this@InitialActivity }
    }
}
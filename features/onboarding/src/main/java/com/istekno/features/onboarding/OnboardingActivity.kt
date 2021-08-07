package com.istekno.features.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.istekno.core.base.BaseActivity
import com.istekno.core.base.adapter.BasePagerAdapter
import com.istekno.features.onboarding.databinding.ActivityOnboardingBinding
import com.istekno.features.onboarding.page.FirstOnboardFragment
import com.istekno.features.onboarding.page.FourthOnboardFragment
import com.istekno.features.onboarding.page.SecondOnboardFragment
import com.istekno.features.onboarding.page.ThirdOnboardFragment
import com.istekno.libraries.utils.Alert.LogD
import com.istekno.libraries.utils.DarkModeState

class OnboardingActivity : BaseActivity<ActivityOnboardingBinding>(), DarkModeState {

    override val layout: Int
        get() = R.layout.activity_onboarding

    override fun setupLifeCycleOwner() {
        dataBinding.apply {
            lifecycleOwner = this@OnboardingActivity
        }
    }

    override val darkModeState: DarkModeState
        get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupPagerAdapter()
    }

    override fun onLightMode() {
        LogD("note: ", "Light Mode")
    }

    override fun onDarkMode() {
        setupViewOnDarkMode()
    }

    private fun setupPagerAdapter() {
        val titles = arrayListOf("1", "2", "3", "4")
        val fragments = arrayListOf(
            FirstOnboardFragment(),
            SecondOnboardFragment(),
            ThirdOnboardFragment(),
            FourthOnboardFragment()
        )  as ArrayList<Fragment>

        val adapter = BasePagerAdapter(supportFragmentManager).apply {
            setTitles(titles)
            setFragments(fragments)
        }

        dataBinding.vpOnboarding.adapter = adapter
    }

    private fun setupViewOnDarkMode() {
        dataBinding.apply {
            imgIcHeader.setImageResource(R.drawable.ic_new_dark)
        }
    }
}
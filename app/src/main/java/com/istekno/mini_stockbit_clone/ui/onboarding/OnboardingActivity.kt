package com.istekno.mini_stockbit_clone.ui.onboarding

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.istekno.mini_stockbit_clone.R
import com.istekno.mini_stockbit_clone.base.BaseActivity
import com.istekno.mini_stockbit_clone.base.adapter.BasePagerAdapter
import com.istekno.mini_stockbit_clone.databinding.ActivityOnboardingBinding
import com.istekno.mini_stockbit_clone.ui.onboarding.page.FirstOnboardFragment
import com.istekno.mini_stockbit_clone.ui.onboarding.page.FourthOnboardFragment
import com.istekno.mini_stockbit_clone.ui.onboarding.page.SecondOnboardFragment
import com.istekno.mini_stockbit_clone.ui.onboarding.page.ThirdOnboardFragment
import com.istekno.mini_stockbit_clone.utils.Alert.LogD
import com.istekno.mini_stockbit_clone.utils.DarkModeState

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
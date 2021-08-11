package com.istekno.features.onboarding

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.istekno.core.base.BaseFragment
import com.istekno.core.base.adapter.BasePagerAdapter
import com.istekno.features.onboarding.databinding.FragmentOnboardingBinding
import com.istekno.features.onboarding.page.FirstOnboardFragment
import com.istekno.features.onboarding.page.FourthOnboardFragment
import com.istekno.features.onboarding.page.SecondOnboardFragment
import com.istekno.features.onboarding.page.ThirdOnboardFragment
import com.istekno.libraries.utils.Constant.BASE_DEEPLINK
import com.istekno.libraries.utils.extensions.Alert.LogD
import com.istekno.libraries.utils.interfaces.DarkModeState
import com.istekno.libraries.utils.interfaces.OnFragmentBackPressed
import com.istekno.libraries.utils.navigator.NavUtils.navigateUriWithDefaultOptions

class OnboardingFragment : BaseFragment<FragmentOnboardingBinding>(), DarkModeState, OnFragmentBackPressed {

    override val layout: Int
        get() = R.layout.fragment_onboarding

    override fun setupLifeCycleOwner() {
        dataBinding.lifecycleOwner = this
    }

    override val darkModeState: DarkModeState
        get() = this

    override val onFragmentBackPressed: OnFragmentBackPressed
        get() = this

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupPagerAdapter()
        setupViewClick()
    }

    override fun onLightMode() {
        setupView(R.drawable.ic_new_light)
    }

    override fun onDarkMode() {
        setupView(R.drawable.ic_new_dark)
    }

    override fun onBackPressed() {
        activity?.apply {
            LogD("Onboarding : ", "onBackPressed = disabled")
        }
    }

    private fun setupPagerAdapter() {
        val titles = arrayListOf("1", "2", "3", "4")
        val fragments = arrayListOf(
            FirstOnboardFragment(),
            SecondOnboardFragment(),
            ThirdOnboardFragment(),
            FourthOnboardFragment()
        )  as ArrayList<Fragment>

        val adapter = BasePagerAdapter(childFragmentManager).apply {
            setTitles(titles)
            setFragments(fragments)
        }

        dataBinding.vpOnboarding.adapter = adapter
    }

    private fun setupViewClick() {
        dataBinding.apply {
            btnRegister.setOnClickListener {
                findNavController().navigateUriWithDefaultOptions(
                    Uri.parse("${BASE_DEEPLINK}/register")
                )
            }

            btnLogin.setOnClickListener {
                findNavController().navigateUriWithDefaultOptions(
                    Uri.parse("${BASE_DEEPLINK}/login")
                )
            }
        }
    }

    private fun setupView(view: Int = 0) {
        dataBinding.apply {
            imgIcHeader.setImageResource(view)
        }
    }
}
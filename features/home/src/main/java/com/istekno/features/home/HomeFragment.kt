package com.istekno.features.home

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.istekno.core.base.BaseFragment
import com.istekno.core.base.entities.model.Instrument
import com.istekno.features.home.databinding.FragmentHomeBinding
import com.istekno.libraries.utils.extensions.Alert.showToast
import com.istekno.libraries.utils.interfaces.DarkModeState
import com.istekno.libraries.utils.interfaces.OnFragmentBackPressed

class HomeFragment : BaseFragment<FragmentHomeBinding>(), DarkModeState, OnFragmentBackPressed {

    private val listInstrument = ArrayList<Instrument>()

    override val layout: Int
        get() = R.layout.fragment_home

    override fun setupLifeCycleOwner() {
        dataBinding.lifecycleOwner = this
    }

    override val darkModeState: DarkModeState?
        get() = this

    override val onFragmentBackPressed: OnFragmentBackPressed
        get() = this

    override fun onBackPressed() {
        activity?.finishAffinity()
    }

    override fun onLightMode() {
        setupView(R.drawable.ic_new_light)
    }

    override fun onDarkMode() {
        setupView(R.drawable.ic_new_dark)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        populateData()
        setupView()
    }

    private fun setupView(view: Int = 0) {
        dataBinding.apply {
            if (view != 0) imgIcHeader.setImageResource(view)
            setupList(rvSymbol)
        }
    }

    private fun setupList(rv: RecyclerView) {
        rv.apply {
            context.let {
                layoutManager = LinearLayoutManager(it)
                adapter = HomeAdapter(
                    instruments = listInstrument,
                    onItemClick = { instrument ->
                        it.apply {
                            showToast(instrument.name)
                        }
                    }
                )
            }
        }
    }

    private fun populateData() {
        listInstrument.add(
            Instrument("BBCA", "PT. Bank Central Asia.", 25231.0, -129.12, -0.15)
        )
        listInstrument.add(
            Instrument("AALI", "Astra Agro Tani Tbk.", 9050.0, 200.0, 2.26)
        )
    }
}
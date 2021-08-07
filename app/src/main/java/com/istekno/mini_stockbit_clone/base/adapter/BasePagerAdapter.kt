package com.istekno.mini_stockbit_clone.base.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class BasePagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private var titles = ArrayList<String>()
    private var fragments = ArrayList<Fragment>()

    fun setTitles(titleList: ArrayList<String>) {
        this.titles = titleList
    }

    fun setFragments(fragmentList: ArrayList<Fragment>) {
        this.fragments = fragmentList
    }

    override fun getCount(): Int = titles.size

    override fun getItem(position: Int): Fragment = fragments[position]
}
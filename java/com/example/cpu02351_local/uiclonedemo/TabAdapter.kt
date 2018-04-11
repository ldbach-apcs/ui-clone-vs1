package com.example.cpu02351_local.uiclonedemo

import android.support.v4.app.FragmentManager
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter

class TabAdapter(fm: FragmentManager, var tabCount: Int) : FragmentStatePagerAdapter(fm) {

    private val tabs = ArrayList<Tab>()
    init {
        for (i in 0 until tabCount)
            tabs.add(Tab.instance())
    }

    override fun getItem(position: Int): Fragment = tabs[position]

    override fun getCount(): Int = tabCount;
}
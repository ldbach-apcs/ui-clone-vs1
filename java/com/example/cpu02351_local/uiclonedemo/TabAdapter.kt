package com.example.cpu02351_local.uiclonedemo

import android.support.v4.app.FragmentManager
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter

/*
 * Demo purposes, will be deleted
 */
open class TabAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    protected var tabCount = 4
    protected val tabs : ArrayList<Tab> = ArrayList()
    init {
        tabs.clear()
        for (i in 0 until tabCount)
            tabs.add(Tab.instance())
    }

    override fun getItem(position: Int): Fragment = tabs[position]

    override fun getCount(): Int = tabCount
}
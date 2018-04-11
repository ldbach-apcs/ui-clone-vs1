package com.example.cpu02351_local.uiclonedemo

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager

abstract class Page : Fragment() {
    protected lateinit var pager : ViewPager
    protected lateinit var tabLayout : TabLayout
    protected var currentIndx = 0

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("current", pager.currentItem)
        super.onSaveInstanceState(outState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        currentIndx = savedInstanceState?.getInt("current") ?: 0
    }

    abstract fun init()
}
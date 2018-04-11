package com.example.cpu02351_local.uiclonedemo

import android.support.v4.app.FragmentManager

class NewsTabAdapter(fm: FragmentManager) : TabAdapter(fm) {
    init {
        tabs.clear()
        tabs.add(ListTab.instance())
        tabs.add(ListTab.instance())
        tabCount = tabs.size
    }
}
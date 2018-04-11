package com.example.cpu02351_local.uiclonedemo

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class NewsPage : Page(),  TabLayout.OnTabSelectedListener {
    companion object {
        @JvmStatic
        fun instance() : NewsPage {
            val newPage = NewsPage()
            return newPage
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_page, container, false)
        tabLayout = rootView!!.findViewById(R.id.tabLayout)
        pager = rootView.findViewById(R.id.pager)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun init() {
        // Load tab
        for (i in 0 until 10) {
            tabLayout.addTab(tabLayout.newTab().setText("News Tabs $i"))
        }
        val adapter = TabAdapter(childFragmentManager, tabLayout.tabCount)
        pager.adapter = adapter
        tabLayout.addOnTabSelectedListener(this)
        pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
    }

    override fun onResume() {
        super.onResume()
        pager.currentItem = currentIndx
    }

    override fun onDestroyView() {
        pager.adapter = null
        tabLayout.clearOnTabSelectedListeners()
        pager.clearOnPageChangeListeners()
        super.onDestroyView()
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
    }


    override fun onTabUnselected(tab: TabLayout.Tab?) {
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        pager.currentItem = tab!!.position
    }
}
package com.example.cpu02351_local.uiclonedemo

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class NewsPage : Page(), TabLayout.OnTabSelectedListener {
    override fun initPager() {
        adapter = NewsTabAdapter(childFragmentManager)
        pager.adapter = adapter
        tabLayout.addOnTabSelectedListener(this)
        pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
    }

    override fun initTabs() {
        for (i in 0 until 2) {
            tabLayout.addTab(tabLayout.newTab().setText("List Tab: $i"))
        }
    }

    private var adapter: TabAdapter? = null

    companion object {
        @JvmStatic
        fun instance(): NewsPage {
            val newPage = NewsPage()
            return newPage
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_page, container, false)
        tabLayout = rootView!!.findViewById(R.id.tabLayout)
        pager = rootView.findViewById(R.id.pager)
        init()
        return rootView
    }


    override fun onResume() {
        super.onResume()
        pager.currentItem = currentIndx
    }

    override fun onDestroyView() {
        adapter = null
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
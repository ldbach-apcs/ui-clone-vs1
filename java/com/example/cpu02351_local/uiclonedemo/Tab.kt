package com.example.cpu02351_local.uiclonedemo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

open class Tab : Fragment() {
    private lateinit var tabText: TextView
    private var index = -1

    companion object {
        @JvmStatic
        var count = 0


        @JvmStatic
        fun instance() : Tab {
            val newTab = Tab()
            val args = Bundle()
            args.putInt("index", count)
            newTab.arguments = args
            count++
            return newTab
        }
    }

    override fun setArguments(args: Bundle?) {
        index = args!!.getInt("index")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_tab, container, false)
        tabText = rootView.findViewById(R.id.tabText)
        tabText.text = "Tab: $index"
        return rootView
    }
}
package com.example.cpu02351_local.uiclonedemo

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.ArrayList

/*
 *
 */
class ListTab : Tab() {

    private lateinit var recyclerView : RecyclerView
    private val simpleStrings = arrayOf("Hello", "testing", "Ui", "Cloning", "application",
            "longg", "longer list please", "longg", "longer list please",
            "longg", "longer list please", "longg", "longer list please",
            "longg", "longer list please", "longg", "longer list please")

    companion object {
        @JvmStatic
        fun instance() : ListTab {
            val newTab = ListTab()
            val args = Bundle()
            newTab.arguments = args
            return newTab
        }
    }

    override fun setArguments(args: Bundle?) {

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_tab_list, container, false)
        recyclerView = rootView.findViewById(R.id.recylerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = ListItemAdapter(simpleStrings.asList())
        recyclerView.adapter = adapter
        return rootView
    }

}
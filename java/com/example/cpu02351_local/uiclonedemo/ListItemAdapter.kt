package com.example.cpu02351_local.uiclonedemo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.*

class ListItemAdapter(var contents: List<String>) : RecyclerView.Adapter<ListItemAdapter.ListItemVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemVH {
        val rootView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_tab_list, parent, false)
        return ListItemVH(rootView)
    }

    override fun getItemCount(): Int = contents.size
    override fun onBindViewHolder(holder: ListItemVH, position: Int) {
        // Since the adapter is generic, cast here
        val curString = contents[position]
        holder.bind(curString)
    }


    class ListItemVH(var view : View) : RecyclerView.ViewHolder(view) {
        private var textView : TextView? = null

        fun bind(string: String) {
            if (textView == null) {
                textView = view.findViewById(R.id.item_tab_list_text)
            }
            textView?.text = string
        }
    }
}
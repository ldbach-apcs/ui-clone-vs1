package com.example.cpu02351_local.uiclonedemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class SimplePage : Page() {
    override fun init() {
        // do nothing
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return  inflater.inflate(R.layout.frag_simple, container, false)
    }
}
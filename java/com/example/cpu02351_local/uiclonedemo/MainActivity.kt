package com.example.cpu02351_local.uiclonedemo

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    // Should be static
    private val FRAGMENT_NEWS = "News Fragment"
    private val FRAGMENT_VIDEO = "Video Fragment"

    private val pages = ArrayList<Page>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        initPages()
        initBottomNav()
    }

    private fun initPages() {
        pages.add(NewsPage())
        pages.add(NewsPage())
    }

    private fun initBottomNav() {
        val navigation = findViewById<BottomNavigationView>(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener(this)
        replaceFragment(pages[0], null)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.navigation_news -> {
                replaceFragment(NewsPage.instance(), FRAGMENT_NEWS)
                true
            }
            R.id.navigation_video -> {
                replaceFragment(VideoPage.instance(), FRAGMENT_VIDEO)
                true
            }
            else -> false
        }
    }


    private fun replaceFragment(newFragment: Page, tag: String?) {
        supportFragmentManager.beginTransaction()
        .replace(R.id.fragment_container, newFragment, tag)
        .commit()
    }
}

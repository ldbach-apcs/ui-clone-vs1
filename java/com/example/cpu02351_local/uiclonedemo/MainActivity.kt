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
        initPages()
        initBottomNav()
    }

    private fun initPages() {
        pages.add(NewsPage.instance())
        pages.add(VideoPage.instance())
    }

    private fun initBottomNav() {
        val navigation = findViewById<BottomNavigationView>(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener(this)
        supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, pages[0], FRAGMENT_NEWS)
                .commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.navigation_news -> {
                replaceFragment(pages[0], FRAGMENT_NEWS)
                true
            }
            R.id.navigation_video -> {
                replaceFragment(pages[1], FRAGMENT_VIDEO)
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

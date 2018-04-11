package com.example.cpu02351_local.uiclonedemo

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    // Should be static
    private val FRAGMENT_NEWS = "News Fragment"
    private val FRAGMENT_VIDEO = "Video Fragment"

    private val pages = HashMap<@android.support.annotation.IdRes Int, Page>()
    private val tags = HashMap<@android.support.annotation.IdRes Int, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initPages()
        initBottomNav()
    }

    private fun initPages() {
        pages[R.id.navigation_news] = NewsPage.instance()
        pages[R.id.navigation_video] = VideoPage.instance()
        tags[R.id.navigation_news] = FRAGMENT_NEWS
        tags[R.id.navigation_video] = FRAGMENT_VIDEO
    }

    private fun initBottomNav() {
        val navigation = findViewById<BottomNavigationView>(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener(this)
        supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, pages[R.id.navigation_news], FRAGMENT_NEWS)
                .commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val itemId = item.itemId
        if (!pages.containsKey(itemId)) return false
        replaceFragment(pages[itemId]!!, tags[itemId])
        return true
    }


    private fun replaceFragment(newFragment: Page, tag: String?) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, newFragment, tag)
            .commit()
    }
}

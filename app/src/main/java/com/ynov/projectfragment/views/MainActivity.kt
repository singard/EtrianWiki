package com.ynov.projectfragment.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.ynov.projectfragment.R
import com.ynov.projectfragment.adapter.onglet.ViewPagerAdapter


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager>(R.id.view_pager_main)
        viewPager.adapter = ViewPagerAdapter(supportFragmentManager)

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout_main)
        tabLayout.setupWithViewPager(viewPager)

        val toolBar = ToolbarFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container, toolBar).commit()




    }


}
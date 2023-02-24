package com.ynov.projectfragment.views

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.ynov.projectfragment.R
import com.ynov.projectfragment.adapter.onglet.ViewPagerAdapter
import com.ynov.projectfragment.model.ThemeManager


class MainActivity : AppCompatActivity() {

    private var isResumedAfterOnPause = false//pour savoir si l'apli est déjà crée quand on fait un retour arrière
    private val className = this::class.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(className,"onCreate")
        ThemeManager.themeSelect(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager>(R.id.view_pager_main)
        viewPager.adapter = ViewPagerAdapter(supportFragmentManager)

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout_main)
        tabLayout.setupWithViewPager(viewPager)

        val toolBar = ToolbarFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container, toolBar).commit()

    }

    public override fun onResume() {
        Log.i(className,"onResume")
       // ThemeManager.majTheme(this,this)
        //ThemeManager.themeSelect(this)
        super.onResume()
        if (isResumedAfterOnPause) {
            Log.i("","onResume retour")
            ThemeManager.themeSelect(this)
            recreate()
            isResumedAfterOnPause = false
        } else {
            Log.i("","onResume après un onPause")
        }
        super.onResume()
    }
    public override fun onStart() {
        Log.i(className,"onStart")
        super.onStart()
    }
    override fun onPause() {
        Log.i(className,"onPause")
        super.onPause()
        isResumedAfterOnPause = true
    }



}
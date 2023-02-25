package com.ynov.projectfragment.views

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.ynov.projectfragment.R
import com.ynov.projectfragment.model.ThemeManager

class AboutActivity : AppCompatActivity() {

    private var isResumedAfterOnPause = false//pour savoir si l'apli est déjà crée quand on fait un retour arrière
    private val className = this::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        ThemeManager.themeSelect(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val toolBar = ToolbarFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container, toolBar).commit()
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // ajoute la flèche de retour
    }



    //action flèche de retour
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // gère le clic sur la flèche de retour
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onPause() {
        Log.i(className,"onPause")
        super.onPause()
        isResumedAfterOnPause = true
    }
    public override fun onResume() {
        Log.i(className,"onResume")
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


}
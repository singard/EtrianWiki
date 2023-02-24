package com.ynov.projectfragment.views


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.ynov.projectfragment.R
import com.ynov.projectfragment.model.Theme
import com.ynov.projectfragment.model.ThemeManager

class ParametersActivity : AppCompatActivity() {

    private val classeName: String = "ParametersActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        ThemeManager.themeSelect(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parameters)

        Log.i(classeName, "ParametersActivity create")

        val toolBar = ToolbarFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container, toolBar).commit()
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // ajoute la flèche de retour

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupParameterTheme)

        // récupérer la valeur du thème enregistré


        val valueThemToString = ThemeManager.getActualTheme(this)

        // sélectionner le bouton radio approprié
        Log.i(classeName, "theme value Actual ${valueThemToString}")
        when (valueThemToString) {
            Theme.LIGHT.toString() -> radioGroup.check(R.id.radioLight)
            Theme.DARK.toString() -> radioGroup.check(R.id.radioDark)
            Theme.AUTOMATIC.toString() -> radioGroup.check(R.id.radioAuto)
            else -> radioGroup.check(R.id.radioAuto)
        }

        // ajouter un listener pour détecter les changements de sélection
        radioGroup.setOnCheckedChangeListener { group, checkedId ->

            val selectedRadioButton = findViewById<RadioButton>(checkedId)

            val sharedPref = this.getSharedPreferences(classeName, Context.MODE_PRIVATE)
            val valueThemToString = ThemeManager.getActualTheme(this)

            Log.i(classeName, "value of valueThemToString ${valueThemToString}")
            when (selectedRadioButton.id) {
                R.id.radioLight -> {
                    Log.d(classeName, "action light select")
                    if (valueThemToString != Theme.LIGHT.toString()) {
                        ThemeManager.setTheme(this, this, Theme.LIGHT)
                    }
                }
                R.id.radioDark -> {
                    Log.d(classeName, "action night select")
                    if (valueThemToString != Theme.DARK.toString()) {
                        ThemeManager.setTheme(this, this, Theme.DARK)
                    }
                }
                R.id.radioAuto -> {
                    Log.d(classeName, "action automatic select")
                    if (valueThemToString != Theme.AUTOMATIC.toString()) {
                        ThemeManager.setTheme(this, this, Theme.AUTOMATIC)
                    }
                }
                else -> ThemeManager.setTheme(this, this, Theme.AUTOMATIC)
            }
        }
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




}
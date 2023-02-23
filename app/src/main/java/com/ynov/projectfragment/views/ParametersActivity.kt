package com.ynov.projectfragment.views

import android.os.Bundle
import android.view.MenuItem
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ynov.projectfragment.R

class ParametersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parameters)

        val toolBar = ToolbarFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container, toolBar).commit()
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // ajoute la flèche de retour

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupParameterTheme)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val selectedRadioButton = findViewById<RadioButton>(checkedId)



            val text = selectedRadioButton.text.toString()
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
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
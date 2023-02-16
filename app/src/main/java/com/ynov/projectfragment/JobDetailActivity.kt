package com.ynov.projectfragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ynov.projectfragment.model.CharacterClass

class JobDetailActivity : AppCompatActivity(){
    private lateinit var textViewName: TextView
    private lateinit var textViewProfile: TextView
    private lateinit var textViewStrengths: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_detail)

        textViewName = findViewById(R.id.textViewName)
        textViewProfile = findViewById(R.id.textViewProfil)
        textViewStrengths = findViewById(R.id.textViewStrengths)

        val characterClass = intent.getSerializableExtra("characterClass")
        Log.i("test",characterClass.toString())

        if (characterClass is CharacterClass) {
            val characterClass = characterClass

            textViewName.text = characterClass.name
            textViewProfile.text = characterClass.profile
            textViewStrengths.text = characterClass.strengths

        } else {
            Log.w("test","not characterClass object")
        }










    }
}
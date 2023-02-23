package com.ynov.projectfragment.views

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ynov.projectfragment.R
import com.ynov.projectfragment.model.CharacterJob

class JobDetailActivity : AppCompatActivity(){
    private lateinit var textViewName: TextView
    private lateinit var textViewProfile: TextView
    private lateinit var textViewStrengths: TextView
    private lateinit var textViewWeaknesses: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_detail)

        textViewName = findViewById(R.id.textViewName)
        textViewProfile = findViewById(R.id.textViewProfil)
        textViewStrengths = findViewById(R.id.textViewStrengths)
        textViewWeaknesses = findViewById(R.id.textViewWeaknesses)

        val characterClass = intent.getSerializableExtra("characterClass")
        Log.i("test",characterClass.toString())

        if (characterClass is CharacterJob) {
            val characterClass = characterClass

            textViewName.text = "   "+characterClass.name
            textViewProfile.text = "   "+characterClass.profile
            textViewStrengths.text = "   "+characterClass.strengths
            textViewWeaknesses.text = "   "+characterClass.weaknesses

        } else {
            Log.w("test","not characterClass object")
        }










    }
}
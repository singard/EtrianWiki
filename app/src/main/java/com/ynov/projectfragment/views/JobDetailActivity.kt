package com.ynov.projectfragment.views

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.ynov.projectfragment.R
import com.ynov.projectfragment.model.CharacterJob
import com.ynov.projectfragment.model.ThemeManager
import java.security.AlgorithmConstraints

class JobDetailActivity : AppCompatActivity(){
    private lateinit var textViewName: TextView
    private lateinit var textViewProfile: TextView
    private lateinit var textViewStrengths: TextView
    private lateinit var textViewWeaknesses: TextView
    private lateinit var constraints: ConstraintLayout

    private var isResumedAfterOnPause = false//pour savoir si l'apli est déjà crée quand on fait un retour arrière
    private val className = this::class.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        ThemeManager.themeSelect(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_detail)

        constraints = findViewById(R.id.constraintLayoutDetailActivity)
        constraints.setBackgroundResource(ThemeManager.imageView)


        val toolBar = ToolbarFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container, toolBar).commit()
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // ajoute la flèche de retour

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

    //action flèche de retour
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // gère le clic sur la flèche de retour
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
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
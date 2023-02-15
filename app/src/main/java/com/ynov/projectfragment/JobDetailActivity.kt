package com.ynov.projectfragment

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class JobDetailActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_detail)

        val characterClass = intent.getSerializableExtra("characterClass")
        Log.i("test",characterClass.toString())




    }
}
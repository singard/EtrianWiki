package com.ynov.projectfragment.model

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.util.Log
import android.widget.ImageView
import androidx.core.app.ActivityCompat.recreate
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import com.ynov.projectfragment.R
import com.ynov.projectfragment.views.JobDetailActivity
import com.ynov.projectfragment.views.MainActivity


class ThemeManager {
    companion object {


        private val classeName : String = "ThemeManager"
         var imageView : Int = 0


        fun  getActualTheme (context: Context): String? {
            val sharedPref = context.getSharedPreferences(classeName, Context.MODE_PRIVATE)
            val valueThemToString = sharedPref.getString(R.string.themeManag.toString(), "")
            return valueThemToString
        }

        fun setTheme(activity: Activity, context: Context, theme: Theme){
            Log.i(classeName,"setTheme");

            val sharedPref = context.getSharedPreferences(classeName, Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString(R.string.themeManag.toString(), theme.toString())
            editor.apply()
            activity.recreate()

        }
        fun majTheme(context: Context,activity: Activity){
            val sharedPref = context.getSharedPreferences(classeName, Context.MODE_PRIVATE)
            val valueThemToString = sharedPref.getString(R.string.themeManag.toString(), "")
            Log.i(classeName,"value theme is : ${valueThemToString}");

            when (valueThemToString) {
                Theme.LIGHT.toString()-> setLightTheme(context)
                Theme.DARK.toString() -> setDarkTheme(context)
                Theme.AUTOMATIC.toString() -> setAutomaticTheme(context)
                else -> setAutomaticTheme(context)
            }
            activity.recreate()
        }

        fun themeSelect(context: Context){
            val sharedPref = context.getSharedPreferences(classeName, Context.MODE_PRIVATE)
            val valueThemToString = sharedPref.getString(R.string.themeManag.toString(), "")
            Log.i(classeName,"value theme is : ${valueThemToString}");

            when (valueThemToString) {
                Theme.LIGHT.toString()-> setLightTheme(context)
                Theme.DARK.toString() -> setDarkTheme(context)
                Theme.AUTOMATIC.toString() -> setAutomaticTheme(context)
                else -> setAutomaticTheme(context)
            }


        }

        private fun setDarkTheme(context: Context) {
            Log.i(classeName,"dark theme install");
            context.setTheme(R.style.DarkTheme)
            imageView = R.drawable.labyrinth_path_night
        }

        private fun setLightTheme(context: Context) {
            Log.i(classeName,"light theme install");
            context.setTheme(R.style.LightTheme)
            imageView = R.drawable.labyrinth_path_light
        }

        private fun setAutomaticTheme(context: Context) {
            Log.i(classeName,"automatic theme install");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                Log.i(classeName,"Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q");
                val currentNightMode = context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
                Log.i(classeName,"currentNightMode : ${currentNightMode.toString()}");
                when (currentNightMode) {
                    Configuration.UI_MODE_NIGHT_NO -> {
                        Log.i(classeName,"light will be run");
                        setLightTheme(context)}
                    Configuration.UI_MODE_NIGHT_YES -> {
                        Log.i(classeName,"dark will be run");
                        setDarkTheme(context)}
                    Configuration.UI_MODE_NIGHT_UNDEFINED -> {
                        Log.i(classeName,"undefined (light) will be run");
                        setLightTheme(context)}
                }
            } else {
                Log.i(classeName,"default theme");
                context.setTheme(R.style.LightTheme)
            }
        }

    }
}
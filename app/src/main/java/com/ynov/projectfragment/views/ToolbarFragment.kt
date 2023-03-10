package com.ynov.projectfragment.views

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ynov.projectfragment.R
import com.ynov.projectfragment.model.ThemeManager


class ToolbarFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        ThemeManager.themeSelect(requireContext())
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)


    }

    override fun onStart() {
        ThemeManager.themeSelect(requireContext())
        super.onStart()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.toolbar, container, false)
        return view
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_in_toolbar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> {
                Toast.makeText(context, "a propos du jeux", Toast.LENGTH_SHORT).show()
                val intent = Intent( requireContext(), AboutActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.action_settings -> {
                Toast.makeText(context, "Paramètres sélectionnés", Toast.LENGTH_SHORT).show()
                val intent = Intent( requireContext(), ParametersActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}


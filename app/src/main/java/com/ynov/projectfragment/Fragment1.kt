package com.ynov.projectfragment

import android.view.*
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.ynov.projectfragment.card.PersonnageAdapter
import com.ynov.projectfragment.model.CharacterClass
import java.io.BufferedReader
import java.io.InputStreamReader

class Fragment1: Fragment(){

    private lateinit var personnages: List<CharacterClass>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)



    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_1, container, false)

        //json
        val resourceId = requireContext().resources.getIdentifier(
            "perso_info",
            "raw",
            requireContext().packageName
        )
        if (resourceId != 0) {
            val inputStream = requireContext().resources.openRawResource(R.raw.perso_info)
            val reader = BufferedReader(InputStreamReader(inputStream))
            val jsonString = reader.use { it.readText() }

            val gson = Gson()
            personnages = gson.fromJson(jsonString, Array<CharacterClass>::class.java).asList()

            Log.i("Fragment1", "" + personnages.size)
            //cardview
            val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
            val adapter = PersonnageAdapter(personnages)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())

        } else {
            Log.i("Fragment1", "le fichier existe pas")
        }
        return view
    }


}

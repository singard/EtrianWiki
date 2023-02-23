package com.ynov.projectfragment.card

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ynov.projectfragment.R
import com.ynov.projectfragment.model.CharacterJob
//cardview
class PersonnageAdapter (private val personnages: List<CharacterJob>) : RecyclerView.Adapter<PersonnageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonnageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.personnage_layout, parent, false)
        return PersonnageViewHolder(view)
    }

    override fun getItemCount(): Int = personnages.size

    override fun onBindViewHolder(holder: PersonnageViewHolder, position: Int) {
        val personnage = personnages[position]
        holder.bind(personnage)
    }
}
package com.ynov.projectfragment.card

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ynov.projectfragment.R
import com.ynov.projectfragment.model.CharacterClass
//cardview
class PersonnageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val textViewName: TextView = itemView.findViewById(R.id.name)
    private val textViewProfile: TextView = itemView.findViewById(R.id.profile)
    private val textViewStrengths: TextView = itemView.findViewById(R.id.strengths)
    private val textViewWeaknesses: TextView = itemView.findViewById(R.id.weaknesses)

    fun bind(characterClass: CharacterClass) {
        textViewName.text = characterClass.name
        textViewProfile.text = characterClass.profile
        textViewStrengths.text = characterClass.strengths
        textViewWeaknesses.text = characterClass.weaknesses
    }
}


package com.ynov.projectfragment.card

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ynov.projectfragment.JobDetailActivity
import com.ynov.projectfragment.R
import com.ynov.projectfragment.model.CharacterClass
//cardview
class PersonnageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val textViewName: TextView = itemView.findViewById(R.id.name)
    private val imgIlu: ImageView = itemView.findViewById(R.id.imageViewJob)
    private val cardView: CardView = itemView.findViewById(R.id.cardViewJob) // pour le clic card

    fun bind(characterClass: CharacterClass) {
        textViewName.text = characterClass.name

        val imageName = characterClass.imgId
        val resId = itemView.context.resources.getIdentifier(imageName, "drawable", itemView.context.packageName)
        imgIlu.setImageResource(resId)
        //pour le clic card
        cardView.setOnClickListener {
            val intent = Intent(itemView.context, JobDetailActivity::class.java)
            intent.putExtra("characterClass", characterClass)
            itemView.context.startActivity(intent)
        }
    }
}


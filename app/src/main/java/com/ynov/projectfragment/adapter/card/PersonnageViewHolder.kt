package com.ynov.projectfragment.adapter.card

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ynov.projectfragment.views.JobDetailActivity
import com.ynov.projectfragment.R
import com.ynov.projectfragment.model.CharacterJob
//cardview
class PersonnageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val textViewName: TextView = itemView.findViewById(R.id.name)
    private val imgIlu: ImageView = itemView.findViewById(R.id.imageViewJob)
    private val cardView: CardView = itemView.findViewById(R.id.cardViewJob) // pour le clic card

    fun bind(characterJob: CharacterJob) {
        textViewName.text = characterJob.name

        val imageName = characterJob.imgId
        val resId = itemView.context.resources.getIdentifier(imageName, "drawable", itemView.context.packageName)
        imgIlu.setImageResource(resId)
        //pour le clic card
        cardView.setOnClickListener {
            val intent = Intent(itemView.context, JobDetailActivity::class.java)
            intent.putExtra("characterClass", characterJob)
            itemView.context.startActivity(intent)
        }
    }
}


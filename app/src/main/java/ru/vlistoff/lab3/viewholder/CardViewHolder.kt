package ru.vlistoff.lab3.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.vlistoff.lab3.R
import ru.vlistoff.lab3.model.Card

class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val idTextView = itemView.findViewById<TextView>(R.id.idTextView)
    private val nameTextView = itemView.findViewById<TextView>(R.id.nameTextView)
    private val typeTextView = itemView.findViewById<TextView>(R.id.typeTextView)
    private val manaCostTextView = itemView.findViewById<TextView>(R.id.manaCostTextView)
    private val rarityTextView = itemView.findViewById<TextView>(R.id.rarityTextView)


    fun bind(card: Card) {
        idTextView.text = card.id.let { "Card №${layoutPosition + 1}\nID: ${card.id}" }
        nameTextView.text = card.name.let { "Name: $it" }
        typeTextView.text = card.type.let { "Type: $it" }
        manaCostTextView.text = card.manaCost.let { "ManaCost: $it" }
        rarityTextView.text = card.rarity.let { "Rarity: $it" }



    }
}


package ru.vlistoff.lab3.adapter

import ru.vlistoff.lab3.viewholder.CardViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.vlistoff.lab3.R
import ru.vlistoff.lab3.model.Card

class CardAdapter(private var cards: List<Card>) : RecyclerView.Adapter<CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_layout, parent, false)
        return CardViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = cards[position]
        holder.bind(card)
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    fun updateData(newCards: List<Card>) {
        cards = newCards
        notifyDataSetChanged()
    }
}

package com.example.messenger

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.message_card.view.*

class MessageAdapter(private val mes_list: MutableList<String>,
                     private val nameUser: String,
                    private val ageUser: String):
        RecyclerView.Adapter<MessageAdapter.MyViewHolder>(){
    class MyViewHolder(val card: CardView): RecyclerView.ViewHolder(card)
    override fun getItemCount(): Int {
        return mes_list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.card.nickname_user.text = nameUser
        holder.card.age_user.text = ageUser
        holder.card.message_user.text = mes_list[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val root = LayoutInflater.from(parent.context)
            .inflate(R.layout.message_card, parent, false) as CardView
        return MyViewHolder(root)
    }
}

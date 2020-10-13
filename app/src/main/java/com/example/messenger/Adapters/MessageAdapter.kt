package com.example.messenger.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.messenger.R
import kotlinx.android.synthetic.main.message_card.view.*

lateinit var nameUser: String
lateinit var ageUser: String
lateinit var mesUser: String
fun parseStr(a: String) {
    val resStr = a.split('`')
    nameUser = resStr[0]
    ageUser = resStr[1]
    mesUser = resStr[2]
    }

class MessageAdapter(private val mes_list: MutableList<String>,
                                name: String,
                                age: String):
        RecyclerView.Adapter<MessageAdapter.MyViewHolder>(){
    private val mName: String = name
    private var mAge: String = age
    class MyViewHolder(val card: CardView): RecyclerView.ViewHolder(card)
    override fun getItemCount(): Int {
        return mes_list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        parseStr(mes_list[position])
        holder.card.nickname_user.text = nameUser
        holder.card.age_user.text = ageUser
        holder.card.message_user.text = mesUser
        if((mName == nameUser) && (mAge == ageUser))
        {
            holder.card.card_background.setBackgroundResource(R.drawable.card_style_user)
        }
        else
        {
            holder.card.card_background.setBackgroundResource(R.drawable.card_style)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val root = LayoutInflater.from(parent.context)
            .inflate(R.layout.message_card, parent, false) as CardView

        return MyViewHolder(root)
    }

    override fun onViewAttachedToWindow(holder: MyViewHolder) {
        super.onViewAttachedToWindow(holder)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
    }
}

package com.example.messenger.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.messenger.R

class AvatarAdapter(private val lister: MutableList<Int>):
        RecyclerView.Adapter<AvatarAdapter.MyViewHolder>() {
    class MyViewHolder(val imView: ImageView) : RecyclerView.ViewHolder(imView)

    override fun getItemCount(): Int {
        return lister.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.imView.setImageResource(lister[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val elem = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item, parent, false) as ImageView
        return MyViewHolder(elem)
    }

}